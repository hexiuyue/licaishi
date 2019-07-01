package com.guoshi.baselib.api.http.base

import android.accounts.NetworkErrorException
import android.content.Context

import com.guoshi.baselib.api.http.bean.BaseEntity

import java.net.ConnectException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：Observer基类
 */
abstract class BaseObserver<T> : Observer<BaseEntity<T>> {
    protected lateinit var mContext: Context

    constructor(cxt: Context) {
        this.mContext = cxt
    }

    constructor() {

    }

    override fun onSubscribe(d: Disposable) {
        onRequestStart()

    }

    override fun onNext(tBaseEntity: BaseEntity<T>) {
        onRequestEnd()
        if (tBaseEntity.isSuccess) {
            try {
                onSuccees(tBaseEntity)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {
            try {
                onCodeError(tBaseEntity)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }


    override fun onError(e: Throwable) {
        //        Log.w(TAG, "onError: ", );这里可以打印错误信息
        onRequestEnd()
        try {
            if (e is ConnectException
                || e is TimeoutException
                || e is NetworkErrorException
                || e is UnknownHostException
            ) {

                onFailure(e, true)
            } else {
                onFailure(e, false)
            }
        } catch (e1: Exception) {
            e1.printStackTrace()
        }

    }

    override fun onComplete() {}

    /**
     * 返回成功
     *
     * @param t
     * @throws Exception
     */
    protected abstract fun onSuccees(t: BaseEntity<T>)

    /**
     * 返回成功了,但是code错误
     *
     * @param t
     * @throws Exception
     */
    protected fun onCodeError(t: BaseEntity<T>) {

    }

    /**
     * 返回失败
     *
     * @param e
     * @param isNetWorkError 是否是网络错误
     * @throws Exception
     */
    protected abstract fun onFailure(e: Throwable, isNetWorkError: Boolean)

    protected fun onRequestStart() {

    }

    protected fun onRequestEnd() {
        closeProgressDialog()
    }

    fun showProgressDialog() {
        //        CustomToast.showToast(mContext, "请稍后");
    }

    fun closeProgressDialog() {

    }

}
