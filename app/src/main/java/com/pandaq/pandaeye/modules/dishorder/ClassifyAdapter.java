package com.pandaq.pandaeye.modules.dishorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.beans.CategoriesBean;

import java.util.List;

/**
 * Created by admin on 2018/5/16.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:
 */

public class ClassifyAdapter extends BaseAdapter {
    private Context mContext;
    private List<CategoriesBean> categoriesData;
    public ClassifyAdapter(Context mContext, List<CategoriesBean> categoriesData) {
        this.mContext = mContext;
        this.categoriesData = categoriesData;
    }

    @Override
    public int getCount() {
        return categoriesData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_food_classify, null);
        TextView tv_classify_name = (TextView) view.findViewById(R.id.tv_classify_name);
        tv_classify_name.setText(categoriesData.get(position).getName());

        return view;
    }
}

