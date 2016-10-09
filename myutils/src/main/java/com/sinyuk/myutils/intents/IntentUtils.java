package com.sinyuk.myutils.intents;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Sinyuk on 16.2.10.
 */
public class IntentUtils {
    /**
     * @param content 附加的文字内容
     * @param uri     图片uri
     */
    public static void shareImageOrText(Context context, String content, String hint, Uri uri) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        if (uri != null) {
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.setType("image/*");
            //当用户选择短信时使用sms_body取得文字
            if (content != null)
                shareIntent.putExtra("sms_body", content);
        } else {
            shareIntent.setType("text/plain");
        }
        shareIntent.putExtra(Intent.EXTRA_TEXT, content);
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //自定义选择框的标题
        context.startActivity(Intent.createChooser(shareIntent, hint));
        //系统默认标题
    }

}
