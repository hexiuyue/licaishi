package com.guoshi.module_news.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentOptionalBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout wdln;

  protected FragmentOptionalBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout wdln) {
    super(_bindingComponent, _root, _localFieldCount);
    this.wdln = wdln;
  }

  @NonNull
  public static FragmentOptionalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_optional, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentOptionalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentOptionalBinding>inflateInternal(inflater, com.guoshi.module_news.R.layout.fragment_optional, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentOptionalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_optional, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentOptionalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentOptionalBinding>inflateInternal(inflater, com.guoshi.module_news.R.layout.fragment_optional, null, false, component);
  }

  public static FragmentOptionalBinding bind(@NonNull View view) {
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
  public static FragmentOptionalBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentOptionalBinding)bind(component, view, com.guoshi.module_news.R.layout.fragment_optional);
  }
}
