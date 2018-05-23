package com.pandaq.pandaeye.modules.dishorder;

import com.pandaq.pandaeye.modules.dishorder.beans.DishDesk;
import com.pandaq.pandaeye.modules.dishorder.beans.Floor;
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
        void setFloors(BaseRespose<List<Floor>> respose);

        void getFunctionBookingFail(String errMsg);
        void getFloorsFail(String errMsg);



    }

    interface Presenter {
        void getFloors(String token);
        void getFunctionBooking(String token,int floor);

    }
}
