package com.pandaq.pandaeye.modules.dishorder.beans;

import java.io.Serializable;

/**
 * Created by admin on 2018/5/23.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:  获取餐厅格局
 */

public class Floor implements Serializable {

    /**
     * id : 1
     * sid : 1
     * floor_name : 大堂
     */

    private int id;
    private int sid;
    private String floor_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getFloor_name() {
        return floor_name;
    }

    public void setFloor_name(String floor_name) {
        this.floor_name = floor_name;
    }
}
