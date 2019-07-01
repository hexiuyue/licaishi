package com.guoshi.module_home.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

import com.bumptech.glide.Glide
import com.guoshi.baselib.api.http.RetrofitFactory
import com.guoshi.baselib.api.http.base.BaseObserver
import com.guoshi.baselib.api.http.bean.BaseEntity
import com.guoshi.baselib.api.http.config.HttpConfig
import com.guoshi.baselib.base.BaseActivity
import com.guoshi.baselib.base.BaseFragment
import com.guoshi.baselib.entity.module_home.PublicSeek
import com.guoshi.baselib.evenbus.MyEvenbus
import com.guoshi.baselib.utils.SignUtil
import com.guoshi.baselib.view.CustomToast
import com.guoshi.module_home.BR
import com.guoshi.module_home.R
import com.guoshi.module_home.adapter.MvvmCommonAdapter
import com.guoshi.module_home.databinding.FragmentAllBinding

import org.greenrobot.eventbus.EventBus

import java.util.HashMap

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：搜索全部界面
 */
class AllFragment : BaseFragment(), View.OnClickListener {
    private var binding: FragmentAllBinding? = null
    private var publicMvvmCommonAdapter: MvvmCommonAdapter? = null
    private var fundcompanyMvvmCommonAdapter: MvvmCommonAdapter? = null
    private var fundMangersMvvmCommonAdapter: MvvmCommonAdapter? = null

