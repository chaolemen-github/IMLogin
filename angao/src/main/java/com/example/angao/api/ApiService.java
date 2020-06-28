package com.example.angao.api;

import com.example.angao.bean.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String home_url = "https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<HomeBean> getData();
}
