package com.guoshi.module_home.public_placement

import android.content.res.ColorStateList
import android.databinding.DataBindingUtil
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import com.alibaba.android.arouter.facade.annotation.Route
import com.fadai.particlesmasher.ParticleSmasher
import com.fadai.particlesmasher.SmashAnimator
import com.guoshi.baselib.Myaplication
import com.guoshi.baselib.api.http.RetrofitFactory
import com.guoshi.baselib.api.http.base.BaseObserver
import com.guoshi.baselib.api.http.bean.BaseEntity
import com.guoshi.baselib.api.http.config.HttpConfig
import com.guoshi.baselib.base.BaseActivity
import com.guoshi.baselib.db.HistoryDao
import com.guoshi.baselib.entity.History
import com.guoshi.baselib.entity.Seek
import com.guoshi.baselib.evenbus.MyEvenbus
import com.guoshi.baselib.route.ModuleHomeUtlis
import com.guoshi.baselib.utils.SignUtil
import com.guoshi.baselib.utils.StatusBarUtil
import com.guoshi.baselib.view.CustomToast
import com.guoshi.module_home.BR
import com.guoshi.module_home.R
import com.guoshi.module_home.adapter.MvvmCommonAdapter
import com.guoshi.module_home.databinding.ActivityPublicMainBinding
import com.guoshi.module_home.fragment.AllFragment
import com.guoshi.module_home.fragment.FundCompanyFragment
import com.guoshi.module_home.fragment.FundManagerFragment
import com.guoshi.module_home.fragment.FundProductFragment
import com.guoshi.module_home.seek.SeekActivity

import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

import java.lang.reflect.Field
import java.util.ArrayList
import java.util.HashMap

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：公募主界面
 */
@Route(path = ModuleHomeUtlis.PUBLIC_MAIN)
class PublicMainActivity : BaseActivity(), View.OnClickListener {
    private var binding: ActivityPublicMainBinding? = null
    private var fragmentList: MutableList<Fragment>? = null
    private var KEY: String? = ""

    private var allFragment: AllFragment? = null
    private var fundProductFragment: FundProductFragment? = null
    private var fundCompanyFragment: FundCompanyFragment? = null
    private var fundManagerFragment: FundManagerFragment? = null

    private var seekList: MutableList<Seek>? = null
    private var hotmvvmCommonAdapter: MvvmCommonAdapter? = null
    private var historyDao: HistoryDao? = null
    private val historyList = ArrayList<History>()
    private var historymvvmCommonAdapter: MvvmCommonAdapter? = null

