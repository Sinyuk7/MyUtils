package com.sinyuk.myutils.system;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * Created by Sinyuk on 16.2.4.
 * 这是用来记录某些动作的次数 根据它们来做出相应的改变
 * 比如在用户第一次进入app的时候干嘛 之后就再也不干那个了
 * 就是这个意思
 */
public class SweetNotificationUtils {
    private static String PREFERENCE_NAME = "prefs";
    private final Context mContext;

    public SweetNotificationUtils(Context mContext) {
        this.mContext = mContext;
    }

    private static boolean putBoolean(Context context, String key, boolean value) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * put int preferences
     *
     * @param context
     * @param key     The name of the preference to modify
     * @param value   The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    private static boolean putInt(Context context, String key, int value) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    private static int getInt(Context context, String key, int defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getInt(key, defaultValue);
    }

    /**
     * @param key      the tag in prefs
     * @param callback do something
     */
    public void once(@NonNull String key, NotifyCallback callback) {
        boolean isFirstTime = getBoolean(mContext, key, true);
        if (isFirstTime) {
            callback.doSomething();
            putBoolean(mContext, key, false);
        }
    }

    /**
     * @param key
     * @param callback
     * @param stio     下次还要这样?
     */
    public void always(@NonNull String key, NotifyCallback callback, boolean stio) {
        boolean isAllowed = getBoolean(mContext, key, true);
        if (isAllowed) {
            callback.doSomething();
            putBoolean(mContext, key, stio);
        }
    }

    /**
     * @param key
     * @param callback
     * @param threshold 大于这个阈值触发这个动作
     */
    public void schedule(@NonNull String key, NotifyCallback callback, int threshold) {
        int times = getInt(mContext, key, 0);
        if (times > threshold) {
            callback.doSomething();
        }
        putInt(mContext, key, ++times);
    }

    private boolean getBoolean(Context context, String key, boolean defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, defaultValue);
    }


    private interface NotifyCallback {
        void doSomething();
    }
}
