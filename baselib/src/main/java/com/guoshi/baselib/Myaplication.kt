package com.guoshi.baselib

import android.app.Application
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.support.multidex.MultiDex

import com.alibaba.android.arouter.launcher.ARouter
import com.guoshi.baselib.db.DaoMaster
import com.guoshi.baselib.db.DaoSession
import com.mob.MobSDK
import com.tencent.bugly.crashreport.CrashReport

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/4/9
 * 文件描述：
 */
class Myaplication : Application() {
    var helper: DaoMaster.DevOpenHelper? = null
    var db: SQLiteDatabase? = null
    var daoMaster: DaoMaster? = null
    var daoSession: DaoSession? = null

    override fun onCreate() {
        super.onCreate()
        instances = this
        ARouter.openLog()     // 打印日志
        ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(instances) // 尽可能早，推荐在Application中初始化
        //正式版本修改false
        CrashReport.initCrashReport(applicationContext, "9cf7ad23d4", true)
        setdatabase()
        MobSDK.init(instances)
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }

    /**
     * 设置greenDAO
     */
    private fun setdatabase() {
        helper = DaoMaster.DevOpenHelper(this, "licaishi-db", null)
        db = helper!!.writableDatabase
        daoMaster = DaoMaster(db)
        daoSession = daoMaster!!.newSession()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    companion object {
        lateinit var instances: Myaplication
    }
}
