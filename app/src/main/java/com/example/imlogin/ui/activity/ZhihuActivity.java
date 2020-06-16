package com.example.imlogin.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.imlogin.R;
import com.example.imlogin.base.BaseActivity;
import com.example.imlogin.ui.fragments.DailyNewsFragment;
import com.example.imlogin.ui.fragments.HotFragment;
import com.example.imlogin.ui.fragments.SpecilFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhihuActivity extends BaseActivity {

    @BindView(R.id.tabLayout_zhihu)
    TabLayout tabLayoutZhihu;
    @BindView(R.id.viewPager_zhihu)
    ViewPager viewPagerZhihu;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhihu;
    }

    @Override
    protected void initView() {
        super.initView();
        fragments = new ArrayList<>();

        fragments.add(new DailyNewsFragment());
        fragments.add(new SpecilFragment());
        fragments.add(new HotFragment());
        titles = new ArrayList<>();
        titles.add("日报");
        titles.add("专栏");
        titles.add("热门");

        viewPagerZhihu.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });

        tabLayoutZhihu.setupWithViewPager(viewPagerZhihu);
    }

}
