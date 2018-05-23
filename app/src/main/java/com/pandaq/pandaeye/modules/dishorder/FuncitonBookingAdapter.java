package com.pandaq.pandaeye.modules.dishorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.beans.DishDesk;

import java.util.List;

/**
 * Created by admin on 2018/5/16.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:
 */

public class FuncitonBookingAdapter extends BaseAdapter {
    private Context mContext;
    private List<DishDesk> destkData;
    public FuncitonBookingAdapter(Context mContext, List<DishDesk> destkData) {
        this.mContext = mContext;
        this.destkData = destkData;
    }

    @Override
    public int getCount() {
        return destkData.size();
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_function_booking, null);
        ImageView iv_item = (ImageView) view.findViewById(R.id.iv_desk_image);
        TextView tv_item = (TextView) view.findViewById(R.id.tv_desk_name);
        TextView tv_status = (TextView) view.findViewById(R.id.tv_desk_status);

        tv_item.setText(destkData.get(position).getDesk_name());
        tv_status.setText(destkData.get(position).getStatus()==0?"空闲":"开始");

//        if (!TextUtils.isEmpty(functionData.get(position).getImage())) {
//            Picasso.with(mContext)
//                    .load(functionData.get(position).getImage())
//                    .into(iv_item);
//        }

        return view;
    }
}

