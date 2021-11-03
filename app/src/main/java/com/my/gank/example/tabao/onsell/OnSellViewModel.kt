package com.my.gank.example.tabao.onsell

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.gank.example.tabao.onsell.bean.MapData
import kotlinx.coroutines.launch

/**
 * Author: mengyuan
 * Date  : 2021/11/1/5:47 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
class OnSellViewModel : ViewModel() {

    val contentList = MutableLiveData<List<MapData>>()

    companion object {
        const val DEFAULT_PAGE = 1
    }

    private var mCurrentPage = DEFAULT_PAGE

    //懒加载
    private val onSellRepository by lazy {
        OnSellRepository()
    }


    /**
     * 加载首页内容
     */
    fun loadContent() {
        this.listContentByPage(mCurrentPage)

    }

    /**
     * 加载更多内容
     */
    fun loadMore() {

    }

    private fun listContentByPage(page: Int) {
        viewModelScope.launch {
            val onSellList = onSellRepository.getOnSellList(page)
            contentList.value = onSellList.tbk_dg_optimus_material_response.result_list.map_data
        }
    }


}