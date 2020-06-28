package com.example.trianingdemo;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trianingdemo.adapter.FoodAdapter;
import com.example.trianingdemo.base.BaseActivity;
import com.example.trianingdemo.bean.FoodBean;
import com.example.trianingdemo.bean.HomeBean;
import com.example.trianingdemo.presenter.FoodPresenter;
import com.example.trianingdemo.view.IFoodView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IFoodView {
    private static final String TAG = "MainActivity";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<HomeBean> list;
    private FoodAdapter foodAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();

        toolbar.setTitle("列表");
        setSupportActionBar(toolbar);


        TextView text = (TextView) toolbar.getChildAt(0);
        text.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        text.setGravity(Gravity.CENTER_HORIZONTAL);

        recycler.setLayoutManager(new LinearLayoutManager(this));
//        recycler.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));

        list = new ArrayList<>();
        foodAdapter = new FoodAdapter(this, list);
        recycler.setAdapter(foodAdapter);
    }

    @Override
    protected void initPresenter() {
        super.initPresenter();
        FoodPresenter foodPresenter = new FoodPresenter(this);
        foodPresenter.getData();
    }

    @Override
    public void getSuccess(FoodBean foodBean) {
        List<FoodBean.DatasBean> datas = foodBean.getDatas();
        List<HomeBean> homeBeans = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            FoodBean.DatasBean datasBean = datas.get(i);
            String id = datasBean.getId();
            long aLong = Long.parseLong(id);
            HomeBean homeBean = new HomeBean(aLong, datasBean.getThumbnail()
                    , datasBean.getTitle()
                    , datasBean.getAuthor()
                    , true);
            homeBeans.add(homeBean);
        }

        list.addAll(homeBeans);
        foodAdapter.notifyDataSetChanged();

    }

    @Override
    public void getError(String error) {
        Log.e(TAG, "getError: "+error );
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
