package com.applestudio.tintuc.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/**
 * Created by lequy on 7/10/2017.
 */

public class Constant {
    public static int convertDpIntoPixels(int sizeInDp, Context context) {
        float scale = context.getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (sizeInDp * scale + 0.5f);
        return dpAsPixels;
    }

    public static void increaseHitArea(final View button) {
        final View parent = (View) button.getParent();  // button: the view you want to enlarge hit area
        parent.post(new Runnable() {
            public void run() {
                final Rect rect = new Rect();
                button.getHitRect(rect);
                rect.top -= 100;    // increase top hit area
                rect.left -= 100;   // increase left hit area
                rect.bottom += 100; // increase bottom hit area
                rect.right += 100;  // increase right hit area
                parent.setTouchDelegate(new TouchDelegate(rect, button));
            }
        });
    }
}
