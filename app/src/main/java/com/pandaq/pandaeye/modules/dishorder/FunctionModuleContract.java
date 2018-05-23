package com.pandaq.pandaeye.modules.dishorder;

import com.pandaq.pandaeye.modules.dishorder.beans.FunctionModule;
import com.pandaq.pandaeye.widget.BaseRespose;

import java.util.List;

/**
 * Created by PandaQ on 2017/4/12.
 * 767807368@qq.com
 */

public interface FunctionModuleContract {
    interface View {
        void showRefreshBar();

        void hideRefreshBar();


        void setDishFunctionModule(BaseRespose<List<FunctionModule>> respose);

        void getFunctionModuleFail(String errMsg);


    }

    interface Presenter {
        void getDishFunctionModule(String token);
    }
}
