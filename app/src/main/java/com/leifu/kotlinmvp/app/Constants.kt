package com.lsky.ener.app

/**
 *常量配置
 */
object Constants {

    //  const val BASE_URL = "http://119.3.49.76:8760/"//正式环境
    const val BASE_URL = "http://192.168.30.16:8760/"//测试环境
    //const val BASE_URL = "http://192.168.20.47:9527/"
    // const val BASE_URL = "http://192.168.20.95:8098"//邵启月

    const val aliYunAppkey = "EA2Mrd5X2wZ7bDBU"//landsky徐福临阿里云账号ener项目

    //------------- SharedPreferences  ----------------------------------------------------------------------------------
//    const val SP_HEAD = "user_holder"//登录后请求头的信息
    const val SP_TOKEN = "sp_token"//登录后请求头的信息
    const val SP_USER_ID = "user_id"//头里面的id
    const val SP_USER_NAME = "user_name"//用户名
    const val SP_USER_PHONE = "user_phone"//用户手机号
    const val SP_PROJECT_ID = "project_id"//orgId下面分[projectId项目,areaId区域]
    const val SP_PROJECT_NAME = "project_name"//orgId下面分[projectId项目,areaId区域]

    const val SP_ALIYUN_TOKEN = "aliyun_token"//orgId下面分[projectId项目,areaId区域]
    const val SP_ALIYUN_TOKEN_EXPIRETIME = "aliyun_token_expireTime"//orgId下面分[projectId项目,areaId区域]

    //------------------园区
    const val SP_PARK_INDEX_CODE = "sp_park_index_code"//园区停车场的parkSyscode
    const val SP_PARK_NAME = "sp_park_name"//园区停车场名字

    //-------------- EventBus  ------------------------------------------------------------------------------------------
    const val EVENT_FLAG_1 = 1//删除告警后回到告警页面刷新
    const val EVENT_FLAG_2 = 2//地图搜索后返回地图页面
    const val EVENT_FLAG_3 = 3//选择项目后名字更改
    const val EVENT_FLAG_4 = 4//事件中心筛选后,列表刷新

    //-------------- intent  ---------------------------------------------------------------------------------------------
    const val INTENT_AREA_ID = "area_id"//项目下面的区域id
    const val INTENT_DEVICE_TYPE = "device_type"//设备类型(广告屏,灯具..)

    const val INTENT_ALERT_DEVICE_TYPE = "alert_device_type"//告警设备列表
    const val INTENT_ALERT_IS_HISTORY = "alert_is_history"//告警设备列表
    const val INTENT_ALERT_IDS = "alert_ids"//告警设备id数组
    const val INTENT_PATCH_CONTROL = "patch_control"//批量控制(判断是灯杆,灯具还是广告屏)
    const val INTENT_PATCH_CONTROL_IDS = "patch_control_ids"//批量控制跳转到详情传的ids[]
    const val INTENT_SEARCH_CONTENT = "search_content"//设备搜索

    const val INTENT_LAMPPOLE_BEAN = "lamppole_bean"//灯杆实体类
    const val INTENT_LAMP_BEAN = "lamp_bean"//灯具实体类
    const val INTENT_WEATHER_BEAN = "weather_bean"//气象站实体类
    const val INTENT_ALERTBOX_BEAN = "alertbox_bean"//气象站实体类
    const val INTENT_WATER_BEAN = "water_bean"//积水实体类
    const val INTENT_CHARGINGPIL_BEAN = "chargingpil_bean"//充电桩
    const val INTENT_ADSCREEN_BEAN = "adscreen_bean"//广告屏
    const val INTENT_CAMERA_BEAN = "camera_bean"//摄像头
    const val INTENT_COLUMN_BEAN = "column_bean"//摄像头
    const val INTENT_ALERT_LIST_BEAN = "alert_list_bean"//告警设备列表
}