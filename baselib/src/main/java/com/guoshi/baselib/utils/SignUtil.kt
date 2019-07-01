package com.guoshi.baselib.utils

import android.util.Log

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.Arrays

//import java.util.HashMap;


/**
 * 签名的的规则
 *
 */

object SignUtil {
    /**
     * 生成sign
     *
     * @param map
     * @param key
     * @return
     * @throws UnsupportedEncodingException
     */
    fun getSign(map: Map<String, Any>, key: String): String {
        var returnValue = ""
        val nameArr = map.keys.toTypedArray()
        Arrays.sort(nameArr)//按照参数名升序排序
        val builder = StringBuilder()
        for (name in nameArr) {
            //			if ("sign".equals(name))//后台需要
            //				continue;
            if (map[name] == null || "" == map[name])
            //参数为空或""不参与
                continue
            builder.append(name + "=" + map[name] + "&")
        }
        builder.append("key=$key")//最后加上公司KEY
        val s = builder.toString()
        val sa = s.replace(" ".toRegex(), "")//去除空格
        Log.e("mainPage/search", sa)
        try {
            returnValue = Md5(sa, "UTF-8")//最后一起使用AES加密
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return returnValue
    }


    /**
     * md5加密
     *
     * @param plainText
     * @param charset
     * @return
     * @throws UnsupportedEncodingException
     */
    @Throws(UnsupportedEncodingException::class)
    private fun Md5(plainText: String, charset: String): String {
        try {
            val md = MessageDigest.getInstance("MD5")
            md.update(plainText.toByteArray(charset(charset)))
            val b = md.digest()
            var i: Int
            val buf = StringBuffer("")
            for (offset in b.indices) {
                i = b[offset].toInt()
                if (i < 0)
                    i += 256
                if (i < 16)
                    buf.append("0")
                buf.append(Integer.toHexString(i))
            }
            return buf.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return "null"
    }
}
