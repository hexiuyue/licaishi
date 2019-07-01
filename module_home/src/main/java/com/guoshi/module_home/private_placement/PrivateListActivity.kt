package com.guoshi.module_home.private_placement

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
import com.guoshi.baselib.entity.fund.Placement
import com.guoshi.baselib.route.ModuleHomeUtlis
import com.guoshi.baselib.utils.SignUtil
import com.guoshi.baselib.utils.StatusBarUtil
import com.guoshi.baselib.view.CustomToast
import com.guoshi.module_home.BR
import com.guoshi.module_home.R
import com.guoshi.module_home.adapter.MvvmCommonAdapter
import com.guoshi.module_home.databinding.ActivityPrivateBinding
import com.guoshi.module_home.public_placement.PublicListActivity
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
 * 文件描述：私募搜索列表
 */
@Route(path = ModuleHomeUtlis.PRIVATE_LIST)
class PrivateListActivity : BaseActivity(), View.OnClickListener {
     var binding: ActivityPrivateBinding? = null
     var key: String? = null

     var privateMvvmCommonAdapter: MvvmCommonAdapter? = null
     var placementList: MutableList<Placement>? = null

     var pageIndex = 1
     var totalPage: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBarLightMode(this)
//        ARouter.getInstance().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_private)
        initview()
        load()
    }

    private fun initview() {

        binding!!.privatelisttop.findViewById<View>(R.id.baseback).setOnClickListener(this)
        (binding!!.privatelisttop.findViewById<View>(R.id.alltext) as TextView).text = "私募基金列表"
        binding!!.privateListRecyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        binding!!.privateListRecyclerView.isNestedScrollingEnabled = false


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

    override fun onClick(v: View) {
        val i = v.id
        if (i == R.id.baseback) {
            finish()
            outacvivity(this@PrivateListActivity)
        }
    }

    override fun onBackPressed() {
        finish()
        outacvivity(this)
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
        val observable1 = RetrofitFactory.getInstence(this@PrivateListActivity)!!.API()
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
                        if (t.data != null) {
                            placementList!!.addAll((t.data as List<Placement>?)!!)
                        } else {
                            binding!!.SmartRefresh.finishLoadMore(0, true, true)
                            return
                        }
                        if (placementList!!.size > 0) {
                            if (privateMvvmCommonAdapter == null) {
                                privateMvvmCommonAdapter = MvvmCommonAdapter(
                                    placementList!!, BR.privateobj, this@PrivateListActivity, R.layout.private_item
                                )
                                binding!!.privateListRecyclerView.adapter = privateMvvmCommonAdapter
                            } else {
                                privateMvvmCommonAdapter!!.notifyDataSetChanged()
                            }
                        }
                    } else {
                        CustomToast.showToast(this@PrivateListActivity, t.message)
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
