package com.guoshi.baselib.entity.fund;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/5/6
 * * 文件描述：基金经理
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/guoshi/baselib/entity/fund/FundManger;", "", "()V", "addAttention", "", "getAddAttention", "()I", "setAddAttention", "(I)V", "companyName", "", "getCompanyName", "()Ljava/lang/String;", "setCompanyName", "(Ljava/lang/String;)V", "experience", "getExperience", "setExperience", "icon", "getIcon", "setIcon", "managerId", "getManagerId", "setManagerId", "managerName", "getManagerName", "setManagerName", "Companion", "baselib_debug"})
public final class FundManger {
    private int addAttention;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String companyName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String managerName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String icon;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String experience;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String managerId;
    public static final com.guoshi.baselib.entity.fund.FundManger.Companion Companion = null;
    
    public final int getAddAttention() {
        return 0;
    }
    
    public final void setAddAttention(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCompanyName() {
        return null;
    }
    
    public final void setCompanyName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getManagerName() {
        return null;
    }
    
    public final void setManagerName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIcon() {
        return null;
    }
    
    public final void setIcon(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getExperience() {
        return null;
    }
    
    public final void setExperience(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getManagerId() {
        return null;
    }
    
    public final void setManagerId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public FundManger() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/guoshi/baselib/entity/fund/FundManger$Companion;", "", "()V", "getInternetImage", "", "iv", "Landroid/widget/ImageView;", "userface", "", "baselib_debug"})
    public static final class Companion {
        
        @android.databinding.BindingAdapter(value = {"fundmangerimgs"})
        public final void getInternetImage(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView iv, @org.jetbrains.annotations.Nullable()
        java.lang.String userface) {
        }
        
        private Companion() {
            super();
        }
    }
}