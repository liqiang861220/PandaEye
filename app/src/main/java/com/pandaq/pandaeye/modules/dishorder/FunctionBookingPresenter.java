package com.pandaq.pandaeye.modules.dishorder;

import com.pandaq.pandaeye.BasePresenter;
import com.pandaq.pandaeye.api.ApiManager;
import com.pandaq.pandaeye.modules.dishorder.beans.DishDesk;
import com.pandaq.pandaeye.modules.dishorder.beans.Floor;
import com.pandaq.pandaeye.widget.BaseRespose;
import java.util.List;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 *
 */

public class FunctionBookingPresenter extends BasePresenter implements FunctionBookingContract.Presenter {

    private FunctionBookingContract.View mFunctionBookingView;
    private String date;

    public FunctionBookingPresenter(FunctionBookingContract.View mFunctionBookingView) {
        this.mFunctionBookingView = mFunctionBookingView;
    }


    @Override
    public void getFloors(String token) {
        ApiManager.getInstence()
                .getDishOrService()
                .getFloors(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseRespose<List<Floor>>>() {
                    @Override
                    public void onComplete() {
                        mFunctionBookingView.hideRefreshBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mFunctionBookingView.hideRefreshBar();
                        mFunctionBookingView.getFloorsFail(e.getMessage());
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BaseRespose<List<Floor>> respose) {
                        mFunctionBookingView.hideRefreshBar();
                        mFunctionBookingView.setFloors(respose);
                    }

                });
    }

    @Override
    public void getFunctionBooking(String token ,int floor ) {
        ApiManager.getInstence()
                .getDishOrService()
                .getFuncitonBooking(token,floor)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseRespose<List<DishDesk>>>() {
                    @Override
                    public void onComplete() {
                        mFunctionBookingView.hideRefreshBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mFunctionBookingView.hideRefreshBar();
                        mFunctionBookingView.getFunctionBookingFail(e.getMessage());
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BaseRespose<List<DishDesk>> respose) {
                        mFunctionBookingView.hideRefreshBar();
                        mFunctionBookingView.setFunctionBooking(respose);
                    }

                });
    }
}
