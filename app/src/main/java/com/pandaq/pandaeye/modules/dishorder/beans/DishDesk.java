package com.pandaq.pandaeye.modules.dishorder.beans;

/**
 * Created by admin on 2018/5/21.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:  餐桌信息
 */

public class DishDesk {

    /**
     * id : 1
     * sid : 1
     * floor : 1
     * desk_name : 1号桌
     * desk_code : 1_1_1
     * print_name : 大厅 : 1号桌
     * status : 1
     */

    private int id;
    private int sid;
    private int floor;
    private String desk_name;
    private String desk_code;
    private String print_name;
    private int status;

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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDesk_name() {
        return desk_name;
    }

    public void setDesk_name(String desk_name) {
        this.desk_name = desk_name;
    }

    public String getDesk_code() {
        return desk_code;
    }

    public void setDesk_code(String desk_code) {
        this.desk_code = desk_code;
    }

    public String getPrint_name() {
        return print_name;
    }

    public void setPrint_name(String print_name) {
        this.print_name = print_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
