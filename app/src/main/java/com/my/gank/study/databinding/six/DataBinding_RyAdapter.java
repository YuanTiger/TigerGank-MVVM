package com.my.gank.study.databinding.six;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.my.gank.R;
import com.my.gank.databinding.ItemDataBinding6Binding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Author: mengyuan
 * Date  : 2021/10/14/2:32 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class DataBinding_RyAdapter extends RecyclerView.Adapter<DataBinding_RyAdapter.MyViewHolder> {


    private List<DataBinding_IdolBean_6> idolList;


    public void setIdolList(List<DataBinding_IdolBean_6> idolList) {
        this.idolList = idolList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemDataBinding6Binding viewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_data_binding_6, parent, false);
        return new MyViewHolder(viewBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.binding.setIdol(idolList.get(position));
    }


    @Override
    public int getItemCount() {
        return idolList == null ? 0 : idolList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ItemDataBinding6Binding binding;

        public MyViewHolder(ItemDataBinding6Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
