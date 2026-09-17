package com.blazewallpapers.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public final class MainActivity extends Activity {
    private LinearLayout catalogContainer;
    private TextView favoriteCount;
    private TextView allFilter;
    private TextView favoritesFilter;
    private FavoriteStore favoriteStore;
    private boolean showingFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureWindow();
        favoriteStore = new FavoriteStore(this);
        setContentView(buildScreen());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (catalogContainer != null) renderCatalog();
    }

    private void configureWindow() {
        Window window = getWindow();
        window.setStatusBarColor(Ui.BG);
        window.setNavigationBarColor(Ui.BG);
        window.getDecorView().setSystemUiVisibility(0);
    }

    private View buildScreen() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Ui.BG);
        root.setOnApplyWindowInsetsListener((view, insets) -> {
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

        root.addView(buildHeader(), new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setClipToPadding(false);
        scroll.setVerticalScrollBarEnabled(false);

        catalogContainer = new LinearLayout(this);
        catalogContainer.setOrientation(LinearLayout.VERTICAL);
        catalogContainer.setPadding(Ui.dp(this, 18), 0, Ui.dp(this, 18), Ui.dp(this, 30));
        scroll.addView(catalogContainer, new ScrollView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        root.addView(scroll, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f));
        renderCatalog();
        return root;
    }

    private View buildHeader() {
        LinearLayout outer = new LinearLayout(this);
        outer.setOrientation(LinearLayout.VERTICAL);
        outer.setPadding(Ui.dp(this, 20), Ui.dp(this, 18), Ui.dp(this, 20), Ui.dp(this, 12));

        LinearLayout titleRow = new LinearLayout(this);
        titleRow.setGravity(Gravity.CENTER_VERTICAL);

        LinearLayout titles = new LinearLayout(this);
        titles.setOrientation(LinearLayout.VERTICAL);
        TextView brand = Ui.label(this, "BLAZE", 11, Ui.CYAN, true);
        brand.setLetterSpacing(0.22f);
        TextView title = Ui.label(this, "Wallpapers", 28, Ui.TEXT, true);
        titles.addView(brand);
        titles.addView(title);
        titleRow.addView(titles, new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));

        favoriteCount = Ui.label(this, "", 13, Ui.TEXT, true);
        favoriteCount.setGravity(Gravity.CENTER);
        favoriteCount.setBackground(Ui.outlined(Ui.PANEL, 0xFF2C3B4D, 18, this));
        Ui.setPadding(favoriteCount, 13, 9);
        titleRow.addView(favoriteCount);
        outer.addView(titleRow);

        TextView collection = Ui.label(this, "NEON SOLITUDE  ·  VOLUME 01", 11, Ui.MUTED, true);
        collection.setLetterSpacing(0.08f);
        LinearLayout.LayoutParams collectionParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        collectionParams.topMargin = Ui.dp(this, 14);
        outer.addView(collection, collectionParams);

        LinearLayout filters = new LinearLayout(this);
        filters.setOrientation(LinearLayout.HORIZONTAL);
        allFilter = filterChip("All", false);
        favoritesFilter = filterChip("Favorites", true);
        filters.addView(allFilter);
        LinearLayout.LayoutParams favoriteParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        favoriteParams.leftMargin = Ui.dp(this, 8);
        filters.addView(favoritesFilter, favoriteParams);
        LinearLayout.LayoutParams filtersParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        filtersParams.topMargin = Ui.dp(this, 14);
        outer.addView(filters, filtersParams);

        updateFilters();
        return outer;
    }

    private TextView filterChip(String label, boolean favorites) {
        TextView chip = Ui.label(this, label, 13, Ui.TEXT, true);
        chip.setGravity(Gravity.CENTER);
        Ui.setPadding(chip, 17, 9);
        chip.setOnClickListener(view -> {
            showingFavorites = favorites;
            updateFilters();
            renderCatalog();
        });
        return chip;
    }

    private void updateFilters() {
        if (allFilter == null || favoritesFilter == null) return;
        allFilter.setBackground(Ui.outlined(
                showingFavorites ? Ui.PANEL : 0xFF173647,
                showingFavorites ? 0xFF2A3747 : Ui.CYAN, 18, this));
        favoritesFilter.setBackground(Ui.outlined(
                showingFavorites ? 0xFF173647 : Ui.PANEL,
                showingFavorites ? Ui.CYAN : 0xFF2A3747, 18, this));
    }

    private void renderCatalog() {
        if (catalogContainer == null) return;
        catalogContainer.removeAllViews();
        favoriteCount.setText("♥  " + favoriteStore.count());

        List<Wallpaper> visible = new ArrayList<>();
        for (Wallpaper wallpaper : WallpaperCatalog.all()) {
            if (!showingFavorites || favoriteStore.contains(wallpaper.id())) visible.add(wallpaper);
        }

        if (visible.isEmpty()) {
            TextView empty = Ui.label(this, "No favorites yet\nTap a wallpaper, then press the heart.", 16, Ui.MUTED, false);
            empty.setGravity(Gravity.CENTER);
            empty.setBackground(Ui.outlined(Ui.PANEL, 0xFF253445, 22, this));
            Ui.setPadding(empty, 24, 48);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.topMargin = Ui.dp(this, 8);
            catalogContainer.addView(empty, params);
            return;
        }

        for (Wallpaper wallpaper : visible) {
            catalogContainer.addView(buildCard(wallpaper), cardParams(wallpaper.featured()));
        }
    }

    private LinearLayout.LayoutParams cardParams(boolean featured) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, Ui.dp(this, featured ? 430 : 315));
        params.topMargin = Ui.dp(this, 10);
        return params;
    }

    private View buildCard(Wallpaper wallpaper) {
        FrameLayout card = new FrameLayout(this);
        card.setClipToOutline(true);
        card.setBackground(Ui.rounded(Ui.PANEL, 24, this));
        card.setOutlineProvider(ViewOutlineProviders.ROUNDED_24);
        card.setContentDescription("Open " + WallpaperCatalog.COLLECTION_NAME
                + " " + wallpaper.typeLabel().toLowerCase() + " wallpaper");

        ImageView image = new ImageView(this);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setBackgroundColor(Ui.PANEL_LIGHT);
        AssetImages.load(image, wallpaper.thumbnailAsset());
        card.addView(image, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        View scrim = new View(this);
        GradientDrawable gradient = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{0x05000000, 0x16000000, 0xD9000000});
        gradient.setCornerRadius(Ui.dp(this, 24));
        scrim.setBackground(gradient);
        card.addView(scrim, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        if (wallpaper.featured()) {
            TextView badge = Ui.label(this, "FEATURED", 10, Color.BLACK, true);
            badge.setLetterSpacing(0.12f);
            badge.setGravity(Gravity.CENTER);
            badge.setBackground(Ui.rounded(wallpaper.accentColor(), 14, this));
            Ui.setPadding(badge, 11, 7);
            FrameLayout.LayoutParams badgeParams = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.TOP | Gravity.START);
            badgeParams.setMargins(Ui.dp(this, 16), Ui.dp(this, 16), 0, 0);
            card.addView(badge, badgeParams);
        }

        TextView heart = Ui.label(this, favoriteStore.contains(wallpaper.id()) ? "♥" : "♡", 23, Ui.TEXT, true);
        heart.setGravity(Gravity.CENTER);
        heart.setBackground(Ui.rounded(0x99070B12, 22, this));
        FrameLayout.LayoutParams heartParams = new FrameLayout.LayoutParams(
                Ui.dp(this, 44), Ui.dp(this, 44), Gravity.TOP | Gravity.END);
        heartParams.setMargins(0, Ui.dp(this, 12), Ui.dp(this, 12), 0);
        card.addView(heart, heartParams);
        heart.setOnClickListener(view -> {
            favoriteStore.toggle(wallpaper.id());
            renderCatalog();
        });

        TextView type = Ui.label(this, wallpaper.typeLabel(), 10, Ui.TEXT, true);
        type.setLetterSpacing(0.12f);
        type.setGravity(Gravity.CENTER);
        type.setBackground(Ui.outlined(0xC9070B12, 0x663D5268, 14, this));
        Ui.setPadding(type, 11, 7);
        FrameLayout.LayoutParams typeParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM | Gravity.START);
        typeParams.setMargins(Ui.dp(this, 16), 0, 0, Ui.dp(this, 16));
        card.addView(type, typeParams);

        card.setOnClickListener(view -> {
            Intent intent = new Intent(this, PreviewActivity.class);
            intent.putExtra(PreviewActivity.EXTRA_WALLPAPER_ID, wallpaper.id());
            startActivity(intent);
        });
        return card;
    }
}
