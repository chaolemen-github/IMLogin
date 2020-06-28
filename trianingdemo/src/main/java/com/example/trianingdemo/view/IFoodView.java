package com.example.trianingdemo.view;

import com.example.trianingdemo.bean.FoodBean;

public interface IFoodView {
    void getSuccess(FoodBean foodBean);
    void getError(String error);
}
