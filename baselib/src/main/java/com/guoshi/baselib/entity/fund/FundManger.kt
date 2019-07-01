package com.guoshi.baselib.entity.fund

import android.databinding.BindingAdapter
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.guoshi.baselib.R

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/6
 * 文件描述：基金经理
 */
class FundManger {
    var addAttention: Int = 0//": "1",
    var companyName: String? = null//": "华安基金",
    var managerName: String? = null//": "张三",
    var icon: String? = null//": "1.jpg",
    var experience: String? = null//": "10年经验"
    var managerId: String? = null//": "10年经验"

    companion object {

        @BindingAdapter("fundmangerimgs")
        fun getInternetImage(iv: ImageView, userface: String?) {
            if ("" != userface && userface != null) {
                val requestOptions = RequestOptions()
                requestOptions.placeholder(R.mipmap.ic_launcher_round)
                requestOptions.error(R.mipmap.ic_launcher_round)
                requestOptions.circleCrop()
                //            requestOptions.bitmapTransform(new CircleCrop());//圆形
                Glide.with(iv.context)
                    .load(userface)
                    .apply(requestOptions)
                    .into(iv)
            } else {
                Glide.with(iv.context)
                    .load(R.color.honeydew)
                    .into(iv)
            }
        }
    }

}
