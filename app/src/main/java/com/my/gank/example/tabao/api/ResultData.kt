package com.my.gank.example.tabao.api

/**
 * Author: mengyuan
 * Date  : 2021/11/1/6:02 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
data class ResultData<T>(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: T
) {

    companion object {
        const val CODE_SUCCESS = 10000
    }


    fun apiData(): T {
        if (code == CODE_SUCCESS) {
            return data
        } else {
            throw ApiException(code, message)
        }
    }

}