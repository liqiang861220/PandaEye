package com.pandaq.pandaeye.modules.dishorder;

import com.pandaq.pandaeye.BasePresenter;
import com.pandaq.pandaeye.api.ApiManager;
import com.pandaq.pandaeye.modules.dishorder.beans.FunctionModule;
import com.pandaq.pandaeye.widget.BaseRespose;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 *
 */

public class FunctionModulePresenter extends BasePresenter implements FunctionModuleContract.Presenter {

    private FunctionModuleContract.View mDishOrderFrag;
    private String date;

    public FunctionModulePresenter(FunctionModuleContract.View mDishOrderFrag) {
        this.mDishOrderFrag = mDishOrderFrag;
    }


    @Override
    public void getDishFunctionModule(String token) {
        mDishOrderFrag.showRefreshBar();
        ApiManager.getInstence()
                .getDishOrService()
                .getFuncitonModule(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseRespose<List<FunctionModule>>>() {
                    @Override
                    public void onComplete() {
                        mDishOrderFrag.hideRefreshBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mDishOrderFrag.hideRefreshBar();
                        mDishOrderFrag.getFunctionModuleFail(e.getMessage());
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BaseRespose<List<FunctionModule>> respose) {
                        mDishOrderFrag.hideRefreshBar();
                        mDishOrderFrag.setDishFunctionModule(respose);
                    }

                });
    }
}
