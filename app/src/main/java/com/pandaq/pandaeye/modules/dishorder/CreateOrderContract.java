package com.pandaq.pandaeye.modules.dishorder;

import com.pandaq.pandaeye.modules.dishorder.beans.GroupsAndFoods;
import com.pandaq.pandaeye.widget.BaseRespose;

/**
 * Created by PandaQ on 2017/4/12.
 * 767807368@qq.com
 */

public interface CreateOrderContract {
    interface View {
        void showRefreshBar();

        void hideRefreshBar();

        void getFoodsSuccessed(BaseRespose<GroupsAndFoods> respose);

        void getFoodsFail(String errMsg);


    }

    interface Presenter {
        void getFoods(String token);
    }
}
