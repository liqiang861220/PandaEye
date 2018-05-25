package com.pandaq.pandaeye.modules.dishorder.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2018/5/25.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:
 */

public class GroupsAndFoods  implements Serializable {


    private List<CategoriesBean> categories;
    private List<FoodBean> foods;

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public List<FoodBean> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodBean> foods) {
        this.foods = foods;
    }


}
