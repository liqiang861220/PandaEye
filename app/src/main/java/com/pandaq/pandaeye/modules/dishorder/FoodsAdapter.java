package com.pandaq.pandaeye.modules.dishorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.beans.FoodBean;

import java.util.List;

/**
 * Created by admin on 2018/5/16.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:
 */

public class FoodsAdapter extends BaseAdapter {

    private Context mContext;
    private List<FoodBean> foodBeenData;
    private LayoutInflater mInflater;

    public FoodsAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return foodBeenData == null ? 0 : foodBeenData.size();
    }

    @Override
    public FoodBean getItem(int position) {
        return (FoodBean) foodBeenData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void resetDataSource(List<FoodBean> foodBeenData){
        this.foodBeenData= foodBeenData;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FoodBean bean = getItem(position);
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_food3, parent, false);
            //holder.iv_remove_item = (ImageView) convertView.findViewById(R.id.iv_remove_item);
            //holder.iv_add_item = (ImageView) convertView.findViewById(R.id.iv_add_item);
            holder.tv_food_name = (TextView) convertView.findViewById(R.id.tv_food_name);
            holder.tv_unit_price = (TextView) convertView.findViewById(R.id.tv_unit_price);
            holder.tv_min_unit = (TextView) convertView.findViewById(R.id.tv_min_unit);
            holder.tv_item_size = (TextView) convertView.findViewById(R.id.tv_item_size);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_food_name.setText(bean.getName());
        holder.tv_unit_price.setText("¥"+bean.getPrice());
        holder.tv_min_unit.setText(bean.getMin()+"份起");
        holder.tv_item_size.setText(bean.getVoteSize()+"");

        return convertView;
    }

    private class ViewHolder {
        private TextView tv_food_name, tv_unit_price, tv_min_unit,tv_item_size;
    }
}

