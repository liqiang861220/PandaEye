package com.pandaq.pandaeye.modules.dishorder;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import com.pandaq.pandaeye.BaseActivity;
import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.beans.CategoriesBean;
import com.pandaq.pandaeye.modules.dishorder.beans.FoodBean;
import com.pandaq.pandaeye.modules.dishorder.beans.GroupsAndFoods;
import com.pandaq.pandaeye.utils.SPUtils;
import com.pandaq.pandaeye.widget.BaseRespose;
import java.util.ArrayList;
import java.util.List;

public class CreateOrderActivity2 extends BaseActivity implements CreateOrderContract.View{


    private CreateOrderPresenter mpresenter;
    private ListView lv_classify_listview;
    private GridView gv_foods_listview;
    private ClassifyAdapter classifyAdapter;
    private FoodsAdapter foodsAdapter;
    private List<FoodBean> foodBeansData;
    private List<CategoriesBean> categoriesBeenData;
    private List<FoodBean> foodAdapterData;
    private int currentCid;//当前分类ID


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ordering);

        lv_classify_listview = (ListView) findViewById(R.id.lv_classify_listview);
        gv_foods_listview = (GridView) findViewById(R.id.gv_foods_listview);

        lv_classify_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentCid = categoriesBeenData.get(position).getId();
                dealClassifyFoods(currentCid);
            }
        });

        gv_foods_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                foodAdapterData.get(position).setVoteSize(foodAdapterData.get(position).getVoteSize()+1);
                dealClassifyFoods(currentCid);
            }
        });

        //将可选内容与ArrayAdapter连接起来
        mpresenter = new CreateOrderPresenter(this);
        mpresenter.getFoods(SPUtils.getStringValue("token",""));

    }

    //点击分类处理
    private void dealClassifyFoods(int categoriesBeanId){

        if(null != foodBeansData){
            foodAdapterData = new ArrayList<>();
            for(int i = 0 ; i<foodBeansData.size() ; i++){
                if(categoriesBeanId == foodBeansData.get(i).getCid()){
                    foodAdapterData.add(foodBeansData.get(i));
                }
            }
            foodsAdapter.resetDataSource(foodAdapterData);
        }

    }

    @Override
    public void showRefreshBar() {

    }

    @Override
    public void hideRefreshBar() {

    }

    @Override
    public void getFoodsSuccessed(BaseRespose<GroupsAndFoods> respose) {
        if(null != respose && null != respose.getData()){
            if (null!=foodBeansData) foodBeansData.clear();
            foodBeansData = respose.getData().getFoods();
            categoriesBeenData = respose.getData().getCategories();
            classifyAdapter = new ClassifyAdapter(CreateOrderActivity2.this,categoriesBeenData);
            foodsAdapter = new FoodsAdapter(CreateOrderActivity2.this);
            lv_classify_listview.setAdapter(classifyAdapter);
            gv_foods_listview.setAdapter(foodsAdapter);
            if (null!=categoriesBeenData && categoriesBeenData.size()>0){
                currentCid = categoriesBeenData.get(0).getId();
                dealClassifyFoods(currentCid);
            }

        }
    }

    @Override
    public void getFoodsFail(String errMsg) {

    }


}
