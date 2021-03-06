package com.example.imlogin.base;

public abstract class BaseMvpActivity<P extends BasePresenter, V extends BaseView> extends BaseActivity {

    protected P mPresenter;

    @Override
    protected void initMvp() {
        super.initMvp();
        mPresenter = initMvpPresenter();
        if (mPresenter!=null){
            mPresenter.setBaseView(initMvpView());
        }
    }

    protected abstract V initMvpView();

    protected abstract P initMvpPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
