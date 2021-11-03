package com.my.gank.example.tabao.utils


import  android.content.Context

/**
 * Author: mengyuan
 * Date  : 2021/11/3/3:02 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
object SizeUtils {

    fun dp2px(context: Context, dpValue: Float): Int {
        val density = context.resources.displayMetrics.density
        return (dpValue * density + 0.5f).toInt()
    }
}
