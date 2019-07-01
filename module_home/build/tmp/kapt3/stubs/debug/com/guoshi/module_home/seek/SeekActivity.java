package com.guoshi.module_home.seek;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：首页搜索界面
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/home/seek")
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H\u0002J$\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0$2\u0006\u0010&\u001a\u00020\u0005H\u0002J\b\u0010\'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\"H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020\"2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020\"H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00064"}, d2 = {"Lcom/guoshi/module_home/seek/SeekActivity;", "Lcom/guoshi/baselib/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "KEY", "", "backProductsadapter", "Lcom/guoshi/module_home/adapter/MvvmCommonAdapter;", "binding", "Lcom/guoshi/module_home/databinding/ActivitySeekBinding;", "filterhistory", "", "Lcom/guoshi/baselib/entity/History;", "historyDao", "Lcom/guoshi/baselib/db/HistoryDao;", "historyList", "Ljava/util/ArrayList;", "historymvvmCommonAdapter", "hotmvvmCommonAdapter", "privateMvvmCommonAdapter", "products", "Lcom/guoshi/baselib/entity/module_home/Products;", "publicMvvmCommonAdapter", "searchView", "Landroid/support/v7/widget/SearchView;", "seekList", "Lcom/guoshi/baselib/entity/Seek;", "smasher", "Lcom/fadai/particlesmasher/ParticleSmasher;", "getSmasher$module_home_debug", "()Lcom/fadai/particlesmasher/ParticleSmasher;", "setSmasher$module_home_debug", "(Lcom/fadai/particlesmasher/ParticleSmasher;)V", "addhistory", "", "filter", "", "strings", "text", "inithistorydata", "initsouok", "initview", "load", "loadseek", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRestart", "module_home_debug"})
public final class SeekActivity extends com.guoshi.baselib.base.BaseActivity implements android.view.View.OnClickListener {
    private com.guoshi.module_home.databinding.ActivitySeekBinding binding;
    private com.guoshi.baselib.db.HistoryDao historyDao;
    private android.support.v7.widget.SearchView searchView;
    private java.lang.String KEY;
    private java.util.List<com.guoshi.baselib.entity.Seek> seekList;
    private com.guoshi.module_home.adapter.MvvmCommonAdapter hotmvvmCommonAdapter;
    private final java.util.ArrayList<com.guoshi.baselib.entity.History> historyList = null;
    private com.guoshi.module_home.adapter.MvvmCommonAdapter historymvvmCommonAdapter;
    private java.util.List<com.guoshi.baselib.entity.History> filterhistory;
    private com.guoshi.module_home.adapter.MvvmCommonAdapter publicMvvmCommonAdapter;
    private com.guoshi.module_home.adapter.MvvmCommonAdapter privateMvvmCommonAdapter;
    private com.guoshi.module_home.adapter.MvvmCommonAdapter backProductsadapter;
    @org.jetbrains.annotations.Nullable()
    private com.fadai.particlesmasher.ParticleSmasher smasher;
    private com.guoshi.baselib.entity.module_home.Products products;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final com.fadai.particlesmasher.ParticleSmasher getSmasher$module_home_debug() {
        return null;
    }
    
    public final void setSmasher$module_home_debug(@org.jetbrains.annotations.Nullable()
    com.fadai.particlesmasher.ParticleSmasher p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initview() {
    }
    
    @java.lang.Override()
    protected void onRestart() {
    }
    
    private final void initsouok() {
    }
    
    private final void inithistorydata() {
    }
    
    private final java.util.List<com.guoshi.baselib.entity.History> filter(java.util.List<com.guoshi.baselib.entity.History> strings, java.lang.String text) {
        return null;
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void loadseek() {
    }
    
    private final void load() {
    }
    
    private final void addhistory() {
    }
    
    public SeekActivity() {
        super();
    }
}