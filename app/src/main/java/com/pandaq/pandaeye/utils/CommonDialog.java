package com.pandaq.pandaeye.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.pandaq.pandaeye.R;


public class CommonDialog {


    private static TextView tv_cancel,tv_confirm;

    private static RadioGroup rg_agreement;
    private static EditText et_reson;
    private static  boolean isAgree = true;
    static TextView tv_dialog_title, tv_confirm_content;
    static View view_cancel;


    /**
     * 普通确认窗口
     * @param mContext
     * @param confirmContent
     * @param listener
     */
    public static void showConfirmDialog(final Context mContext,String cancelText,String confirmText,String confirmContent, final DialogClickListener listener) {
        final Dialog dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_common_dialog, null);
        tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        tv_confirm = (TextView) view.findViewById(R.id.tv_confirm);
        TextView tv_dialog_title = (TextView) view.findViewById(R.id.tv_dialog_title);
        TextView tv_confirm_content = (TextView) view.findViewById(R.id.tv_dialog_content);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.setConfirm();
                dialog.dismiss();
            }
        });
        tv_cancel.setText(cancelText);
        tv_confirm.setText(confirmText);
        tv_dialog_title.setText("提醒！");
        tv_confirm_content.setText(confirmContent);
        dialog.setContentView(view);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
    }


    public interface DialogClickListener{
        void setConfirm();
    }
}
