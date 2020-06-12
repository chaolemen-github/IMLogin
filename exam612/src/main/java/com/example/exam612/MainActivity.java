package com.example.exam612;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exam612.adapter.FoodAdapter;
import com.example.exam612.bean.FoodBean;
import com.example.exam612.bean.HomeBean;
import com.example.exam612.presenter.FoodPresenter;
import com.example.exam612.view.IFoodView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IFoodView {

    private RecyclerView mRecycler;
    private List<HomeBean> data;
    private FoodAdapter foodAdapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPresenter();
    }

    private void initPresenter() {
        FoodPresenter foodPresenter = new FoodPresenter(this);
        foodPresenter.getData();
    }

    private void initView() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setTitle("列表");
        setSupportActionBar(mToolbar);

        TextView textView = (TextView) mToolbar.getChildAt(0);
        textView.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        textView.setGravity(Gravity.CENTER_HORIZONTAL);

        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));

        data = new ArrayList<>();
        foodAdapter = new FoodAdapter(this, data);
        mRecycler.setAdapter(foodAdapter);
    }

    @Override
    public void getSuccess(FoodBean foodBean) {
        List<HomeBean> datas = foodBean.getDatas();
        data.addAll(datas);
        foodAdapter.notifyDataSetChanged();
    }

    @Override
    public void getError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
