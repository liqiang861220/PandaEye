package com.pandaq.pandaeye.modules.dishorder.beans;

import java.io.Serializable;

/**
 * Created by admin on 2018/5/21.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:  餐品名称
 */

public class Food implements Serializable {

    /**
     * id : 1
     * sid : 1
     * cid : 1
     * name : 土豆丝
     * slogan : 清脆可口好吃得很
     * img : http://api.yidian.cc/uploads/fo72j16ytft1or111f723ojrcp9b7171/foods/5aee5f8a1af71.jpg
     * price : 10.01
     * sale_count : 0
     * spec :
     * description :
     * is_show : 1
     * sort : 400
     * min : 1
     * max : 0
     * unit : 份
     */

    private int id;
    private int sid;
    private int cid;
    private String name;
    private String slogan;
    private String img;
    private String price;
    private int sale_count;
    private String spec;
    private String description;
    private int is_show;
    private int sort;
    private int min;
    private int max;
    private String unit;

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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getSale_count() {
        return sale_count;
    }

    public void setSale_count(int sale_count) {
        this.sale_count = sale_count;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIs_show() {
        return is_show;
    }

    public void setIs_show(int is_show) {
        this.is_show = is_show;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
