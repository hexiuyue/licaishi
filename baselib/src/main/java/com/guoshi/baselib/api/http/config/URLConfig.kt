package com.guoshi.baselib.api.http.config

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：网络接口地址
 */
interface URLConfig {
    companion object {
        const val login_token_url = "app/mainPage"
        /**
         * 首页热门搜索内容
         */
        const val mainPage_hotSearch = "app/mainPage/hotSearch"
        /**
         * 更多银行理财列表接口（带加载）
         */
        const val mainPage_moreBankProducts = "app/mainPage/moreBankProducts "
        /**
         * 更多私募基金列表接口（带加载）
         */
        const val mainPage_morePrivateFunds = "app/mainPage/morePrivateFunds"
        /**
         * 更多公募基金列表接口（带加载）
         */
        const val mainPage_morePublicFunds = "app/mainPage/morePublicFunds"
        /**
         * 加入自选接口
         */
        const val mainPage_optional = "app/mainPage/optional"
        //    String adduser="user/adduser";
        /**
         * 首页搜索
         */
        const val mainPage_search = "app/mainPage/search"
        /**
         * 加入关注接口
         */
        const val publicFunds_attention = "app/publicFunds/attention"
        /**
         * 公募发现接口
         */
        const val publicFunds_find = "app/publicFunds/find"
        /**
         * 公募搜索基金公司接口（带加载）
         */
        const val publicFunds_moreCompanys = "app/publicFunds/moreCompanys"
        /**
         * 公募搜索基金经理接口（带加载）
         */
        const val publicFunds_moreManagers = "app/publicFunds/moreManagers"
        /**
         * 公募搜索基金产品接口（带加载）
         */
        const val publicFunds_moreProducts = "app/publicFunds/moreProducts"
        /**
         * 公募搜索接口
         */
        const val publicFunds_search = "app/publicFunds/search"
    }
}
