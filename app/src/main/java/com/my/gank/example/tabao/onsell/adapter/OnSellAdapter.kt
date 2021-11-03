package com.my.gank.example.tabao.onsell.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.my.gank.R
import com.my.gank.example.tabao.onsell.bean.MapData

/**
 * Author: mengyuan
 * Date  : 2021/11/3/11:40 上午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
class OnSellAdapter : RecyclerView.Adapter<OnSellAdapter.ItemHolder>() {


    private val mContentList = arrayListOf<MapData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.item_on_sell, parent, false)
        return ItemHolder(inflate)
    }


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.itemView.apply {
            val tvContent = findViewById<TextView>(R.id.tv_title)
            val tvFinalPrice = findViewById<TextView>(R.id.tv_final_price)
            val ivPic = findViewById<ImageView>(R.id.iv_pic)

            with(mContentList[position]) {
                tvContent.text = title
                tvFinalPrice.text =
                    String.format("券后价：￥%.2f", zk_final_price.toFloat() - coupon_amount)
                Glide.with(context).load("https:$pict_url").into(ivPic)
            }

        }
    }


    override fun getItemCount(): Int {
        return mContentList.size
    }


    fun setData(list: List<MapData>) {
        mContentList.clear()
        mContentList.addAll(list)
        notifyDataSetChanged()
    }


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}