package com.guoshi.baselib.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：自定义viewpager,是否可以滑动切换
 */
class CustomViewPager : ViewPager {

    private var isCanScroll = true


    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    /**
     * 设置其是否能滑动换页
     * @param isCanScroll false 不能换页， true 可以滑动换页
     */
    fun setScanScroll(isCanScroll: Boolean) {
        this.isCanScroll = isCanScroll
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return isCanScroll && super.onInterceptTouchEvent(ev)


    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return isCanScroll && super.onTouchEvent(ev)

    }
}