    private val navigationTag = ArrayList<String>()
    internal var smasher: ParticleSmasher? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBarLightMode(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_public_main)
        initview()
        load()
    }

    private fun initview() {
        EventBus.getDefault().register(this)
        binding!!.publichistorydelete.setOnClickListener(this)
        binding!!.publictop.findViewById<View>(R.id.baseback).setOnClickListener(this)
        (binding!!.publictop.findViewById<View>(R.id.alltext) as TextView).text = "公募"

        //搜索框文字设置
        val editText = binding!!.publicsearchview.findViewById<EditText>(R.id.search_src_text)
        editText.textSize = 14f

        //搜索框右边图标设置
        val closeViewIcon = binding!!.publicsearchview.findViewById<ImageView>(R.id.search_close_btn)
        closeViewIcon.setImageDrawable(
            ContextCompat
                .getDrawable(this, R.mipmap.souclear)
        )
        //去除下划线
        binding!!.publicsearchview.findViewById<View>(R.id.search_plate).background = null
        binding!!.publicsearchview.findViewById<View>(R.id.submit_area).background = null

        //搜索历史
        binding!!.publichistoryHotRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding!!.publichistoryHotRecyclerView.isNestedScrollingEnabled = false
        historyDao = Myaplication.getInstances().daoSession.historyDao
        mainhistory()

        //发现RecyclerView
        binding!!.HotRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding!!.HotRecyclerView.isNestedScrollingEnabled = false

        //搜索框内容变化监听
        binding!!.publicsearchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                binding!!.publicoka.visibility = View.GONE
                binding!!.publicokb.visibility = View.VISIBLE
                //点击搜索按钮将搜索内容加入数据库
                for (history in historyList) {
                    if (history.getContent() == s) {
                        historyDao!!.delete(history)
                        break
                    }
                }
                val history = History()
                history.setContent(s)
                history.setType(1)
                historyDao!!.insert(history)
                mainhistory()
                return false
            }

            override fun onQueryTextChange(s: String?): Boolean {//搜索框内容变化时
                if ("" != s && s != null) {
                    KEY = s
                    binding!!.publicoka.visibility = View.GONE
                    binding!!.publicokb.visibility = View.VISIBLE
                    binding!!.publicmainviewpager.setCurrentItem(0, false)
                    setkey()
                } else {
                    binding!!.publicoka.visibility = View.VISIBLE
                    binding!!.publicokb.visibility = View.GONE
                }
                return false
            }
        })
        fragmentList = ArrayList()
        allFragment = AllFragment()
        fundProductFragment = FundProductFragment()
        fundCompanyFragment = FundCompanyFragment()
        fundManagerFragment = FundManagerFragment()
        fragmentList!!.add(allFragment!!)
        fragmentList!!.add(fundProductFragment!!)
        fragmentList!!.add(fundCompanyFragment!!)
        fragmentList!!.add(fundManagerFragment!!)
        navigationTag.add("全部")
        navigationTag.add("基金产品")
        navigationTag.add("基金公司")
        navigationTag.add("基金经理")
        binding!!.publicmainviewpager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(i: Int): Fragment {
                return fragmentList!![i]
            }

            override fun getCount(): Int {
                return fragmentList!!.size
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                super.destroyItem(container, position, `object`)
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return navigationTag[position]
            }
        }
        binding!!.publicmaintablayout.setupWithViewPager(binding!!.publicmainviewpager)
        reflex(binding!!.publicmaintablayout)
        binding!!.publicmainviewpager.offscreenPageLimit = 3

        //去除点击黑色背景
        binding!!.publicmaintablayout.tabRippleColor = ColorStateList.valueOf(
            this@PublicMainActivity.resources.getColor(R.color.white)
        )
        //取消点击tab，feagment切换动画
        binding!!.publicmaintablayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                BaseActivity.hidenInputMethod(this@PublicMainActivity)
                val position = tab.position
                binding!!.publicmainviewpager.setCurrentItem(position, false)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })


    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: MyEvenbus) {
        if ("Uppubliclist" == event.tag) {
            val index = Integer.parseInt(event.message)
            binding!!.publicmainviewpager.setCurrentItem(index, false)
        } else if ("addhistory" == event.tag) {
            //点击搜索按钮将搜索内容加入数据库
            for (history in historyList) {
                if (history.getContent() == event.message) {
                    historyDao!!.delete(history)
                    break
                }
            }
            val history = History()
            history.setContent(event.message)
            history.setType(1)
            historyDao!!.insert(history)
            mainhistory()
        }
    }

    private fun setkey() {
        allFragment!!.setKey(KEY!!)
        fundProductFragment!!.setKey(KEY!!)
        fundCompanyFragment!!.setKey(KEY!!)
        fundManagerFragment!!.setKey(KEY!!)
    }

    private fun mainhistory() {
        historyList.clear()
        val historys = historyDao!!.queryBuilder()
            .where(HistoryDao.Properties.Type.eq(1))
            .orderDesc(HistoryDao.Properties.Id)
            .limit(9)
            .list()
        historyList.addAll(historys)
        if (historyList.size == 0) {
            binding!!.historylin.visibility = View.GONE
        } else {
            binding!!.historylin.visibility = View.VISIBLE
            binding!!.publichistoryHotRecyclerView.visibility = View.VISIBLE
            if (historymvvmCommonAdapter == null) {
                historymvvmCommonAdapter = MvvmCommonAdapter(historyList, BR.history, this, R.layout.history_item)
                binding!!.publichistoryHotRecyclerView.adapter = historymvvmCommonAdapter
                historymvvmCommonAdapter!!.setOnItemClickListener(object : MvvmCommonAdapter.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        binding!!.publicsearchview.setQuery(historyList[position].getContent(), true)
                    }
                })
            } else {
                historymvvmCommonAdapter!!.notifyDataSetChanged()
            }
            if (smasher != null) {
                smasher!!.reShowView(binding!!.historylin)
            }
        }
    }

    /**
     * 自定义Tab的View
     * @param currentPosition
     * @return
     */
    private fun getTabView(currentPosition: Int): View {
        val view = LayoutInflater.from(this@PublicMainActivity).inflate(R.layout.layout_tab, null)
        val textView = view.findViewById<View>(R.id.tab_item_textview) as TextView
        textView.text = navigationTag[currentPosition]
        return view
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.baseback) {
            if (binding!!.publicokb.visibility == View.VISIBLE && "" != KEY) {
                BaseActivity.hidenInputMethod(this@PublicMainActivity)
                binding!!.publicoka.visibility = View.VISIBLE
                binding!!.publicokb.visibility = View.GONE
                binding!!.publicsearchview.setQuery("", false)
            } else {
                finish()
                BaseActivity.Companion.outacvivity(this@PublicMainActivity)
            }
        } else if (id == R.id.publichistorydelete) {
            smasher = ParticleSmasher(this)
            // 默认为爆炸动画
            smasher!!.with(binding!!.historylin)
                .setStyle(SmashAnimator.STYLE_EXPLOSION)    // 设置动画样式
                .setDuration(500)                     // 设置动画时间
                .setStartDelay(300)                    // 设置动画前延时
                .setHorizontalMultiple(2f)              // 设置横向运动幅度，默认为3
                .setVerticalMultiple(2f)                // 设置竖向运动幅度，默认为4
                .addAnimatorListener(object : SmashAnimator.OnAnimatorListener() {
                    override fun onAnimatorStart() {
                        super.onAnimatorStart()
                        // 回调，动画开始
                    }

                    override fun onAnimatorEnd() {
                        super.onAnimatorEnd()
                        // 回调，动画结束
                        binding!!.historylin.visibility = View.GONE
                        historyDao!!.deleteAll()
                        historyList.clear()
                        historymvvmCommonAdapter!!.notifyDataSetChanged()
                    }
                })
                .start()
        }
    }

    override fun onBackPressed() {
        if (binding!!.publicokb.visibility == View.VISIBLE && "" != KEY) {
            binding!!.publicoka.visibility = View.VISIBLE
            binding!!.publicokb.visibility = View.GONE
            binding!!.publicsearchview.setQuery("", false)
        } else {
            finish()
            BaseActivity.Companion.outacvivity(this)
        }
    }

    private fun load() {
        val timestamp = BaseActivity.getTime()
        val map = HashMap<String, Any>()
        map["timestamp"] = timestamp
        val sign = SignUtil.getSign(map, HttpConfig.APPKEY)
        map["sign"] = sign
        val observable1 = RetrofitFactory.getInstence(this@PublicMainActivity)!!.API()
            .publicFunds_find(map)
            .compose(this.setThread())
        observable1
            .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
            .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
            .subscribe(object : BaseObserver<List<Seek>>() {
                @Throws(Exception::class)
                override fun onSuccees(t: BaseEntity<List<Seek>>) {
                    if (t.status == 1) {
                        if (seekList == null) {
                            seekList = ArrayList()
                        }
                        seekList!!.addAll((t.data as List<Seek>?)!!)
                        hotmvvmCommonAdapter = MvvmCommonAdapter(
                            seekList!!, BR.seek,
                            this@PublicMainActivity, R.layout.seek_item
                        )
                        binding!!.HotRecyclerView.adapter = hotmvvmCommonAdapter
                    } else {
                        CustomToast.showToast(this@PublicMainActivity, t.message)
                    }
                }

                @Throws(Exception::class)
                override fun onFailure(e: Throwable, isNetWorkError: Boolean) {

                }
            })
    }

    companion object {
        fun reflex(tabLayout: TabLayout) {
            //了解源码得知 线的宽度是根据 tabView的宽度来设置的
            tabLayout.post {
                try {
                    //拿到tabLayout的mTabStrip属性
                    val mTabStrip = tabLayout.getChildAt(0) as LinearLayout
                    val dp10 = BaseActivity.Companion.dip2px(tabLayout.context, 10f)
                    for (i in 0 until mTabStrip.childCount) {
                        val tabView = mTabStrip.getChildAt(i)
                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        val mTextViewField = tabView.javaClass.getDeclaredField("mTextView")
                        mTextViewField.isAccessible = true
                        val mTextView = mTextViewField.get(tabView) as TextView
                        tabView.setPadding(0, 0, 0, 0)
                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        var width = 0
                        width = mTextView.width
                        if (width == 0) {
                            mTextView.measure(0, 0)
                            width = mTextView.measuredWidth
                        }
                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        val params = tabView.layoutParams as LinearLayout.LayoutParams
                        params.width = width
                        params.leftMargin = dp10
                        params.rightMargin = dp10
                        tabView.layoutParams = params
                        tabView.invalidate()
                    }

                } catch (e: NoSuchFieldException) {
                    e.printStackTrace()
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }
            }

        }
    }
}
