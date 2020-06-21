package com.example.imlogin.base;

import java.util.ArrayList;

public abstract class BasePresenter {

    protected BaseView baseView;
    ArrayList<BaseModel> models = new ArrayList<>();

    public void setBaseView(BaseView baseView) {
        this.baseView = baseView;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    protected void addModel(BaseModel model){
        models.add(model);
    }

    protected void onDestroy(){
        baseView=null;
        if (models.size()>0){
            for (BaseModel model : models) {
                model.onDestroy();
            }
            models.clear();
        }
    }

}
