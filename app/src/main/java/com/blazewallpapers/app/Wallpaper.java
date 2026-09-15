package com.blazewallpapers.app;

import java.util.Objects;

public final class Wallpaper {
    private final String id;
    private final String title;
    private final String description;
    private final String thumbnailAsset;
    private final String lockAsset;
    private final String homeAsset;
    private final int accentColor;
    private final boolean featured;

    public Wallpaper(
            String id,
            String title,
            String description,
            String thumbnailAsset,
            String lockAsset,
            String homeAsset,
            int accentColor,
            boolean featured
    ) {
        this.id = Objects.requireNonNull(id);
        this.title = Objects.requireNonNull(title);
        this.description = Objects.requireNonNull(description);
        this.thumbnailAsset = Objects.requireNonNull(thumbnailAsset);
        this.lockAsset = Objects.requireNonNull(lockAsset);
        this.homeAsset = Objects.requireNonNull(homeAsset);
        this.accentColor = accentColor;
        this.featured = featured;
    }

    public String id() { return id; }
    public String title() { return title; }
    public String description() { return description; }
    public String thumbnailAsset() { return thumbnailAsset; }
    public String lockAsset() { return lockAsset; }
    public String homeAsset() { return homeAsset; }
    public int accentColor() { return accentColor; }
    public boolean featured() { return featured; }
}

