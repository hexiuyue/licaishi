package com.guoshi.module_home.adapter

import android.content.Context
import android.content.res.Resources
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView

import com.guoshi.baselib.api.http.RetrofitFactory
import com.guoshi.baselib.api.http.base.BaseObserver
import com.guoshi.baselib.api.http.bean.BaseEntity
import com.guoshi.baselib.api.http.config.HttpConfig
import com.guoshi.baselib.base.BaseActivity
import com.guoshi.baselib.entity.Seek
import com.guoshi.baselib.entity.back.BackProducts
import com.guoshi.baselib.entity.fund.FundManger
import com.guoshi.baselib.entity.fund.Company
import com.guoshi.baselib.entity.fund.Placement
import com.guoshi.baselib.utils.SignUtil
import com.guoshi.baselib.view.CustomToast
import com.guoshi.module_home.R
import com.guoshi.baselib.entity.History

import org.json.JSONException
import org.json.JSONObject

import java.util.HashMap

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：RecyclerView通用Adapter
 */
class MvvmCommonAdapter : RecyclerView.Adapter<MvvmCommonAdapter.CommonHolder>, View.OnClickListener,
    View.OnLongClickListener {
    protected var myContext: Context
    //所有 item 的数据集合
    protected var mDatas: List<*>? = null
    //item 布局文件 id
    protected var mLayoutId: Int = 0
    protected var mInflater: LayoutInflater
    // mvvm绑定的viewModel引用
    private var mVariableId: Int = 0

    private var holder: CommonHolder? = null

    private var mOnItemClickListener: OnItemClickListener? = null
    private var onItemLongClickListener: RecyclerViewOnItemLongClickListener? = null


    private var KEY: String? = null
    fun getvview(): View {
        return holder!!.binding!!.root
    }

    //构造方法ordarrview
    constructor(datas: List<*>, variableId: Int, context: Context, layoutId: Int) {
        myContext = context
        mDatas = datas
        mLayoutId = layoutId
        mInflater = LayoutInflater.from(myContext)
        mVariableId = variableId
    }


    fun getmDatas(): List<*>? {
        return mDatas
    }

    fun setmDatas(mDatas: List<*>) {
        this.mDatas = mDatas
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonHolder {
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), mLayoutId, parent, false)
        val myHolder = CommonHolder(binding.root)
        myHolder.binding = binding
        //将创建的View注册点击事件
        binding.root.setOnClickListener(this)
        binding.root.setOnLongClickListener(this)

        //        binding.executePendingBindings(); //防止闪烁

        //        myHolder.setIsRecyclable(false);//禁止复用
        return myHolder
    }

    override fun onBindViewHolder(holder: CommonHolder, position: Int) {
        if (position == 0) {
            this.holder = holder
        }
        //item内容点击事件
        //热搜词图片
        val hotradioButton = holder.binding!!.root.findViewById<RadioButton>(R.id.hotRadioButton)
        if (hotradioButton != null) {
            val seeks = mDatas
            val seek:Seek = seeks!![position] as Seek
            if (seek.isHot === 1) {
                val res = myContext.resources
                val myImage = res.getDrawable(R.mipmap.huo)
                hotradioButton.setCompoundDrawablesWithIntrinsicBounds(null, null, myImage, null)
            } else {
                hotradioButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
            }
            //            if(2<position){
            //                if(position>4){
            //                    hotradioButton.setCompoundDrawablesWithIntrinsicBounds(null,null , null, null);
            //                }else{
            //                    Resources res = mContext.getResources();
            //                    Drawable myImage = res.getDrawable(R.mipmap.huo);
            //                    hotradioButton.setCompoundDrawablesWithIntrinsicBounds(null,null , myImage, null);
            //                }
            //            }
        }
        //联动搜索关键字字体
        //公募基金
        val publicname = holder.binding!!.root.findViewById<TextView>(R.id.publicname)
        if (publicname != null && KEY != null) {
            val publicPlacements = mDatas
            val placement:Placement = publicPlacements!![position] as Placement
            val textString = placement.fundName
            if ("" != textString && textString != null) {
                val span = ForegroundColorSpan(myContext.resources.getColor(R.color.red))//要显示的颜色
                val builder = SpannableStringBuilder(textString)
                val index = textString!!.toLowerCase().indexOf(KEY!!.toLowerCase())//从第几个匹配上
                if (index != -1) {//有这个关键字用builder显示
                    builder.setSpan(span, index, index + KEY!!.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    publicname.text = builder
                } else {//没有则直接显示
                    publicname.setText(textString)
                }
            }
        }
        //联动搜索关键字字体
        //私募基金
        val privatename = holder.binding!!.root.findViewById<TextView>(R.id.privatename)
        if (privatename != null && KEY != null) {
            val privatePlacements = mDatas
            val placement:Placement = privatePlacements!![position] as Placement
            val textString = placement.fundName
            if ("" != textString && textString != null) {
                val span = ForegroundColorSpan(myContext.resources.getColor(R.color.red))//要显示的颜色
                val builder = SpannableStringBuilder(textString)
                val index = textString!!.toLowerCase().indexOf(KEY!!.toLowerCase())//从第几个匹配上
                if (index != -1) {//有这个关键字用builder显示
                    builder.setSpan(span, index, index + KEY!!.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    privatename.text = builder
                } else {//没有则直接显示
                    privatename.text = textString
                }
            }

        }

        //联动搜索关键字字体
        //银行理财
        val backproductname = holder.binding!!.root.findViewById<TextView>(R.id.backproductname)
        if (backproductname != null && KEY != null) {
            val backProducts = mDatas
            val products:BackProducts = backProducts!![position] as BackProducts
            val textString = products.name
            if ("" != textString && textString != null) {
                val span = ForegroundColorSpan(myContext.resources.getColor(R.color.red))//要显示的颜色
                val builder = SpannableStringBuilder(textString)
                val index = textString!!.toLowerCase().indexOf(KEY!!.toLowerCase())//从第几个匹配上
                if (index != -1) {//有这个关键字用builder显示
                    builder.setSpan(span, index, index + KEY!!.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    backproductname.text = builder
                } else {//没有则直接显示
                    backproductname.setText(textString)
                }
            }
        }
        //联动搜索关键字字体
        //基金公司
        val publiccompanyname = holder.binding!!.root.findViewById<TextView>(R.id.publiccompanyname)
        if (publiccompanyname != null && KEY != null) {
            val publicCompanies = mDatas
            val company:Company = publicCompanies!![position] as Company
            val textString = company.companyName
            if ("" != textString && textString != null) {
                val span = ForegroundColorSpan(myContext.resources.getColor(R.color.red))//要显示的颜色
                val builder = SpannableStringBuilder(textString)
                val index = textString!!.toLowerCase().indexOf(KEY!!.toLowerCase())//从第几个匹配上
                if (index != -1) {//有这个关键字用builder显示
                    builder.setSpan(span, index, index + KEY!!.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    publiccompanyname.text = builder
                } else {//没有则直接显示
                    publiccompanyname.setText(textString)
                }
            }
        }
        //联动搜索关键字字体
        //基金经理
        val fundmname = holder.binding!!.root.findViewById<TextView>(R.id.fundmname)
        if (fundmname != null && KEY != null) {
            val fundMangers = mDatas
            val fundManger:FundManger = fundMangers!![position] as FundManger
            val textString = fundManger.managerName
            if ("" != textString && textString != null) {
                val span = ForegroundColorSpan(myContext.resources.getColor(R.color.red))//要显示的颜色
                val builder = SpannableStringBuilder(textString)
                val index = textString!!.toLowerCase().indexOf(KEY!!.toLowerCase())//从第几个匹配上
                if (index != -1) {//有这个关键字用builder显示
                    builder.setSpan(span, index, index + KEY!!.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    fundmname.text = builder
                } else {//没有则直接显示
                    fundmname.setText(textString)
                }
            }
        }
        //公募基金是否加入自选
        val publicicon = holder.binding!!.root.findViewById<ImageView>(R.id.publicicon)
        if (publicicon != null) {
            val publicPlacements = mDatas
            val placement:Placement = publicPlacements!![position] as Placement
            if (placement.addOptional == 1) {//已加入自选
                publicicon.setImageResource(R.mipmap.deicon)
            } else {//未加入自选
                publicicon.setImageResource(R.mipmap.addicon)
            }
            publicicon.setOnClickListener {
                if (placement.addOptional == 1) {//已加入自选
                    optional(placement.fundId, 2, 1)
                } else {//未加入自选
                    optional(placement.fundId, 1, 1)
                }
            }
        }
        //私募基金是否加入自选
        val privateicon = holder.binding!!.root.findViewById<ImageView>(R.id.privateicon)
        if (privateicon != null) {
            val privatePlacements = mDatas
            val placement:Placement = privatePlacements!![position] as Placement
            if (placement.addOptional == 1) {//已加入自选
                privateicon.setImageResource(R.mipmap.deicon)
            } else {//未加入自选
                privateicon.setImageResource(R.mipmap.addicon)
            }
            privateicon.setOnClickListener {
                //                    privateicon.toggle();
                if (placement.addOptional == 1) {//已加入自选
                    optional(placement.fundId, 2, 2)
                } else {//未加入自选
                    optional(placement.fundId, 1, 2)
                }
            }
        }
        //基金公司是否关注
        val publicompanycicon = holder.binding!!.root.findViewById<ImageView>(R.id.publicompanycicon)
        if (publicompanycicon != null) {
            val publicCompanies = mDatas
            val company:Company = publicCompanies!![position] as Company
            if (company.addAttention == 1) {//已加入关注
                publicompanycicon.setImageResource(R.mipmap.deicon)
            } else {//未加入关注
                publicompanycicon.setImageResource(R.mipmap.addicon)
            }
            publicompanycicon.setOnClickListener {
                if (company.addAttention == 1) {//已加入自选
                    attention(company.companyId, 2, 2)
                } else {//未加入自选
                    attention(company.companyId, 1, 2)
                }
            }
        }
        //基金经理是否关注
        val publicmangericon = holder.binding!!.root.findViewById<ImageView>(R.id.publicmangericon)
        if (publicmangericon != null) {
            val fundMangers = mDatas
            val manger:FundManger = fundMangers!![position] as FundManger
            if (manger.addAttention == 1) {//已加入关注
                publicmangericon.setImageResource(R.mipmap.deicon)
            } else {//未加入关注
                publicmangericon.setImageResource(R.mipmap.addicon)
            }
            publicmangericon.setOnClickListener {
                if (manger.addAttention == 1) {//已加入自选
                    attention(manger.managerId, 2, 3)
                } else {//未加入自选
                    attention(manger.managerId, 1, 3)
                }
            }
        }
        //通用
        holder.binding!!.setVariable(mVariableId, mDatas!![position])
        holder.binding!!.executePendingBindings()
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.binding!!.root.tag = position
    }

    override fun getItemCount(): Int {
        return if (null == mDatas) 0 else mDatas!!.size
    }

    override fun onClick(v: View) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener!!.onItemClick(v, v.tag as Int)
        }
    }


    inner class CommonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ViewDataBinding? = null
    }

    /*设置点击事件*/
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mOnItemClickListener = listener
    }

    //define interface
    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    /*设置长按事件*/
    fun setOnItemLongClickListener(onItemLongClickListener: RecyclerViewOnItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener
    }

    interface RecyclerViewOnItemLongClickListener {
        fun onItemLongClickListener(view: View, position: Int): Boolean
    }

    override fun onLongClick(v: View): Boolean {
        return onItemLongClickListener != null && onItemLongClickListener!!.onItemLongClickListener(v, v.tag as Int)
    }

    fun setFilter(filterHistory: List<History>) {
        mDatas = filterHistory
        notifyDataSetChanged()
    }

    //构造方法ordarrview
    constructor(datas: List<*>, variableId: Int, context: Context, layoutId: Int, KEYs: String) {
        myContext = context
        mDatas = datas
        mLayoutId = layoutId
        mInflater = LayoutInflater.from(myContext)
        mVariableId = variableId
        KEY = KEYs
    }

    fun setKET(KEYs: String) {
        KEY = KEYs
        notifyDataSetChanged()
    }

    fun <T> setThread(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    private fun attention(id: String?, operateType: Int, type: Int) {
        val timestamp = BaseActivity.getTime()
        val map = HashMap<String, Any>()
        map["id"] = id!!
        map["operateType"] = operateType
        map["type"] = type
        map["timestamp"] = timestamp
        val sign = SignUtil.getSign(map, HttpConfig.APPKEY)
        val `object` = JSONObject()
        try {
            `object`.put("id", id)
            `object`.put("operateType", operateType)
            `object`.put("type", type)
            `object`.put("timestamp", timestamp)
            `object`.put("sign", sign)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        val json = `object`.toString()
        val requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), json)
        val observable1 = RetrofitFactory.getInstence(myContext)!!.API()
            .publicFunds_attention(requestBody)
            .compose(this.setThread())
        observable1
            .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
            .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
            .subscribe(object : BaseObserver<String>() {
                @Throws(Exception::class)
                override fun onSuccees(t: BaseEntity<String>) {
                    CustomToast.showToast(myContext, t.message!!)
                }

                @Throws(Exception::class)
                override fun onFailure(e: Throwable, isNetWorkError: Boolean) {

                }
            })
    }

    private fun optional(id: String?, operateType: Int, type: Int) {
        val timestamp = BaseActivity.getTime()
        val map = HashMap<String, Any>()
        map["id"] = id!!
        map["operateType"] = operateType
        map["type"] = type
        map["timestamp"] = timestamp
        val sign = SignUtil.getSign(map, HttpConfig.APPKEY)
        val `object` = JSONObject()
        try {
            `object`.put("id", id)
            `object`.put("operateType", operateType)
            `object`.put("type", type)
            `object`.put("timestamp", timestamp)
            `object`.put("sign", sign)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        val json = `object`.toString()
        val requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), json)
val observable1 = RetrofitFactory.getInstence(myContext)!!.API()
            .mainPage_optional(requestBody)
            .compose(this.setThread())
        observable1
            .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
            .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
            .subscribe(object : BaseObserver<String>() {
                @Throws(Exception::class)
                override fun onSuccees(t: BaseEntity<String>) {
                    CustomToast.showToast(myContext, t.message!!)
                }

                @Throws(Exception::class)
                override fun onFailure(e: Throwable, isNetWorkError: Boolean) {

                }
            })
    }

    companion object {
        val TAG = "MvvmCommonAdapter"
    }
}
