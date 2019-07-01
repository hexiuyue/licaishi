package com.guoshi.module_home.public_placement

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.TextView

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.guoshi.baselib.api.http.RetrofitFactory
import com.guoshi.baselib.api.http.base.BaseObserver
import com.guoshi.baselib.api.http.bean.BaseEntity
import com.guoshi.baselib.api.http.config.HttpConfig
import com.guoshi.baselib.base.BaseActivity
import com.guoshi.baselib.entity.Seek
import com.guoshi.baselib.entity.fund.Placement
import com.guoshi.baselib.route.ModuleHomeUtlis
import com.guoshi.baselib.utils.SignUtil
import com.guoshi.baselib.utils.StatusBarUtil
import com.guoshi.baselib.view.CustomToast
import com.guoshi.module_home.BR
import com.guoshi.module_home.R
import com.guoshi.module_home.adapter.MvvmCommonAdapter
import com.guoshi.module_home.databinding.ActivityPublicListBinding
import com.guoshi.module_home.seek.SeekActivity
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.guoshi.baselib.utils.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener

import java.util.ArrayList
import java.util.HashMap

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：公募搜索列表
 */
@Route(path = ModuleHomeUtlis.PUBLIC_LIST)
class PublicListActivity : BaseActivity(), View.OnClickListener {
    private var binding: ActivityPublicListBinding? = null
    private var key: String? = null
    private var mvvmCommonAdapter: MvvmCommonAdapter? = null
    private var placementList: MutableList<Placement>? = null
    private var pageIndex = 1
    private var totalPage: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBarLightMode(this)
        ARouter.getInstance().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_public_list)
        initview()
        load()
    }

    private fun initview() {
        binding!!.publiclisttop.findViewById<View>(R.id.baseback).setOnClickListener(this)
        (binding!!.publiclisttop.findViewById<View>(R.id.alltext) as TextView).text = "公募基金列表"
        binding!!.publicListRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        binding!!.publicListRecyclerView.isNestedScrollingEnabled = false


        binding!!.SmartRefresh.setRefreshHeader(ClassicsHeader(this))
        binding!!.SmartRefresh.setRefreshFooter(ClassicsFooter(this))
        binding!!.SmartRefresh.setEnableRefresh(false)//关闭刷新
        binding!!.SmartRefresh.setEnableLoadMore(true)//打开加载
        binding!!.SmartRefresh.setEnableAutoLoadMore(false)
        binding!!.SmartRefresh.setOnLoadMoreListener {
            pageIndex++
            load()
        }
    }

    override fun onBackPressed() {
        finish()
        BaseActivity.Companion.outacvivity(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.baseback) {
            finish()
            BaseActivity.Companion.outacvivity(this@PublicListActivity)
        }
    }

    private fun load() {
        val timestamp = BaseActivity.getTime()
        val map = HashMap<String, Any>()
        map["timestamp"] = timestamp
        map["keyword"] = key!!
        map["pageIndex"] = pageIndex
        map["pageSize"] = HttpConfig.pageSize
        val sign = SignUtil.getSign(map, HttpConfig.APPKEY)
        map["sign"] = sign
        val observable1 = RetrofitFactory.getInstence(this@PublicListActivity)!!.API()
            .mainPage_morePublicFunds(map)
            .compose(this.setThread())
        observable1
            .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
            .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
            .subscribe(object : BaseObserver<List<Placement>>() {
                @Throws(Exception::class)
                override fun onSuccees(t: BaseEntity<List<Placement>>) {
                    map.clear()
                    if (t.status == 1) {
                        totalPage = t.totalPage
                        if (placementList == null) {
                            placementList = ArrayList()
                        }
                        if (t.data != null && (t.data as List<Placement>).size > 0) {
                            placementList!!.addAll((t.data as List<Placement>?)!!)
                        } else {
                            binding!!.SmartRefresh.finishLoadMore(0, true, true)
                            return
                        }
                        if (placementList!!.size > 0) {
                            if (mvvmCommonAdapter == null) {
                                mvvmCommonAdapter = MvvmCommonAdapter(
                                    placementList!!, BR.publicobj, this@PublicListActivity, R.layout.public_item
                                )
                                binding!!.publicListRecyclerView.adapter = mvvmCommonAdapter
                            } else {
                                mvvmCommonAdapter!!.notifyDataSetChanged()
                            }
                        }
                    } else {
                        CustomToast.showToast(this@PublicListActivity, t.message)
                    }
                    if (pageIndex < totalPage) {
                        binding!!.SmartRefresh.finishLoadMore(0, true, false)
                    } else {
                        binding!!.SmartRefresh.finishLoadMore(0, true, true)
                    }

                }

                @Throws(Exception::class)
                override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                    map.clear()
                }
            })
    }
}
