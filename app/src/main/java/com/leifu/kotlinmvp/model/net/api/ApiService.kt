package com.lsky.ener.model.net.api

import com.lsky.ener.model.net.response.BaseBean
import io.reactivex.Flowable
import okhttp3.ResponseBody
import retrofit2.http.*
import java.util.*

/**
 *创建人:雷富
 *创建时间:2019/6/5 17:16
 *描述:
 */
interface ApiService {



    /**
     * 道闸历史列表
     * @param map
     * @return
     */
    @GET("park/park/passRecords")
    fun getParkHistoryList(@QueryMap map: HashMap<String, String>): Flowable<BaseBean>

    /**
     * 事件中心
     * @param map
     * @return
     */
    @POST("common/eventInfo/list")
    @FormUrlEncoded
    fun getEventCenterList(@FieldMap map: HashMap<String, Any>): Flowable<BaseBean>


}