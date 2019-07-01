package com.guoshi.baselib.entity.module_home

import com.guoshi.baselib.entity.fund.FundManger
import com.guoshi.baselib.entity.fund.Company
import com.guoshi.baselib.entity.fund.Placement

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/5/20
 * 文件描述：首页搜索组合体
 */
class PublicSeek {

    var funds: MutableList<Placement>? = null
    var companys: MutableList<Company>? = null
    var managers: MutableList<FundManger>? = null
}
