package com.pandaq.pandaeye.modules.dishorder;

import android.app.ActivityOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.github.florent37.viewanimator.ViewAnimator;
import com.pandaq.pandaeye.BaseActivity;
import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.Views.AddWidget;
import com.pandaq.pandaeye.modules.dishorder.Views.ShopCarView;
import com.pandaq.pandaeye.modules.dishorder.Views.ShopInfoContainer;
import com.pandaq.pandaeye.modules.dishorder.adapters.CarAdapter;
import com.pandaq.pandaeye.modules.dishorder.beans.FoodBean;
import com.pandaq.pandaeye.modules.dishorder.behaviors.AppBarBehavior;
import com.pandaq.pandaeye.modules.dishorder.fooddetail.ShopDetailActivity;
import com.pandaq.pandaeye.modules.dishorder.fragments.FirstFragment;
import com.pandaq.pandaeye.modules.dishorder.fragments.SecondFragment;
import com.pandaq.pandaeye.modules.dishorder.utils.ViewUtils;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CreateOrderActivity extends BaseActivity implements AddWidget.OnAddClick {

    public static final String CAR_ACTION = "handleCar";
    public static final String CLEARCAR_ACTION = "clearCar";
    private CoordinatorLayout rootview;
    public BottomSheetBehavior behavior;
    public View scroll_container;
    private FirstFragment firstFragment;
    public static CarAdapter carAdapter;
    private ShopCarView shopCarView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_create_order);
        initViews();
        IntentFilter intentFilter = new IntentFilter(CAR_ACTION);
        intentFilter.addAction(CLEARCAR_ACTION);
        registerReceiver(broadcastReceiver, intentFilter);
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case CAR_ACTION:
                    FoodBean foodBean = (FoodBean) intent.getSerializableExtra("foodbean");
                    FoodBean fb = foodBean;
                    int p = intent.getIntExtra("position", -1);
                    if (p >= 0 && p < firstFragment.getFoodAdapter().getItemCount()) {
                        fb = firstFragment.getFoodAdapter().getItem(p);
                        fb.setSelectCount(foodBean.getSelectCount());
                        firstFragment.getFoodAdapter().setData(p, fb);
                    } else {
                        for (int i = 0; i < firstFragment.getFoodAdapter().getItemCount(); i++) {
                            fb = firstFragment.getFoodAdapter().getItem(i);
                            if (fb.getId() == foodBean.getId()) {
                                fb.setSelectCount(foodBean.getSelectCount());
                                firstFragment.getFoodAdapter().setData(i, fb);
                                break;
                            }
                        }
                    }
                    dealCar(fb);
                    break;
                case CLEARCAR_ACTION:
                    clearCar();
                    break;
            }
            if (CAR_ACTION.equals(intent.getAction())) {

            }
        }
    };

    private void initViews() {
        rootview = (CoordinatorLayout) findViewById(R.id.rootview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViewpager();
        initShopCar();
    }

    private void initShopCar() {
        behavior = BottomSheetBehavior.from(findViewById(R.id.car_container));
        shopCarView = (ShopCarView) findViewById(R.id.car_mainfl);
        View blackView = findViewById(R.id.blackview);
        shopCarView.setBehavior(behavior, blackView);
        RecyclerView carRecView = (RecyclerView) findViewById(R.id.car_recyclerview);
//		carRecView.setNestedScrollingEnabled(false);
        carRecView.setLayoutManager(new LinearLayoutManager(this));
        ((DefaultItemAnimator) carRecView.getItemAnimator()).setSupportsChangeAnimations(false);
        carAdapter = new CarAdapter(new ArrayList<FoodBean>(), this);
        carAdapter.bindToRecyclerView(carRecView);
    }

    private void initViewpager() {
        scroll_container = findViewById(R.id.scroll_container);
        ScrollIndicatorView mSv = (ScrollIndicatorView) findViewById(R.id.indicator);
        ColorBar colorBar = new ColorBar(this, ContextCompat.getColor(this, R.color.dicator_line_blue), 6,
                ScrollBar.Gravity.BOTTOM);
        colorBar.setWidth(ViewUtils.dip2px(this, 30));
        mSv.setScrollBar(colorBar);
        mSv.setSplitAuto(false);
        mSv.setOnTransitionListener(new OnTransitionTextListener().setColor(ContextCompat.getColor(this, R.color.dicator_line_blue),
                ContextCompat.getColor(this, R.color.black)));
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
        IndicatorViewPager indicatorViewPager = new IndicatorViewPager(mSv, mViewPager);
        firstFragment = new FirstFragment();
        ViewpagerAdapter myAdapter = new ViewpagerAdapter(getSupportFragmentManager());
        indicatorViewPager.setAdapter(myAdapter);
    }

    private class ViewpagerAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private LayoutInflater inflater;
        private int padding;
        private String[] tabs = new String[]{"商品", "评价"};

        ViewpagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            inflater = LayoutInflater.from(CreateOrderActivity.this);
            padding = ViewUtils.dip2px(CreateOrderActivity.this, 20);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            convertView = inflater.inflate(R.layout.item_textview, container, false);
            TextView textView = (TextView) convertView;
            textView.setText(tabs[position]); //名称
            textView.setPadding(padding, 0, padding, 0);
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            switch (position) {
                case 0:
                    return firstFragment;
            }
            return new SecondFragment();
        }
    }

    @Override
    public void onAddClick(View view, FoodBean fb) {
        dealCar(fb);
        ViewUtils.addTvAnim(view, shopCarView.carLoc, this, rootview);
    }


    @Override
    public void onSubClick(FoodBean fb) {
        dealCar(fb);
    }

    private void dealCar(FoodBean foodBean) {
        HashMap<String, Long> typeSelect = new HashMap<>();//更新左侧类别badge用
        BigDecimal amount = new BigDecimal(0.0);
        int total = 0;
        boolean hasFood = false;
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            firstFragment.getFoodAdapter().notifyDataSetChanged();
        }
        List<FoodBean> flist = carAdapter.getData();
        int p = -1;
        for (int i = 0; i < flist.size(); i++) {
            FoodBean fb = flist.get(i);
            if (fb.getId() == foodBean.getId()) {
                fb = foodBean;
                hasFood = true;
                if (foodBean.getSelectCount() == 0) {
                    p = i;
                } else {
                    carAdapter.setData(i, foodBean);
                }
            }
            total += fb.getSelectCount();
            if (typeSelect.containsKey(fb.getType())) {
                typeSelect.put(fb.getType(), typeSelect.get(fb.getType()) + fb.getSelectCount());
            } else {
                typeSelect.put(fb.getType(), fb.getSelectCount());
            }
            amount = amount.add(fb.getPrice().multiply(BigDecimal.valueOf(fb.getSelectCount())));
        }
        if (p >= 0) {
            carAdapter.remove(p);
        } else if (!hasFood && foodBean.getSelectCount() > 0) {
            carAdapter.addData(foodBean);
            if (typeSelect.containsKey(foodBean.getType())) {
                typeSelect.put(foodBean.getType(), typeSelect.get(foodBean.getType()) + foodBean.getSelectCount());
            } else {
                typeSelect.put(foodBean.getType(), foodBean.getSelectCount());
            }
            amount = amount.add(foodBean.getPrice().multiply(BigDecimal.valueOf(foodBean.getSelectCount())));
            total += foodBean.getSelectCount();
        }
        shopCarView.showBadge(total);
        firstFragment.getTypeAdapter().updateBadge(typeSelect);
        shopCarView.updateAmount(amount);
    }

    public void expendCut(View view) {
        float cty = scroll_container.getTranslationY();
        if (!ViewUtils.isFastClick()) {
            ViewAnimator.animate(scroll_container)
                    .translationY(cty, cty == 0 ? AppBarBehavior.cutExpHeight : 0)
                    .decelerate()
                    .duration(100)
                    .start();
        }
    }

    public void clearCar(View view) {
        ViewUtils.showClearCar(this, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clearCar();
            }
        });
    }

    private void clearCar() {
        List<FoodBean> flist = carAdapter.getData();
        for (int i = 0; i < flist.size(); i++) {
            FoodBean fb = flist.get(i);
            fb.setSelectCount(0);
        }
        carAdapter.setNewData(new ArrayList<FoodBean>());
        firstFragment.getFoodAdapter().notifyDataSetChanged();
        shopCarView.showBadge(0);
        firstFragment.getTypeAdapter().updateBadge(new HashMap<String, Long>());
        shopCarView.updateAmount(new BigDecimal(0.0));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
        System.exit(0);
    }

    public void toShopDetail(View view) {
        ShopInfoContainer shopInfoContainer = (ShopInfoContainer) findViewById(R.id.shopcontainer);
        if (android.os.Build.VERSION.SDK_INT > 20) {
            startActivity(new Intent(this, ShopDetailActivity.class), ActivityOptions.makeSceneTransitionAnimation(CreateOrderActivity.this, shopInfoContainer.iv_shop, "transitionShopImg").toBundle());
        } else {
            startActivity(new Intent(this, ShopDetailActivity.class));
        }

    }
}
