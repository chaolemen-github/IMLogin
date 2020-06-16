package com.example.imlogin.callback;


import com.example.imlogin.base.BaseView;
import com.example.imlogin.bean.DailyBean;

public interface DailyNewsCallBack extends BaseView<DailyBean> {

    void onSuccess(DailyBean dailyBean);

    void onFail(String error);
}
