package com.guoshi.baselib.entity;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/4/15
 * * 文件描述：搜索历史内容类
 */
@org.greenrobot.greendao.annotation.Entity()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\u0007\b\u0016\u00a2\u0006\u0002\u0010\tJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005J\u0015\u0010\u0011\u001a\u00020\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/guoshi/baselib/entity/History;", "Landroid/databinding/BaseObservable;", "id", "", "content", "", "type", "", "(Ljava/lang/Long;Ljava/lang/String;I)V", "()V", "Ljava/lang/Long;", "getContent", "getId", "()Ljava/lang/Long;", "getType", "setContent", "", "setId", "(Ljava/lang/Long;)V", "setType", "baselib_debug"})
public final class History extends android.databinding.BaseObservable {
    @org.greenrobot.greendao.annotation.Id(autoincrement = true)
    private java.lang.Long id;
    private java.lang.String content;
    private int type;
    
    @org.jetbrains.annotations.Nullable()
    @android.databinding.Bindable()
    public final java.lang.Long getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Long id) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.databinding.Bindable()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final void setContent(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    @android.databinding.Bindable()
    public final int getType() {
        return 0;
    }
    
    public final void setType(int type) {
    }
    
    @org.greenrobot.greendao.annotation.Generated(hash = 743537489)
    public History(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    java.lang.String content, int type) {
        super();
    }
    
    @org.greenrobot.greendao.annotation.Generated(hash = 869423138)
    public History() {
        super();
    }
}