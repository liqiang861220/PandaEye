package com.pandaq.pandaeye.modules.dishorder.fooddetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.drawee.view.SimpleDraweeView;
import com.pandaq.pandaeye.BaseActivity;
import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.utils.ViewUtils;

/**
 * Created by k on 2017/10/30.
 */

public class ShopDetailActivity extends BaseActivity implements View.OnClickListener {

    private SimpleDraweeView iv_shop;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        iv_shop = (SimpleDraweeView) findViewById(R.id.iv_shop);
        ViewUtils.getBlurFresco(this, (SimpleDraweeView) findViewById(R.id.iv_shop_bg), "res:///" + R.drawable.icon_shop);

        //  ViewUtils.getFrescoController(mContext, iv_shop, "res:///" + R.drawable.icon_shop, 40, 40);
    }

    @Override
    public void onClick(View v) {

    }

}


