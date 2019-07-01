package com.guoshi.baselib.api.http.base;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：Observer基类
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0004J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H$J\u0016\u0010\u0017\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0004J\b\u0010\u001a\u001a\u00020\rH\u0004J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H$J\u0006\u0010\u001f\u001a\u00020\rR\u001a\u0010\b\u001a\u00020\u0005X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0006\u00a8\u0006 "}, d2 = {"Lcom/guoshi/baselib/api/http/base/BaseObserver;", "T", "Lio/reactivex/Observer;", "Lcom/guoshi/baselib/api/http/bean/BaseEntity;", "cxt", "Landroid/content/Context;", "(Landroid/content/Context;)V", "()V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "closeProgressDialog", "", "onCodeError", "t", "onComplete", "onError", "e", "", "onFailure", "isNetWorkError", "", "onNext", "tBaseEntity", "onRequestEnd", "onRequestStart", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccees", "showProgressDialog", "baselib_debug"})
public abstract class BaseObserver<T extends java.lang.Object> implements io.reactivex.Observer<com.guoshi.baselib.api.http.bean.BaseEntity<T>> {
    @org.jetbrains.annotations.NotNull()
    protected android.content.Context mContext;
    
    @org.jetbrains.annotations.NotNull()
    protected final android.content.Context getMContext() {
        return null;
    }
    
    protected final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @java.lang.Override()
    public void onSubscribe(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable d) {
    }
    
    @java.lang.Override()
    public void onNext(@org.jetbrains.annotations.NotNull()
    com.guoshi.baselib.api.http.bean.BaseEntity<T> tBaseEntity) {
    }
    
    @java.lang.Override()
    public void onError(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable e) {
    }
    
    @java.lang.Override()
    public void onComplete() {
    }
    
    /**
     * * 返回成功
     *     *
     *     * @param t
     *     * @throws Exception
     */
    protected abstract void onSuccees(@org.jetbrains.annotations.NotNull()
    com.guoshi.baselib.api.http.bean.BaseEntity<T> t);
    
    /**
     * * 返回成功了,但是code错误
     *     *
     *     * @param t
     *     * @throws Exception
     */
    protected final void onCodeError(@org.jetbrains.annotations.NotNull()
    com.guoshi.baselib.api.http.bean.BaseEntity<T> t) {
    }
    
    /**
     * * 返回失败
     *     *
     *     * @param e
     *     * @param isNetWorkError 是否是网络错误
     *     * @throws Exception
     */
    protected abstract void onFailure(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable e, boolean isNetWorkError);
    
    protected final void onRequestStart() {
    }
    
    protected final void onRequestEnd() {
    }
    
    public final void showProgressDialog() {
    }
    
    public final void closeProgressDialog() {
    }
    
    public BaseObserver(@org.jetbrains.annotations.NotNull()
    android.content.Context cxt) {
        super();
    }
    
    public BaseObserver() {
        super();
    }
}