package com.guoshi.baselib.view

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast

import com.guoshi.baselib.R


/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/20.
 * 文件描述：自定义Toast
 */
object CustomToast {
    private var mTextView: TextView? = null
    private var toastStart: Toast? = null

    fun showToast(context: Context, message: String) {
        if (toastStart != null) {
            toastStart!!.cancel()
        }
        //加载Toast布局
        val toastRoot = LayoutInflater.from(context).inflate(R.layout.toast_view, null)
        //初始化布局控件
        mTextView = toastRoot.findViewById<View>(R.id.toast_text) as TextView
        //为控件设置属性
        mTextView!!.text = message
        //Toast的初始化
        toastStart = Toast(context)
        //获取屏幕高度
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val height = wm.defaultDisplay.height
        //Toast的Y坐标是屏幕高度的1/3，不会出现不适配的问题
        toastStart!!.setGravity(Gravity.BOTTOM, 0, height / 2)
        toastStart!!.duration = Toast.LENGTH_SHORT
        toastStart!!.view = toastRoot
        toastStart!!.show()
    }
}
