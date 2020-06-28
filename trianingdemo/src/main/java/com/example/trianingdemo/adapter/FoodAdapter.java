package com.example.trianingdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.trianingdemo.R;
import com.example.trianingdemo.bean.HomeBean;
import com.example.trianingdemo.utile.DBHolper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    Context context;
    List<HomeBean> list;

    public FoodAdapter(Context context, List<HomeBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_main_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final HomeBean homeBean = list.get(i);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();

        Glide.with(context).load(homeBean.getImg()).apply(requestOptions).into(viewHolder.ivFoodImg);
        viewHolder.tvFoodTitle.setText(homeBean.getTitle());
        viewHolder.tvFoodName.setText(homeBean.getName());

        viewHolder.btnFoodAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String atten = viewHolder.btnFoodAttention.getText().toString();
                if (atten.equals("关注")){
                    viewHolder.btnFoodAttention.setText("取消");
                    DBHolper.getInstance().insert(homeBean);
                } else {
                    viewHolder.btnFoodAttention.setText("关注");
                    DBHolper.getInstance().delete(homeBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_food_img)
        ImageView ivFoodImg;
        @BindView(R.id.tv_food_title)
        TextView tvFoodTitle;
        @BindView(R.id.tv_food_name)
        TextView tvFoodName;
        @BindView(R.id.btn_food_attention)
        Button btnFoodAttention;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
