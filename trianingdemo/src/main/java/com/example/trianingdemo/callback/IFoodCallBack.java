package com.example.trianingdemo.callback;

import com.example.trianingdemo.bean.FoodBean;

public interface IFoodCallBack {
    void getSuccess(FoodBean foodBean);
    void getError(String error);
}
