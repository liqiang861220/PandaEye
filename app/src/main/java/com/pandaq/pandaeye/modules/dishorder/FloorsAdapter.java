package com.pandaq.pandaeye.modules.dishorder;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

/**
 * Created by admin on 2018/5/24.
 * Company: NewStrength
 * Email: liqiang861220@163.com
 * desc:
 */

public class FloorsAdapter extends ArrayAdapter {
    public FloorsAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
