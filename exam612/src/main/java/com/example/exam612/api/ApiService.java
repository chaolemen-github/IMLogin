package com.example.exam612.api;

import com.example.exam612.bean.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String food_url = "http://static.owspace.com/";
    @GET("?c=api&a=getList&page_id=0")
    Observable<FoodBean> getFoodData();
}
