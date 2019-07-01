package com.guoshi.baselib.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast

import com.guoshi.baselib.R
import com.guoshi.baselib.view.MyBottomSheetDialog

import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date

import cn.sharesdk.onekeyshare.OnekeyShare
import cn.sharesdk.tencent.qq.QQ
import cn.sharesdk.tencent.qzone.QZone
import cn.sharesdk.wechat.friends.Wechat
import cn.sharesdk.wechat.moments.WechatMoments

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/31
 * 文件描述：
 */
object Utils {

    fun showShareDialog(context: Context, onClickListener: View.OnClickListener) {
        val bottomSheetDialog = MyBottomSheetDialog(context, R.style.bottomdialog)
        val view = LayoutInflater.from(context).inflate(R.layout.share_view, null, false)
        view.findViewById<View>(R.id.wx).setOnClickListener(onClickListener)
        view.findViewById<View>(R.id.wxp).setOnClickListener(onClickListener)
        view.findViewById<View>(R.id.qq).setOnClickListener(onClickListener)
        view.findViewById<View>(R.id.qqk).setOnClickListener(onClickListener)
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
    }

    fun share(
        context: Context, title: String, text: String, link_url: String,
        img_url: String, type: String
    ) {// type 'wx' 就是发送到微信'wxp' 微信朋友圈
        val oks = OnekeyShare()
        oks.setTitle(title)
        oks.text = text
        oks.setUrl(link_url)
        /** url在微信（包括好友、朋友圈收藏）和易信（包括好友和朋友圈）中使用，否则可以不提供  */
        oks.setTitleUrl(link_url)
        /** titleUrl是标题的网络链接，仅在人人网和QQ空间使用，否则可以不提供  */
        if ("" != img_url) {
            oks.setImageUrl(img_url)
        } else {
            oks.setImageUrl("http://img.i-banmei.com/inviteShareShowPic.png")
        }
        if (type == "wx") {
            oks.setPlatform(Wechat.NAME)
        } else if (type == "wxp") {
            oks.setPlatform(WechatMoments.NAME)
        } else if (type == "qq") {
            oks.setPlatform(QQ.NAME)
        } else if (type == "qqk") {
            oks.setPlatform(QZone.NAME)
        }
        oks.show(context)
    }

    fun saveBitmap(context: Context, bitmap: Bitmap) {
        val format = SimpleDateFormat("yyyyMMddHHmmss")
        val bitName = format.format(Date()) + ".JPEG"
        val fileName: String
        val file: File
        if (Build.BRAND == "Xiaomi") { // 小米手机
            fileName = Environment.getExternalStorageDirectory().path + "/DCIM/" + bitName
        } else {  // Meizu 、Oppo
            fileName = Environment.getExternalStorageDirectory().path + "/DCIM/" + bitName
        }
        file = File(fileName)

        if (file.exists()) {
            file.delete()
        }
        val out: FileOutputStream
        try {
            out = FileOutputStream(file)
            // 格式为 JPEG，照相机拍出的图片为JPEG格式的，PNG格式的不能显示在相册中
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)) {
                out.flush()
                out.close()


                // 插入图库
                MediaStore.Images.Media.insertImage(context.contentResolver, file.absolutePath, bitName, null)
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        // 发送广播，通知刷新图库的显示
        context.sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://$fileName")))
        Toast.makeText(context, "图片保存图库成功", Toast.LENGTH_LONG).show()
    }

    /**
     * 判断当前是否有网络
     *
     * @param context Activity的this
     * @return
     */
    fun CheckNetwork(context: Context): Boolean {
        var flag = false
        val cwjManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (cwjManager.activeNetworkInfo != null)
            flag = cwjManager.activeNetworkInfo.isAvailable
        if (!flag) {
            val b = AlertDialog.Builder(context).setTitle("警告").setMessage("当前没有可用的网络！是否需要设置查找可用网络！")
            b.setPositiveButton("设置") { dialog, whichButton ->
                val mIntent = Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS)
                context.startActivity(mIntent)
            }.setNeutralButton("取消") { dialog, whichButton -> dialog.cancel() }.create()
            b.setOnCancelListener {
                //                    ((Activity)context).finish();
            }
            b.show()
        }
        return flag
    }
}
