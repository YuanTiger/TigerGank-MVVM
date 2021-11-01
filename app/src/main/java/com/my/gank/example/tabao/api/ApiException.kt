package com.my.gank.example.tabao.api

import java.lang.RuntimeException

/**
 * Author: mengyuan
 * Date  : 2021/11/1/6:04 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
data class ApiException(val code: Int, override val message: String?) : RuntimeException() {

}