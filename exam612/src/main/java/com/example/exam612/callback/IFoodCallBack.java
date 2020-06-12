package com.example.exam612.callback;

import com.example.exam612.bean.FoodBean;

public interface IFoodCallBack {
    void getSuccess(FoodBean foodBean);
    void getError(String error);
}
