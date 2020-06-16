package com.example.imlogin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.imlogin.R;
import com.example.imlogin.bean.SpecialBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.ViewHolder> {

    Context context;
    List<SpecialBean.DataBean> list;

    public SpecialAdapter(Context context, List<SpecialBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_special, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SpecialBean.DataBean dataBean = list.get(i);
        Glide.with(context).load(dataBean.getThumbnail()).into(viewHolder.ivSpecial);
        viewHolder.tvSpecial.setText(dataBean.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_special)
        ImageView ivSpecial;
        @BindView(R.id.tv_special)
        TextView tvSpecial;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
