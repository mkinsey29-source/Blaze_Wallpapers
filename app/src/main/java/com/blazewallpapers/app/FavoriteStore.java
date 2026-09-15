package com.blazewallpapers.app;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class FavoriteStore {
    private static final String FILE_NAME = "blaze_favorites";
    private static final String KEY_IDS = "wallpaper_ids";

    private final SharedPreferences preferences;

    public FavoriteStore(Context context) {
        preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public boolean contains(String id) {
        return preferences.getStringSet(KEY_IDS, Collections.emptySet()).contains(id);
    }

    public boolean toggle(String id) {
        Set<String> current = new HashSet<>(
                preferences.getStringSet(KEY_IDS, Collections.emptySet()));
        boolean favorite;
        if (current.contains(id)) {
            current.remove(id);
            favorite = false;
        } else {
            current.add(id);
            favorite = true;
        }
        preferences.edit().putStringSet(KEY_IDS, current).apply();
        return favorite;
    }

    public int count() {
        return preferences.getStringSet(KEY_IDS, Collections.emptySet()).size();
    }
}
