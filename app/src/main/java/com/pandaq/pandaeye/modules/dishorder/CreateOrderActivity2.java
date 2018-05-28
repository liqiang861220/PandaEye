package com.pandaq.pandaeye.modules.dishorder;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.pandaq.pandaeye.BaseActivity;
import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.beans.GroupsAndFoods;
import com.pandaq.pandaeye.utils.SPUtils;
import com.pandaq.pandaeye.widget.BaseRespose;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class CreateOrderActivity2 extends BaseActivity implements CreateOrderContract.View{


    private CreateOrderPresenter mpresenter;

    private ListView lv_classify_listview;
    private GridView gv_foods_listview;
    private ClassifyAdapter classifyAdapter;
    private FoodsAdapter foodsAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ordering);

        lv_classify_listview = (ListView) findViewById(R.id.lv_classify_listview);
        gv_foods_listview = (GridView) findViewById(R.id.gv_foods_listview);

        lv_classify_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        //将可选内容与ArrayAdapter连接起来
        mpresenter = new CreateOrderPresenter(this);
        mpresenter.getFoods(SPUtils.getStringValue("token",""));

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
            classifyAdapter = new ClassifyAdapter(CreateOrderActivity2.this,respose.getData().getCategories());
            foodsAdapter = new FoodsAdapter(CreateOrderActivity2.this,respose.getData().getFoods());
            lv_classify_listview.setAdapter(classifyAdapter);
            gv_foods_listview.setAdapter(foodsAdapter);

        }
    }

    @Override
    public void getFoodsFail(String errMsg) {

    }


}
