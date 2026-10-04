# 001 — Conservatory Above the Sea

## Status

Approved portrait recovered; separately composed landscape completed for the
Blaze Wallpapers catalog.

## Creation

- Method: OpenAI image generation from the user's approved art direction.
- Portrait source: `Sunlit Conservatory Above the Sea.png`
  (`697f1a618a5ea1c936b902f286388b246e1cac96c62254c75fcd3bf2edb9d3d8`).
- Landscape source: independently generated 16:9 composition
  (`a1b7897a858ac9024dc2f401bf653a7390f06299e939d353ed2362a3bc0d6027`).
- Final preparation: proportional Lanczos upscale, centered aspect trim, light
  sharpening, sRGB conversion, and WebP export.

## Deliverables

- `exports/2160x3840/sunroom-reverie-001-conservatory-above-the-sea-portrait-2160x3840.webp`
- `exports/3840x2160/sunroom-reverie-001-conservatory-above-the-sea-landscape-3840x2160.webp`

## 2026-10-04 landscape export reconstruction

The landscape export originally committed in PR #4 at `a2d3b8e6af06300407b5722e638f9f1dab93ef1b` was truncated.
Its Git blob `9d9e09f1cbd7c93588371c3713cc0d10ed796b4d` is 786444 bytes,
while its RIFF header declares 862558 bytes; full decoding fails.
This record accompanies a complete reconstructed replacement.
Independent review and integration are tracked separately.

### Exact recovered source

- Original PNG: `Sunlit Mediterranean Glass Conservatory.png`
- Native source dimensions: 1672 × 940
- Source SHA-256: `a1b7897a858ac9024dc2f401bf653a7390f06299e939d353ed2362a3bc0d6027`
- Source identity exactly matches the landscape hash above; original bytes remain unchanged
- No artwork regeneration, new objects, composition redraw, or generative enlargement

### Reconstruction settings and limits

The earlier recipe specifies Lanczos scaling, centered aspect trim, light
sharpening, sRGB conversion, and WebP output, but does not supply numeric
encoder/sharpening settings. The following are explicit reconstruction choices,
not recovered historical values, and do not promise byte-identical reproduction.

- Target: 3840 × 2160; proportional cover scale 2.297872340426
- Centered continuous source crop box: [0.44444444444457076, 5.684341886080802e-14, 1671.5555555555554, 940.0]
- Crop and proportional upscale combined in one Pillow Lanczos resampling pass
- Unsharp mask: radius 1.0, amount 50%, threshold 3
- Untagged RGB PNG interpreted as sRGB; absent source ICC means its color intent cannot independently be established
- Explicit sRGB-to-sRGB LittleCMS conversion, RGB output, embedded sRGB ICC
- WebP: lossy, quality 95, method 6, exact=true
- Pillow 12.3.0; libwebp 1.6.0; LittleCMS 2.19
- ICC SHA-256: `6f6fe5cc53cd24ceeb7997fb24ce2889fdfb88d88ce4fdc5f8e25e0481294953`; creation-date header fixed to 2000-01-01 for deterministic metadata

This is a **reconstructed upscaled 4K export**, not native 4K. Resizing does not
establish premium-quality or storefront-release acceptance. The three repaired
landscapes and the exact resulting repository revision still require review.

### Reconstructed export identity and author-session checks

- Bytes: 2197210 (RIFF-declared total equals actual length)
- SHA-256: `5c2d16b8f98174c77bd2200239fb961a235f3a4033e3981bddb5f742eafb6a89`
- Git blob SHA-1: `34aa44239a4a5f68b10c2a05b2e0b35fbbccbf8a`
- Full Pillow and FFmpeg decoding: pass; exact 3840 × 2160; opaque RGB; embedded sRGB
- Repeat in-memory reconstruction produces identical full bytes
- Original source and candidate whole-image/detail inspection performed in the author session; not independent review

Only this landscape and its provenance change in this repair. Portrait and
other PR #4 exports retain their pinned Git blob identities. These author-session
checks do not establish independent review, exact remote-revision validation,
device acceptance, merge, or storefront publication.
