package com.example.imlogin.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.imlogin.R;
import com.example.imlogin.base.BaseFragment;
import com.example.imlogin.ui.activity.ZhihuActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryFragment extends BaseFragment {


    @BindView(R.id.btn_zhihu)
    Button btnZhihu;
    Unbinder unbinder;

    public DiscoveryFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discovery;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_zhihu)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), ZhihuActivity.class));
    }
}
