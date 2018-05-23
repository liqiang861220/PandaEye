package com.pandaq.pandaeye.modules.dishorder;

import com.pandaq.pandaeye.modules.dishorder.beans.DishDesk;
import com.pandaq.pandaeye.widget.BaseRespose;

import java.util.List;

/**
 * Created by PandaQ on 2017/4/12.
 * 767807368@qq.com
 */

public interface FunctionBookingContract {
    interface View {
        void showRefreshBar();

        void hideRefreshBar();


        void setFunctionBooking(BaseRespose<List<DishDesk>> respose);

        void getFunctionBookingFail(String errMsg);


    }

    interface Presenter {
        void getFunctionBooking(String token);
    }
}
