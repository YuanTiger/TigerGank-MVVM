package com.my.gank.example.tabao.onsell.bean

/**
 * Author: mengyuan
 * Date  : 2021/11/1/6:06 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
 data class OnSellData(
    val tbk_dg_optimus_material_response: TbkDgOptimusMaterialResponse
)

data class TbkDgOptimusMaterialResponse(
    val is_default: String,
    val request_id: String,
    val result_list: ResultList
)

data class ResultList(
    val map_data: List<MapData>
)

data class MapData(
    val category_id: Int,
    val category_name: Any,
    val click_url: String,
    val commission_rate: String,
    val coupon_amount: Int,
    val coupon_click_url: String,
    val coupon_end_time: String,
    val coupon_info: Any,
    val coupon_remain_count: Int,
    val coupon_share_url: String,
    val coupon_start_fee: String,
    val coupon_start_time: String,
    val coupon_total_count: Int,
    val item_description: String,
    val item_id: Long,
    val level_one_category_id: Int,
    val level_one_category_name: String,
    val nick: String,
    val pict_url: String,
    val seller_id: Long,
    val shop_title: Any,
    val small_images: SmallImages,
    val title: String,
    val user_type: Int,
    val volume: Int,
    val zk_final_price: String
)

data class SmallImages(
    val string: List<String>
)