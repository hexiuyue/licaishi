package com.guoshi.baselib.base

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.inputmethod.InputMethodManager

import com.guoshi.baselib.R

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：activity父类
 */
open class BaseActivity : FragmentActivity() {
    fun <T> setThread(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    companion object {
        /**
         * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
         */
        fun dip2px(context: Context, dpValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dpValue * scale + 0.5f).toInt()
        }

        /**
         * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
         */
        fun px2dip(context: Context, pxValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (pxValue / scale + 0.5f).toInt()
        }

        fun getstatusbar(context: Context): Int {
            var result = 0
            val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
            return result
        }

        fun inacvivity(context: Context) {
            (context as Activity).overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out)
        }

        fun outacvivity(context: Context) {
            (context as Activity).overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out)
        }

        /**
         * //获取系统时间的13位的时间戳
         * @return
         */
        fun getTime(): String {
            val time = System.currentTimeMillis()
            return time.toString()
        }
        /**
         * 获取版本名称
         *
         * @param context
         * @return
         */
        fun getVerName(context: Context?): String {
            var verName = ""
            if (context != null) {
                try {
                    verName = context.packageManager.getPackageInfo(
                        "com.guoshi.licaishi", 0
                    ).versionName
                } catch (e: PackageManager.NameNotFoundException) {
                    Log.e("msg", e.message)
                }

            }
            return verName
        }

        /**
         * 获取手机型号 厂家系统版本
         */
        fun getbrand(): String {
            return Build.MODEL + "    " + Build.BRAND
        }

        /**
         * 获取手机系统版本
         */
        fun getrelease(): String {
            return Build.VERSION.RELEASE
        }

        //隐藏输入法
        fun hidenInputMethod(context: Context) {
            if ((context as Activity).currentFocus != null) {
                (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                    context.currentFocus!!.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
            }
        }
    }
}
