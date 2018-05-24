package com.pandaq.pandaeye.modules.dishorder;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.pandaq.pandaeye.BaseActivity;
import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.beans.FunctionModule;
import com.pandaq.pandaeye.utils.CommonDialog;
import com.pandaq.pandaeye.utils.SPUtils;
import com.pandaq.pandaeye.utils.ToastUitl;
import com.pandaq.pandaeye.widget.BaseRespose;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FunctionModuleActivity extends BaseActivity implements FunctionModuleContract.View {

    private static final int FUNCTION_BOOKING = 1; //点餐
    private static final int FUNCTION_ORDER_QUERY = 2;//查询订单
    private static final int FUNCTION_PRINT_DORDER = 3;//打印清单
    private static final int FUNCTION_SETTLE_ACCOUNTS = 4;//结账

    private List<FunctionModule> functionData  ;
    private FuncitonMloduleAdapter funcitonMloduleAdapter;
    private FunctionModulePresenter mpresenter;

    private GridView gv_function_list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_function_module);
        gv_function_list = (GridView) findViewById(R.id.gv_function_list);


        gv_function_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(null!=functionData){
                    switch (functionData.get(position).getMark()){
                        case FUNCTION_BOOKING:
                            //订餐
                            startActivity(FunctionBookingActivity.class);
                            break;
                        case FUNCTION_ORDER_QUERY:
                            //账单查询
                            break;
                        case FUNCTION_PRINT_DORDER:
                            //打预结单
                            break;
                        case FUNCTION_SETTLE_ACCOUNTS:
                            //结账

                            break;


                    }

                }
            }
        });
        mpresenter = new FunctionModulePresenter(this);
        mpresenter.getDishFunctionModule(SPUtils.getStringValue("token",""));


    }


    @Override
    public void showRefreshBar() {

    }

    @Override
    public void hideRefreshBar() {

    }

    @Override
    public void setDishFunctionModule(BaseRespose<List<FunctionModule>> respose) {
        if(null!= respose.getData()){

            functionData = new ArrayList<>();
            functionData.addAll(respose.getData());
            funcitonMloduleAdapter = new FuncitonMloduleAdapter(this,functionData);
            gv_function_list.setAdapter(funcitonMloduleAdapter);
        }

    }

    @Override
    public void getFunctionModuleFail(String errMsg) {
        ToastUitl.showShort(errMsg);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        CommonDialog.showConfirmDialog(this, "点错了", "要退出", "你确定要退出吗？", new CommonDialog.DialogClickListener() {
            @Override
            public void setConfirm() {
                finish();
            }

        });
    }
}
