# 003 — Cloudgarden Studio

## Status

Approved portrait recovered; separately composed landscape completed for the
Blaze Wallpapers catalog.

## Creation

- Method: OpenAI image generation from the user's approved art direction.
- Portrait source: `Cloudgarden Studio in Bloom.png`
  (`3511c4148b59827a9a64591db431e80f66b41565f69de41ab250d7325c0d41b7`).
- Landscape source: independently generated 16:9 composition
  (`673c400ed947d03c02c0188169df091442454c9d636fe62e9c9a5f4c4788c403`).
- Final preparation: proportional Lanczos upscale, centered aspect trim, light
  sharpening, sRGB conversion, and WebP export.

## Deliverables

- `exports/2160x3840/sunroom-reverie-003-cloudgarden-studio-portrait-2160x3840.webp`
- `exports/3840x2160/sunroom-reverie-003-cloudgarden-studio-landscape-3840x2160.webp`

## 2026-10-04 landscape export reconstruction

The landscape export originally committed in PR #4 at `a2d3b8e6af06300407b5722e638f9f1dab93ef1b` was truncated.
Its Git blob `f484fe4b1c3d5ff7ad465b9060c96cf7e782e8a7` is 786445 bytes,
while its RIFF header declares 941364 bytes; full decoding fails.
This record accompanies a complete reconstructed replacement.
Independent review and integration are tracked separately.

### Exact recovered source

- Original PNG: `Blooming Glasshouse Studio Overlooking the Valley.png`
- Native source dimensions: 1672 × 941
- Source SHA-256: `673c400ed947d03c02c0188169df091442454c9d636fe62e9c9a5f4c4788c403`
- Source identity exactly matches the landscape hash above; original bytes remain unchanged
- No artwork regeneration, new objects, composition redraw, or generative enlargement

### Reconstruction settings and limits

The earlier recipe specifies Lanczos scaling, centered aspect trim, light
sharpening, sRGB conversion, and WebP output, but does not supply numeric
encoder/sharpening settings. The following are explicit reconstruction choices,
not recovered historical values, and do not promise byte-identical reproduction.

- Target: 3840 × 2160; proportional cover scale 2.296650717703
- Centered continuous source crop box: [0.0, 0.25, 1672.0, 940.75]
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

- Bytes: 2456910 (RIFF-declared total equals actual length)
- SHA-256: `1042f63ee951c0fc73a87a81800f73e84b8c4568c56bf01216dae0ded819a4b7`
- Git blob SHA-1: `44ef34e3107653f7e1b383a91b76bb745c469da7`
- Full Pillow and FFmpeg decoding: pass; exact 3840 × 2160; opaque RGB; embedded sRGB
- Repeat in-memory reconstruction produces identical full bytes
- Original source and candidate whole-image/detail inspection performed in the author session; not independent review

Only this landscape and its provenance change in this repair. Portrait and
other PR #4 exports retain their pinned Git blob identities. These author-session
checks do not establish independent review, exact remote-revision validation,
device acceptance, merge, or storefront publication.
