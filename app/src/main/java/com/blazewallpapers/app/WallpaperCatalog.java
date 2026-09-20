package com.blazewallpapers.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class WallpaperCatalog {
    private static final List<Wallpaper> ITEMS = Collections.unmodifiableList(Arrays.asList(
            new Wallpaper(
                    "rooftop-silence",
                    "NEON SOLITUDE",
                    "Rain above the city. One empty chair. A view that belongs to no one.",
                    "STATIC",
                    "thumbnails/rooftop_silence.webp",
                    "wallpapers/rooftop_silence_lock.webp",
                    "wallpapers/rooftop_silence_home.webp",
                    0xFF66D9FF,
                    true
            ),
            new Wallpaper(
                    "solitary-station",
                    "NEON SOLITUDE",
                    "A quiet cyan refuge glowing against a rain-dark mountain road.",
                    "STATIC",
                    "thumbnails/solitary_station.webp",
                    "wallpapers/solitary_station_lock.webp",
                    "wallpapers/solitary_station_home.webp",
                    0xFF25D9FF,
                    false
            ),
            new Wallpaper(
                    "last-bus",
                    "NEON SOLITUDE",
                    "The road is empty, the shelter is warm, and the final bus is gone.",
                    "STATIC",
                    "thumbnails/last_bus.webp",
                    "wallpapers/last_bus_lock.webp",
                    "wallpapers/last_bus_home.webp",
                    0xFFFFB55F,
                    false
            ),
            new Wallpaper(
                    "ember-moon-courier",
                    "EMBER MOON",
                    "A courier draws an ember ring across a rain-dark moonlit crossing.",
                    "STATIC",
                    "thumbnails/ember_moon_courier.webp",
                    "wallpapers/ember_moon_courier_lock.webp",
                    "wallpapers/ember_moon_courier_home.webp",
                    0xFFFF7A26,
                    false
            ),
            new Wallpaper(
                    "ember-moon-bell-keeper",
                    "EMBER MOON",
                    "A solitary keeper rides a suspended bell above the lantern city.",
                    "STATIC",
                    "thumbnails/ember_moon_bell_keeper.webp",
                    "wallpapers/ember_moon_bell_keeper_lock.webp",
                    "wallpapers/ember_moon_bell_keeper_home.webp",
                    0xFFFF9D32,
                    false
            ),
            new Wallpaper(
                    "ember-moon-sky-fisher",
                    "EMBER MOON",
                    "An ember line traces living light through a flooded city beneath the moon.",
                    "STATIC",
                    "thumbnails/ember_moon_sky_fisher.webp",
                    "wallpapers/ember_moon_sky_fisher_lock.webp",
                    "wallpapers/ember_moon_sky_fisher_home.webp",
                    0xFFFF7A26,
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
