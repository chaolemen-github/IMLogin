package com.example.trianingdemo.base;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.trianingdemo.model.FoodModel;
import com.example.trianingdemo.presenter.FoodPresenter;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();
        initPresenter();
    }

    protected void initPresenter() {

    }

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView(){};

    protected abstract int getLayoutId();
}
