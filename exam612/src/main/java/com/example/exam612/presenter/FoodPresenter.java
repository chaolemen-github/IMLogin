package com.example.exam612.presenter;

import com.example.exam612.bean.FoodBean;
import com.example.exam612.callback.IFoodCallBack;
import com.example.exam612.model.FoodModel;
import com.example.exam612.view.IFoodView;

public class FoodPresenter {
    private final FoodModel foodModel;
    private IFoodView view;

    public FoodPresenter(IFoodView view) {
        this.view = view;
        foodModel = new FoodModel();
    }

    public void getData(){
        foodModel.getData(new IFoodCallBack() {
            @Override
            public void getSuccess(FoodBean foodBean) {
                view.getSuccess(foodBean);
            }

            @Override
            public void getError(String error) {
                view.getError(error);
            }
        });
    }
}
