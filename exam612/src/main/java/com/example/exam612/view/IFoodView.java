package com.example.exam612.view;

import com.example.exam612.bean.FoodBean;

public interface IFoodView {
    void getSuccess(FoodBean foodBean);
    void getError(String error);
}
