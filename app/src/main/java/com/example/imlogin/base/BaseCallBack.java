package com.example.imlogin.base;

public interface BaseCallBack<T> {
    void getSuccess(T t);
    void getError(String error);
}
