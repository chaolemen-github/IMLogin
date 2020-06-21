package com.example.imlogin.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.imlogin.R;
import com.example.imlogin.adapter.NaviAdapter;
import com.example.imlogin.base.BaseMvpActivity;
import com.example.imlogin.bean.NaviBean;
import com.example.imlogin.presenter.NaviPresenter;
import com.example.imlogin.view.NaviView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import qdx.stickyheaderdecoration.NormalDecoration;

public class NaviActivity extends BaseMvpActivity<NaviPresenter, NaviView> implements NaviView {


    @BindView(R.id.recycler_navi)
    RecyclerView recyclerNavi;
    private List<NaviBean.DataBean> list;
    private NaviAdapter adapter;

    @Override
    protected NaviView initMvpView() {
        return this;
    }

    @Override
    protected NaviPresenter initMvpPresenter() {
        return new NaviPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_navi;
    }

    @Override
    protected void initView() {
        super.initView();
        recyclerNavi.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new NaviAdapter(this, list);

        NormalDecoration normalDecoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return list.get(i).getName();
            }
        };
        recyclerNavi.addItemDecoration(normalDecoration);
        recyclerNavi.setAdapter(adapter);

    }

    @Override
    public void onSuccess(NaviBean naviBean) {
        List<NaviBean.DataBean> data = naviBean.getData();
        list.addAll(data);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onFail(String error) {

    }


}
