package com.guoshi.baselib.api.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.media.ExifInterface

import java.io.File
import java.io.FileOutputStream
import java.io.IOException


/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：关于图片的工具类
 */
object BitmapUtil {
    private val PHOTO_FILE_NAME = "PMSManagerPhoto"


    /**
     * 获取图片的旋转角度
     *
     * @param filePath
     * @return
     */
    fun getRotateAngle(filePath: String): Int {
        var rotate_angle = 0
        try {
            val exifInterface = ExifInterface(filePath)
            val orientation =
                exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
            when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> rotate_angle = 90
                ExifInterface.ORIENTATION_ROTATE_180 -> rotate_angle = 180
                ExifInterface.ORIENTATION_ROTATE_270 -> rotate_angle = 270
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return rotate_angle
    }

    /**
     * 旋转图片角度
     *
     * @param angle
     * @param bitmap
     * @return
     */
    fun setRotateAngle(angle: Int, bitmap: Bitmap?): Bitmap? {
        var bitmap = bitmap

        if (bitmap != null) {
            val m = Matrix()
            m.postRotate(angle.toFloat())
            bitmap = Bitmap.createBitmap(
                bitmap, 0, 0, bitmap.width,
                bitmap.height, m, true
            )
            return bitmap
        }
        return bitmap

    }

    //转换为圆形状的bitmap
    fun createCircleImage(source: Bitmap): Bitmap {
        val length = if (source.width < source.height) source.width else source.height
        val paint = Paint()
        paint.isAntiAlias = true
        val target = Bitmap.createBitmap(length, length, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(target)
        canvas.drawCircle((length / 2).toFloat(), (length / 2).toFloat(), (length / 2).toFloat(), paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(source, 0f, 0f, paint)
        return target
    }

    /**
     * 图片压缩-质量压缩
     *
     * @param filePath 源图片路径
     * @return 压缩后的路径
     */

    fun compressImage(filePath: String): String {

        //原文件
        val oldFile = File(filePath)


        //压缩文件路径 照片路径/
        val targetPath = oldFile.path
        val quality = 50//压缩比例
        var bm: Bitmap? = getSmallBitmap(filePath)//获取一定尺寸的图片
        val degree = getRotateAngle(filePath)//获取相片拍摄角度

        if (degree != 0) {//旋转照片角度，防止头像横着显示
            bm = setRotateAngle(degree, bm)
        }
        val outputFile = File(targetPath)
        try {
            if (!outputFile.exists()) {
                outputFile.parentFile.mkdirs()
                //outputFile.createNewFile();
            } else {
                outputFile.delete()
            }
            val out = FileOutputStream(outputFile)
            bm!!.compress(Bitmap.CompressFormat.PNG, quality, out)
            out.close()
        } catch (e: Exception) {
            e.printStackTrace()
            return filePath
        }

        return outputFile.path
    }

    /**
     * 根据路径获得图片信息并按比例压缩，返回bitmap
     */
    fun getSmallBitmap(filePath: String): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true//只解析图片边沿，获取宽高
        BitmapFactory.decodeFile(filePath, options)
        // 计算缩放比
        options.inSampleSize = calculateInSampleSize(options, 480, 800)
        // 完整解析图片返回bitmap
        options.inJustDecodeBounds = false
        return BitmapFactory.decodeFile(filePath, options)
    }


    fun calculateInSampleSize(
        options: BitmapFactory.Options,
        reqWidth: Int, reqHeight: Int
    ): Int {
        val height = options.outHeight
        val width = options.outWidth
        var inSampleSize = 1
        if (height > reqHeight || width > reqWidth) {
            val heightRatio = Math.round(height.toFloat() / reqHeight.toFloat())
            val widthRatio = Math.round(width.toFloat() / reqWidth.toFloat())
            inSampleSize = if (heightRatio < widthRatio) heightRatio else widthRatio
        }
        return inSampleSize
    }


}
