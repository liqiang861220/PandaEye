package com.pandaq.pandaeye.modules.dishorder;

import com.pandaq.pandaeye.BasePresenter;
import com.pandaq.pandaeye.api.ApiManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by PandaQ on 2016/9/13.
 * email : 767807368@qq.com
 */
public class DishOrderPresenter extends BasePresenter implements DishOrderContract.Presenter {

    private DishOrderContract.View mDishOrderFrag;
    private String date;

    public DishOrderPresenter(DishOrderContract.View mDishOrderFrag) {
        this.mDishOrderFrag = mDishOrderFrag;
    }


    @Override
    public void userLogin(String userName,String password) {
        mDishOrderFrag.showRefreshBar();
        ApiManager.getInstence()
                .getDishOrService()
                .login(userName,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginUser>() {
                    @Override
                    public void onComplete() {
                        mDishOrderFrag.hideRefreshBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mDishOrderFrag.hideRefreshBar();
                        mDishOrderFrag.loginFail(e.getMessage());
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LoginUser mLoginUser) {
                        mDishOrderFrag.hideRefreshBar();
                        mDishOrderFrag.loginSuccessed(mLoginUser);
                    }
                });
    }


}
