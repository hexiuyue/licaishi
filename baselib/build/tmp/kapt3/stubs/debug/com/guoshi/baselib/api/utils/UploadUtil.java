package com.guoshi.baselib.api.utils;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：上传图片
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ*\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/guoshi/baselib/api/utils/UploadUtil;", "", "()V", "filesToMultipartBodyParts", "", "Lokhttp3/MultipartBody$Part;", "files", "Ljava/io/File;", "uploadImage", "", "filePath", "", "observer", "Lio/reactivex/Observer;", "context", "Landroid/content/Context;", "uploadImages", "mFilesPath", "Ljava/util/ArrayList;", "baselib_debug"})
public final class UploadUtil {
    public static final com.guoshi.baselib.api.utils.UploadUtil INSTANCE = null;
    
    /**
     * * 上传单张图片
     *     *
     *     * @param filePath 图片路径
     *     * @param observer 观察者
     *     * @throws IOException
     */
    public final void uploadImage(@org.jetbrains.annotations.NotNull()
    java.lang.String filePath, @org.jetbrains.annotations.NotNull()
    io.reactivex.Observer<java.lang.Object> observer, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * * 上传多张照片
     *     *
     *     * @param mFilesPath
     *     * @param observer
     */
    public final void uploadImages(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> mFilesPath, @org.jetbrains.annotations.NotNull()
    io.reactivex.Observer<java.lang.Object> observer, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * * @param files 多图片文件转表单
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<okhttp3.MultipartBody.Part> filesToMultipartBodyParts(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> files) {
        return null;
    }
    
    private UploadUtil() {
        super();
    }
}