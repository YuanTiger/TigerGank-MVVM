package com.my.gank.test.databinding.six;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.my.gank.R;

/**
 * Author: mengyuan
 * Date  : 2021/10/13/4:52 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class ImageViewBindingAdapter_6 {


    @BindingAdapter("dataBindingImageTest")
    public static void setImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.getContext()).load(url).placeholder(R.mipmap.ic_data_binding_2).into(imageView);
        } else {
            imageView.setBackgroundColor(Color.GRAY);
        }
    }


}
