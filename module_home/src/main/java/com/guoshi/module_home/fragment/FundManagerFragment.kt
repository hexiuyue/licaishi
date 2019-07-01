package com.guoshi.module_home.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.guoshi.baselib.api.http.RetrofitFactory
import com.guoshi.baselib.api.http.base.BaseObserver
import com.guoshi.baselib.api.http.bean.BaseEntity
import com.guoshi.baselib.api.http.config.HttpConfig
import com.guoshi.baselib.base.BaseActivity
import com.guoshi.baselib.base.BaseFragment
import com.guoshi.baselib.entity.fund.FundManger
import com.guoshi.baselib.evenbus.MyEvenbus
import com.guoshi.baselib.layout.LoadDataLayout
import com.guoshi.baselib.utils.ClassicsFooter
import com.guoshi.baselib.utils.SignUtil
import com.guoshi.baselib.view.CustomToast
import com.guoshi.module_home.BR
import com.guoshi.module_home.R
import com.guoshi.module_home.adapter.MvvmCommonAdapter
import com.guoshi.module_home.databinding.FragmentFundManagerBinding
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener

import org.greenrobot.eventbus.EventBus

import java.util.ArrayList
import java.util.HashMap

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：搜索基金经理界面
 */
class FundManagerFragment : BaseFragment() {
    private var binding: FragmentFundManagerBinding? = null
    private var KEY = "1"
    private var fundMangers: MutableList<FundManger>? = null
    private var fundMangersMvvmCommonAdapter: MvvmCommonAdapter? = null
    private var pageIndex = 1
    private var totalPage: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fund_manager, container, false)
        initview()
        return binding!!.root
    }

    private fun initview() {
        binding!!.ldl.setBindView(binding!!.lv)

        //基金经理
        binding!!.fundFundmangerRecyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL, false
        )
        binding!!.fundFundmangerRecyclerView.isNestedScrollingEnabled = false

        binding!!.SmartRefresh.setRefreshHeader(ClassicsHeader(activity!!))
        binding!!.SmartRefresh.setRefreshFooter(ClassicsFooter(activity))
        binding!!.SmartRefresh.setEnableRefresh(false)
        binding!!.SmartRefresh.setEnableLoadMore(true)
        binding!!.SmartRefresh.setEnableAutoLoadMore(false)
        binding!!.SmartRefresh.setOnLoadMoreListener {
            pageIndex++
            load()
        }
        binding!!.ldl.setRefreshListener { setKey(KEY) }
    }

    fun setKey(key: String) {
        KEY = key
        pageIndex = 1
        if (fundMangers != null) {
            fundMangers!!.clear()
        }
        load()
    }

    private fun load() {
        if (pageIndex == 1) {
            binding!!.ldl.showLoading("努力加载中")
        }
        val timestamp = BaseActivity.getTime()
        val map = HashMap<String, Any>()
        map["keyword"] = KEY
        map["timestamp"] = timestamp
        map["pageIndex"] = pageIndex
        map["pageSize"] = HttpConfig.pageSize
        val sign = SignUtil.getSign(map, HttpConfig.APPKEY)
        map["sign"] = sign
        val observable = RetrofitFactory.getInstence(activity!!)!!
            .API()
            .publicFunds_moreManagers(map)
            .compose(this.setThread())
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
            .subscribe(object : BaseObserver<List<FundManger>>() {
                @Throws(Exception::class)
                override fun onSuccees(t: BaseEntity<List<FundManger>>) {
                    map.clear()
                    if (t.status == 1) {
                        totalPage = t.totalPage
                        if (fundMangers == null) {
                            fundMangers = ArrayList()
                        }
                        if (t.data != null && (t.data as Collection<FundManger>).size > 0) {
                            fundMangers!!.addAll((t.data as Collection<FundManger>?)!!)
                        }
                        if (fundMangers!!.size > 0) {
                            if (fundMangersMvvmCommonAdapter == null) {
                                fundMangersMvvmCommonAdapter = MvvmCommonAdapter(
                                    fundMangers!!, BR.funmanger, activity!!, R.layout.fund_manger_item, KEY
                                )
                                binding!!.fundFundmangerRecyclerView.adapter = fundMangersMvvmCommonAdapter
                                fundMangersMvvmCommonAdapter!!.setOnItemClickListener(object :
                                    MvvmCommonAdapter.OnItemClickListener {
                                    override fun onItemClick(view: View, position: Int) {
                                        //点击搜索按钮将搜索内容加入数据库
                                        EventBus.getDefault().post(MyEvenbus("addhistory", KEY))
                                    }
                                })
                            } else {
                                fundMangersMvvmCommonAdapter!!.setKET(KEY)
                            }
                            if (pageIndex < totalPage) {
                                binding!!.SmartRefresh.finishLoadMore(0, true, false)
                            } else {
                                binding!!.SmartRefresh.finishLoadMore(0, true, true)
                            }
                            binding!!.ldl.showSuccess()
                        } else {
                            binding!!.ldl.showEmpty("抱歉，未找到与“$KEY”相关的基金经理。", KEY) { img ->
                                Glide.with(activity!!)
                                    .load(R.mipmap.oknull)
                                    .into(img)
                            }
                        }
                    } else {
                        CustomToast.showToast(activity, t.message)
                    }
                }

                @Throws(Exception::class)
                override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                    binding!!.ldl.showError("网络异常，点击重新加载")
                    map.clear()
                }
            })
    }
}
