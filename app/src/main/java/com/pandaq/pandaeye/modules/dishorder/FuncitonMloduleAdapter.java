package com.pandaq.pandaeye.modules.dishorder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.beans.FunctionModule;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by admin on 2018/5/16.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:
 */

public class FuncitonMloduleAdapter extends BaseAdapter {
    private Context mContext;
    private List<FunctionModule> functionData;
    public FuncitonMloduleAdapter(Context mContext, List<FunctionModule> functionData) {
        this.mContext = mContext;
        this.functionData = functionData;
    }

    @Override
    public int getCount() {
        return functionData.size();
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_function_module, null);
        ImageView iv_item = (ImageView) view.findViewById(R.id.iv_function_image);
        TextView tv_item = (TextView) view.findViewById(R.id.tv_function_name);
        tv_item.setText(functionData.get(position).getTitle());

        if (!TextUtils.isEmpty(functionData.get(position).getImage())) {
            Picasso.with(mContext)
                    .load(functionData.get(position).getImage())
                    .into(iv_item);
        }

        return view;
    }
}

