package com.guoshi.baselib.entity.module_home

import com.guoshi.baselib.entity.back.BackProducts
import com.guoshi.baselib.entity.fund.Placement

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/20
 * 文件描述：首页搜索组合体
 */
class Products {
    var bankProducts: MutableList<BackProducts>? = null
    var privateFunds: MutableList<Placement>? = null
    var publicFunds: MutableList<Placement>? = null
}
