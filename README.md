# Blaze Wallpapers

An Android-first premium wallpaper app built around original, device-fitted
static and parallax collections.

## Android vertical slice

The first test build is intentionally offline and contains the three approved
Neon Solitude wallpaper pairs:

- Rooftop Silence (featured)
- Solitary Station
- Last Bus

The app provides a premium gallery, favorites, separate lock/home previews, and
direct Home, Lock, or Both application through Android's `WallpaperManager`.
No account, network service, analytics, advertising, or payment SDK is included
in this build.

### Build

The project uses Java 17, Android Gradle Plugin 9.4, `compileSdk`/`targetSdk` 36,
and a minimum SDK of 26. A GitHub Actions workflow builds and uploads a numbered
debug APK on pushes and pull requests.

```sh
gradle testDebugUnitTest lintDebug assembleDebug
```

The initial package identifier is `com.blazewallpapers.app`.

## Collections

- `Neon Solitude` — quiet nighttime environments with restrained neon light,
  rain, reflections, fog, and uncluttered areas for phone UI.

## Asset layout

Each wallpaper has its own numbered directory containing:

- `masters/` — original working images retained without replacement.
- `exports/<resolution>/` — device-ready lock-screen and home-screen files.
- `PROVENANCE.md` — generation, editing, rights, and quality-control notes.

Do not publish a master directly. Application builds and downloads should use
the files under `exports/`.

App-bundled copies live under `app/src/main/assets/`; thumbnails are separate
lower-memory derivatives so the gallery does not decode six full-resolution
images at once.
