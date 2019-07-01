package com.guoshi.module_home.public_placement;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：公募主界面
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/home/publicmain")
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0016J\u0010\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020%H\u0016J\u0012\u0010/\u001a\u00020)2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020)H\u0014J\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u000205H\u0007J\b\u00106\u001a\u00020)H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00068"}, d2 = {"Lcom/guoshi/module_home/public_placement/PublicMainActivity;", "Lcom/guoshi/baselib/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "KEY", "", "allFragment", "Lcom/guoshi/module_home/fragment/AllFragment;", "binding", "Lcom/guoshi/module_home/databinding/ActivityPublicMainBinding;", "fragmentList", "", "Landroid/support/v4/app/Fragment;", "fundCompanyFragment", "Lcom/guoshi/module_home/fragment/FundCompanyFragment;", "fundManagerFragment", "Lcom/guoshi/module_home/fragment/FundManagerFragment;", "fundProductFragment", "Lcom/guoshi/module_home/fragment/FundProductFragment;", "historyDao", "Lcom/guoshi/baselib/db/HistoryDao;", "historyList", "Ljava/util/ArrayList;", "Lcom/guoshi/baselib/entity/History;", "historymvvmCommonAdapter", "Lcom/guoshi/module_home/adapter/MvvmCommonAdapter;", "hotmvvmCommonAdapter", "navigationTag", "seekList", "Lcom/guoshi/baselib/entity/Seek;", "smasher", "Lcom/fadai/particlesmasher/ParticleSmasher;", "getSmasher$module_home_debug", "()Lcom/fadai/particlesmasher/ParticleSmasher;", "setSmasher$module_home_debug", "(Lcom/fadai/particlesmasher/ParticleSmasher;)V", "getTabView", "Landroid/view/View;", "currentPosition", "", "initview", "", "load", "mainhistory", "onBackPressed", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEventMainThread", "event", "Lcom/guoshi/baselib/evenbus/MyEvenbus;", "setkey", "Companion", "module_home_debug"})
public final class PublicMainActivity extends com.guoshi.baselib.base.BaseActivity implements android.view.View.OnClickListener {
    private com.guoshi.module_home.databinding.ActivityPublicMainBinding binding;
    private java.util.List<android.support.v4.app.Fragment> fragmentList;
    private java.lang.String KEY;
    private com.guoshi.module_home.fragment.AllFragment allFragment;
    private com.guoshi.module_home.fragment.FundProductFragment fundProductFragment;
    private com.guoshi.module_home.fragment.FundCompanyFragment fundCompanyFragment;
    private com.guoshi.module_home.fragment.FundManagerFragment fundManagerFragment;
    private java.util.List<com.guoshi.baselib.entity.Seek> seekList;
    private com.guoshi.module_home.adapter.MvvmCommonAdapter hotmvvmCommonAdapter;
    private com.guoshi.baselib.db.HistoryDao historyDao;
    private final java.util.ArrayList<com.guoshi.baselib.entity.History> historyList = null;
    private com.guoshi.module_home.adapter.MvvmCommonAdapter historymvvmCommonAdapter;
    private final java.util.ArrayList<java.lang.String> navigationTag = null;
    @org.jetbrains.annotations.Nullable()
    private com.fadai.particlesmasher.ParticleSmasher smasher;
    public static final com.guoshi.module_home.public_placement.PublicMainActivity.Companion Companion = null;
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
    protected void onDestroy() {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onEventMainThread(@org.jetbrains.annotations.NotNull()
    com.guoshi.baselib.evenbus.MyEvenbus event) {
    }
    
    private final void setkey() {
    }
    
    private final void mainhistory() {
    }
    
    /**
     * * 自定义Tab的View
     *     * @param currentPosition
     *     * @return
     */
    private final android.view.View getTabView(int currentPosition) {
        return null;
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
    
    public PublicMainActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/guoshi/module_home/public_placement/PublicMainActivity$Companion;", "", "()V", "reflex", "", "tabLayout", "Landroid/support/design/widget/TabLayout;", "module_home_debug"})
    public static final class Companion {
        
        public final void reflex(@org.jetbrains.annotations.NotNull()
        android.support.design.widget.TabLayout tabLayout) {
        }
        
        private Companion() {
            super();
        }
    }
}