package com.blazewallpapers.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class WallpaperCatalog {
    public static final String COLLECTION_NAME = "NEON SOLITUDE";

    private static final List<Wallpaper> ITEMS = Collections.unmodifiableList(Arrays.asList(
            new Wallpaper(
                    "rooftop-silence",
                    "Rooftop Silence",
                    "Rain above the city. One empty chair. A view that belongs to no one.",
                    "thumbnails/rooftop_silence.webp",
                    "wallpapers/rooftop_silence_lock.webp",
                    "wallpapers/rooftop_silence_home.webp",
                    0xFF66D9FF,
                    true
            ),
            new Wallpaper(
                    "solitary-station",
                    "Solitary Station",
                    "A quiet cyan refuge glowing against a rain-dark mountain road.",
                    "thumbnails/solitary_station.webp",
                    "wallpapers/solitary_station_lock.webp",
                    "wallpapers/solitary_station_home.webp",
                    0xFF25D9FF,
                    false
            ),
            new Wallpaper(
                    "last-bus",
                    "Last Bus",
                    "The road is empty, the shelter is warm, and the final bus is gone.",
                    "thumbnails/last_bus.webp",
                    "wallpapers/last_bus_lock.webp",
                    "wallpapers/last_bus_home.webp",
                    0xFFFFB55F,
                    false
            )
    ));

    private WallpaperCatalog() {}

    public static List<Wallpaper> all() {
        return ITEMS;
    }

    public static Wallpaper find(String id) {
        for (Wallpaper wallpaper : ITEMS) {
            if (wallpaper.id().equals(id)) return wallpaper;
        }
        return null;
    }
}

