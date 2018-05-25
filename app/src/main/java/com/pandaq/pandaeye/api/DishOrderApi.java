package com.pandaq.pandaeye.api;

import com.pandaq.pandaeye.modules.dishorder.beans.DishDesk;
import com.pandaq.pandaeye.modules.dishorder.beans.Floor;
import com.pandaq.pandaeye.modules.dishorder.beans.FunctionModule;
import com.pandaq.pandaeye.modules.dishorder.beans.GroupsAndFoods;
import com.pandaq.pandaeye.modules.dishorder.beans.LoginUser;
import com.pandaq.pandaeye.widget.BaseRespose;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
    @GET("v1/floors/{token}")
    Observable<BaseRespose<List<Floor>>> getFloors(@Path("token") String token);

    /**
     * 获取餐桌
     * @param token
     * @return
     */
    @GET("v1/desks/{token}")
    Observable<BaseRespose<List<DishDesk>>> getFuncitonBooking(@Path("token") String token, @Query("floor") int floor);


    /**
     * 获取餐桌
     * @param token
     * @return
     */
    @GET("v1/menus/{token}")
    Observable<BaseRespose<GroupsAndFoods>> getFoods(@Path("token") String token);



}
