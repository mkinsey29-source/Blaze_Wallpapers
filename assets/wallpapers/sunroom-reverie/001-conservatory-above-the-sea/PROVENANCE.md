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

## 2026-10-04 narrowly masked lettering correction

The owner authorized removal of the review-identified letter-like marks while preserving the rest of the artwork. This dated entry supersedes earlier current-export identities only for the exports below; earlier records and native source identities remain historical evidence.

OpenAI built-in imagegen supplied the replacement book-spine/boom-cover material from the actual export crops. Only the small described masks were composited onto the exact pre-correction decoded export with ImageMagick 7.1.1-43. The final WebPs use lossless encoding (method 6, quality 100), preserving every decoded RGB pixel outside the masks and avoiding global lossy re-encoding drift. The existing Sunroom sRGB ICC profile is retained; untagged Blue Cutter WebPs retain format-default sRGB. These remain edited, previously upscaled 4K exports, not native-4K generation. Larger files are an intentional consequence of pixel preservation.


### sunroom-landscape

- Native source retained unchanged: `Sunlit Mediterranean Glass Conservatory.png`, 1672 × 940; SHA-256 `a1b7897a858ac9024dc2f401bf653a7390f06299e939d353ed2362a3bc0d6027`
- Exact pre-correction export at `d29244d10525cca38fd39d78cef01efe15c321e2`: 2197210 bytes; SHA-256 `5c2d16b8f98174c77bd2200239fb961a235f3a4033e3981bddb5f742eafb6a89`; Git blob `34aa44239a4a5f68b10c2a05b2e0b35fbbccbf8a`
- Reference crop in that export (x, y, width, height): `[1130,1330,512,512]`; pixels were cropped without resizing
- Imagegen semantic edit result: 1254 × 1254; SHA-256 `c8b9ae9c3b6b6d3b2aac7d1474fea3f24795a6fc3b1e0d22fbc003f734da0ead`
- Generated crop alone was Lanczos-resampled to 512 × 512 to register with the original crop. The complete wallpaper was never resized, reframed, sharpened or regenerated in this correction
- Mask polygons in crop coordinates: `[[[174,229],[276,233],[276,245],[173,241]],[[161,249],[283,254],[283,265],[161,261]]]`; white on black, Gaussian blur sigma 1, 8-bit mask
- Nonzero mask support in full-export coordinates, inclusive: `[1288,1556,1416,1598]`; mask covers 4291 pixels
- Actual changed RGB pixels: 4111 of 8294400 (0.04956%); zero changed pixels outside the mask; 8290109 outside-mask pixels are exactly equal in all three RGB channels
- Corrected export: 3840 × 2160; 9090024 bytes; SHA-256 `4c31cb06282291c9e937669873236d7a0dc86d758f974a9668f58c6135c5fad1`; Git blob `eeb6042920e6100fced41b49708bdf0ea9f401cc`
- Full ImageMagick and FFmpeg decodes, dimensions, opacity, RIFF/chunk integrity, and lossless WebP-to-intermediate RGB equality: pass

Selected edit prompt:

Use case: precise-object-edit. Remove ONLY the dark fake lettering printed on the two warm beige book spines beneath the cup. Both spine faces are warm tan/cream parchment fabric, framed by dark blue-gray edging; the dark symbols are lettering, NOT the overall spine color. Reconstruct the tiny letter shapes with the SAME original warm beige material and lighting that directly surrounds the letters. Do NOT turn either spine gray or recolor the whole spine. Keep the original dark blue borders and both warm beige faces, grain, shading, edges, proportions and perspective. Keep the coffee cup, book pages, reflection, table, flowers, chair and all other pixels as close to identical as possible. Exact original square crop and alignment, no reframe, no crop, no new symbols or text.

### Review scope and limits

The author inspected full-size crop comparisons and the three completed exports. The selected prompts remove markings without adding text or symbols; color and edge continuity were checked around the masks. The three native PNGs remain byte-identical to their documented source hashes. All 20 pinned baseline exports were downloaded and fully decoded; the other 17 export identities remain unchanged in the candidate set.

These are author-session technical and visual checks, not independent review or owner acceptance. Exact committed-revision review, repository integration, device acceptance and storefront release are separate gates. Generation is not deterministic; the recorded selected patch identities and masks identify the actual composited material.
