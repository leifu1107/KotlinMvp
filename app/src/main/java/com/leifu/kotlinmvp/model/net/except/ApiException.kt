package com.lsky.ener.model.net.except

/**
 *创建人:雷富
 *创建时间:2019/6/5 17:05
 *描述:
 */
class ApiException(var success: Boolean?, var msg: String?) : Exception()