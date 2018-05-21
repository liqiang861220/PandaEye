package com.pandaq.pandaeye.modules.dishorder;

/**
 * Created by PandaQ on 2017/4/12.
 * 767807368@qq.com
 */

public interface DishOrderContract {
    interface View {
        void showRefreshBar();

        void hideRefreshBar();

        void userLogin();

        void loginSuccessed(LoginUser loginUser);

        void loginFail(String errMsg);


    }

    interface Presenter {
        void userLogin(String userName,String password);
    }
}
