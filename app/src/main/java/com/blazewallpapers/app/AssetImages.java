package com.blazewallpapers.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class AssetImages {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);

    private AssetImages() {}

    public static Bitmap decode(Context context, String assetPath) throws IOException {
        try (InputStream input = context.getAssets().open(assetPath)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeStream(input, null, options);
            if (bitmap == null) throw new IOException("Unable to decode " + assetPath);
            return bitmap;
        }
    }

    public static void load(ImageView target, String assetPath) {
        target.setTag(assetPath);
        EXECUTOR.execute(() -> {
            try {
                Bitmap bitmap = decode(target.getContext(), assetPath);
                target.post(() -> {
                    if (assetPath.equals(target.getTag())) {
                        target.setImageBitmap(bitmap);
                    } else {
                        bitmap.recycle();
                    }
                });
            } catch (IOException ignored) {
                target.post(() -> target.setBackgroundColor(Ui.PANEL_LIGHT));
            }
        });
    }
}

