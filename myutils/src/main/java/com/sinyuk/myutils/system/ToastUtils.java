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
        toast(message, Toast.LENGTH_SHORT);
    }

    public void toastShort(int resId) {
        toast(context.getString(resId), Toast.LENGTH_SHORT);
    }

    public void toastLong(@NonNull String message) {
        toast(message, Toast.LENGTH_LONG);
    }


    public void toastLong(int resId) {
        toast(context.getString(resId), Toast.LENGTH_LONG);
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


    private static CharSequence oldMsg = null;
    private static int oldDuration = 0;
    private static Toast toast = null;
    private static long firstTime = 0;
    private static long secondTime = 0;

    private void toast(CharSequence text, int duration) {
        if (toast == null) {
            firstTime = System.currentTimeMillis();
            toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            secondTime = System.currentTimeMillis();
            if (text.equals(oldMsg)) {
                if (secondTime - firstTime > oldDuration) {
                    toast.show();
                } else {
                    // pass
                }
            } else {
                oldMsg = text;
                toast.setText(text);
                toast.show();
            }
        }

        firstTime = secondTime;
        oldDuration = duration;
    }
}
