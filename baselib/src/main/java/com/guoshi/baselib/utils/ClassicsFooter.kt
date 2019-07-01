package com.guoshi.baselib.utils

import android.content.Context
import android.content.res.TypedArray
import android.support.annotation.ColorInt
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.RelativeLayout

import com.scwang.smartrefresh.layout.R
import com.scwang.smartrefresh.layout.api.RefreshFooter
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.constant.RefreshState
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.internal.ArrowDrawable
import com.scwang.smartrefresh.layout.internal.InternalClassics
import com.scwang.smartrefresh.layout.internal.ProgressDrawable
import com.scwang.smartrefresh.layout.util.DensityUtil

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/21
 * 文件描述：自定义上拉底部组件
 */
class ClassicsFooter @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    InternalClassics<ClassicsFooter>(context, attrs, defStyleAttr), RefreshFooter {

    protected var mTextPulling: String? = null//"上拉加载更多";
    protected var mTextRelease: String? = null//"释放立即加载";
    protected var mTextLoading: String? = null//"正在加载...";
    protected var mTextRefreshing: String? = null//"正在刷新...";
    protected var mTextFinish: String? = null//"加载完成";
    protected var mTextFailed: String? = null//"加载失败";
    protected var mTextNothing: String? = null//"没有更多数据了";

    protected var mNoMoreData = false

    init {

        if (REFRESH_FOOTER_PULLING == null) {
            REFRESH_FOOTER_PULLING = context.getString(R.string.srl_footer_pulling)
        }

        if (REFRESH_FOOTER_RELEASE == null) {
            REFRESH_FOOTER_RELEASE = context.getString(R.string.srl_footer_release)
        }

        if (REFRESH_FOOTER_LOADING == null) {
            REFRESH_FOOTER_LOADING = context.getString(R.string.srl_footer_loading)
        }

        if (REFRESH_FOOTER_REFRESHING == null) {
            REFRESH_FOOTER_REFRESHING = context.getString(R.string.srl_footer_refreshing)
        }

        if (REFRESH_FOOTER_FINISH == null) {
            REFRESH_FOOTER_FINISH = context.getString(R.string.srl_footer_finish)
        }

        if (REFRESH_FOOTER_FAILED == null) {
            REFRESH_FOOTER_FAILED = context.getString(R.string.srl_footer_failed)
        }

        if (REFRESH_FOOTER_NOTHING == null) {
            REFRESH_FOOTER_NOTHING = context.getString(com.guoshi.baselib.R.string.mysrl_footer_nothing)
        }

        val thisView = this
        val arrowView = mArrowView
        val progressView = mProgressView
        val density = DensityUtil()

        mTitleText.setTextColor(-0x99999a)
        mTitleText.text = if (thisView.isInEditMode) REFRESH_FOOTER_LOADING else REFRESH_FOOTER_PULLING

        val ta = context.obtainStyledAttributes(attrs, R.styleable.ClassicsFooter)

        val lpArrow = arrowView.layoutParams as RelativeLayout.LayoutParams
        val lpProgress = progressView.layoutParams as RelativeLayout.LayoutParams
        lpProgress.rightMargin =
            ta.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, density.dip2px(20f))
        lpArrow.rightMargin = lpProgress.rightMargin

