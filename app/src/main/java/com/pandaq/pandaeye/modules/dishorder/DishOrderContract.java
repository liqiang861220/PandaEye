package com.pandaq.pandaeye.modules.dishorder;

import com.pandaq.pandaeye.modules.dishorder.beans.LoginUser;
import com.pandaq.pandaeye.widget.BaseRespose;

/**
 * Created by PandaQ on 2017/4/12.
 * 767807368@qq.com
 */

public interface DishOrderContract {
    interface View {
        void showRefreshBar();

        void hideRefreshBar();

        void userLogin();

        void loginSuccessed(BaseRespose<LoginUser> respose);

        void loginFail(String errMsg);


    }

    interface Presenter {
        void userLogin(String userName,String password);
    }
}
