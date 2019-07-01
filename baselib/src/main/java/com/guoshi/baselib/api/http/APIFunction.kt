package com.guoshi.baselib.api.http


import com.guoshi.baselib.api.http.bean.ABean
import com.guoshi.baselib.api.http.bean.BaseEntity
import com.guoshi.baselib.api.http.config.URLConfig
import com.guoshi.baselib.entity.Seek
import com.guoshi.baselib.entity.fund.FundManger
import com.guoshi.baselib.entity.module_home.Products
import com.guoshi.baselib.entity.module_home.PublicSeek
import com.guoshi.baselib.entity.fund.Placement
import com.guoshi.baselib.entity.fund.Company

import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query
import retrofit2.http.QueryMap


/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：API接口
 */
interface APIFunction {
    @FormUrlEncoded
    @POST(URLConfig.login_token_url)//@FieldMap
    fun loginByToken(@Query("mobile") mobile: String, @Query("token") cookie: String): Call<String>

    //上传单张图片
    @POST("服务器地址")
    fun imageUpload(@Part img: MultipartBody.Part): @JvmSuppressWildcards Observable<Any>

    //上传多张图片
    @POST("服务器地址")
    fun imagesUpload(@Part imgs: List<MultipartBody.Part>): @JvmSuppressWildcards Observable<Any>


    /**
     * 首页热门搜索内容接口
     * @return
     */
    //    @POST(URLConfig.mainPage_hotSearch)
    //    Observable<BaseEntity<List<ABean>>> mainPage_hotSearch(@Body RequestBody requestBody);
    /**
     * 首页热门搜索内容接口
     * @return
     */


    @GET(URLConfig.mainPage_hotSearch)
    fun mainPage_hotSearch(@QueryMap map: Map<String, @JvmSuppressWildcards Any>): Observable<BaseEntity<List<Seek>>>

    /**
     * 首页搜索
     * @return
     */
    @GET(URLConfig.mainPage_search)
    fun mainPage_search(@QueryMap map: Map<String, @JvmSuppressWildcards Any>): Observable<BaseEntity<Products>>

    /**
     * 更多银行理财列表接口（带加载）
     * @return
     */
    @GET(URLConfig.mainPage_moreBankProducts)
    fun mainPage_moreBankProducts(@QueryMap map: Map<String, @JvmSuppressWildcards Any>):  Observable<BaseEntity<List<ABean>>>

    /**
     * 更多私募基金列表接口（带加载）
     * @return
     */
    @GET(URLConfig.mainPage_morePrivateFunds)
    fun mainPage_morePrivateFunds(@QueryMap map: Map<String, @JvmSuppressWildcards Any>):  Observable<BaseEntity<List<Placement>>>

    /**
     * 更多公募基金列表接口（带加载）
     * @return
     */
    @GET(URLConfig.mainPage_morePublicFunds)
    fun mainPage_morePublicFunds(@QueryMap map: Map<String, @JvmSuppressWildcards Any>): Observable<BaseEntity<List<Placement>>>

    /**
     * 公募发现接口
     * @return
     */
    @GET(URLConfig.publicFunds_find)
    fun publicFunds_find(@QueryMap map: Map<String, @JvmSuppressWildcards Any>):  Observable<BaseEntity<List<Seek>>>

    /**
     * 公募搜索基金公司接口（带加载）
     * @return
     */
    @GET(URLConfig.publicFunds_moreCompanys)
    fun publicFunds_moreCompanys(@QueryMap map: Map<String, @JvmSuppressWildcards Any>): Observable<BaseEntity<List<Company>>>

    /**
     * 公募搜索基金经理接口（带加载）
     * @return
     */
    @GET(URLConfig.publicFunds_moreManagers)
    fun publicFunds_moreManagers(@QueryMap map: Map<String, @JvmSuppressWildcards Any>): Observable<BaseEntity<List<FundManger>>>

    /**
     * 公募搜索基金产品接口（带加载）
     * @return
     */
    @GET(URLConfig.publicFunds_moreProducts)
    fun publicFunds_moreProducts(@QueryMap map: Map<String,@JvmSuppressWildcards Any>):  Observable<BaseEntity<List<Placement>>>

    /**
     * 公募搜索接口
     * @return
     */
    @GET(URLConfig.publicFunds_search)
    fun publicFunds_search(@QueryMap map: Map<String, @JvmSuppressWildcards Any>): Observable<BaseEntity<PublicSeek>>

    /**
     * 加入自选与关注接口
     * @return
     */
    @POST(URLConfig.publicFunds_attention)
    fun publicFunds_attention(@Body requestBody: RequestBody): Observable<BaseEntity<String>>

    /**
     *
     */
    @POST(URLConfig.mainPage_optional)
    fun mainPage_optional(@Body requestBody: RequestBody): Observable<BaseEntity<String>>

    //    /**
    //     *
    //     */
    //    @POST(URLConfig.adduser)
    //    Observable<BaseEntity<String>> adduser(@Body RequestBody requestBody);
}
