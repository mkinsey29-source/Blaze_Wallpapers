# 003 — Blue Cutter Wave Impact

## Status

Approved portrait recovered; separately composed landscape completed for the
Blaze Wallpapers catalog.

## Creation

- Method: OpenAI image generation from the user's approved art direction.
- Portrait source: `Solo Cutter Against the Gale.png`
  (`5c9e113bba05edb75688966264e7e6563ccd9e0ad11325111f5e0cf334a99221`).
- Landscape source: independently generated 16:9 composition
  (`3d5f538e495a6fd50272e986e9f3a86f82a8c20b61f9962dcd2273b65973115a`).
- Final preparation: approved portrait export retained; landscape received a
  proportional Lanczos upscale, centered aspect trim, light sharpening, sRGB
  conversion, and WebP export.

## Deliverables

- `exports/2160x3840/against-the-gale-003-blue-cutter-wave-impact-portrait-2160x3840.webp`
- `exports/3840x2160/against-the-gale-003-blue-cutter-wave-impact-landscape-3840x2160.webp`

## 2026-10-04 narrowly masked lettering correction

The owner authorized removal of the review-identified letter-like marks while preserving the rest of the artwork. This dated entry supersedes earlier current-export identities only for the exports below; earlier records and native source identities remain historical evidence.

OpenAI built-in imagegen supplied the replacement book-spine/boom-cover material from the actual export crops. Only the small described masks were composited onto the exact pre-correction decoded export with ImageMagick 7.1.1-43. The final WebPs use lossless encoding (method 6, quality 100), preserving every decoded RGB pixel outside the masks and avoiding global lossy re-encoding drift. The existing Sunroom sRGB ICC profile is retained; untagged Blue Cutter WebPs retain format-default sRGB. These remain edited, previously upscaled 4K exports, not native-4K generation. Larger files are an intentional consequence of pixel preservation.


### cutter-landscape

- Native source retained unchanged: `Solo Cutter Battling Slate Seas.png`, 1672 × 941; SHA-256 `3d5f538e495a6fd50272e986e9f3a86f82a8c20b61f9962dcd2273b65973115a`
- Exact pre-correction export at `d29244d10525cca38fd39d78cef01efe15c321e2`: 551006 bytes; SHA-256 `2488549b53e39619863604a76dfdb5575d8f4d59551d921e20829fdc4697c367`; Git blob `530f91f1971b9fc675c600477cb2c318979993bc`
- Reference crop in that export (x, y, width, height): `[1650,240,768,768]`; pixels were cropped without resizing
- Imagegen semantic edit result: 1254 × 1254; SHA-256 `6b0c004b4ad76eef040c5ecd229d6ffd4663e0bad86a0b3da656542c9c37dc5f`
- Generated crop alone was Lanczos-resampled to 768 × 768 to register with the original crop. The complete wallpaper was never resized, reframed, sharpened or regenerated in this correction
- Mask polygons in crop coordinates: `[[[392,293],[435,280],[463,286],[466,305],[398,322],[389,318]],[[468,288],[482,284],[484,304],[470,307]]]`; white on black, Gaussian blur sigma 2, 8-bit mask
- Nonzero mask support in full-export coordinates, inclusive: `[2034,515,2139,567]`; mask covers 3949 pixels
- Actual changed RGB pixels: 3928 of 8294400 (0.04736%); zero changed pixels outside the mask; 8290451 outside-mask pixels are exactly equal in all three RGB channels
- Corrected export: 3840 × 2160; 6093000 bytes; SHA-256 `07b1e0202a325372eb3606410faf72ccef72aab59431517bc7926e02f8cfa482`; Git blob `b3e63e0b2379bb2ce35846ae09041f93fb6465be`
- Full ImageMagick and FFmpeg decodes, dimensions, opacity, RIFF/chunk integrity, and lossless WebP-to-intermediate RGB equality: pass

Selected edit prompt:

