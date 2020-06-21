package com.example.imlogin.view;

import com.example.imlogin.base.BaseView;
import com.example.imlogin.bean.NaviBean;

public interface NaviView extends BaseView<NaviBean> {
    @Override
    void onSuccess(NaviBean naviBean);

    @Override
    void onFail(String error);
}
