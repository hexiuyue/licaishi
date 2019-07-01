package com.guoshi.baselib.entity


import android.databinding.BaseObservable
import android.databinding.Bindable

import com.guoshi.baselib.BR

import org.greenrobot.greendao.annotation.Entity
import org.greenrobot.greendao.annotation.Generated
import org.greenrobot.greendao.annotation.Id
import org.greenrobot.greendao.annotation.Unique

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/4/15
 * 文件描述：搜索历史内容类
 */
@Entity
class History : BaseObservable {
    @Id(autoincrement = true)
    private var id: Long? = null

    private var content: String? = null

    private var type: Int = 0//历史记录类型 0首页搜索，1公募搜索，2私募搜索

    @Generated(hash = 743537489)
    constructor(id: Long?, content: String, type: Int) {
        this.id = id
        this.content = content
        this.type = type
    }

    @Generated(hash = 869423138)
    constructor() {
    }

    @Bindable
    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
        notifyPropertyChanged(BR.id)
    }

    @Bindable
    fun getContent(): String? {
        return content
    }

    fun setContent(content: String) {
        this.content = content
        notifyPropertyChanged(BR.content)
    }

    @Bindable
    fun getType(): Int {
        return type
    }

    fun setType(type: Int) {
        this.type = type
        notifyPropertyChanged(BR.type)
    }
}
