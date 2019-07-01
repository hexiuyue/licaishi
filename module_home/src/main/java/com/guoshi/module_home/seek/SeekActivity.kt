package com.guoshi.module_home.seek

import android.databinding.DataBindingUtil
import android.support.v4.content.ContextCompat
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.ImageView

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.fadai.particlesmasher.ParticleSmasher
import com.fadai.particlesmasher.SmashAnimator
import com.guoshi.baselib.Myaplication
import com.guoshi.baselib.api.http.RetrofitFactory
import com.guoshi.baselib.api.http.base.BaseObserver
import com.guoshi.baselib.api.http.bean.BaseEntity
import com.guoshi.baselib.api.http.config.HttpConfig
import com.guoshi.baselib.base.BaseActivity
import com.guoshi.baselib.db.HistoryDao
import com.guoshi.baselib.entity.module_home.Products
import com.guoshi.baselib.layout.LoadDataLayout
import com.guoshi.baselib.route.ModuleHomeUtlis
import com.guoshi.baselib.utils.ClassicsFooter
import com.guoshi.baselib.utils.SignUtil
import com.guoshi.baselib.utils.StatusBarUtil
import com.guoshi.baselib.view.CustomToast
import com.guoshi.module_home.BR
import com.guoshi.module_home.R
import com.guoshi.module_home.adapter.MvvmCommonAdapter
import com.guoshi.module_home.databinding.ActivitySeekBinding
import com.guoshi.baselib.entity.History
import com.guoshi.baselib.entity.Seek
import com.scwang.smartrefresh.layout.header.ClassicsHeader

import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList
import java.util.HashMap

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：首页搜索界面
 */
@Route(path = ModuleHomeUtlis.HOME_SEEK)
class SeekActivity : BaseActivity(), View.OnClickListener {
    private var binding: ActivitySeekBinding? = null
    private var historyDao: HistoryDao? = null
    private var searchView: SearchView? = null

    private var KEY: String? = ""
    private var seekList: MutableList<Seek>? = null
    private var hotmvvmCommonAdapter: MvvmCommonAdapter? = null
    private val historyList = ArrayList<History>()
    private var historymvvmCommonAdapter: MvvmCommonAdapter? = null
    private var filterhistory: MutableList<History>? = null
    private var publicMvvmCommonAdapter: MvvmCommonAdapter? = null
    private var privateMvvmCommonAdapter: MvvmCommonAdapter? = null
    private var backProductsadapter: MvvmCommonAdapter? = null
    internal var smasher: ParticleSmasher? = null

