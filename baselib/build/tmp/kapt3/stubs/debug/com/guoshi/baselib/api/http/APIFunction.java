package com.guoshi.baselib.api.http;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：API接口
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\u0002\b\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J#\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\u0002\b\u00042\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\'J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\fH\'J5\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\u00100\u00032\u0019\b\u0001\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\t\u0012\u00070\u0001\u00a2\u0006\u0002\b\u00040\u0013H\'J5\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\t0\u00100\u00032\u0019\b\u0001\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\t\u0012\u00070\u0001\u00a2\u0006\u0002\b\u00040\u0013H\'J5\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\t0\u00100\u00032\u0019\b\u0001\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\t\u0012\u00070\u0001\u00a2\u0006\u0002\b\u00040\u0013H\'J5\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\t0\u00100\u00032\u0019\b\u0001\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\t\u0012\u00070\u0001\u00a2\u0006\u0002\b\u00040\u0013H\'J\u001e\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\'J/\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00100\u00032\u0019\b\u0001\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\t\u0012\u00070\u0001\u00a2\u0006\u0002\b\u00040\u0013H\'J\u001e\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\'J5\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\u00100\u00032\u0019\b\u0001\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\t\u0012\u00070\u0001\u00a2\u0006\u0002\b\u00040\u0013H\'J5\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\t0\u00100\u00032\u0019\b\u0001\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\t\u0012\u00070\u0001\u00a2\u0006\u0002\b\u00040\u0013H\'J5\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\t0\u00100\u00032\u0019\b\u0001\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\t\u0012\u00070\u0001\u00a2\u0006\u0002\b\u00040\u0013H\'J5\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\t0\u00100\u00032\u0019\b\u0001\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\t\u0012\u00070\u0001\u00a2\u0006\u0002\b\u00040\u0013H\'J/\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00100\u00032\u0019\b\u0001\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\t\u0012\u00070\u0001\u00a2\u0006\u0002\b\u00040\u0013H\'\u00a8\u0006\'"}, d2 = {"Lcom/guoshi/baselib/api/http/APIFunction;", "", "imageUpload", "Lio/reactivex/Observable;", "Lkotlin/jvm/JvmSuppressWildcards;", "img", "Lokhttp3/MultipartBody$Part;", "imagesUpload", "imgs", "", "loginByToken", "Lretrofit2/Call;", "", "mobile", "cookie", "mainPage_hotSearch", "Lcom/guoshi/baselib/api/http/bean/BaseEntity;", "Lcom/guoshi/baselib/entity/Seek;", "map", "", "mainPage_moreBankProducts", "Lcom/guoshi/baselib/api/http/bean/ABean;", "mainPage_morePrivateFunds", "Lcom/guoshi/baselib/entity/fund/Placement;", "mainPage_morePublicFunds", "mainPage_optional", "requestBody", "Lokhttp3/RequestBody;", "mainPage_search", "Lcom/guoshi/baselib/entity/module_home/Products;", "publicFunds_attention", "publicFunds_find", "publicFunds_moreCompanys", "Lcom/guoshi/baselib/entity/fund/Company;", "publicFunds_moreManagers", "Lcom/guoshi/baselib/entity/fund/FundManger;", "publicFunds_moreProducts", "publicFunds_search", "Lcom/guoshi/baselib/entity/module_home/PublicSeek;", "baselib_debug"})
public abstract interface APIFunction {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "app/mainPage")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<java.lang.String> loginByToken(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "mobile")
    java.lang.String mobile, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "token")
    java.lang.String cookie);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "\u670d\u52a1\u5668\u5730\u5740")
    public abstract io.reactivex.Observable<java.lang.Object> imageUpload(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part img);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "\u670d\u52a1\u5668\u5730\u5740")
    public abstract io.reactivex.Observable<java.lang.Object> imagesUpload(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    java.util.List<okhttp3.MultipartBody.Part> imgs);
    
    /**
     * * 首页热门搜索内容接口
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "app/mainPage/hotSearch")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<java.util.List<com.guoshi.baselib.entity.Seek>>> mainPage_hotSearch(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.Object> map);
    
    /**
     * * 首页搜索
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "app/mainPage/search")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<com.guoshi.baselib.entity.module_home.Products>> mainPage_search(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.Object> map);
    
    /**
     * * 更多银行理财列表接口（带加载）
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "app/mainPage/moreBankProducts ")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<java.util.List<com.guoshi.baselib.api.http.bean.ABean>>> mainPage_moreBankProducts(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.Object> map);
    
    /**
     * * 更多私募基金列表接口（带加载）
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "app/mainPage/morePrivateFunds")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<java.util.List<com.guoshi.baselib.entity.fund.Placement>>> mainPage_morePrivateFunds(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.Object> map);
    
    /**
     * * 更多公募基金列表接口（带加载）
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "app/mainPage/morePublicFunds")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<java.util.List<com.guoshi.baselib.entity.fund.Placement>>> mainPage_morePublicFunds(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.Object> map);
    
    /**
     * * 公募发现接口
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "app/publicFunds/find")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<java.util.List<com.guoshi.baselib.entity.Seek>>> publicFunds_find(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.Object> map);
    
    /**
     * * 公募搜索基金公司接口（带加载）
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "app/publicFunds/moreCompanys")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<java.util.List<com.guoshi.baselib.entity.fund.Company>>> publicFunds_moreCompanys(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.Object> map);
    
    /**
     * * 公募搜索基金经理接口（带加载）
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "app/publicFunds/moreManagers")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<java.util.List<com.guoshi.baselib.entity.fund.FundManger>>> publicFunds_moreManagers(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.Object> map);
    
    /**
     * * 公募搜索基金产品接口（带加载）
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "app/publicFunds/moreProducts")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<java.util.List<com.guoshi.baselib.entity.fund.Placement>>> publicFunds_moreProducts(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.Object> map);
    
    /**
     * * 公募搜索接口
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "app/publicFunds/search")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<com.guoshi.baselib.entity.module_home.PublicSeek>> publicFunds_search(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.Object> map);
    
    /**
     * * 加入自选与关注接口
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "app/publicFunds/attention")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<java.lang.String>> publicFunds_attention(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    okhttp3.RequestBody requestBody);
    
    /**
     * *
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "app/mainPage/optional")
    public abstract io.reactivex.Observable<com.guoshi.baselib.api.http.bean.BaseEntity<java.lang.String>> mainPage_optional(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    okhttp3.RequestBody requestBody);
}