package com.guoshi.baselib.base;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：activity父类
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/guoshi/baselib/base/BaseActivity;", "Landroid/support/v4/app/FragmentActivity;", "()V", "setThread", "Lio/reactivex/ObservableTransformer;", "T", "Companion", "baselib_debug"})
public class BaseActivity extends android.support.v4.app.FragmentActivity {
    public static final com.guoshi.baselib.base.BaseActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>io.reactivex.ObservableTransformer<T, T> setThread() {
        return null;
    }
    
    public BaseActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b\u00a8\u0006\u0015"}, d2 = {"Lcom/guoshi/baselib/base/BaseActivity$Companion;", "", "()V", "dip2px", "", "context", "Landroid/content/Context;", "dpValue", "", "getTime", "", "getVerName", "getbrand", "getrelease", "getstatusbar", "hidenInputMethod", "", "inacvivity", "outacvivity", "px2dip", "pxValue", "baselib_debug"})
    public static final class Companion {
        
        /**
         * * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
         */
        public final int dip2px(@org.jetbrains.annotations.NotNull()
        android.content.Context context, float dpValue) {
            return 0;
        }
        
        /**
         * * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
         */
        public final int px2dip(@org.jetbrains.annotations.NotNull()
        android.content.Context context, float pxValue) {
            return 0;
        }
        
        public final int getstatusbar(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return 0;
        }
        
        public final void inacvivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void outacvivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        /**
         * * //获取系统时间的13位的时间戳
         *         * @return
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTime() {
            return null;
        }
        
        /**
         * * 获取版本名称
         *         *
         *         * @param context
         *         * @return
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVerName(@org.jetbrains.annotations.Nullable()
        android.content.Context context) {
            return null;
        }
        
        /**
         * * 获取手机型号 厂家系统版本
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getbrand() {
            return null;
        }
        
        /**
         * * 获取手机系统版本
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getrelease() {
            return null;
        }
        
        public final void hidenInputMethod(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        private Companion() {
            super();
        }
    }
}