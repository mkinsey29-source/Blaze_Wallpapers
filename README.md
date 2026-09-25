# Blaze Wallpaper Bundles

Blaze creates original premium wallpaper theme bundles for direct download.
The Android app is no longer the active product; the prototype remains in this
repository for reference while new work focuses on finished artwork packs for
Etsy and other storefronts.

## Bundle standard

Each approved scene is delivered as two separately composed wallpapers:

- Portrait: `2160x3840` WebP (`9:16`)
- Landscape: `3840x2160` WebP (`16:9`)

Landscape versions are not crops or stretched copies of portrait artwork.
Final wallpapers contain no device mockups, text, logos, or watermarks.
Optional parallax releases include a flattened wallpaper plus registered source
layers, configuration, and a motion preview.

## Theme collections

Current and developing collections include:

- Ember Moon
- Neon Solitude
- Wild Presence
- Christmas Skater
- Sunroom Reverie
- Skyloom Festival
- Solar Pursuit
- Against the Gale

## Asset layout

Artwork is organized under `assets/wallpapers/<theme>/<scene>/`:

- `masters/` — original working files retained for future editing
- `exports/2160x3840/` — customer-ready portrait wallpapers
- `exports/3840x2160/` — customer-ready landscape wallpapers
- `parallax/` — optional layered sources, configuration, and previews
- `PROVENANCE.md` — generation, editing, rights, and quality-control notes

Storefront bundles ship from `exports/`. Masters and app-bundled copies are not
customer deliverables.

## Release checks

Before a wallpaper enters a bundle, confirm:

- exact dimensions and sRGB color
- independent portrait and landscape composition
- clean edges and convincing physical contact, water, shadows, and motion
- no unintended text, logos, watermarks, or duplicated artifacts
- complete provenance and licensing notes

## Archived Android prototype

The Java Android prototype and its build workflow remain in the repository as
historical reference. They are not the current product direction.
