package com.sinyuk.myutils.text;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.sinyuk.myutils.resource.StringUtils;


/**
 * Created by Sinyuk on 16/9/12.
 */
public class TextViewHelper {
    public static void setText(TextView textView, String input, String defaultValue) {
        if (textView == null) return;
        if (TextUtils.isEmpty(input) && TextUtils.isEmpty(defaultValue)) {
            textView.setVisibility(View.INVISIBLE);
        } else {
            textView.setText(StringUtils.valueOrDefault(input, defaultValue));
        }
    }
}
