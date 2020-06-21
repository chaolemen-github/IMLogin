package com.example.imlogin.callback;

import com.example.imlogin.base.BaseCallBack;
import com.example.imlogin.bean.NaviBean;

public interface NaviCallBack extends BaseCallBack<NaviBean> {
    @Override
    void getSuccess(NaviBean naviBean);

    @Override
    void getError(String error);
}
