package com.my.gank.test.databinding.three;

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
public class ImageViewBindingAdapter {


    @BindingAdapter("dataBindingImageTest")
    public static void setImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.getContext()).load(url).placeholder(R.mipmap.ic_data_binding_2).into(imageView);
        } else {
            imageView.setBackgroundColor(Color.GRAY);
        }
    }

    @BindingAdapter("dataBindingImageTest2")
    public static void setImage(ImageView imageView, int resource) {
        Glide.with(imageView.getContext()).load(resource).placeholder(R.mipmap.ic_data_binding_2).into(imageView);
    }


    @BindingAdapter(value = {"dataBindingImageTest", "dataBindingImageTest2"}, requireAll = false)
    public static void setImage(ImageView imageView, String url,int resource ) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.getContext()).load(url).placeholder(R.mipmap.ic_data_binding_2).into(imageView);
        } else if (resource > 0) {
            Glide.with(imageView.getContext()).load(resource).placeholder(R.mipmap.ic_data_binding_2).into(imageView);
        } else {
            imageView.setBackgroundColor(Color.GRAY);
        }
    }
}
