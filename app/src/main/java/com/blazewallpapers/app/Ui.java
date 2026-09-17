package com.blazewallpapers.app;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public final class Ui {
    public static final int BG = Color.rgb(7, 11, 18);
    public static final int PANEL = Color.rgb(15, 22, 32);
    public static final int PANEL_LIGHT = Color.rgb(23, 32, 45);
    public static final int TEXT = Color.rgb(242, 246, 250);
    public static final int MUTED = Color.rgb(157, 169, 184);
    public static final int CYAN = Color.rgb(81, 216, 255);

    private Ui() {}

    public static int dp(Context context, float value) {
        return Math.round(value * context.getResources().getDisplayMetrics().density);
    }

    public static GradientDrawable rounded(int color, float radiusDp, Context context) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(color);
        drawable.setCornerRadius(dp(context, radiusDp));
        return drawable;
    }

    public static GradientDrawable outlined(int fill, int stroke, float radiusDp, Context context) {
        GradientDrawable drawable = rounded(fill, radiusDp, context);
        drawable.setStroke(dp(context, 1), stroke);
        return drawable;
    }

    public static TextView label(Context context, String text, float sp, int color, boolean bold) {
        TextView view = new TextView(context);
        view.setText(text);
        view.setTextSize(sp);
        view.setTextColor(color);
        view.setGravity(Gravity.CENTER_VERTICAL);
        view.setTypeface(Typeface.create("sans-serif", bold ? Typeface.BOLD : Typeface.NORMAL));
        view.setIncludeFontPadding(false);
        return view;
    }

    public static void setPadding(View view, float horizontalDp, float verticalDp) {
        int h = dp(view.getContext(), horizontalDp);
        int v = dp(view.getContext(), verticalDp);
        view.setPadding(h, v, h, v);
    }
}

