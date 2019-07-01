package com.guoshi.baselib.api.http.config;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：关于网络的配置
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/guoshi/baselib/api/http/config/HttpConfig;", "", "()V", "APPKEY", "", "getAPPKEY", "()Ljava/lang/String;", "setAPPKEY", "(Ljava/lang/String;)V", "BASE_URL", "getBASE_URL", "setBASE_URL", "HTTP_TIME", "", "getHTTP_TIME", "()I", "setHTTP_TIME", "(I)V", "pageSize", "getPageSize", "setPageSize", "baselib_debug"})
public final class HttpConfig {
    private static int HTTP_TIME;
    private static int pageSize;
    
    /**
     * * 签名KEY
     *     * 接口对接签名需要
     */
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String APPKEY;
    
    /**
     * * 刘毅伟IP
     */
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String BASE_URL;
    public static final com.guoshi.baselib.api.http.config.HttpConfig INSTANCE = null;
    
    public final int getHTTP_TIME() {
        return 0;
    }
    
    public final void setHTTP_TIME(int p0) {
    }
    
    public final int getPageSize() {
        return 0;
    }
    
    public final void setPageSize(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAPPKEY() {
        return null;
    }
    
    public final void setAPPKEY(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBASE_URL() {
        return null;
    }
    
    public final void setBASE_URL(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private HttpConfig() {
        super();
    }
}