package com.blazewallpapers.app;

import java.util.Objects;

public final class Wallpaper {
    private final String id;
    private final String collectionLabel;
    private final String description;
    private final String typeLabel;
    private final String thumbnailAsset;
    private final String lockAsset;
    private final String homeAsset;
    private final int accentColor;
    private final boolean featured;

    public Wallpaper(
            String id,
            String collectionLabel,
            String description,
            String typeLabel,
            String thumbnailAsset,
            String lockAsset,
            String homeAsset,
            int accentColor,
            boolean featured
    ) {
        this.id = Objects.requireNonNull(id);
        this.collectionLabel = Objects.requireNonNull(collectionLabel);
        this.description = Objects.requireNonNull(description);
        this.typeLabel = Objects.requireNonNull(typeLabel);
        this.thumbnailAsset = Objects.requireNonNull(thumbnailAsset);
        this.lockAsset = Objects.requireNonNull(lockAsset);
        this.homeAsset = Objects.requireNonNull(homeAsset);
        this.accentColor = accentColor;
        this.featured = featured;
    }

    public String id() { return id; }
    public String collectionLabel() { return collectionLabel; }
    public String description() { return description; }
    public String typeLabel() { return typeLabel; }
    public String thumbnailAsset() { return thumbnailAsset; }
    public String lockAsset() { return lockAsset; }
    public String homeAsset() { return homeAsset; }
    public int accentColor() { return accentColor; }
    public boolean featured() { return featured; }
}