    private var products: Products? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_seek)
        StatusBarUtil.setStatusBarLightMode(this)
        initview()
        load()
        //        adduser();
    }

    private fun initview() {
        binding!!.ldl.setBindView(binding!!.SmartRefresh)
        binding!!.ldlpublic.setBindView(binding!!.publicRecyclerView)
        binding!!.ldlprivate.setBindView(binding!!.privateRecyclerView)
        binding!!.ldlbank.setBindView(binding!!.bankRecyclerView)
        historyDao = Myaplication.getInstances().daoSession.historyDao
        searchView = binding!!.seektop.findViewById(R.id.SearchView)
        binding!!.seektop.findViewById<View>(R.id.seekback).setOnClickListener(this)
        binding!!.seektop.findViewById<View>(R.id.seektopview).visibility = View.VISIBLE
        binding!!.seektop.findViewById<View>(R.id.alltop).visibility = View.GONE
        binding!!.intopubliclist.setOnClickListener(this)
        binding!!.intoprivatelist.setOnClickListener(this)
        //搜索框文字设置
        val editText = searchView!!.findViewById<EditText>(R.id.search_src_text)
        editText.textSize = 14f
        //点击删除历史搜索
        binding!!.historydelete.setOnClickListener(this)
        //搜索框右边图标设置
        val closeViewIcon = searchView!!.findViewById<ImageView>(R.id.search_close_btn)
        closeViewIcon.setImageDrawable(
            ContextCompat
                .getDrawable(this, R.mipmap.souclear)
        )
        //去除下划线
        searchView!!.findViewById<View>(R.id.search_plate).background = null
        searchView!!.findViewById<View>(R.id.submit_area).background = null
        //搜索框内容变化监听
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                //点击搜索按钮将搜索内容加入数据库
                for (history in historyList) {
                    if (history.getContent() == s) {
                        historyDao!!.delete(history)
                        break
                    }
                }
                val history = History()
                history.setContent(s)
                history.setType(0)
                historyDao!!.insert(history)
                inithistorydata()
                //确认搜索搜索词用于列表关键字变红
                KEY = s
                if ("" != KEY && KEY != null) {//有搜索内容时
                    loadseek()
                } else {//无搜索内容时
                    binding!!.ldl.visibility = View.GONE
                    binding!!.resouview.visibility = View.VISIBLE
                }
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {//搜索框内容变化时
                KEY = s
                if ("" != KEY && KEY != null) {
                    loadseek()
                } else {
                    binding!!.ldl.visibility = View.GONE
                    binding!!.resouview.visibility = View.VISIBLE
                }
                return false
            }
        })

        //热门搜索RecyclerView
        binding!!.HotRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding!!.HotRecyclerView.isNestedScrollingEnabled = false
        //历史搜索
        binding!!.historyHotRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding!!.historyHotRecyclerView.isNestedScrollingEnabled = false
        inithistorydata()

        //搜索成功+联动搜索
        //公募基金
        binding!!.publicRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        binding!!.publicRecyclerView.isNestedScrollingEnabled = false

        //私募基金
        binding!!.privateRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        binding!!.privateRecyclerView.isNestedScrollingEnabled = false

        //银行理财
        binding!!.bankRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        binding!!.bankRecyclerView.isNestedScrollingEnabled = false

        binding!!.SmartRefresh.setRefreshHeader(ClassicsHeader(this))
        binding!!.SmartRefresh.setRefreshFooter(ClassicsFooter(this))
        binding!!.SmartRefresh.setEnableRefresh(false)//关闭刷新
        binding!!.SmartRefresh.setEnableLoadMore(true)//打开加载
        binding!!.SmartRefresh.setEnableAutoLoadMore(false)//是否启用列表惯性滑动到底部时自动加载更多
        binding!!.SmartRefresh.finishLoadMoreWithNoMoreData()//完成加载并标记没有更多数据


        binding!!.seekokview.setOnTouchListener { v, event ->
            //隐藏输入法
            when (event.action) {
                MotionEvent.ACTION_DOWN -> BaseActivity.hidenInputMethod(this@SeekActivity)
                MotionEvent.ACTION_MOVE -> BaseActivity.hidenInputMethod(this@SeekActivity)
            }
            false
        }

        binding!!.ldl.setRefreshListener { loadseek() }
    }

    override fun onRestart() {
        super.onRestart()
        binding!!.seektop.isFocusable = true
        binding!!.seektop.isFocusableInTouchMode = true
        binding!!.seektop.requestFocus()
    }

    private fun initsouok() {
        if (products!!.publicFunds != null && products!!.publicFunds!!.size > 0) {
            if (publicMvvmCommonAdapter == null) {
                publicMvvmCommonAdapter = MvvmCommonAdapter(
                    products!!.publicFunds!!, BR.publicobj, this@SeekActivity, R.layout.public_item, KEY!!
                )
                binding!!.publicRecyclerView.adapter = publicMvvmCommonAdapter
                publicMvvmCommonAdapter!!.setOnItemClickListener(object : MvvmCommonAdapter.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        //加入历史搜索
                        for (history in historyList) {
                            if (history.getContent() == KEY) {
                                historyDao!!.delete(history)
                                break
                            }
                        }
                        val history = History()
                        history.setContent(KEY!!)
                        history.setType(0)
                        historyDao!!.insert(history)
                        inithistorydata()
                    }
                })
            } else {
                publicMvvmCommonAdapter!!.setKET(KEY!!)
            }
            if (products!!.publicFunds!!.size < 5) {
                binding!!.intopubliclist.visibility = View.GONE
            } else {
                binding!!.intopubliclist.visibility = View.VISIBLE
            }
            binding!!.ldlpublic.showSuccess()
        } else {
            binding!!.ldlpublic.showEmpty(
                "抱歉，未找到与“$KEY”相关的公募产品",
                KEY, null
            )
            binding!!.intopubliclist.visibility = View.GONE
        }

        if (products!!.privateFunds != null && products!!.privateFunds!!.size > 0) {
            if (privateMvvmCommonAdapter == null) {
                privateMvvmCommonAdapter = MvvmCommonAdapter(
                    products!!.privateFunds!!, BR.privateobj, this@SeekActivity, R.layout.private_item, KEY!!
                )
                binding!!.privateRecyclerView.adapter = privateMvvmCommonAdapter
                privateMvvmCommonAdapter!!.setOnItemClickListener(object : MvvmCommonAdapter.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        //加入历史搜索
                        for (history in historyList) {
                            if (history.getContent() == KEY) {
                                historyDao!!.delete(history)
                                break
                            }
                        }
                        val history = History()
                        history.setContent(KEY!!)
                        history.setType(0)
                        historyDao!!.insert(history)
                        inithistorydata()
                    }
                })
            } else {
                privateMvvmCommonAdapter!!.setKET(KEY!!)
            }
            if (products!!.privateFunds!!.size < 5) {
                binding!!.intoprivatelist.visibility = View.GONE
            } else {
                binding!!.intoprivatelist.visibility = View.VISIBLE
            }
            binding!!.ldlprivate.showSuccess()
        } else {
            binding!!.ldlprivate.showEmpty(
                "抱歉，未找到与“$KEY”相关的私募产品",
                KEY, null
            )
            binding!!.intoprivatelist.visibility = View.GONE
        }
        if (products!!.bankProducts != null && products!!.bankProducts!!.size > 0) {
            if (backProductsadapter == null) {
                backProductsadapter = MvvmCommonAdapter(
                    products!!.bankProducts!!, BR.backproduct, this@SeekActivity, R.layout.back_product_item, KEY!!
                )
                binding!!.bankRecyclerView.adapter = backProductsadapter
                backProductsadapter!!.setOnItemClickListener(object : MvvmCommonAdapter.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        addhistory()
                    }
                })
            } else {
                backProductsadapter!!.setKET(KEY!!)
            }
            if (products!!.bankProducts!!.size < 5) {
                binding!!.bankgengduo.visibility = View.GONE
            } else {
                binding!!.bankgengduo.visibility = View.VISIBLE
            }
            binding!!.ldlbank.showSuccess()
        } else {
            binding!!.ldlbank.showEmpty(
                "抱歉，未找到与“$KEY”相关的银行产品",
                KEY, null
            )
            binding!!.bankgengduo.visibility = View.GONE
        }


    }

    private fun inithistorydata() {
        historyList.clear()
        val historys = historyDao!!.queryBuilder()
            .where(HistoryDao.Properties.Type.eq(0))
            .orderDesc(HistoryDao.Properties.Id)
            .limit(9)
            .list()
        historyList.addAll(historys)
        if (historyList.size == 0) {
            binding!!.historylin.visibility = View.GONE
        } else {
            binding!!.historylin.visibility = View.VISIBLE
            binding!!.historyHotRecyclerView.visibility = View.VISIBLE
            if (historymvvmCommonAdapter == null) {
                historymvvmCommonAdapter = MvvmCommonAdapter(historyList, BR.history, this, R.layout.history_item)
                binding!!.historyHotRecyclerView.adapter = historymvvmCommonAdapter
                historymvvmCommonAdapter!!.setOnItemClickListener(object : MvvmCommonAdapter.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        searchView!!.setQuery(historyList[position].getContent(), true)
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

    private fun filter(strings: List<History>, text: String): List<History> {
        filterhistory = ArrayList()
        for (word in strings) {
            if (word.getContent()!!.contains(text))
                filterhistory!!.add(word)
        }
        return filterhistory as ArrayList<History>
    }

    override fun onClick(v: View) {
        val i = v.id
        if (i == R.id.seekback) {
            if (binding!!.ldl.visibility == View.VISIBLE) {
                BaseActivity.hidenInputMethod(this@SeekActivity)
                searchView!!.setQuery("", false)
            } else {
                finish()
                BaseActivity.Companion.outacvivity(this@SeekActivity)
            }
        } else if (i == R.id.intopubliclist) {
            addhistory()
            ARouter.getInstance()
                .build(ModuleHomeUtlis.PUBLIC_LIST)
                .withString("key", KEY)
                .withTransition(R.anim.slide_right_in, R.anim.slide_left_out)
                .navigation()
        } else if (i == R.id.intoprivatelist) {
            addhistory()
            ARouter.getInstance()
                .build(ModuleHomeUtlis.PRIVATE_LIST)
                .withString("key", KEY)
                .withTransition(R.anim.slide_right_in, R.anim.slide_left_out)
                .navigation()
        } else if (i == R.id.historydelete) {
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
        if (binding!!.ldl.visibility == View.VISIBLE) {
            searchView!!.setQuery("", false)
        } else {
            finish()
            BaseActivity.Companion.outacvivity(this)
        }
    }

    private fun loadseek() {
        binding!!.ldl.visibility = View.VISIBLE
        binding!!.resouview.visibility = View.GONE
        binding!!.ldl.showLoading("努力加载中...")
        val timestamp = BaseActivity.getTime()
        val map = HashMap<String, Any>()
        map["keyword"] = KEY!!
        map["timestamp"] = timestamp
        val sign = SignUtil.getSign(map, HttpConfig.APPKEY)
        map["sign"] = sign
        val observable1 = RetrofitFactory.getInstence(this@SeekActivity)!!.API()
            .mainPage_search(map)
            .compose(this.setThread())
        observable1
            .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
            .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
            .subscribe(object : BaseObserver<Products>() {
                @Throws(Exception::class)
                override fun onSuccees(t: BaseEntity<Products>) {
                    map.clear()
                    if (t.status == 1) {
                        if (t.data == null) {
                            binding!!.ldl.showEmpty(
                                "抱歉，未找到与“$KEY”相关的基金产品",
                                KEY
                            ) { img ->
                                Glide.with(this@SeekActivity)
                                    .load(R.mipmap.oknull)
                                    .into(img)
                            }
                        } else {
                            if (products == null) {
                                products = t.data as Products?
                            } else {
                                if ((t.data as Products).publicFunds == null &&
                                    (t.data as Products).privateFunds == null &&
                                    (t.data as Products).bankProducts == null
                                ) {
                                    binding!!.ldl.showEmpty(
                                        "抱歉，未找到与“$KEY”相关的基金产品",
                                        KEY
                                    ) { img ->
                                        Glide.with(this@SeekActivity)
                                            .load(R.mipmap.oknull)
                                            .into(img)
                                    }
                                    return
                                } else {
                                    products!!.bankProducts!!.clear()
                                    products!!.privateFunds!!.clear()
                                    products!!.publicFunds!!.clear()
                                    if ((t.data as Products).bankProducts != null) {
                                        products!!.bankProducts!!.addAll((t.data as Products).bankProducts!!)
                                    }
                                    if ((t.data as Products).privateFunds != null) {
                                        products!!.privateFunds!!.addAll((t.data as Products).privateFunds!!)
                                    }
                                    if ((t.data as Products).publicFunds != null) {
                                        products!!.publicFunds!!.addAll((t.data as Products).publicFunds!!)
                                    }
                                }
                            }
                            initsouok()
                            binding!!.ldl.showSuccess()
                        }
                    } else {
                        CustomToast.showToast(this@SeekActivity, t.message)
                    }
                }

                @Throws(Exception::class)
                override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                    map.clear()
                    binding!!.ldl.showError("网络异常，点击重新加载")
                }
            })
    }

    private fun load() {
        val timestamp = BaseActivity.getTime()
        val map = HashMap<String, Any>()
        map["timestamp"] = timestamp
        val sign = SignUtil.getSign(map, HttpConfig.APPKEY)
        map["sign"] = sign
        val observable1 = RetrofitFactory.getInstence(this@SeekActivity)!!.API()
            .mainPage_hotSearch(map)
            .compose(this.setThread())
        observable1
            .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
            .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
            .subscribe(object : BaseObserver<List<Seek>>() {
                @Throws(Exception::class)
                override fun onSuccees(t: BaseEntity<List<Seek>>) {
                    map.clear()
                    if (t.status == 1) {
                        if (seekList == null) {
                            seekList = ArrayList()
                        }
                        seekList!!.addAll((t.data as List<Seek>?)!!)
                        hotmvvmCommonAdapter = MvvmCommonAdapter(
                            seekList!!, BR.seek,
                            this@SeekActivity, R.layout.seek_item
                        )
                        binding!!.HotRecyclerView.adapter = hotmvvmCommonAdapter
                    } else {
                        CustomToast.showToast(this@SeekActivity, t.message)

                    }
                }

                @Throws(Exception::class)
                override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                    map.clear()
                }
            })
    }

    private fun addhistory() {
        //加入历史搜索
        for (history in historyList) {
            if (history.getContent() == KEY) {
                historyDao!!.delete(history)
                break
            }
        }
        val history = History()
        history.setContent(KEY!!)
        history.setType(0)
        historyDao!!.insert(history)
        inithistorydata()
    }

    //    private void adduser(){
    //        JSONObject object=new JSONObject();
    //        try {
    //            object.put("name","knight");
    //            object.put("age",30);
    //        } catch (JSONException e) {
    //            e.printStackTrace();
    //        }
    //        String json=object.toString();
    //        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json;charset=utf-8"),json);
    //        Observable observable1= RetrofitFactory.getInstence(SeekActivity.this).API()
    //                .adduser(requestBody)
    //                .compose(this.<BaseEntity>setThread());
    //        observable1
    //                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
    //                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
    //                .subscribe(new BaseObserver<Object>(){
    //                    @Override
    //                    protected void onSuccees(BaseEntity<Object> t)throws Exception {
    //
    //                    }
    //                    @Override
    //                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
    //                    }
    //                });
    //    }
}
