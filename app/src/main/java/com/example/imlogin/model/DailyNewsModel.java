package com.example.imlogin.model;

import com.example.imlogin.api.ApiService;
import com.example.imlogin.api.BaseObserver;
import com.example.imlogin.base.BaseModel;
import com.example.imlogin.bean.DailyBean;
import com.example.imlogin.callback.DailyNewsCallBack;
import com.example.imlogin.utils.HttpManager;
import com.example.imlogin.utils.RxUtil;

public class DailyNewsModel extends BaseModel {
    public void getDailyData(DailyNewsCallBack callBack) {
//        HttpManager.getHttpManager().getApiService(ApiService.baseZhiUrl, ApiService.class)
//                .getDailyData()
//                .compose(RxUtil.rxFlowableTransformer())
//                .subscribeWith(new BaseObserver<>());
    }
}
