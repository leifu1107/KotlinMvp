package com.lsky.ener.model.net.response

/**
 * 封装返回的数据
 *
 */
class BaseResponseBean<T>(
    val code: Int,
    val msg: String,
    val data: T
)