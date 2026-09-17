package com.blazewallpapers.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public final class PreviewActivity extends Activity {
    public static final String EXTRA_WALLPAPER_ID = "wallpaper_id";

    private static final int TARGET_HOME = 1;
    private static final int TARGET_LOCK = 2;
    private static final int TARGET_BOTH = 3;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final AtomicInteger imageRequest = new AtomicInteger();

    private Wallpaper wallpaper;
    private FavoriteStore favoriteStore;
    private ImageView preview;
    private TextView favoriteButton;
    private Bitmap displayedBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String id = getIntent().getStringExtra(EXTRA_WALLPAPER_ID);
        wallpaper = WallpaperCatalog.find(id);
        if (wallpaper == null) {
            finish();
            return;
        }
        favoriteStore = new FavoriteStore(this);
        configureWindow();
        setContentView(buildScreen());
        loadPreview(wallpaper.lockAsset());
    }

    @Override
    protected void onDestroy() {
        imageRequest.incrementAndGet();
        executor.shutdownNow();
        if (displayedBitmap != null && !displayedBitmap.isRecycled()) displayedBitmap.recycle();
        super.onDestroy();
    }

    private void configureWindow() {
        Window window = getWindow();
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Ui.BG);
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private View buildScreen() {
        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Ui.BG);

        preview = new ImageView(this);
        preview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        preview.setBackgroundColor(Ui.PANEL);
        root.addView(preview, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        View shade = new View(this);
        shade.setBackground(new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{0x88000000, 0x00000000, 0x18000000, 0xF0000000}));
        root.addView(shade, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        LinearLayout chrome = new LinearLayout(this);
        chrome.setOrientation(LinearLayout.VERTICAL);
        chrome.setGravity(Gravity.FILL);
        chrome.setOnApplyWindowInsetsListener((view, insets) -> {
            int top;
            int bottom;
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                android.graphics.Insets bars = insets.getInsets(WindowInsets.Type.systemBars());
                top = bars.top;
                bottom = bars.bottom;
            } else {
                top = insets.getSystemWindowInsetTop();
                bottom = insets.getSystemWindowInsetBottom();
            }
            view.setPadding(0, top, 0, bottom);
            return insets;
        });
        chrome.addView(buildTopBar(), new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        chrome.addView(new View(this), new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f));
        chrome.addView(buildBottomPanel(), new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        root.addView(chrome, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return root;
    }

    private View buildTopBar() {
        LinearLayout row = new LinearLayout(this);
        row.setGravity(Gravity.CENTER_VERTICAL);
        row.setPadding(Ui.dp(this, 14), Ui.dp(this, 12), Ui.dp(this, 14), Ui.dp(this, 8));

        TextView back = circularButton("‹", 30);
        back.setContentDescription("Back");
        back.setOnClickListener(view -> finish());
        row.addView(back, new LinearLayout.LayoutParams(Ui.dp(this, 46), Ui.dp(this, 46)));

        TextView collection = Ui.label(this, WallpaperCatalog.COLLECTION_NAME, 11, Ui.TEXT, true);
        collection.setLetterSpacing(0.12f);
        collection.setGravity(Gravity.CENTER);
        row.addView(collection, new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));

        favoriteButton = circularButton(favoriteStore.contains(wallpaper.id()) ? "♥" : "♡", 24);
        favoriteButton.setContentDescription("Toggle favorite");
        favoriteButton.setOnClickListener(view -> {
            boolean favorite = favoriteStore.toggle(wallpaper.id());
            favoriteButton.setText(favorite ? "♥" : "♡");
        });
        row.addView(favoriteButton, new LinearLayout.LayoutParams(Ui.dp(this, 46), Ui.dp(this, 46)));
        return row;
    }

    private TextView circularButton(String text, float sizeSp) {
        TextView view = Ui.label(this, text, sizeSp, Ui.TEXT, true);
        view.setGravity(Gravity.CENTER);
        view.setBackground(Ui.outlined(0xAA070B12, 0x553D5268, 23, this));
        return view;
    }

    private View buildBottomPanel() {
        LinearLayout panel = new LinearLayout(this);
        panel.setOrientation(LinearLayout.VERTICAL);
        panel.setPadding(Ui.dp(this, 20), Ui.dp(this, 28), Ui.dp(this, 20), Ui.dp(this, 18));

        TextView type = Ui.label(this, wallpaper.typeLabel() + " WALLPAPER", 11, Ui.CYAN, true);
        type.setLetterSpacing(0.12f);
        LinearLayout.LayoutParams typeParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        panel.addView(type, typeParams);

        TextView destinationPrompt = Ui.label(
                this, "Where would you like to use it?", 14, 0xFFD2DAE4, false);
        LinearLayout.LayoutParams promptParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        promptParams.topMargin = Ui.dp(this, 9);
        panel.addView(destinationPrompt, promptParams);

        LinearLayout actions = new LinearLayout(this);
        actions.setOrientation(LinearLayout.HORIZONTAL);
        actions.addView(applyButton("HOME", TARGET_HOME), new LinearLayout.LayoutParams(0, Ui.dp(this, 52), 1f));
        LinearLayout.LayoutParams middle = new LinearLayout.LayoutParams(0, Ui.dp(this, 52), 1f);
        middle.leftMargin = Ui.dp(this, 8);
        actions.addView(applyButton("LOCK", TARGET_LOCK), middle);
        LinearLayout.LayoutParams last = new LinearLayout.LayoutParams(0, Ui.dp(this, 52), 1f);
        last.leftMargin = Ui.dp(this, 8);
        actions.addView(applyButton("BOTH", TARGET_BOTH), last);
        LinearLayout.LayoutParams actionsParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        actionsParams.topMargin = Ui.dp(this, 17);
        panel.addView(actions, actionsParams);
        return panel;
    }

    private TextView applyButton(String text, int target) {
        boolean primary = target == TARGET_BOTH;
        TextView button = Ui.label(this, text, 12, primary ? Color.BLACK : Ui.TEXT, true);
        button.setLetterSpacing(0.07f);
        button.setGravity(Gravity.CENTER);
        button.setBackground(Ui.outlined(
                primary ? Ui.CYAN : 0xDD172230,
                primary ? Ui.CYAN : 0xFF34475B,
                16,
                this
        ));
        button.setOnClickListener(view -> confirmApply(target));
        return button;
    }

    private void loadPreview(String assetPath) {
        int request = imageRequest.incrementAndGet();
        executor.execute(() -> {
            try {
                Bitmap decoded = AssetImages.decode(this, assetPath);
                mainHandler.post(() -> {
                    if (request != imageRequest.get() || isFinishing()) {
                        decoded.recycle();
                        return;
                    }
                    Bitmap previous = displayedBitmap;
                    displayedBitmap = decoded;
                    preview.setImageBitmap(decoded);
                    if (previous != null && previous != decoded && !previous.isRecycled()) previous.recycle();
                });
            } catch (IOException error) {
                mainHandler.post(() -> Toast.makeText(this, R.string.image_load_failed, Toast.LENGTH_LONG).show());
            }
        });
    }

    private void confirmApply(int target) {
        String destination = target == TARGET_HOME ? "home screen"
                : target == TARGET_LOCK ? "lock screen" : "home and lock screens";
        new AlertDialog.Builder(this)
                .setTitle("Apply this wallpaper?")
                .setMessage("This will replace the wallpaper on your " + destination + ".")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Apply", (dialog, which) -> applyWallpaper(target))
                .show();
    }

    private void applyWallpaper(int target) {
        Dialog progress = progressDialog();
        progress.show();
        executor.execute(() -> {
            try {
                WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
                if (target == TARGET_HOME || target == TARGET_BOTH) {
                    Bitmap home = AssetImages.decode(this, wallpaper.homeAsset());
                    manager.setBitmap(home, null, true, WallpaperManager.FLAG_SYSTEM);
                    home.recycle();
                }
                if (target == TARGET_LOCK || target == TARGET_BOTH) {
                    Bitmap lock = AssetImages.decode(this, wallpaper.lockAsset());
                    manager.setBitmap(lock, null, true, WallpaperManager.FLAG_LOCK);
                    lock.recycle();
                }
                mainHandler.post(() -> {
                    progress.dismiss();
                    Toast.makeText(this, "Wallpaper applied", Toast.LENGTH_SHORT).show();
                });
            } catch (Exception error) {
                mainHandler.post(() -> {
                    progress.dismiss();
                    new AlertDialog.Builder(this)
                            .setTitle("Could not apply wallpaper")
                            .setMessage(error.getMessage() == null
                                    ? "Your device rejected the wallpaper change."
                                    : error.getMessage())
                            .setPositiveButton("OK", null)
                            .show();
                });
            }
        });
    }

    private Dialog progressDialog() {
        Dialog dialog = new Dialog(this);
        TextView message = Ui.label(this, "Preparing full-resolution wallpaper…", 15, Ui.TEXT, true);
        message.setGravity(Gravity.CENTER);
        message.setBackground(Ui.outlined(0xFF111925, 0xFF34475B, 20, this));
        Ui.setPadding(message, 26, 22);
        dialog.setContentView(message);
        dialog.setCancelable(false);
        Window window = dialog.getWindow();
        if (window != null) window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }
}
