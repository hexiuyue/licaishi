package com.guoshi.baselib.web

import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.webkit.JavascriptInterface
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView

import com.alibaba.android.arouter.facade.annotation.Route
import com.guoshi.baselib.R
import com.guoshi.baselib.base.BaseActivity
import com.guoshi.baselib.databinding.ActivityWebViewBinding
import com.guoshi.baselib.route.BaseLibUtlis
import com.guoshi.baselib.utils.StatusBarUtil

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/16
 * 文件描述：统一webview
 */
@Route(path = BaseLibUtlis.WEBVIEW)
class WebViewActivity : BaseActivity(), View.OnClickListener {
    private var binding: ActivityWebViewBinding? = null
    private val url =
        "https://view.inews.qq.com/w/WXN20190611002025020?refer=nwx&bat_id=1109043838&cur_pos=3&openid=o04IBANy6jAyshaGba8HVzXwOzDU&groupid=1560228624&msgid=3"
    private var isGoBack = false
    private var isFirst = true
    private var iamgeView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBarLightMode(this)
        binding = DataBindingUtil.setContentView<ActivityWebViewBinding>(this, R.layout.activity_web_view)
        initview()
    }

    private fun initview() {
        binding!!.webviewtop.findViewById<View>(R.id.topviews).setVisibility(View.GONE)
        // 设置setWebChromeClient对象
        binding!!.webview.setWebChromeClient(object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (!isGoBack) {//回退不显示进度条
                    if (newProgress == 100) {
                        binding!!.progressBar.setVisibility(View.GONE)//加载完网页进度条消失
                    } else {
                        binding!!.progressBar.setVisibility(View.VISIBLE)//开始加载网页时显示进度条
                        binding!!.progressBar.setProgress(newProgress)//设置进度值
                    }
                }
                if (isFirst) {
                    return  //刚进入页面不需要模拟效果，app自己有
                }
                if (newProgress == 100) {
                    //加载完毕，显示webview 隐藏imageview
                    view.visibility = View.VISIBLE
                    if (iamgeView != null) {
                        iamgeView!!.visibility = View.GONE
                    }
                    //页面进入效果的动画
                    var translate_in = AnimationUtils.loadAnimation(
                        this@WebViewActivity, R.anim.slide_right_in
                    )
                    var translate_out = AnimationUtils.loadAnimation(
                        this@WebViewActivity, R.anim.slide_left_out
                    )
                    //页面退出的动画
                    if (isGoBack) {
                        translate_in = AnimationUtils.loadAnimation(
                            this@WebViewActivity, R.anim.slide_left_in
                        )
                        translate_out = AnimationUtils.loadAnimation(
                            this@WebViewActivity, R.anim.slide_right_out
                        )
                    }
                    translate_in.fillAfter = true
                    translate_in.detachWallpaper = true
                    translate_out.fillAfter = true
                    translate_out.detachWallpaper = true
                    //                     开启动画
                    if (null != iamgeView) {
                        iamgeView!!.startAnimation(translate_out)
                    }
                    view.startAnimation(translate_in)
                    //动画结束后，移除imageView
                    translate_out.setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(animation: Animation) {
                            if (null != iamgeView) {
                                binding!!.root.removeView(iamgeView)
                                iamgeView = null
                                isGoBack = false
                            }
                        }

                        override fun onAnimationEnd(animation: Animation) {

                        }

                        override fun onAnimationRepeat(animation: Animation) {


                        }
                    })
                } else {
                    view.visibility = View.GONE//先隐藏webview
                    //url没加载好之前，隐藏webview，在主布局中，加入imageview显示当前页面快照
                    if (null == iamgeView) {
                        iamgeView = ImageView(this@WebViewActivity)
                        view.isDrawingCacheEnabled = true
                        val bitmap = view.drawingCache
                        if (null != bitmap) {
                            val b = Bitmap.createBitmap(bitmap)
                            iamgeView!!.setImageBitmap(b)
                        }
                        binding!!.root.addView(iamgeView)
                    }
                }
            }

            override fun onReceivedTitle(view: WebView, title: String) {
                super.onReceivedTitle(view, title)
                (binding!!.webviewtop.findViewById(R.id.alltext) as TextView).text = title

            }
        })
        binding!!.webview.addJavascriptInterface(WebAppAndroid(this), "android")
        //声明WebSettings子类
        val webSettings = binding!!.webview.getSettings()
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW)
        }
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true) //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true) // 缩放至屏幕的大小
        //缩放操作
        webSettings.setSupportZoom(false) //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(false) //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false) //隐藏原生的缩放控件
        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT) //关闭webview中缓存
        webSettings.setAllowFileAccess(true) //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true) //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true) //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8")//设置编码格式
        webSettings.setDomStorageEnabled(true) // 开启 DOM storage 功能("utf-8");//设置编码格式
        //使得打开网页时不调用系统浏览器， 而是在本WebView中显示
        binding!!.webview.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url2: String): Boolean {
                isFirst = false
                view.loadUrl(url2)
                return true
            }

            override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
                handler.proceed() // 接受所有网站的证书
            }
        })


        binding!!.webviewtop.findViewById<ImageView>(R.id.baseback).setOnClickListener(this)

        binding!!.webview.loadUrl(url)
    }


    inner class WebAppAndroid(internal var mContext: Context) {

        @JavascriptInterface
        fun showToast(id: String) {

        }
    }

    //设置回退
    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding!!.webview.canGoBack()) {
            isGoBack = true
            binding!!.webview.goBack() //goBack()表示返回WebView的上一页面
            return true
        } else {
            this.finish()
            BaseActivity.Companion.outacvivity(this@WebViewActivity)
        }
        return false
    }

    override fun onClick(v: View) {
        if (v.id == R.id.baseback) {
            if (binding!!.webview.canGoBack()) {
                isGoBack = true
                binding!!.webview.goBack() //goBack()表示返回WebView的上一页面
            } else {
                this.finish()
                BaseActivity.Companion.outacvivity(this@WebViewActivity)
            }
        }
    }
}
