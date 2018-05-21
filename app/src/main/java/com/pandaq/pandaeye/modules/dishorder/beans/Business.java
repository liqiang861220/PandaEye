package com.pandaq.pandaeye.modules.dishorder.beans;

import java.io.Serializable;

/**
 * Created by admin on 2018/5/21.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:  商家店铺信息
 */

public class Business implements Serializable {

    /**
     * address : 满城区上古春天
     * approve : 0
     * join_time : 2018-05-13 19:02:42
     * open_time : 0
     * name : 未来之初餐厅
     * mobile : 18501257574
     * logo : http://api.wsrok.com/static/index/food.png
     */

    private String address;
    private int approve;
    private String join_time;
    private int open_time;
    private String name;
    private String mobile;
    private String logo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getApprove() {
        return approve;
    }

    public void setApprove(int approve) {
        this.approve = approve;
    }

    public String getJoin_time() {
        return join_time;
    }

    public void setJoin_time(String join_time) {
        this.join_time = join_time;
    }

    public int getOpen_time() {
        return open_time;
    }

    public void setOpen_time(int open_time) {
        this.open_time = open_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
