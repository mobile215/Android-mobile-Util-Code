package com.blankj.utilcode.util;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * <pre>
 *     author: blankj
 *     blog  : http://blankj.com
 *     time  : 2018/12/29
 *     desc  : utils about anti shake
 * </pre>
 */
public class AntiShakeUtils {

    private static final long DEFAULT_DURATION = 200;
    private static final int  TAG_KEY          = 0x7EFFFFFF;

    private AntiShakeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isValid(@NonNull View view) {
        return isValid(view, DEFAULT_DURATION);
    }

    public static boolean isValid(@NonNull View view, @IntRange(from = 0) long duration) {
        long curTime = System.currentTimeMillis();
        Object tag = view.getTag(TAG_KEY);
        view.setTag(TAG_KEY, curTime);
        if (!(tag instanceof Long)) return true;
        long preTime = (Long) tag;
        return curTime - preTime > duration;
    }
}
