package com.pandaq.pandaeye.api;

import com.pandaq.pandaeye.modules.dishorder.beans.LoginUser;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by PandaQ on 2016/9/8.
 * email : 767807368@qq.com
 * 用户API接口
 */
public interface DishOrderApi {

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("v1/waiter.login")
    Observable<LoginUser> login(@Field("username") String userName, @Field("password") String password);

}
