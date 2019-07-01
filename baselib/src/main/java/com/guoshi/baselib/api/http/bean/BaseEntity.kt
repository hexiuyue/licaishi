package com.guoshi.baselib.api.http.bean

import android.util.Log

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：解析实体基类
 */
class BaseEntity<T> {
    var status: Int = 0
    var message: String? = null
    var data: T? = null
    var count: Int = 0
    var totalPage: Int = 0

    val isSuccess: Boolean
        get() {
            Log.e("getStatus()", status.toString() + "")
            Log.e("message()", message!! + "")
            return status == SUCCESS_CODE
        }

    companion object {
        private val SUCCESS_CODE = 1//成功的code
    }
}
