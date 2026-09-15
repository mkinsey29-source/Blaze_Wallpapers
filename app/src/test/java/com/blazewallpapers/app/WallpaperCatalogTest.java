package com.blazewallpapers.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public final class WallpaperCatalogTest {
    @Test
    public void catalogContainsThreeUniqueDeviceFittedPairs() {
        assertEquals(3, WallpaperCatalog.all().size());
        Set<String> ids = new HashSet<>();
        int featured = 0;

        for (Wallpaper wallpaper : WallpaperCatalog.all()) {
            assertTrue(ids.add(wallpaper.id()));
            assertTrue(wallpaper.lockAsset().endsWith("_lock.webp"));
            assertTrue(wallpaper.homeAsset().endsWith("_home.webp"));
            assertTrue(wallpaper.thumbnailAsset().startsWith("thumbnails/"));
            if (wallpaper.featured()) featured++;
        }

        assertEquals(1, featured);
    }

    @Test
    public void rooftopSilenceIsTheFeaturedHero() {
        Wallpaper wallpaper = WallpaperCatalog.find("rooftop-silence");
        assertNotNull(wallpaper);
        assertTrue(wallpaper.featured());
        assertEquals("Rooftop Silence", wallpaper.title());
    }
}