        lpArrow.width = ta.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, lpArrow.width)
        lpArrow.height = ta.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, lpArrow.height)
        lpProgress.width = ta.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, lpProgress.width)
        lpProgress.height = ta.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, lpProgress.height)

        lpArrow.width = ta.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, lpArrow.width)
        lpArrow.height = ta.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, lpArrow.height)
        lpProgress.width = ta.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, lpProgress.width)
        lpProgress.height = ta.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, lpProgress.height)

        mFinishDuration = ta.getInt(R.styleable.ClassicsFooter_srlFinishDuration, mFinishDuration)
        mSpinnerStyle =
            SpinnerStyle.values()[ta.getInt(R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, mSpinnerStyle.ordinal)]

        if (ta.hasValue(R.styleable.ClassicsFooter_srlDrawableArrow)) {
            mArrowView.setImageDrawable(ta.getDrawable(R.styleable.ClassicsFooter_srlDrawableArrow))
        } else {
            mArrowDrawable = ArrowDrawable()
            mArrowDrawable.setColor(-0x99999a)
            mArrowView.setImageDrawable(mArrowDrawable)
        }

        if (ta.hasValue(R.styleable.ClassicsFooter_srlDrawableProgress)) {
            mProgressView.setImageDrawable(ta.getDrawable(R.styleable.ClassicsFooter_srlDrawableProgress))
        } else {
            mProgressDrawable = ProgressDrawable()
            mProgressDrawable.setColor(-0x99999a)
            mProgressView.setImageDrawable(mProgressDrawable)
        }

        if (ta.hasValue(R.styleable.ClassicsFooter_srlTextSizeTitle)) {
            mTitleText.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                ta.getDimensionPixelSize(R.styleable.ClassicsFooter_srlTextSizeTitle, DensityUtil.dp2px(16f)).toFloat()
            )
        } else {
            mTitleText.textSize = 16f
        }

        if (ta.hasValue(R.styleable.ClassicsFooter_srlPrimaryColor)) {
            super.setPrimaryColor(ta.getColor(R.styleable.ClassicsFooter_srlPrimaryColor, 0))
        }
        if (ta.hasValue(R.styleable.ClassicsFooter_srlAccentColor)) {
            super.setAccentColor(ta.getColor(R.styleable.ClassicsFooter_srlAccentColor, 0))
        }

        mTextPulling = REFRESH_FOOTER_PULLING
        mTextRelease = REFRESH_FOOTER_RELEASE
        mTextLoading = REFRESH_FOOTER_LOADING
        mTextRefreshing = REFRESH_FOOTER_REFRESHING
        mTextFinish = REFRESH_FOOTER_FINISH
        mTextFailed = REFRESH_FOOTER_FAILED
        mTextNothing = REFRESH_FOOTER_NOTHING

        if (ta.hasValue(R.styleable.ClassicsFooter_srlTextPulling)) {
            mTextPulling = ta.getString(R.styleable.ClassicsFooter_srlTextPulling)
        }
        if (ta.hasValue(R.styleable.ClassicsFooter_srlTextRelease)) {
            mTextRelease = ta.getString(R.styleable.ClassicsFooter_srlTextRelease)
        }
        if (ta.hasValue(R.styleable.ClassicsFooter_srlTextLoading)) {
            mTextLoading = ta.getString(R.styleable.ClassicsFooter_srlTextLoading)
        }
        if (ta.hasValue(R.styleable.ClassicsFooter_srlTextRefreshing)) {
            mTextRefreshing = ta.getString(R.styleable.ClassicsFooter_srlTextRefreshing)
        }
        if (ta.hasValue(R.styleable.ClassicsFooter_srlTextFinish)) {
            mTextFinish = ta.getString(R.styleable.ClassicsFooter_srlTextFinish)
        }
        if (ta.hasValue(R.styleable.ClassicsFooter_srlTextFailed)) {
            mTextFailed = ta.getString(R.styleable.ClassicsFooter_srlTextFailed)
        }
        if (ta.hasValue(R.styleable.ClassicsFooter_srlTextNothing)) {
            mTextNothing = ta.getString(R.styleable.ClassicsFooter_srlTextNothing)
        }

        ta.recycle()

    }

    //    @Override
    //    protected ClassicsFooter self() {
    //        return this;
    //    }

    //</editor-fold>

    //<editor-fold desc="RefreshFooter">

    override fun onStartAnimator(refreshLayout: RefreshLayout, height: Int, maxDragHeight: Int) {
        if (!mNoMoreData) {
            super.onStartAnimator(refreshLayout, height, maxDragHeight)
        }
    }

    override fun onFinish(layout: RefreshLayout, success: Boolean): Int {
        if (!mNoMoreData) {
            mTitleText.text = if (success) mTextFinish else mTextFailed
            return super.onFinish(layout, success)
        }
        return 0
    }

    /**
     * ClassicsFooter 在(SpinnerStyle.FixedBehind)时才有主题色
     */
    @Deprecated("")
    override fun setPrimaryColors(@ColorInt vararg colors: Int) {
        if (mSpinnerStyle == SpinnerStyle.FixedBehind) {
            super.setPrimaryColors(*colors)
        }
    }

    /**
     * 设置数据全部加载完成，将不能再次触发加载功能
     */
    override fun setNoMoreData(noMoreData: Boolean): Boolean {
        if (mNoMoreData != noMoreData) {
            mNoMoreData = noMoreData
            val arrowView = mArrowView
            if (noMoreData) {
                mTitleText.text = mTextNothing
                arrowView.visibility = View.GONE
            } else {
                mTitleText.text = mTextPulling
                arrowView.visibility = View.VISIBLE
            }
        }
        return true
    }

    override fun onStateChanged(refreshLayout: RefreshLayout, oldState: RefreshState, newState: RefreshState) {
        val arrowView = mArrowView
        if (!mNoMoreData) {
            when (newState) {
                RefreshState.None -> {
                    arrowView.visibility = View.VISIBLE
                    mTitleText.text = mTextPulling
                    arrowView.animate().rotation(180f)
                }
                RefreshState.PullUpToLoad -> {
                    mTitleText.text = mTextPulling
                    arrowView.animate().rotation(180f)
                }
                RefreshState.Loading, RefreshState.LoadReleased -> {
                    arrowView.visibility = View.GONE
                    mTitleText.text = mTextLoading
                }
                RefreshState.ReleaseToLoad -> {
                    mTitleText.text = mTextRelease
                    arrowView.animate().rotation(0f)
                }
                RefreshState.Refreshing -> {
                    mTitleText.text = mTextRefreshing
                    arrowView.visibility = View.GONE
                }
            }
        }
    }

    companion object {

        var REFRESH_FOOTER_PULLING: String? = null//"上拉加载更多";
        var REFRESH_FOOTER_RELEASE: String? = null//"释放立即加载";
        var REFRESH_FOOTER_LOADING: String? = null//"正在加载...";
        var REFRESH_FOOTER_REFRESHING: String? = null//"正在刷新...";
        var REFRESH_FOOTER_FINISH: String? = null//"加载完成";
        var REFRESH_FOOTER_FAILED: String? = null//"加载失败";
        var REFRESH_FOOTER_NOTHING: String? = null//"没有更多数据了";
    }
    //</editor-fold>

}//<editor-fold desc="LinearLayout">
