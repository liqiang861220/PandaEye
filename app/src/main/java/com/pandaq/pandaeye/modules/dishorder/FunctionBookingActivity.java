package com.pandaq.pandaeye.modules.dishorder;

import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.pandaq.pandaeye.BaseActivity;
import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.beans.DishDesk;
import com.pandaq.pandaeye.modules.dishorder.beans.Floor;
import com.pandaq.pandaeye.utils.SPUtils;
import com.pandaq.pandaeye.utils.ToastUitl;
import com.pandaq.pandaeye.widget.BaseRespose;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FunctionBookingActivity extends BaseActivity implements FunctionBookingContract.View,AdapterView.OnItemSelectedListener {


    private List<DishDesk> destkData  ;
    private List<Floor> floorsData  ;
    private FuncitonBookingAdapter funcitonBookingAdapter;
    private FunctionBookingPresenter mpresenter;
    private GridView gv_booking_list;
    private AppCompatSpinner acs_floors;
    private ArrayAdapter adapter2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_function_booking);
        gv_booking_list = (GridView) findViewById(R.id.gv_booking_list);

        acs_floors = (AppCompatSpinner) findViewById(R.id.acs_floors);
        //将可选内容与ArrayAdapter连接起来

        gv_booking_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(null!=destkData){
                    ToastUitl.showShort("当前点餐桌号名字叫："+destkData.get(position).getDesk_name());
                    startActivity(CreateOrderActivity2.class);
                }
            }
        });
        mpresenter = new FunctionBookingPresenter(this);
        mpresenter.getFunctionBooking(SPUtils.getStringValue("token",""),0);
        mpresenter.getFloors(SPUtils.getStringValue("token",""));

    }


    @Override
    public void showRefreshBar() {

    }

    @Override
    public void hideRefreshBar() {

    }

    @Override
    public void setFunctionBooking(BaseRespose<List<DishDesk>> respose) {
        if(null!= respose.getData()){

            destkData = new ArrayList<>();
            destkData.addAll(respose.getData());
            funcitonBookingAdapter = new FuncitonBookingAdapter(this,destkData);
            gv_booking_list.setAdapter(funcitonBookingAdapter);
        }
    }

    @Override
    public void setFloors(BaseRespose<List<Floor>> respose) {
        if(null!= respose.getData()){
            floorsData = respose.getData();
            ToastUitl.showShort("获取楼层格局成功");
            List<String>  floorsName = new ArrayList<>();
            for(int i = 0 ; i<floorsData.size(); i ++){
                floorsName.add(floorsData.get(i).getFloor_name());
            }
            adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, floorsName);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            acs_floors.setAdapter(adapter2);

            acs_floors.setOnItemSelectedListener(this);
        }
    }

    @Override
    public void getFunctionBookingFail(String errMsg) {
        ToastUitl.showShort(errMsg);
    }

    @Override
    public void getFloorsFail(String errMsg) {
        ToastUitl.showShort(errMsg);
    }


    //楼层选择回调


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         int floor = destkData.get(position).getFloor();
        mpresenter.getFunctionBooking(SPUtils.getStringValue("token",""),floor);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
