package com.pandaq.pandaeye.modules.dishorder;

import com.pandaq.pandaeye.BasePresenter;
import com.pandaq.pandaeye.api.ApiManager;
import com.pandaq.pandaeye.modules.dishorder.beans.GroupsAndFoods;
import com.pandaq.pandaeye.widget.BaseRespose;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by PandaQ on 2016/9/13.
 * email : 767807368@qq.com
 */
public class CreateOrderPresenter extends BasePresenter implements CreateOrderContract.Presenter {

    private CreateOrderContract.View mCreateOrderFrag;
    private String date;

    public CreateOrderPresenter(CreateOrderContract.View mDishOrderFrag) {
        this.mCreateOrderFrag = mDishOrderFrag;
    }


    @Override
    public void getFoods(String token) {
        mCreateOrderFrag.showRefreshBar();
        ApiManager.getInstence()
                .getDishOrService()
                .getFoods(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseRespose<GroupsAndFoods>>() {
                    @Override
                    public void onComplete() {
                        mCreateOrderFrag.hideRefreshBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mCreateOrderFrag.hideRefreshBar();
                        mCreateOrderFrag.getFoodsFail(e.getMessage());
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BaseRespose<GroupsAndFoods> respose) {
                        mCreateOrderFrag.hideRefreshBar();
                        mCreateOrderFrag.getFoodsSuccessed(respose);
                    }

                });
    }
}
