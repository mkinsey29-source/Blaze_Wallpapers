package com.blazewallpapers.app;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

public final class ViewOutlineProviders {
    public static final ViewOutlineProvider ROUNDED_24 = new ViewOutlineProvider() {
        @Override
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), Ui.dp(view.getContext(), 24));
        }
    };

    private ViewOutlineProviders() {}
}

