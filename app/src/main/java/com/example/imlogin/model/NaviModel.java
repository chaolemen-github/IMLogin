package com.example.imlogin.model;

import com.example.imlogin.api.ApiService;
import com.example.imlogin.api.BaseObserver;
import com.example.imlogin.base.BaseModel;
import com.example.imlogin.bean.NaviBean;
import com.example.imlogin.callback.NaviCallBack;
import com.example.imlogin.utils.HttpManager;
import com.example.imlogin.utils.RxUtil;

public class NaviModel extends BaseModel {
    public void getNaviData(NaviCallBack naviCallBack){
        HttpManager.getHttpManager()
                .getApiService(ApiService.naviUrl,ApiService.class)
                .getNaviData()
                .compose(RxUtil.rxFlowableTransformer())
                .subscribe(new BaseObserver<NaviBean>() {
                    @Override
                    protected void onSuccess(NaviBean naviBean) {
                        if (naviBean!=null){
                            naviCallBack.getSuccess(naviBean);
                        } else {
                            naviCallBack.getError("空数据");
                        }
                    }
                });
    }
}
