package com.guoshi.module_home.adapter;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：RecyclerView通用Adapter
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 N2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u00032\u00020\u0004:\u0004MNOPB+\b\u0016\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0002\u0010\fB3\b\u0016\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\"\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\bH\u0002J\b\u00101\u001a\u00020\bH\u0016J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\bH\u0016J\f\u00105\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006J\u0006\u00106\u001a\u000207J\u001c\u00108\u001a\u00020-2\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u00104\u001a\u00020\bH\u0016J\u0010\u00109\u001a\u00020-2\u0006\u0010:\u001a\u000207H\u0016J\u001c\u0010;\u001a\u00060\u0002R\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\bH\u0016J\u0010\u0010?\u001a\u00020@2\u0006\u0010:\u001a\u000207H\u0016J\"\u0010A\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\bH\u0002J\u0014\u0010B\u001a\u00020-2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u0006J\u000e\u0010E\u001a\u00020-2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020#J\u000e\u0010H\u001a\u00020-2\u0006\u0010*\u001a\u00020+J\u0018\u0010I\u001a\u000e\u0012\u0004\u0012\u0002HK\u0012\u0004\u0012\u0002HK0J\"\u0004\b\u0000\u0010KJ\u0012\u0010L\u001a\u00020-2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0006R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0002R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\nX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006Q"}, d2 = {"Lcom/guoshi/module_home/adapter/MvvmCommonAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/guoshi/module_home/adapter/MvvmCommonAdapter$CommonHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "datas", "", "variableId", "", "context", "Landroid/content/Context;", "layoutId", "(Ljava/util/List;ILandroid/content/Context;I)V", "KEYs", "", "(Ljava/util/List;ILandroid/content/Context;ILjava/lang/String;)V", "KEY", "holder", "mDatas", "getMDatas", "()Ljava/util/List;", "setMDatas", "(Ljava/util/List;)V", "mInflater", "Landroid/view/LayoutInflater;", "getMInflater", "()Landroid/view/LayoutInflater;", "setMInflater", "(Landroid/view/LayoutInflater;)V", "mLayoutId", "getMLayoutId", "()I", "setMLayoutId", "(I)V", "mOnItemClickListener", "Lcom/guoshi/module_home/adapter/MvvmCommonAdapter$OnItemClickListener;", "mVariableId", "myContext", "getMyContext", "()Landroid/content/Context;", "setMyContext", "(Landroid/content/Context;)V", "onItemLongClickListener", "Lcom/guoshi/module_home/adapter/MvvmCommonAdapter$RecyclerViewOnItemLongClickListener;", "attention", "", "id", "operateType", "type", "getItemCount", "getItemId", "", "position", "getmDatas", "getvview", "Landroid/view/View;", "onBindViewHolder", "onClick", "v", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onLongClick", "", "optional", "setFilter", "filterHistory", "Lcom/guoshi/baselib/entity/History;", "setKET", "setOnItemClickListener", "listener", "setOnItemLongClickListener", "setThread", "Lio/reactivex/ObservableTransformer;", "T", "setmDatas", "CommonHolder", "Companion", "OnItemClickListener", "RecyclerViewOnItemLongClickListener", "module_home_debug"})
public final class MvvmCommonAdapter extends android.support.v7.widget.RecyclerView.Adapter<com.guoshi.module_home.adapter.MvvmCommonAdapter.CommonHolder> implements android.view.View.OnClickListener, android.view.View.OnLongClickListener {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context myContext;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<?> mDatas;
    private int mLayoutId;
    @org.jetbrains.annotations.NotNull()
    private android.view.LayoutInflater mInflater;
    private int mVariableId;
    private com.guoshi.module_home.adapter.MvvmCommonAdapter.CommonHolder holder;
    private com.guoshi.module_home.adapter.MvvmCommonAdapter.OnItemClickListener mOnItemClickListener;
    private com.guoshi.module_home.adapter.MvvmCommonAdapter.RecyclerViewOnItemLongClickListener onItemLongClickListener;
    private java.lang.String KEY;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "MvvmCommonAdapter";
    public static final com.guoshi.module_home.adapter.MvvmCommonAdapter.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    protected final android.content.Context getMyContext() {
        return null;
    }
    
    protected final void setMyContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final java.util.List<?> getMDatas() {
        return null;
    }
    
    protected final void setMDatas(@org.jetbrains.annotations.Nullable()
    java.util.List<?> p0) {
    }
    
    protected final int getMLayoutId() {
        return 0;
    }
    
    protected final void setMLayoutId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final android.view.LayoutInflater getMInflater() {
        return null;
    }
    
    protected final void setMInflater(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getvview() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<?> getmDatas() {
        return null;
    }
    
    public final void setmDatas(@org.jetbrains.annotations.NotNull()
    java.util.List<?> mDatas) {
    }
    
    @java.lang.Override()
    public long getItemId(int position) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.guoshi.module_home.adapter.MvvmCommonAdapter.CommonHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.guoshi.module_home.adapter.MvvmCommonAdapter.CommonHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.NotNull()
    com.guoshi.module_home.adapter.MvvmCommonAdapter.OnItemClickListener listener) {
    }
    
    public final void setOnItemLongClickListener(@org.jetbrains.annotations.NotNull()
    com.guoshi.module_home.adapter.MvvmCommonAdapter.RecyclerViewOnItemLongClickListener onItemLongClickListener) {
    }
    
    @java.lang.Override()
    public boolean onLongClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
        return false;
    }
    
    public final void setFilter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.guoshi.baselib.entity.History> filterHistory) {
    }
    
    public final void setKET(@org.jetbrains.annotations.NotNull()
    java.lang.String KEYs) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>io.reactivex.ObservableTransformer<T, T> setThread() {
        return null;
    }
    
    private final void attention(java.lang.String id, int operateType, int type) {
    }
    
    private final void optional(java.lang.String id, int operateType, int type) {
    }
    
    public MvvmCommonAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<?> datas, int variableId, @org.jetbrains.annotations.NotNull()
    android.content.Context context, int layoutId) {
        super();
    }
    
    public MvvmCommonAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<?> datas, int variableId, @org.jetbrains.annotations.NotNull()
    android.content.Context context, int layoutId, @org.jetbrains.annotations.NotNull()
    java.lang.String KEYs) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/guoshi/module_home/adapter/MvvmCommonAdapter$CommonHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/guoshi/module_home/adapter/MvvmCommonAdapter;Landroid/view/View;)V", "binding", "Landroid/databinding/ViewDataBinding;", "getBinding", "()Landroid/databinding/ViewDataBinding;", "setBinding", "(Landroid/databinding/ViewDataBinding;)V", "module_home_debug"})
    public final class CommonHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.Nullable()
        private android.databinding.ViewDataBinding binding;
        
        @org.jetbrains.annotations.Nullable()
        public final android.databinding.ViewDataBinding getBinding() {
            return null;
        }
        
        public final void setBinding(@org.jetbrains.annotations.Nullable()
        android.databinding.ViewDataBinding p0) {
        }
        
        public CommonHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/guoshi/module_home/adapter/MvvmCommonAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "module_home_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/guoshi/module_home/adapter/MvvmCommonAdapter$RecyclerViewOnItemLongClickListener;", "", "onItemLongClickListener", "", "view", "Landroid/view/View;", "position", "", "module_home_debug"})
    public static abstract interface RecyclerViewOnItemLongClickListener {
        
        public abstract boolean onItemLongClickListener(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/guoshi/module_home/adapter/MvvmCommonAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "module_home_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTAG() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}