package com.sinyuk.myutils.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/**
 * 把LayerType的变化提取出来，硬件层可以加速动画【同时内存会有一些损耗】
 */
public class AnimatorLayerListener extends AnimatorListenerAdapter {

    private View mView;
    private int mOriginLayerType;

    public AnimatorLayerListener(View v) {
        mView = v;
    }

    @Override
    public void onAnimationStart(Animator animation) {
        mOriginLayerType = mView.getLayerType();
        mView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        mView.setLayerType(mOriginLayerType, null);
    }

}
