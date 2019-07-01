package com.guoshi.baselib.api.http.config;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：网络接口地址
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/guoshi/baselib/api/http/config/URLConfig;", "", "Companion", "baselib_debug"})
public abstract interface URLConfig {
    public static final com.guoshi.baselib.api.http.config.URLConfig.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String login_token_url = "app/mainPage";
    
    /**
     * * 首页热门搜索内容
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String mainPage_hotSearch = "app/mainPage/hotSearch";
    
    /**
     * * 更多银行理财列表接口（带加载）
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String mainPage_moreBankProducts = "app/mainPage/moreBankProducts ";
    
    /**
     * * 更多私募基金列表接口（带加载）
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String mainPage_morePrivateFunds = "app/mainPage/morePrivateFunds";
    
    /**
     * * 更多公募基金列表接口（带加载）
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String mainPage_morePublicFunds = "app/mainPage/morePublicFunds";
    
    /**
     * * 加入自选接口
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String mainPage_optional = "app/mainPage/optional";
    
    /**
     * * 首页搜索
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String mainPage_search = "app/mainPage/search";
    
    /**
     * * 加入关注接口
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String publicFunds_attention = "app/publicFunds/attention";
    
    /**
     * * 公募发现接口
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String publicFunds_find = "app/publicFunds/find";
    
    /**
     * * 公募搜索基金公司接口（带加载）
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String publicFunds_moreCompanys = "app/publicFunds/moreCompanys";
    
    /**
     * * 公募搜索基金经理接口（带加载）
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String publicFunds_moreManagers = "app/publicFunds/moreManagers";
    
    /**
     * * 公募搜索基金产品接口（带加载）
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String publicFunds_moreProducts = "app/publicFunds/moreProducts";
    
    /**
     * * 公募搜索接口
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String publicFunds_search = "app/publicFunds/search";
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/guoshi/baselib/api/http/config/URLConfig$Companion;", "", "()V", "login_token_url", "", "mainPage_hotSearch", "mainPage_moreBankProducts", "mainPage_morePrivateFunds", "mainPage_morePublicFunds", "mainPage_optional", "mainPage_search", "publicFunds_attention", "publicFunds_find", "publicFunds_moreCompanys", "publicFunds_moreManagers", "publicFunds_moreProducts", "publicFunds_search", "baselib_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String login_token_url = "app/mainPage";
        
        /**
         * * 首页热门搜索内容
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String mainPage_hotSearch = "app/mainPage/hotSearch";
        
        /**
         * * 更多银行理财列表接口（带加载）
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String mainPage_moreBankProducts = "app/mainPage/moreBankProducts ";
        
        /**
         * * 更多私募基金列表接口（带加载）
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String mainPage_morePrivateFunds = "app/mainPage/morePrivateFunds";
        
        /**
         * * 更多公募基金列表接口（带加载）
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String mainPage_morePublicFunds = "app/mainPage/morePublicFunds";
        
        /**
         * * 加入自选接口
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String mainPage_optional = "app/mainPage/optional";
        
        /**
         * * 首页搜索
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String mainPage_search = "app/mainPage/search";
        
        /**
         * * 加入关注接口
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String publicFunds_attention = "app/publicFunds/attention";
        
        /**
         * * 公募发现接口
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String publicFunds_find = "app/publicFunds/find";
        
        /**
         * * 公募搜索基金公司接口（带加载）
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String publicFunds_moreCompanys = "app/publicFunds/moreCompanys";
        
        /**
         * * 公募搜索基金经理接口（带加载）
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String publicFunds_moreManagers = "app/publicFunds/moreManagers";
        
        /**
         * * 公募搜索基金产品接口（带加载）
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String publicFunds_moreProducts = "app/publicFunds/moreProducts";
        
        /**
         * * 公募搜索接口
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String publicFunds_search = "app/publicFunds/search";
        
        private Companion() {
            super();
        }
    }
}