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
import com.example.imlogin.bean.DailyBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyAdapter extends RecyclerView.Adapter {
    private Context context;

    private List<DailyBean.StoriesBean> list;
    private List<DailyBean.TopStoriesBean> banners;

    private int ITEM_VIEW_TYPE_ONE = 1;
    private int ITEM_VIEW_TYPE_TWO = 2;
    private int ITEM_VIEW_TYPE_THREE = 3;
    private final LayoutInflater inflater;
    private int newPosition;

    public DailyAdapter(Context context, List<DailyBean.StoriesBean> list, List<DailyBean.TopStoriesBean> banners) {
        this.context = context;
        this.list = list;
        this.banners = banners;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == ITEM_VIEW_TYPE_ONE) {
            View view = inflater.inflate(R.layout.item_daily_news_banner, parent, false);
            return new ViewHolderBanner(view);
        } else if (viewType == ITEM_VIEW_TYPE_TWO) {
            View view = inflater.inflate(R.layout.item_daily_title, parent, false);
            return new ViewHolderTitle(view);
        } else {
            View view = inflater.inflate(R.layout.item_daily_news, parent, false);
            return new ViewHolderList(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        if (viewType == ITEM_VIEW_TYPE_ONE) {
            ArrayList<String> images = new ArrayList<>();
            for (DailyBean.TopStoriesBean banner : banners) {
                images.add(banner.getImage());
            }
            ViewHolderBanner holderBanner = (ViewHolderBanner) holder;
            holderBanner.banner.setImages(images)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context).load(path).into(imageView);
                        }
                    })
                    .start();
        } else if (viewType == ITEM_VIEW_TYPE_TWO) {

        } else if (viewType == ITEM_VIEW_TYPE_THREE) {
            newPosition = position;
            if (banners != null && banners.size() >= 0) {
                newPosition = position - 2;
            } else {
                newPosition = position - 1;
            }

            ViewHolderList viewHolderList = (ViewHolderList) holder;
            DailyBean.StoriesBean storiesBean = list.get(newPosition);
            viewHolderList.tvTitle.setText(storiesBean.getTitle());
            Glide.with(context).load(storiesBean.getImages().get(0)).into(viewHolderList.ivDaily);


        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCilckListenerDaily!=null){
                    onCilckListenerDaily.onClick(newPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size() + 1 + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_VIEW_TYPE_ONE;
        } else if (position == 1) {
            return ITEM_VIEW_TYPE_TWO;
        } else {
            return ITEM_VIEW_TYPE_THREE;
        }
    }

    class ViewHolderBanner extends RecyclerView.ViewHolder {

        @BindView(R.id.banner)
        Banner banner;

        ViewHolderBanner(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    class ViewHolderTitle extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHolderTitle(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ViewHolderList extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_daily)
        ImageView ivDaily;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHolderList(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    OnCilckListenerDaily onCilckListenerDaily;

    public void setOnCilckListenerDaily(OnCilckListenerDaily onCilckListenerDaily) {
        this.onCilckListenerDaily = onCilckListenerDaily;
    }

    public interface OnCilckListenerDaily {
        void onClick(int post);
    }
}
