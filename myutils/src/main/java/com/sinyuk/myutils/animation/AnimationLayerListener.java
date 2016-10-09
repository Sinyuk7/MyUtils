package com.sinyuk.myutils.animation;

import android.view.View;
import android.view.animation.Animation;

/**
 * Created by Sinyuk on 16/9/18.
 */
public class AnimationLayerListener implements Animation.AnimationListener{

    private View mView;
    private int mOriginLayerType;

    public AnimationLayerListener(View v){
        mView = v;
    }
    @Override
    public void onAnimationStart(Animation animation) {
        mOriginLayerType = mView.getLayerType();
        mView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mView.setLayerType(mOriginLayerType, null);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
