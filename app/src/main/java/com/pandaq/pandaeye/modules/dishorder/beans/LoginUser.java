package com.pandaq.pandaeye.modules.dishorder.beans;

import java.io.Serializable;

/**
 * Created by admin on 2018/5/21.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:
 */

public class LoginUser implements Serializable{

    /**
     * id : 1
     * sid : 1
     * username : w1
     * name : 服务员1号
     * number : 0001
     * token : 2658972483ae87e1eb49b0708b3d8509
     */

    private int id;
    private int sid;
    private String username;
    private String name;
    private String number;
    private String token;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
