package com.guoshi.baselib.api.utils

import android.content.Context
import android.os.AsyncTask


import com.guoshi.baselib.api.http.RetrofitFactory

import java.io.File
import java.io.IOException
import java.util.ArrayList

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：上传图片
 */
object UploadUtil {

    /**
     * 上传单张图片
     *
     * @param filePath 图片路径
     * @param observer 观察者
     * @throws IOException
     */
    fun uploadImage(filePath: String, observer: Observer<Any>, context: Context) {
        object : AsyncTask<Int, Int, File>() {
            override fun doInBackground(vararg params: Int?): File? {
                //压缩图片
                val file = File(BitmapUtil.compressImage(filePath))
                return null
            }

            override fun onPostExecute(file: File) {
                super.onPostExecute(file)
                val requestBody = RequestBody.create(MediaType.parse("image/png"), file)
                val part = MultipartBody.Part.createFormData("file", file.name, requestBody)
                RetrofitFactory.getInstence(context)!!.API()
                    .imageUpload(part)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer)
            }
        }.execute()


    }

    /**
     * 上传多张照片
     *
     * @param mFilesPath
     * @param observer
     */
    fun uploadImages(mFilesPath: ArrayList<String>, observer: Observer<Any>, context: Context) {
        object : AsyncTask<Int, Int, List<File>>() {
            override fun doInBackground(vararg params: Int?): List<File> {
                //压缩图片
                val files = ArrayList<File>()
                for (path in mFilesPath) {
                    val file = File(BitmapUtil.compressImage(path))
                    files.add(file)

                }
                return files
            }

            override fun onPostExecute(files: List<File>) {
                super.onPostExecute(files)
                val xx = filesToMultipartBodyParts(files)
                RetrofitFactory.getInstence(context)!!.API()
                    .imagesUpload(xx)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer)
            }
        }.execute()


    }

    /**
     * @param files 多图片文件转表单
     * @return
     */
    fun filesToMultipartBodyParts(files: List<File>): List<MultipartBody.Part> {
        val parts = ArrayList<MultipartBody.Part>(files.size)
        for (file in files) {
            val requestBody = RequestBody.create(MediaType.parse("image/png"), file)
            val part = MultipartBody.Part.createFormData("files", file.name, requestBody)
            parts.add(part)
        }
        return parts
    }
}
