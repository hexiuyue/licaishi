package com.guoshi.baselib.view

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.res.Resources
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.view.WindowManager

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/6/10
 * 文件描述：自定义BottomSheetDialog主要解决沉浸式状态栏变色问题
 */
class MyBottomSheetDialog : BottomSheetDialog {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, theme: Int) : super(context, theme) {}

    protected constructor(
        context: Context,
        cancelable: Boolean,
        cancelListener: DialogInterface.OnCancelListener
    ) : super(context, cancelable, cancelListener) {
    }

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        val screenHeight = getScreenHeight(context)
        window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            if (screenHeight == 0) ViewGroup.LayoutParams.MATCH_PARENT else screenHeight
        )
    }

    companion object {

        fun getScreenHeight(context: Context): Int {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            return wm.defaultDisplay.height
        }
    }
}
