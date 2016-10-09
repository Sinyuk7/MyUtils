package com.sinyuk.myutils.text;

import java.util.Random;

/**
 * Created by Sinyuk on 16.5.22.
 */
public class CommentGenerator {

    public static final String[] fakeComments = new String[]{
            "看起来不错~",
            "能不能便宜点",
            "可以当面看一下吗",
            "能小刀吗",
            "问下在哪里买的",
            "多大的尺码",
            "问下这东西出手了没",
            "方便帮我送过来吗",
            "看起来用了蛮久了",
            "好漂亮",
            "哇晒,想要!",

    };

    public static String getComment() {
        int index = new Random().nextInt(11);
        if (index >= fakeComments.length) { index = 0; }

        return fakeComments[index];
    }
}
