package com.example.imlogin.presenter;

import com.example.imlogin.base.BaseModel;
import com.example.imlogin.base.BasePresenter;
import com.example.imlogin.base.BaseView;
import com.example.imlogin.bean.NaviBean;
import com.example.imlogin.callback.NaviCallBack;
import com.example.imlogin.model.NaviModel;

public class NaviPresenter extends BasePresenter implements NaviCallBack {

    private NaviModel naviModel;

    @Override
    protected void initModel() {
        naviModel = new NaviModel();
        addModel(naviModel);
    }

    public void getNaviData() {
        naviModel.getNaviData(this);
    }

    @Override
    public void getSuccess(NaviBean naviBean) {
        baseView.onSuccess(naviBean);
    }

    @Override
    public void getError(String error) {
        baseView.onFail(error);
    }
}
