package com.example.imlogin.callback;


import com.example.imlogin.base.BaseCallBack;
import com.example.imlogin.base.BaseView;
import com.example.imlogin.bean.DailyBean;

public interface DailyNewsCallBack extends BaseCallBack<DailyBean> {
    @Override
    void getSuccess(DailyBean dailyBean);

    @Override
    void getError(String error);
}
