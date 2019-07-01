package com.guoshi.baselib.api.http;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：拦截器工具类
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/guoshi/baselib/api/http/InterceptorUtil;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "Token", "UTF8", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", "getUTF8", "()Ljava/nio/charset/Charset;", "LogInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "tokenInterceptor", "Lokhttp3/Interceptor;", "tokenInterceptor1", "", "baselib_debug"})
public final class InterceptorUtil {
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String TAG;
    private static final java.lang.String Token = "";
    private static final java.nio.charset.Charset UTF8 = null;
    public static final com.guoshi.baselib.api.http.InterceptorUtil INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    public final void setTAG(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final java.nio.charset.Charset getUTF8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.logging.HttpLoggingInterceptor LogInterceptor() {
        return null;
    }
    
    /**
     * * token验证的拦截器
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.Interceptor tokenInterceptor() {
        return null;
    }
    
    /**
     * * token验证的拦截器1
     *     * @return
     */
    public final void tokenInterceptor1() {
    }
    
    private InterceptorUtil() {
        super();
    }
}