package com.pandaq.pandaeye.modules.dishorder;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

import com.pandaq.pandaeye.BaseActivity;
import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.beans.DishDesk;
import com.pandaq.pandaeye.utils.SPUtils;
import com.pandaq.pandaeye.utils.ToastUitl;
import com.pandaq.pandaeye.widget.BaseRespose;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FunctionBookingActivity extends BaseActivity implements FunctionBookingContract.View {


    private List<DishDesk> destkData  ;
    private FuncitonBookingAdapter funcitonBookingAdapter;
    private FunctionBookingPresenter mpresenter;
    private GridView gv_booking_list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_function_booking);
        gv_booking_list = (GridView) findViewById(R.id.gv_booking_list);


        gv_booking_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(null!=destkData){
                    ToastUitl.showShort("当前点餐桌号名字叫："+destkData.get(position).getDesk_name());
                }
            }
        });
        mpresenter = new FunctionBookingPresenter(this);
        mpresenter.getFunctionBooking(SPUtils.getStringValue("token",""));

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
    public void getFunctionBookingFail(String errMsg) {
        ToastUitl.showShort(errMsg);
    }


}
