package com.lsky.ener.app

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.support.multidex.MultiDex
import android.view.Gravity
import com.blankj.utilcode.util.ToastUtils
import com.blankj.utilcode.util.Utils
import com.leifu.kotlinmvp.BuildConfig
import com.leifu.kotlinmvp.R
import com.scwang.smartrefresh.header.MaterialHeader
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.*
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import kotlin.properties.Delegates


/**
 *创建人:雷富
 *创建时间:2019/6/5 14:24
 *描述:
 */
class MyApp : Application() {
    private val TAG = "MyApplication"

    companion object {
        var context: Context by Delegates.notNull()
    }

    //static 代码段可以防止内存泄露
    init {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(object : DefaultRefreshHeaderCreator {
            override fun createRefreshHeader(
                context: Context,
                layout: RefreshLayout
            ): RefreshHeader {
                //全局设置主题颜色（优先级第二低，可以覆盖 DefaultRefreshInitializer 的配置，与下面的ClassicsHeader绑定）
                layout.setPrimaryColorsId(R.color.colorPrimary, R.color.colorPrimary)
                return MaterialHeader(context)
            }
        })
        SmartRefreshLayout.setDefaultRefreshFooterCreator(object : DefaultRefreshFooterCreator {
            override fun createRefreshFooter(
                context: Context,
                layout: RefreshLayout
            ): RefreshFooter {
                return ClassicsFooter(context).setDrawableSize(20F)
            }
        })
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initConfig()
    }

    private fun initConfig() {
        //腾讯升级
//        CrashReport.setIsDevelopmentDevice(context, BuildConfig.DEBUG)
//        Bugly.init(applicationContext, "016d4ebfcc", BuildConfig.DEBUG)
        //内存泄漏和过度绘制检测
        if (BuildConfig.DEBUG) {
//            LeakCanary.install(this)
//            BlockCanary.install(applicationContext, AppBlockCanaryContext()).start()
        }

        Utils.init(this)
        ToastUtils.setBgColor(Color.parseColor("#FFFFFFFF"))
        ToastUtils.setMsgColor(Color.parseColor("#FFE02020"))
        ToastUtils.setGravity(Gravity.CENTER, 0, 0)
    }
}