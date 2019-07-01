package com.guoshi.module_home.private_placement;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：私募搜索列表
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/home/PrivateList")
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010&\u001a\u00020\'H\u0002J\b\u0010(\u001a\u00020\'H\u0002J\b\u0010)\u001a\u00020\'H\u0016J\u0010\u0010*\u001a\u00020\'2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020\'2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015\u00a8\u00060"}, d2 = {"Lcom/guoshi/module_home/private_placement/PrivateListActivity;", "Lcom/guoshi/baselib/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/guoshi/module_home/databinding/ActivityPrivateBinding;", "getBinding", "()Lcom/guoshi/module_home/databinding/ActivityPrivateBinding;", "setBinding", "(Lcom/guoshi/module_home/databinding/ActivityPrivateBinding;)V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "pageIndex", "", "getPageIndex", "()I", "setPageIndex", "(I)V", "placementList", "", "Lcom/guoshi/baselib/entity/fund/Placement;", "getPlacementList", "()Ljava/util/List;", "setPlacementList", "(Ljava/util/List;)V", "privateMvvmCommonAdapter", "Lcom/guoshi/module_home/adapter/MvvmCommonAdapter;", "getPrivateMvvmCommonAdapter", "()Lcom/guoshi/module_home/adapter/MvvmCommonAdapter;", "setPrivateMvvmCommonAdapter", "(Lcom/guoshi/module_home/adapter/MvvmCommonAdapter;)V", "totalPage", "getTotalPage", "setTotalPage", "initview", "", "load", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "module_home_debug"})
public final class PrivateListActivity extends com.guoshi.baselib.base.BaseActivity implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.Nullable()
    private com.guoshi.module_home.databinding.ActivityPrivateBinding binding;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String key;
    @org.jetbrains.annotations.Nullable()
    private com.guoshi.module_home.adapter.MvvmCommonAdapter privateMvvmCommonAdapter;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.guoshi.baselib.entity.fund.Placement> placementList;
    private int pageIndex;
    private int totalPage;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final com.guoshi.module_home.databinding.ActivityPrivateBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.Nullable()
    com.guoshi.module_home.databinding.ActivityPrivateBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getKey() {
        return null;
    }
    
    public final void setKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.guoshi.module_home.adapter.MvvmCommonAdapter getPrivateMvvmCommonAdapter() {
        return null;
    }
    
    public final void setPrivateMvvmCommonAdapter(@org.jetbrains.annotations.Nullable()
    com.guoshi.module_home.adapter.MvvmCommonAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.guoshi.baselib.entity.fund.Placement> getPlacementList() {
        return null;
    }
    
    public final void setPlacementList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.guoshi.baselib.entity.fund.Placement> p0) {
    }
    
    public final int getPageIndex() {
        return 0;
    }
    
    public final void setPageIndex(int p0) {
    }
    
    public final int getTotalPage() {
        return 0;
    }
    
    public final void setTotalPage(int p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initview() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void load() {
    }
    
    public PrivateListActivity() {
        super();
    }
}