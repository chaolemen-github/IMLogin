package com.example.trianingdemo.api;

import com.example.trianingdemo.bean.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    String food_url = "http://static.owspace.com/";
    @GET("?c=api&a=getList&page_id=0")
    Observable<FoodBean> getData();
}
