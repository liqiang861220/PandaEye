package com.pandaq.pandaeye.api;

import com.pandaq.pandaeye.modules.dishorder.beans.DishDesk;
import com.pandaq.pandaeye.modules.dishorder.beans.FunctionModule;
import com.pandaq.pandaeye.modules.dishorder.beans.LoginUser;
import com.pandaq.pandaeye.widget.BaseRespose;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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
    Observable<BaseRespose<LoginUser>> login(@Field("username") String userName, @Field("password") String password);

    /**
     * 获取模块
     * @param token
     * @return
     */
    @GET("v1/modules/{token}")
    Observable<BaseRespose<List<FunctionModule>>> getFuncitonModule(@Path("token") String token);

    /**
     * 获取餐桌
     * @param token
     * @return
     */
    @GET("v1/desks/{token}")
    Observable<BaseRespose<List<DishDesk>>> getFuncitonBooking(@Path("token") String token);

}
