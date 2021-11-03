package com.my.gank.example.tabao.onsell

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.my.gank.R
import com.my.gank.databinding.ActivityOnSellBinding
import com.my.gank.example.tabao.onsell.adapter.OnSellAdapter

/**
 * Author: mengyuan
 * Date  : 2021/11/1/5:47 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
class OnSellActivity : AppCompatActivity() {


    private lateinit var viewBinding: ActivityOnSellBinding
    private lateinit var onSellAdapter: OnSellAdapter


    private val viewModel by lazy {
        ViewModelProvider(this).get(OnSellViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this@OnSellActivity, R.layout.activity_on_sell)

        initView()
        initObserver()
    }


    private fun initView() {
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(this@OnSellActivity)
        onSellAdapter = OnSellAdapter()
        viewBinding.recyclerView.adapter = onSellAdapter

    }


    private fun initObserver() {
        viewModel.apply {
            contentList.observe(this@OnSellActivity, Observer {
                //内容列表更新
                //更新适配器
                onSellAdapter.setData(it)
            })
        }.loadContent()

    }


}