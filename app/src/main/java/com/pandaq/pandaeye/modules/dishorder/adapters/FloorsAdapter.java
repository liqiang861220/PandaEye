package com.pandaq.pandaeye.modules.dishorder.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.beans.Floor;

import java.util.List;

/**
 /**
 * Created by ph on 2018/1/2.
 * 邮箱: penghao@newstrength.cn
 * 描述: 行程变更
 */

public class FloorsAdapter extends RecyclerView.Adapter<FloorsAdapter.ViewHolder> {

    private List<Floor> mDatas;
    private Context mContext;
    public FloorsAdapter(Context mContext){
        this.mContext = mContext;
    }

    public void setDatas(List<Floor> mDatas){
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        if (null == viewHolder) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_floor, parent, false);
            viewHolder = new ViewHolder(view);
        }
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Floor floorBean = mDatas.get(position);
        holder.tvCommit.setText(floorBean.getFloor_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != onItemClickListener){
                    onItemClickListener.onItemClickListener(view, position, 0);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return  null == mDatas ? 0 : mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvCommit;
        public ViewHolder(View itemView) {
            super(itemView);
            tvCommit = (TextView) itemView.findViewById(R.id.tv_item_floor);
        }
    }
    public interface OnItemClickListener{
        void onItemClickListener(View v, int position, int clickType);
    }
}
