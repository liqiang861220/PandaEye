package com.pandaq.pandaeye.modules.dishorder.beans;

import java.io.Serializable;

/**
 * Created by admin on 2018/5/21.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:  APP模块
 */

public class FunctionModule implements Serializable {

    /**
     * id : 1
     * sid : 1
     * mark : 1
     * title : 点餐
     * image : http://api.wsrok.com/uploads/icons/menu.png
     * bgcolor : #007bff
     * sort : 100
     * is_open : 1
     */

    private int id;
    private int sid;
    private int mark;
    private String title;
    private String image;
    private String bgcolor;
    private int sort;
    private int is_open;

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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getIs_open() {
        return is_open;
    }

    public void setIs_open(int is_open) {
        this.is_open = is_open;
    }
}
