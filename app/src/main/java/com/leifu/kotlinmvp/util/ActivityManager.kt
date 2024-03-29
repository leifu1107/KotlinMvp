package com.lsky.ener.util

import android.app.Activity
import android.content.Context
import java.util.*
import kotlin.system.exitProcess

/**
 * Created by ShenBotao on 2016/5/17.
 * Activity管理类：用于管理Activity和退出程序
 */
class ActivityManager private constructor() {

    var activityStack: Stack<Activity>? = null

    companion object {
        val instance: ActivityManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ActivityManager()
        }
    }

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        if (activityStack == null) {
            activityStack = Stack()
        }
        activityStack?.add(activity)
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity {
        return activityStack!!.lastElement()
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun removeActivity() {
        val activity = activityStack!!.lastElement()
        removeActivity(activity)
    }

    /**
     * 结束指定的Activity
     */
    fun removeActivity(activity: Activity?) {
        activity?.apply {
            activityStack?.remove(this)
            finish()
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun removeActivity(cls: Class<*>) {
        try {
            for (activity in activityStack!!) {
                if (activity.javaClass == cls) {
                    removeActivity(activity)
                }
            }
        } catch (e: Exception) {
        }

    }

    /**
     * 结束指定类名的Activity
     */
    fun isActivitySurvive(cls: Class<*>): Boolean {
        for (activity in activityStack!!) {
            if (activity.javaClass == cls) {
                return true
            }
        }
        return false
    }

    /**
     * 结束指定类名的Activity  除了登录页面
     */
    fun finishWithOutActivity(cls: Class<*>) {
        //上面代码会有bug这里进行了特殊处理，如果直接在循环里面remove会报concurrentmodificationexception 错误
        activityStack?.apply {
            for (activity in this) {
                if (activity.javaClass != cls) {
                    activity.finish()
                }
            }
            clear()
        }
    }

    /**
     * 结束所有Activity
     */
    fun removeAllActivity() {
        activityStack?.apply {
            for (it in this) {
                it.finish()
            }
        }
        activityStack?.clear()
    }

    /**
     * 退出应用程序
     */
    fun appExit(context: Context) {
        try {
            removeAllActivity()
            val activityMgr = context.getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager
            activityMgr.killBackgroundProcesses(context.packageName)
            exitProcess(0)
        } catch (e: Exception) {
        }
    }

}
