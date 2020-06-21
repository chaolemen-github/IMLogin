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
import com.example.imlogin.ui.activity.ITInfoActivity;
import com.example.imlogin.ui.activity.ZhihuActivity;

import org.greenrobot.eventbus.EventBus;

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

    @BindView(R.id.btn_it)
    Button btnIt;
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
//        EventBus.getDefault().postSticky("");
        return rootView;
    }

    @OnClick({R.id.btn_zhihu, R.id.btn_it})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_zhihu:
                startActivity(new Intent(getActivity(), ZhihuActivity.class));
                break;
            case R.id.btn_it:
                startActivity(new Intent(getActivity(), ITInfoActivity.class));
                break;
        }
    }
}
