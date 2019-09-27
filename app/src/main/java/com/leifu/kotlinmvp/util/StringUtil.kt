package com.lsky.ener.util

import android.text.TextUtils

/**
 *创建人:雷富
 *创建时间:2019/7/3 14:36
 *描述:
 */
class StringUtil {

    companion object {
        /**
         * 数据为null,
         */
        fun isEmpty(string: String?): Boolean {
            return null == string || string.trim().isEmpty()
        }

        /**
         * 数据为null,返回-
         */
        fun isEmptyReturn_(string: String?): String? {
            if (TextUtils.isEmpty(string)) {
                return "--"
            }
            return string
        }

        /**
         * 数据为null,返回" "
         */
        fun isEmptyReturnNull(string: String?): String {
            return if (TextUtils.isEmpty(string)) {
                " "
            } else {
                string.toString()
            }

        }

        /**
         * 数据为null,返回-
         */
        fun isEmptyId(string: String?): String? {
            if (TextUtils.isEmpty(string)) {
                return "未安装"
            }
            return "已安装"
        }

        /**
         * 传递ids,用,分开
         */
        fun getIds(ids: MutableList<String>): String {
            val sb = StringBuilder()
            for (id in ids) {
                if (id.trim().isNotEmpty()) {//去空格
                    if (sb.isNotEmpty()) {
                        sb.append(",")
                    }
                    sb.append(id)
                }
            }
            return sb.toString()
        }


        /**
         * 灯具状态
         */
        fun lampStatus(status: Int?): String {
            when (status) {
                0 -> return "正常"
                1 -> return "异常"
                2 -> return "模拟异常"
                3 -> return "灯泡损坏"
                4 -> return "电压过压"
                5 -> return "电流过流"
                6 -> return "电压欠压"
                7 -> return "电流欠流"
            }
            return "未知"
        }

        /**
         * 灯具状态
         */
        fun lampOnOffStatus(status: Int?): String {
            when (status) {
                0 -> return "关灯"
                1 -> return "开灯"
                2 -> return "离线"
            }
            return "未知"
        }

        /**
         * 气象站状态
         */
        fun weatherStatus(status: Int?): String {
            when (status) {
                0 -> return "离线"
                1 -> return "正常"
                2 -> return "故障"
            }
            return "未知"
        }

        /**
         * 报警状态
         */
        fun alertBoxStatus(status: Int?): String {
            when (status) {
                0 -> return "未登入"
                1 -> return "不在线"
                2 -> return "在线"
            }
            return "未知"
        }

        /**
         * 报警布防状态
         */
        fun alertBoxRelievedStatus(status: Int?): String {
            when (status) {
                0 -> return "布防"
                1 -> return "解除布防"
            }
            return "未知"
        }


        /**
         * 充电桩状态 广告屏
         */
        fun chargingPileStatus(status: Int?): String {
            when (status) {
                0 -> return "离线"
                1 -> return "在线"
            }
            return "未知"
        }



        /**
         * 充电桩状态 广告屏
         */
        fun alertDeviceType(status: Int?): String {
            when (status) {
                18 -> return "电箱报警"
                0 -> return "线路过压"
                1 -> return "线路欠压"
                2 -> return "线路过流"
                3 -> return "柜门监测"
                30 -> return "灯杆倾斜"

                19 -> return "灯具报警"
                28 -> return "电源故障"

                20 -> return "一键报警警报"
                12 -> return "一键报警警报"

                21 -> return "监控报警"
                31 -> return "区域入侵"
                33 -> return "移动侦测"

                24 -> return "广告屏报警"
                13 -> return "广告屏高温"

                17 -> return "环境监测报警"
                34 -> return "环境高温报警"
                35 -> return "环境低温报警"
                36 -> return "pm2.5超限"
                37 -> return "噪声超限"
                32 -> return "积水限值超限"


                25 -> return "设备丢失"
                16 -> return "设备丢失"
            }
            return "未知"
        }

    }

}