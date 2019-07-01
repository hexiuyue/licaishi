package com.guoshi.baselib.api.utils;

import java.lang.System;

/**
 * * 国时智能
 * * 作者：knight.he
 * * 创建时间：2019/3/4
 * * 文件描述：关于图片的工具类
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/guoshi/baselib/api/utils/BitmapUtil;", "", "()V", "PHOTO_FILE_NAME", "", "calculateInSampleSize", "", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "compressImage", "filePath", "createCircleImage", "Landroid/graphics/Bitmap;", "source", "getRotateAngle", "getSmallBitmap", "setRotateAngle", "angle", "bitmap", "baselib_debug"})
public final class BitmapUtil {
    private static final java.lang.String PHOTO_FILE_NAME = "PMSManagerPhoto";
    public static final com.guoshi.baselib.api.utils.BitmapUtil INSTANCE = null;
    
    /**
     * * 获取图片的旋转角度
     *     *
     *     * @param filePath
     *     * @return
     */
    public final int getRotateAngle(@org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return 0;
    }
    
    /**
     * * 旋转图片角度
     *     *
     *     * @param angle
     *     * @param bitmap
     *     * @return
     */
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap setRotateAngle(int angle, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap createCircleImage(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap source) {
        return null;
    }
    
    /**
     * * 图片压缩-质量压缩
     *     *
     *     * @param filePath 源图片路径
     *     * @return 压缩后的路径
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String compressImage(@org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return null;
    }
    
    /**
     * * 根据路径获得图片信息并按比例压缩，返回bitmap
     */
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap getSmallBitmap(@org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return null;
    }
    
    public final int calculateInSampleSize(@org.jetbrains.annotations.NotNull()
    android.graphics.BitmapFactory.Options options, int reqWidth, int reqHeight) {
        return 0;
    }
    
    private BitmapUtil() {
        super();
    }
}