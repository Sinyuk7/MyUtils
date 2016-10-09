package com.sinyuk.myutils.system;

import android.app.Application;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Sinyuk on 16.2.27.
 */
public class ToastUtils {

    private final Application context;

    public ToastUtils(Application context) {
        this.context = context;
    }

    public void toastShort(@NonNull String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void toastShort(int resId) {
        Toast.makeText(context, context.getString(resId), Toast.LENGTH_SHORT).show();
    }

    public void toastLong(@NonNull String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }


    public void toastLong(int resId) {
        Toast.makeText(context, context.getString(resId), Toast.LENGTH_LONG).show();
    }

    public void toastWithPicture(int resId, CharSequence text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);

        View toastView = toast.getView();

        ImageView img = new ImageView(context);
        img.setImageResource(resId);

        LinearLayout ll = new LinearLayout(context);
        //向LinearLayout中添加ImageView和Toast原有的View
        ll.addView(img);
        ll.addView(toastView);

        //将LineLayout容器设置为toast的View
        toast.setView(ll);

        toast.show();
    }
}
