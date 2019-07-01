package com.guoshi.baselib.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ShareViewBinding extends ViewDataBinding {
  @NonNull
  public final RadioButton qq;

  @NonNull
  public final RadioButton qqk;

  @NonNull
  public final LinearLayout sharelin;

  @NonNull
  public final RadioButton wx;

  @NonNull
  public final RadioButton wxp;

  protected ShareViewBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RadioButton qq, RadioButton qqk, LinearLayout sharelin, RadioButton wx, RadioButton wxp) {
    super(_bindingComponent, _root, _localFieldCount);
    this.qq = qq;
    this.qqk = qqk;
    this.sharelin = sharelin;
    this.wx = wx;
    this.wxp = wxp;
  }

  @NonNull
  public static ShareViewBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.share_view, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ShareViewBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ShareViewBinding>inflateInternal(inflater, com.guoshi.baselib.R.layout.share_view, root, attachToRoot, component);
  }

  @NonNull
  public static ShareViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.share_view, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ShareViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ShareViewBinding>inflateInternal(inflater, com.guoshi.baselib.R.layout.share_view, null, false, component);
  }

  public static ShareViewBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ShareViewBinding bind(@NonNull View view, @Nullable Object component) {
    return (ShareViewBinding)bind(component, view, com.guoshi.baselib.R.layout.share_view);
  }
}
