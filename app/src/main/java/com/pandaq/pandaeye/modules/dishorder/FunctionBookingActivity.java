package com.pandaq.pandaeye.modules.dishorder;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.pandaq.pandaeye.BaseActivity;
import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.adapters.FloorsAdapter;
import com.pandaq.pandaeye.modules.dishorder.beans.DishDesk;
import com.pandaq.pandaeye.modules.dishorder.beans.Floor;
import com.pandaq.pandaeye.utils.SPUtils;
import com.pandaq.pandaeye.utils.ToastUitl;
import com.pandaq.pandaeye.widget.BaseRespose;
import com.pandaq.pandaeye.widget.CustomPopWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FunctionBookingActivity extends BaseActivity implements FunctionBookingContract.View {


    private List<DishDesk> destkData  ;
    private List<Floor> floorsData  ;
    private FuncitonBookingAdapter funcitonBookingAdapter;
    private FunctionBookingPresenter mpresenter;
    private GridView gv_booking_list;
    private TextView tv_floors;
    private ArrayAdapter adapter2;
    private CustomPopWindow popWindow;
    private FloorsAdapter mFloorAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_function_booking);
        gv_booking_list = (GridView) findViewById(R.id.gv_booking_list);

        tv_floors = (TextView) findViewById(R.id.tv_floors);
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

        initFloorView();//初始化popwindown
        mpresenter = new FunctionBookingPresenter(this);
        mpresenter.getFunctionBooking(SPUtils.getStringValue("token",""),0);
        mpresenter.getFloors(SPUtils.getStringValue("token",""));

    }

    private void initFloorView(){
        View contentView = LayoutInflater.from(this).inflate(R.layout.popup_floors_list,null);
        RecyclerView mRecycleRView = (RecyclerView) contentView.findViewById(R.id.rv_floors);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleRView.setLayoutManager(manager);
        mFloorAdapter = new FloorsAdapter(FunctionBookingActivity.this);
        mRecycleRView.setAdapter(mFloorAdapter);
        mFloorAdapter.setOnItemClickListener(new FloorsAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position, int clickType) {
                popWindow.dissmiss();
                if(null!=floorsData&&floorsData.size()>0){
                    mpresenter.getFunctionBooking(SPUtils.getStringValue("token",""),floorsData.get(position).getId());
                }
            }
        });

        popWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)//显示的布局，还可以通过设置一个View
                //     .size(600,400) //设置显示的大小，不设置就默认包裹内容
                .setFocusable(true)//是否获取焦点，默认为ture
                .setOutsideTouchable(true)//是否PopupWindow 以外触摸dissmiss
                .create();//创建PopupWindow


        tv_floors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popWindow.isShowing()) {
                    popWindow.dissmiss();
                } else {
                    popWindow.showAtLocation(tv_floors, Gravity.BOTTOM,0, 150);
                }

            }
        });

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
            mFloorAdapter.setDatas(floorsData);
            mFloorAdapter.notifyDataSetChanged();
            ToastUitl.showShort("获取楼层格局成功");
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


}