Use case: precise-object-edit. This is an exact cropped edit target, not inspiration. Remove ONLY the small white letter-like painted marks on the navy cloth boom cover (upper center of image, approximately x390–480, y280–320 in this 768x768 crop). Reconstruct matching blank dark navy sail-cover fabric with its existing folds, tonal shading and weathered texture. Preserve the narrow curving structural seams/fold highlights; only erase the white lettering. Keep the boom shape, position, sail, all rigging, sailor, canopy, sea spray, lighting, blur, texture and every other part EXACTLY unchanged. No moving, reframing, crop, zoom, sharpening or recomposition. No new letters, logos, symbols or text. Return the same 768x768 square framing if supported.


### cutter-portrait

- Native source retained unchanged: `Solo Cutter Against the Gale.png`, 941 × 1672; SHA-256 `5c9e113bba05edb75688966264e7e6563ccd9e0ad11325111f5e0cf334a99221`
- Exact pre-correction export at `d29244d10525cca38fd39d78cef01efe15c321e2`: 360432 bytes; SHA-256 `566d74fa4ce776b6d95acae50d41e80bacba500694e2f064fa901f1ffcfe2d50`; Git blob `f0438cfa14419cbdd230a0e576e2e9e5a4910b76`
- Reference crop in that export (x, y, width, height): `[700,800,768,768]`; pixels were cropped without resizing
- Imagegen semantic edit result: 1254 × 1254; SHA-256 `6d77af1d171fcdcc2dc1ab2cf939235e7598772d57139a66723a6bd0e57e537e`
- Generated crop alone was Lanczos-resampled to 768 × 768 to register with the original crop. The complete wallpaper was never resized, reframed, sharpened or regenerated in this correction
- Mask polygons in crop coordinates: `[[[353,375],[375,354],[402,345],[408,376],[366,395],[349,394]],[[420,354],[429,347],[431,368],[419,373]]]`; white on black, Gaussian blur sigma 2, 8-bit mask
- Nonzero mask support in full-export coordinates, inclusive: `[1044,1140,1136,1200]`; mask covers 3480 pixels
- Actual changed RGB pixels: 3476 of 8294400 (0.04191%); zero changed pixels outside the mask; 8290920 outside-mask pixels are exactly equal in all three RGB channels
- Corrected export: 2160 × 3840; 4492248 bytes; SHA-256 `be5cbff982c1bf892e4f70524a0cf8b89ddd9508005f65570f1c66b3f07597ad`; Git blob `6874897eac53827ef2fc9f411474a09c308e6693`
- Full ImageMagick and FFmpeg decodes, dimensions, opacity, RIFF/chunk integrity, and lossless WebP-to-intermediate RGB equality: pass

Selected edit prompt:

Use case: precise-object-edit. This is an exact cropped edit target, not inspiration. Remove ONLY the small white letter-like painted marks on the navy cloth boom cover (upper-middle of image, approximately x350–425, y345–395 in this 768x768 crop). Reconstruct matching blank dark navy sail-cover fabric, retaining its existing folds, tonal shading and weathered texture. Preserve the narrow curving structural seams/fold highlights; only erase the white lettering. Keep boom shape, position, sail, all rigging, sailor, canopy, sea spray, lighting, blur, texture and every other part EXACTLY unchanged. No moving, reframing, crop, zoom, sharpening or recomposition. No new letters, logos, symbols or text. Return the same 768x768 square framing if supported.

### Review scope and limits

The author inspected full-size crop comparisons and the three completed exports. The selected prompts remove markings without adding text or symbols; color and edge continuity were checked around the masks. The three native PNGs remain byte-identical to their documented source hashes. All 20 pinned baseline exports were downloaded and fully decoded; the other 17 export identities remain unchanged in the candidate set.

These are author-session technical and visual checks, not independent review or owner acceptance. Exact committed-revision review, repository integration, device acceptance and storefront release are separate gates. Generation is not deterministic; the recorded selected patch identities and masks identify the actual composited material.
