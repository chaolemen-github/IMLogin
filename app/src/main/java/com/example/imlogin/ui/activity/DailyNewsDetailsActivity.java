package com.example.imlogin.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.imlogin.R;
import com.example.imlogin.api.ApiService;
import com.example.imlogin.api.BaseObserver;
import com.example.imlogin.base.BaseActivity;
import com.example.imlogin.bean.DailyNewsDetailsBean;
import com.example.imlogin.utils.HttpManager;
import com.example.imlogin.utils.RxUtil;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyNewsDetailsActivity extends BaseActivity {


    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.t_toolbar)
    Toolbar tToolbar;
    @BindView(R.id.ctl)
    CollapsingToolbarLayout ctl;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.html_text)
    HtmlTextView htmlText;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.cdl)
    CoordinatorLayout cdl;
    private int id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_daily_news_details;
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intent = getIntent();
        String img = intent.getStringExtra("img");
        String title = intent.getStringExtra("title");
        id = intent.getIntExtra("id", 0);

        ctl.setTitle(title);
        Glide.with(this).load(img).into(ivImg);
        ctl.setExpandedTitleColor(Color.RED);
        ctl.setCollapsedTitleTextColor(Color.WHITE);

    }

    @Override
    protected void initData() {
        super.initData();
        HttpManager.getHttpManager().getApiService(ApiService.baseZhiUrl,ApiService.class)
                .getDailyNewsDetailsData(id)
                .compose(RxUtil.rxFlowableTransformer())
                .subscribeWith(new BaseObserver<DailyNewsDetailsBean>() {
                    @Override
                    protected void onSuccess(DailyNewsDetailsBean dailyNewsDetailsBean) {
                        if (dailyNewsDetailsBean!=null){
                            String body = dailyNewsDetailsBean.getBody();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    htmlText.setHtml(body,new HtmlHttpImageGetter(htmlText));
                                }
                            });
                        } else {
                            Toast.makeText(DailyNewsDetailsActivity.this, "空数据", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
