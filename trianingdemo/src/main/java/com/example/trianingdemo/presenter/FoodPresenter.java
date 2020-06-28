package com.example.trianingdemo.presenter;

import com.example.trianingdemo.bean.FoodBean;
import com.example.trianingdemo.callback.IFoodCallBack;
import com.example.trianingdemo.model.FoodModel;
import com.example.trianingdemo.view.IFoodView;

public class FoodPresenter {

    private final FoodModel foodModel;
    private IFoodView iFoodView;

    public FoodPresenter(IFoodView iFoodView) {
        this.iFoodView = iFoodView;
        foodModel = new FoodModel();
    }

    public void getData() {
        foodModel.getData(new IFoodCallBack() {
            @Override
            public void getSuccess(FoodBean foodBean) {
                iFoodView.getSuccess(foodBean);
            }

            @Override
            public void getError(String error) {
                iFoodView.getError(error);
            }
        });
    }
}