    private var KEY = ""
    private var publicSeek: PublicSeek? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all, container, false)
        initview()
        return binding!!.root
    }

    private fun initview() {
        binding!!.ldl.setBindView(binding!!.seekokview)

        binding!!.porduct.setOnClickListener(this)
        binding!!.company.setOnClickListener(this)
        binding!!.fundmanger.setOnClickListener(this)
        //基金成品
        binding!!.fundPorductRecyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL, false
        )
        binding!!.fundPorductRecyclerView.isNestedScrollingEnabled = false
        //基金公司
        binding!!.fundCompanyRecyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL, false
        )
        binding!!.fundCompanyRecyclerView.isNestedScrollingEnabled = false
        //基金经理
        binding!!.fundFundmangerRecyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL, false
        )
        binding!!.fundFundmangerRecyclerView.isNestedScrollingEnabled = false
        binding!!.seekokview.setOnTouchListener { v, event ->
            //隐藏输入法
            when (event.action) {
                MotionEvent.ACTION_DOWN -> BaseActivity.hidenInputMethod(this!!.activity!!)
                MotionEvent.ACTION_MOVE -> BaseActivity.hidenInputMethod(this!!.activity!!)
            }
            false
        }
        binding!!.ldl.setRefreshListener { setKey(KEY) }
    }

    private fun initdata() {
        if (publicSeek!!.funds != null && publicSeek!!.funds!!.size > 0) {
            if (publicMvvmCommonAdapter == null) {
                publicMvvmCommonAdapter = MvvmCommonAdapter(
                    publicSeek!!.funds!!, BR.publicobj, activity!!, R.layout.public_item, KEY
                )
                binding!!.fundPorductRecyclerView.adapter = publicMvvmCommonAdapter
                publicMvvmCommonAdapter!!.setOnItemClickListener(object : MvvmCommonAdapter.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        //点击搜索按钮将搜索内容加入数据库
                        EventBus.getDefault().post(MyEvenbus("addhistory", KEY))
                    }
                })
            } else {
                publicMvvmCommonAdapter!!.setKET(KEY)
            }
            binding!!.ldlporduct.showSuccess()
        } else {
            binding!!.ldlporduct.showEmpty("抱歉，未找到与“$KEY”相关的基金产品。", KEY, null)
            binding!!.porduct.visibility = View.GONE
        }

        if (publicSeek!!.companys != null && publicSeek!!.companys!!.size > 0) {
            if (fundcompanyMvvmCommonAdapter == null) {
                fundcompanyMvvmCommonAdapter = MvvmCommonAdapter(
                    publicSeek!!.companys!!, BR.publiccompany, activity!!, R.layout.public_company_item, KEY
                )
                binding!!.fundCompanyRecyclerView.adapter = fundcompanyMvvmCommonAdapter
                fundcompanyMvvmCommonAdapter!!.setOnItemClickListener(object : MvvmCommonAdapter.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        //点击搜索按钮将搜索内容加入数据库
                        EventBus.getDefault().post(MyEvenbus("addhistory", KEY))
                    }
                })
            } else {
                fundcompanyMvvmCommonAdapter!!.setKET(KEY)
            }
            binding!!.ldlcompany.showSuccess()
        } else {
            binding!!.ldlcompany.showEmpty("抱歉，未找到与“$KEY”相关的基金公司。", KEY, null)
            binding!!.company.visibility = View.GONE
        }

        if (publicSeek!!.managers != null && publicSeek!!.managers!!.size > 0) {
            if (fundMangersMvvmCommonAdapter == null) {
                fundMangersMvvmCommonAdapter = MvvmCommonAdapter(
                    publicSeek!!.managers!!, BR.funmanger, activity!!, R.layout.fund_manger_item, KEY
                )
                binding!!.fundFundmangerRecyclerView.adapter = fundMangersMvvmCommonAdapter
                fundMangersMvvmCommonAdapter!!.setOnItemClickListener(object : MvvmCommonAdapter.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        //点击搜索按钮将搜索内容加入数据库
                        EventBus.getDefault().post(MyEvenbus("addhistory", KEY))
                    }
                })
            } else {
                fundMangersMvvmCommonAdapter!!.setKET(KEY)
            }
            binding!!.ldlmanger.showSuccess()
        } else {
            binding!!.ldlmanger.showEmpty("抱歉，未找到与“$KEY”相关的基金经理。", KEY, null)
            binding!!.fundmanger.visibility = View.INVISIBLE
        }

    }

    fun setKey(key: String) {
        KEY = key
        load()
    }

    override fun onClick(v: View) {
        val i = v.id
        if (i == R.id.porduct) {
            EventBus.getDefault().post(MyEvenbus("Uppubliclist", "1"))
        } else if (i == R.id.company) {
            EventBus.getDefault().post(MyEvenbus("Uppubliclist", "2"))
        } else if (i == R.id.fundmanger) {
            EventBus.getDefault().post(MyEvenbus("Uppubliclist", "3"))
        }
    }

    private fun load() {
        binding!!.ldl.showLoading("努力加载中...")
        val timestamp = BaseActivity.getTime()
        val map = HashMap<String, Any>()
        map["keyword"] = KEY
        map["timestamp"] = timestamp
        val sign = SignUtil.getSign(map, HttpConfig.APPKEY)
        map["sign"] = sign
        val observable1 = RetrofitFactory.getInstence(this!!.activity!!)!!.API()
            .publicFunds_search(map)
            .compose(this.setThread())
        observable1
            .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
            .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
            .subscribe(object : BaseObserver<PublicSeek>() {
                @Throws(Exception::class)
                override fun onSuccees(t: BaseEntity<PublicSeek>) {
                    map.clear()
                    if (t.status == 1) {
                        if (t.data == null) {
                            binding!!.ldl.showEmpty("抱歉，未找到与“$KEY”相关的基金信息。", KEY) { img ->
                                Glide.with(activity!!)
                                    .load(R.mipmap.oknull)
                                    .into(img)
                            }
                        } else {
                            if (publicSeek == null) {
                                publicSeek = t.data as PublicSeek
                            } else {
                                if ((t.data as PublicSeek).funds == null &&
                                    (t.data as PublicSeek).managers == null &&
                                    (t.data as PublicSeek).companys == null
                                ) {
                                    binding!!.ldl.showEmpty(
                                        "抱歉，未找到与“$KEY”相关的基金产品",
                                        KEY
                                    ) { img ->
                                        Glide.with(activity!!)
                                            .load(R.mipmap.oknull)
                                            .into(img)
                                    }
                                    return
                                } else {
                                    publicSeek!!.companys!!.clear()
                                    publicSeek!!.funds!!.clear()
                                    publicSeek!!.managers!!.clear()
                                    if ((t.data as PublicSeek).companys != null) {
                                        publicSeek!!.companys!!.addAll((t.data as PublicSeek).companys!!)
                                    }
                                    if ((t.data as PublicSeek).funds != null) {
                                        publicSeek!!.funds!!.addAll((t.data as PublicSeek).funds!!)
                                    }
                                    if ((t.data as PublicSeek).managers != null) {
                                        publicSeek!!.managers!!.addAll((t.data as PublicSeek).managers!!)
                                    }
                                }
                            }
                            initdata()
                            binding!!.ldl.showSuccess()
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
