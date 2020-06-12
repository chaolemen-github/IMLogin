package com.example.exam612.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.exam612.R;
import com.example.exam612.bean.FoodBean;
import com.example.exam612.bean.HomeBean;
import com.example.exam612.utile.DBHolper;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    Context context;
    List<HomeBean> data;


    public FoodAdapter(Context context, List<HomeBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_main_item, viewGroup, false);
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final HomeBean datasBean = data.get(i);

        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(context).load(datasBean.getThumbnail()).apply(requestOptions).into(viewHolder.mImgFood);
        viewHolder.mTitleFood.setText(datasBean.getTitle());
        viewHolder.mNameFood.setText(datasBean.getAuthor());

        viewHolder.mBtnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHolper.getInstance().insert(datasBean);
//                Toast.makeText(context, "111", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView mImgFood;
         TextView mTitleFood;
         TextView mNameFood;
         Button mBtnFood;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImgFood = (ImageView) itemView.findViewById(R.id.food_img);
            mTitleFood = (TextView) itemView.findViewById(R.id.food_title);
            mNameFood = (TextView) itemView.findViewById(R.id.food_name);
            mBtnFood = (Button) itemView.findViewById(R.id.food_btn);

        }
    }
}
