package com.example.angao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.angao.R;
import com.example.angao.bean.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    List<HomeBean.DataBean.DatasBean> list;

    public HomeAdapter(Context context, List<HomeBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_home_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        HomeBean.DataBean.DatasBean datasBean = list.get(i);
        viewHolder.tvHomeTitle.setText(datasBean.getTitle());
        viewHolder.tvHomeText.setText(datasBean.getSuperChapterName());
        Glide.with(context).load(datasBean.getEnvelopePic()).into(viewHolder.ivHomeImg);

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onClickHomeListener!=null){
                    onClickHomeListener.onClick(i);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_home_img)
        ImageView ivHomeImg;
        @BindView(R.id.tv_home_title)
        TextView tvHomeTitle;
        @BindView(R.id.tv_home_text)
        TextView tvHomeText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    OnClickHomeListener onClickHomeListener;

    public void setOnClickHomeListener(OnClickHomeListener onClickHomeListener) {
        this.onClickHomeListener = onClickHomeListener;
    }

    public interface OnClickHomeListener{
        void onClick(int pose);
    }

}
