package com.pandaq.pandaeye.modules.dishorder.beans;

import java.io.Serializable;

/**
 * Created by admin on 2018/5/25.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:
 */

public class CategoriesBean implements Serializable {

    /**
     * id : 1
     * sid : 1
     * name : 本店热销
     * sort : 0
     */

    private int id;
    private int sid;
    private String name;
    private int sort;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
