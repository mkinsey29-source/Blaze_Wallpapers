# Blaze Theme Packs — Project Summary, Checklist, and Handoff

**Handoff date:** 2026-09-21  
**Repository:** `mkinsey29-source/Blaze_Wallpapers`  
**Default and only remote branch:** `main`  
**Current `main` commit:** `965ae2b6367fdb131c033719b26ce336e22a9499` — `Add approved Ember Moon wallpaper collection`  
**Current verified Android workflow:** Build 45, successful  
**Commercial direction:** Sell downloadable theme packs; do not make the Android wallpaper app the primary product.

---

## 1. Purpose of this handoff

This document lets a new chat continue the Blaze project without reconstructing
the decisions from the long original conversation. It records:

- the commercial pivot from an app to downloadable theme packs;
- the repository and asset truth as of the handoff date;
- approved art directions and rejected failure modes;
- product, quality, naming, rights, and packaging rules;
- what is finished, what is only preserved, and what is missing;
- a prioritized checklist for producing the first sellable pack.

The newest decisions in this document supersede the older app-focused handoff
dated 2026-09-17 whenever they conflict.

---

## 2. Executive summary

Blaze began as a proposed low-cost Android/iOS wallpaper app intended to reach a
quick-revenue target of roughly **$1,500–$2,000 per month**. The app prototype
was successfully built, installed, and tested, and several original wallpaper
families were developed. The user has now decided that the better first product
is a series of **downloadable premium theme packs**, not a wallpaper app.

This materially simplifies the project:

- no app-store review or app-store commission structure;
- no APK maintenance as a requirement for each art release;
- no payment SDK, accounts, backend, analytics, or privacy collection;
- no need to solve every device API and wallpaper-permission issue before sale;
- the strongest work—the original coordinated artwork—can be sold directly;
- packs can be launched, tested, expanded, and bundled independently.

The existing Android project is not wasted. Preserve it as:

- a working internal gallery and preview tool;
- a proof that lock/home pairs can be applied correctly;
- a possible future app if theme-pack sales justify returning to it.

Do **not** continue app feature development or produce another APK unless the
user specifically requests it. The immediate goal is a polished, customer-ready
theme-pack product.

The best first pack is **Ember Moon — Volume 1**. Three coordinated lock/home
pairs already exist and are committed. The recommended commercial target is
eight to ten coordinated pairs before launch, but the final count and price have
not yet been locked by the user.

---

## 3. User goals and working preferences

### Commercial goal

- Fast, inexpensive path to a sellable digital product.
- Low upfront cash requirement.
- A realistic possibility of building toward $1,500–$2,000 monthly revenue.
- Prefer reusable digital inventory over a project requiring continuous code
  maintenance before the first sale.

### Creative and product preferences

- Premium-looking artwork, not a bulk collection of generic images.
- Sharp, high-resolution files: normally at least 2K/QHD, with a separate 4K
  tier only when the file genuinely meets the 4K delivery standard.
- Separate, coordinated compositions for lock and home screens.
- No blurry delivery, arbitrary customer cropping, or low-resolution images
  enlarged without a quality pass.
- Strong thumbnails and listing previews that make the artwork look premium.
- Named collections and theme packs, not public names for every individual
  picture.
- Minimal customer-facing clutter. Static wallpaper is expected and does not
  need a `STATIC` label.
- Reserve `PARALLAX` and `MOTION` wording for products that actually include
  those capabilities.
- Original artwork only. References communicate broad design appeal and must
  never become recognizable copies, traced compositions, or resold reference
  files.
- Avoid unnecessary personal information or account requirements.

### Working style

- Once a direction is clear, proceed without repeatedly asking for approval.
- Show creative samples, accept direct visual feedback, and iterate.
- Do not claim completion from source changes alone; verify final dimensions,
  package contents, and rendered/listing output.
- Keep progress updates concise, but make handoffs and checklists extensive.

---

## 4. Repository truth as of 2026-09-21

### Git status

- Repository: `https://github.com/mkinsey29-source/Blaze_Wallpapers`
- Only remote branch: `main`
- Current `main`: `965ae2b6367fdb131c033719b26ce336e22a9499`
- Prior app and artwork branches have been merged or removed.
- The latest commit added the complete Ember Moon app-ready set.
- GitHub Actions Build 45 passed Android unit tests, lint, compilation, and APK
  packaging.

### Current repository roles

The repository currently contains two overlapping systems:

1. `assets/wallpapers/` — the durable production-art archive and the correct
   starting point for theme-pack exports.
2. `app/` — the native Android prototype and its bundled runtime copies.

For the theme-pack business, treat `assets/wallpapers/` as canonical. Do not
mistake the lower-size copies in `app/src/main/assets/` for the full commercial
inventory.

### Current folders of interest

```text
assets/wallpapers/
  christmas/
  ember-moon/
  neon-solitude/
  wild-presence/

app/src/main/assets/
  thumbnails/
  wallpapers/

references/inspiration/
  gallery-boards/
  red-signal/

docs/
  CATALOG_NAMING.md
  BLAZE_THEME_PACKS_HANDOFF_2026-09-21.md
```

### Documentation caveat

The root `README.md` and parts of `docs/CATALOG_NAMING.md` still describe an
Android-first app. They are historically accurate but no longer describe the
commercial priority. Updating the repository documentation for the theme-pack
business is an early checklist item; do not delete the Android source.

---

## 5. Exact production-asset inventory in GitHub

### A. Ember Moon — three coordinated pairs

**Status:** approved, exported, committed, bundled into the app, and registered
in its catalog. These are the foundation of the first commercial theme pack.

All six delivery files are **1440×3120 WebP**.

| Internal set | Lock screen | Home screen |
|---|---|---|
| `001-moon-courier` | `ember-moon-001-moon-courier-lock-1440x3120.webp` | `ember-moon-001-moon-courier-home-1440x3120.webp` |
| `002-bell-keeper` | `ember-moon-002-bell-keeper-lock-1440x3120.webp` | `ember-moon-002-bell-keeper-home-1440x3120.webp` |
| `003-sky-fisher` | `ember-moon-003-sky-fisher-lock-1440x3120.webp` | `ember-moon-003-sky-fisher-home-1440x3120.webp` |

Repository location:

```text
assets/wallpapers/ember-moon/<numbered-set>/exports/1440x3120/
```

Each set also has a `PROVENANCE.md` tying its exports to the approved source
images with SHA-256 hashes.

The six original generated PNG sources remain preserved outside Git under these
exact titles and should be recovered rather than regenerated if the source is
needed:

- `Moon Courier Beneath the Ember Ring.png`
- `Moon Courier Over Midnight Clouds.png`
- `Bell Keeper Beneath the Cyan Moon.png`
- `Moonlit Bell Keeper and Ember Moths.png`
- `Ember Moon Sky-Fisher Wallpaper.png`
- `Ember Moon Sky Fisher.png`

Pairing used in the repository:

- Moon Courier: `Beneath the Ember Ring` = lock; `Over Midnight Clouds` = home.
- Bell Keeper: `Beneath the Cyan Moon` = lock; `Moonlit ... Ember Moths` = home.
- Sky Fisher: hyphenated `Sky-Fisher Wallpaper` = lock; `Sky Fisher` = home.

### B. Neon Solitude — three coordinated pairs

**Status:** approved app assets and useful future theme-pack inventory.

All six delivery files are **1440×3120 WebP**.

1. `Rooftop Silence` — preferred hero image and the user's favorite of the
   original three.
2. `Solitary Station`
3. `Last Bus`

The customer-facing pack should say **Neon Solitude**. The individual names can
remain internal production slugs and do not need to appear in the product UI or
customer folders.

### C. Wild Presence — tiger-family sequence

**Status:** three approved 4K production images committed under
`assets/wallpapers/wild-presence/`.

Each file is **2160×3840 WebP**:

1. sleeping father with playful young cub;
2. father and visibly small cub stalking a distant gazelle;
3. cub concealed while watching the father chase the gazelle in the distance.

These are currently three individual compositions, not three completed
lock/home pairs. Do not describe the collection as commercially packaged until
the pairing strategy, customer files, instructions, previews, and ZIP are
finished.

### D. Christmas glowing-skater pair

**Status:** two approved **2160×3840 WebP** production images committed under
`assets/wallpapers/christmas/`.

- Forward-facing skater in the illuminated clearing.
- Rear-facing skater moving deeper into the dark decorated forest.

These are complementary scenes and future parallax candidates. They are **not**
layer-separated, animated, or currently sold as parallax. Do not use a
`PARALLAX` claim until the depth layers, movement, performance, and customer
delivery method exist and have been tested.

### E. Reference material

The repository contains nine gallery-reference boards and four Red Signal
character/style references plus one branded motorcycle photograph. These live
under `references/inspiration/` and are deliberately outside production assets.

They are **reference only**:

- do not include them in a customer ZIP;
- do not sell or redistribute them;
- do not copy recognizable characters, costumes, logos, or compositions;
- do not use the branded motorcycle photograph as a finished prop;
- use only broad palette, layout, contrast, mood, and subject insights.

---

## 6. Approved or retained work not currently in GitHub production assets

These items require recovery or completion before they can be sold.

### Red Signal generated artwork

Several Red Signal images were positively reviewed, including:

- the recurring braided lead in portrait and action-oriented compositions;
- the lead with a heavy black street motorcycle;
- helmet-on and helmet-handling compositions;
- the refined helmet-placement scene;
- two crouched/squatting pose experiments, both approved for the collection;
- scenes using stronger yellow, charcoal, gray, red, and black variation.

The generated production images themselves are **not present in the current
GitHub asset tree**. The written collection brief and user-supplied references
are present. A future chat must search the user's preserved generated images by
date/theme and recover the approved finals before regenerating anything.

Do not assume every image shown in the old conversation is approved. Preserve
only the versions the user explicitly accepted.

### Monochrome face portraits

Three portrait concepts were retained in the older handoff:

- silver-haired close portrait;
- dark/wet-hair portrait;
- Black woman with natural curls.

They were approved as masters/direction, but are not present in the current
GitHub production tree and were not verified there as final 2160×3840 pack
deliverables. Recover and review them before making a 4K claim.

### Christmas adults-playing collection

The accepted direction is fully grown adults showing sincere, childlike
Christmas-morning excitement while opening or playing with normal-size toys.
Adults must remain visibly adult-sized; the result should be joyful rather than
mocking or uncanny. Earlier images were concepts, not a finished customer pack.

### Other possible collection families

The reference analysis proposed:

- Afterglow Roads
- Quiet Cosmos
- Soft Minimal
- Ink & Form
- Botanical Calm
- Painted Worlds

These are possibilities, not approved next-production commitments.

---

## 7. The new commercial product model

### Settled direction

Blaze will first sell **downloadable theme packs**, not charge for a wallpaper
app. The brand name `Blaze Wallpapers` may remain even though the primary
deliverables are ZIP products.

Each theme pack should be a complete digital product rather than a loose folder
of images. At minimum, a release needs:

- coordinated wallpaper files;
- clear device/usage folders;
- accurate previews showing what is included;
- a short installation guide;
- a personal-use license;
- a customer-ready ZIP with no internal, reference, or work-in-progress files;
- listing copy and listing images;
- final pre-upload QA.

### First pack

**Working product:** `Ember Moon — Volume 1`

Current finished content: three coordinated lock/home pairs, six delivery
images total.

Recommended launch target: eight to ten coordinated pairs, producing sixteen to
twenty primary images before optional device-size derivatives. This count is a
recommendation, not a locked user decision. Do not pad the pack with mediocre
work merely to reach a number.

### Pricing discussed but not finalized

- Suggested single-pack range: **$3.99–$5.99**.
- Suggested larger multi-pack bundle range: **$9.99–$14.99**.
- Avoid positioning the premium pack at $0.99; fees consume too much of the sale
  and the price works against the premium presentation.

The user has not yet finalized price, launch discount, marketplace, refund
language, or commercial-license options.

### Likely sales channels

Etsy and Gumroad are logical first channels and fit the user's broader digital
product work, but the final distribution decision for Blaze is still pending.
Do not claim a listing is live until it has actually been created and checked.

---

## 8. Customer-facing naming rules

### What customers see

- Brand: `Blaze Wallpapers`
- Collection/product: e.g. `Ember Moon — Volume 1`
- Meaningful format or value terms only when true: `4K`, `Lock + Home Pair`,
  `Parallax`, or `Motion`

### What customers do not need

- individual poetic names for every image;
- `STATIC` labels;
- internal descriptions;
- source-resolution or generation-process details;
- app-specific catalog metadata;
- internal slugs, hashes, QA notes, or provenance documents.

### Internal naming

Every asset still needs a stable ID for versioning and support. Keep numbered
IDs such as:

```text
ember-moon-001-lock-1440x3120.webp
ember-moon-001-home-1440x3120.webp
```

Customer folders may use clean numbering without publishing internal scene
titles. Never silently replace an approved file under an existing ID; revise the
version or provenance deliberately.

---

## 9. Artwork and quality standards

### Phone-first composition

- Compose vertically for the target ratio; do not crop a landscape poster into
  a phone wallpaper after the fact.
- Lock versions should preserve a calmer upper region for clock and
  notifications without looking artificially empty.
- Home versions should control detail and contrast behind icons and widgets.
- Lock and home images should feel coordinated but should each serve their
  actual screen.
- Do not stretch one file to make the second version.
- No customer should need to crop the focal subject to make the wallpaper fit.

### General visual QA

- sharp at delivered dimensions;
- no blurry or smeared textures;
- no extra limbs, broken hands, malformed faces, inconsistent animal anatomy,
  floating objects, or impossible perspective;
- no fake text, accidental letters, watermarks, copied patches, or real logos;
- no banding in dark gradients;
- no obvious upscale halos or oversharpened edges;
- coherent reflections, rain, fabric, fur, hair, hardware, and lighting;
- consistent palette and finish within the pack;
- thumbnail must accurately represent the actual delivered file.

### 4K policy

A wallpaper qualifies for Blaze's vertical 4K group only when:

1. final delivery is exactly **2160×3840**;
2. the scene received a deliberate detail/repair pass before or during final
   preparation;
3. it has been visually inspected at 100% size;
4. artifacts, anatomy, edges, texture, and distant objects pass review;
5. the listing says `4K wallpaper` or `4K optimized`, not `native 4K`, unless
   the source was genuinely authored natively at that size.

Resizing alone does not create a premium 4K product.

### Device testing

The user has already demonstrated that downloaded full-resolution images can be
set directly as wallpaper and personally checks them on-device. Relevant test
hardware includes a recent Galaxy S25 Ultra-class phone, an older Galaxy S10,
and an Android tablet. Capture concrete feedback from those checks; do not add a
duplicative approval gate after the user has already tested a file.

---

## 10. Collection-specific creative briefs

### Ember Moon

Core language:

- original anime-influenced fantasy, never recognizable franchise characters;
- deep cyan/blue moonlight and ember-orange highlights;
- rain, water, mist, reflected lanterns, monumental moons, distant tiered
  architecture, and small narrative figures;
- a sense that the character is doing something within the world, not merely
  posing for the camera;
- cinematic vertical depth and readable upper clock zones.

Existing story archetypes:

- Moon Courier
- Bell Keeper
- Sky Fisher

New entries should share the visual world but can introduce different jobs,
rituals, travel methods, creatures, weather, structures, and points of view.
Do not repeat the same moon size, centered pose, or orange-ring device in every
image.

### Neon Solitude

- quiet rain-dark locations;
- restrained cyan, blue, magenta, or warm practical lights;
- wet pavement, fog, reflections, distant architecture;
- a single human-scale trace—chair, shelter, station, road—without crowding;
- calm, premium, OLED-friendly composition.

Preferred existing order: Rooftop Silence first, Solitary Station second, Last
Bus third.

### Red Signal

The full written brief is in:

`references/inspiration/red-signal/COLLECTION_BRIEF.md`

Critical rules:

- original adult Black lead with long braids, metal braid cuffs, angular pale
  eye paint, piercings, spiked black outerwear, and layered metal necklaces;
- visibly illustrated/posterized, not photorealistic skin and anatomy;
- subtly elongated, elegant neck and fashion-illustration proportions;
- primary palette: red, black, bone white, silver; selected wallpapers may use
  hazard yellow or burnt orange;
- vary backgrounds; concentric circles are one option, not the default;
- keep the immediate background behind the lead broad and simple;
- put detailed scaffolding, antennas, industrial shapes, and environments at a
  distance rather than merging them into her silhouette;
- reserve direct eye contact for deliberate portraits; action and prop scenes
  should feel observed rather than staged for a camera;
- avoid repeatedly using the same low-angle, chin-raised pose;
- helmet design uses an original full-head black shell, paired round red optics
  on one forward eye line, and substantial side filters;
- perspective may hide an optic; never move it onto the helmet's side merely to
  display two red circles;
- if she is putting on the helmet, its opening and faceplate must align with the
  action rather than face the viewer like a trophy;
- heavy street motorcycle should borrow only the broad low, muscular, black
  stance of the reference; remove Indian branding and redesign proprietary
  details;
- hostile machine can use a skeletal mechanical feeling, but must be an
  original drone/armor design rather than a copied character or human skeleton.

### Wild Presence

- cinematic wildlife with coherent anatomy and clear scale relationships;
- cub must read as young and much smaller than the father;
- animals' gaze and body orientation must support the story rather than face the
  viewer by default;
- hunting images imply pursuit, not gore, capture, or injury.

### Christmas glowing skater

- nearly black decorated forest and ice;
- the icy blue-white skater is the meaningful light source;
- nearby gifts, ornaments, branches, and ice appear only where her light reaches;
- retain broad dark areas and restrained distant glints;
- do not brighten the rear-view foreground until it loses the intended darkness;
- parallax remains a future enhancement, not a current claim.

### Monochrome face portraits

- face fills the wallpaper edge to edge;
- almost no background or shoulders;
- hair and shadow frame the face;
- eyes carry the image;
- painterly grayscale, not photorealistic skin;
- no cracks, floating fragments, ribbons, scenery, or excessive decorative
  effects competing with the face.

---

## 11. Proposed customer package structure

This structure is recommended for the first pack. Exact iPhone resolutions and
whether JPG is offered alongside WebP/PNG are still product decisions.

```text
Blaze-Ember-Moon-Volume-1/
  START-HERE.pdf
  LICENSE.txt
  Android/
    Lock-Screen/
      Ember-Moon-01-Lock.<format>
      ...
    Home-Screen/
      Ember-Moon-01-Home.<format>
      ...
  iPhone/
    Lock-Screen/
    Home-Screen/
  Preview/
    Ember-Moon-Collection-Preview.jpg
```

Do not include:

- reference images;
- generated source files that are not customer deliverables;
- provenance files or SHA hashes;
- Android source code or APKs;
- thumbnails as if they were full wallpapers;
- rejected candidates;
- prompt text, internal notes, or test images;
- files with model execution IDs or confusing internal names.

### Format decision still required

The repository currently uses WebP efficiently, but customer convenience may
favor high-quality JPG or PNG depending on platform behavior. Before packaging:

- verify Android and iOS save/set behavior for the chosen format;
- compare visible quality and ZIP size;
- avoid delivering several redundant formats unless they solve a real customer
  problem;
- never recompress repeatedly from a lossy export—derive all customer formats
  from the highest-quality approved source.

---

## 12. Store-listing deliverables

Each pack needs its own listing kit:

1. Square or marketplace-native cover image with pack name.
2. Phone mockup showing a representative lock screen.
3. Phone mockup showing a representative home screen.
4. Coordinated-pair comparison image.
5. Full collection contact sheet with every included composition visible.
6. Close-detail quality image.
7. `What's Included` graphic with exact file/pair count and resolutions.
8. Compatibility/installation graphic.
9. Personal-use license summary.
10. Optional cross-sell graphic for another Blaze pack or future bundle.

Listing copy should state only facts supported by the final ZIP:

- exact number of files and coordinated pairs;
- exact dimensions;
- formats;
- digital-download status;
- supported use and installation method;
- no physical item;
- personal-use license;
- whether any 4K claim applies.

Avoid implying that the pack includes an application, live wallpaper, motion,
parallax, automatic installation, icons, widgets, or full phone themes unless
those items are actually included.

---

## 13. Licensing baseline

Create a concise license before launch. The initial product should normally
grant personal use only:

- customer may use the images as wallpapers on personally owned devices;
- customer may keep personal backups;
- no resale, redistribution, sharing, sublicensing, uploading to wallpaper
  sites, print-on-demand, NFT/token use, training-dataset resale, or claiming
  authorship;
- no commercial branding or merchandise use unless a separate license is sold;
- copyright and product rights remain with Blaze/the seller;
- digital-product refund language must match the marketplace's actual rules.

Do not promise exclusivity to buyers of a mass-market pack.

---

## 14. Extensive production checklist

### Phase 0 — New-chat startup and protection

- [ ] Read this handoff before proposing new directions.
- [ ] Verify `main` still points to or descends from `965ae2b`.
- [ ] Check for user changes made after this handoff; never overwrite them.
- [ ] Confirm `main` remains the only intended working branch.
- [ ] Preserve the Android source and existing approved exports.
- [ ] Treat `assets/wallpapers/` as canonical for theme-pack production.
- [ ] Do not regenerate an approved image merely because it is not immediately
      visible; search the repository and preserved generated-image storage first.
- [ ] Do not begin another APK build unless the user asks.

### Phase 1 — Convert repository documentation to the new business direction

- [ ] Update the root README so downloadable theme packs are the primary
      product and the Android app is described as preserved/internal/future.
- [ ] Update `docs/CATALOG_NAMING.md` so it describes customer packs rather than
      only app cards.
- [ ] Preserve the rule that individual image names are internal.
- [ ] Preserve the rule that static is unlabeled.
- [ ] Add a `products/` or `release-packages/` area that keeps customer-ready
      packages separate from masters and app assets.
- [ ] Add a release manifest template with pack name, version, file count,
      dimensions, formats, hashes, and QA status.
- [ ] Add an explicit `.gitignore` rule for temporary renders, marketplace
      downloads, and extracted customer ZIP staging if needed.

### Phase 2 — Lock the Ember Moon Volume 1 product specification

- [ ] Decide final coordinated-pair count; recommendation: eight to ten.
- [ ] Decide whether all pairs need both Android and iPhone-specific crops.
- [ ] Decide primary customer format after save/set testing.
- [ ] Decide whether a genuine 2160×3840 tier will be produced.
- [ ] Decide exact product name and edition/version label.
- [ ] Decide launch price and whether there is an introductory discount.
- [ ] Decide Etsy, Gumroad, or both as first channels.
- [ ] Decide whether the first release includes only wallpapers or also a bonus
      contact sheet/phone background guide.
- [ ] Record these decisions in an Ember Moon product manifest.

### Phase 3 — Finish the Ember Moon artwork

- [x] Recover and preserve the six original source images.
- [x] Create and commit three 1440×3120 coordinated pairs.
- [x] Add provenance records and source hashes.
- [x] Add app thumbnails and catalog entries for the existing prototype.
- [ ] Review the six current exports at 100% for edge/detail artifacts.
- [ ] Confirm the current lock/home assignment for each pair still feels right
      outside the app context.
- [ ] Design the next five to seven distinct Ember Moon narrative concepts.
- [ ] Vary character role, camera angle, moon placement, environment, and ember
      motif so the pack does not look repetitive.
- [ ] Generate concept samples without recognizable anime/franchise elements.
- [ ] Get user visual approval for each new scene family.
- [ ] Create a separate lock and home composition for every accepted scene.
- [ ] Perform anatomy, object, reflection, rain, architecture, and lighting QA.
- [ ] Finish and export every approved pair at the locked customer sizes.
- [ ] Create accurate thumbnails/contact sheets from the actual final files.

### Phase 4 — Device and format validation

- [ ] Test the chosen format on the user's current Android phone.
- [ ] Test on the older Galaxy S10 for memory, sharpness, and crop behavior.
- [ ] Check the Android tablet where relevant, without claiming tablet-specific
      support unless it is intentionally delivered.
- [ ] Validate iPhone dimensions/crop behavior before advertising iPhone support.
- [ ] Check lock-screen clock and notification readability.
- [ ] Check home-screen icons and widgets against bright/detailed regions.
- [ ] Verify no system zoom/crop removes the subject on targeted devices.
- [ ] Compare OLED blacks, gradients, and shadow detail on-device.
- [ ] Record which exact file was approved; do not rely on visual memory.

### Phase 5 — Customer package construction

- [ ] Create a clean staging folder from approved exports only.
- [ ] Use sequential customer-facing numbering.
- [ ] Separate Lock Screen and Home Screen folders clearly.
- [ ] Separate Android and iPhone only if the files truly differ.
- [ ] Write `START-HERE` installation instructions in plain language.
- [ ] Write and review the personal-use license.
- [ ] Add a compact troubleshooting section for saving and setting wallpapers.
- [ ] Remove source prompts, references, provenance, hidden files, and test files.
- [ ] Generate the final ZIP once from the clean staging folder.
- [ ] Extract the ZIP into a clean directory and compare file count/hashes.
- [ ] Open every delivered image from the extracted ZIP.
- [ ] Confirm exact dimensions, color profile, orientation, and extension.
- [ ] Confirm filenames sort naturally on phone and desktop.
- [ ] Record ZIP SHA-256 and final byte size in the release manifest.

### Phase 6 — Listing asset production

- [ ] Establish the Blaze visual identity for listing images.
- [ ] Create cover/hero image for Ember Moon Volume 1.
- [ ] Create lock/home mockup comparison.
- [ ] Create complete pack contact sheet.
- [ ] Create close-detail quality proof.
- [ ] Create `What's Included` graphic with exact counts.
- [ ] Create resolution/compatibility graphic.
- [ ] Create digital-download/no-physical-item graphic if marketplace convention
      makes it useful.
- [ ] Verify every preview corresponds to an actual delivered image.
- [ ] Avoid excessive text and keep artwork visually dominant.
- [ ] Check listing images on a phone-sized display.

### Phase 7 — Listing copy and commercial setup

- [ ] Choose final title using marketplace-search language without keyword spam.
- [ ] Write description around the specific mood, coordinated pairs, quality,
      compatibility, included files, and license.
- [ ] Write concise installation steps in the listing and full steps in the ZIP.
- [ ] Set final price.
- [ ] Select accurate categories/tags.
- [ ] State `digital download`; state `no physical item` where appropriate.
- [ ] State exact file count and dimensions.
- [ ] Do not claim native 4K, live wallpaper, parallax, motion, automatic
      installation, or universal compatibility without proof.
- [ ] Upload the final verified ZIP, not the staging folder or sources.
- [ ] Preview the live/draft listing on mobile.
- [ ] Test the customer download route where the marketplace allows it.

### Phase 8 — Launch and post-launch learning

- [ ] Publish only after product ZIP and listing assets pass final review.
- [ ] Keep a copy of the exact uploaded ZIP and listing image set.
- [ ] Record launch date, channel, price, and listing URL.
- [ ] Track views, favorites, conversion, refunds/issues, and customer questions.
- [ ] Do not overreact to a few days of traffic; review meaningful intervals.
- [ ] Use actual questions to improve the installation guide and listing.
- [ ] Avoid changing delivered files silently after customers have purchased;
      version updates explicitly.
- [ ] Decide whether the second release should be Neon Solitude, Red Signal, or
      a bundle based on readiness and customer response—not only personal taste.

### Phase 9 — Later catalog development

- [ ] Package Neon Solitude after Ember Moon unless another pack is materially
      closer to commercial completion.
- [ ] Recover approved Red Signal generated finals.
- [ ] Build and approve the Red Signal character sheet before large-scale new
      generation to prevent identity drift.
- [ ] Complete coordinated pairs for Wild Presence.
- [ ] Decide whether the skater scenes become a standard pack, a coordinated
      Christmas pair, or a properly engineered parallax product.
- [ ] Recover and quality-check monochrome portrait masters.
- [ ] Keep seasonal packs visually tied to an established Blaze language rather
      than generic holiday clip art.
- [ ] Create cross-pack bundles only after each included pack is independently
      complete and documented.

---

## 15. Definition of done for a sellable theme pack

A Blaze pack is ready to sell only when all of the following are true:

- [ ] Final artistic scope and pair count are documented.
- [ ] Every advertised image is present in the customer package.
- [ ] Every pair has the correct lock and home file.
- [ ] All files pass full-resolution visual inspection.
- [ ] Dimensions and format match the listing exactly.
- [ ] Target-device crop behavior has been checked.
- [ ] No references, copyrighted characters, real brands, watermarks, or
      accidental text appear in the product.
- [ ] Customer filenames and folders are understandable without the repository.
- [ ] Installation guide and license are included.
- [ ] Listing images use actual final artwork.
- [ ] Listing title, description, counts, resolution, and compatibility match
      the ZIP.
- [ ] ZIP has been extracted and verified from the customer perspective.
- [ ] Release manifest records version, hashes, size, and approval status.
- [ ] Exact uploaded deliverable is archived.

---

## 16. Explicit exclusions and common failure modes

Do not:

- restart by designing another wallpaper app;
- build an APK as a substitute for finishing a customer pack;
- publish the user-supplied inspiration boards;
- copy recognizable anime/game characters or franchise visual identities;
- include Indian motorcycle branding or proprietary exact details;
- call enlarged images native 4K;
- sell a wallpaper as parallax because it merely has depth;
- show `STATIC` as a selling point;
- invent public names for dozens of individual images;
- force every collection to use the same palette or composition;
- repeat a single camera-facing character pose across a pack;
- brighten intentionally dark art until it loses the intended mood;
- use app thumbnails as customer wallpapers;
- put unapproved candidates into a ZIP to inflate the file count;
- promise all-device compatibility without testing or sizing for it;
- delete the existing Android prototype or approved masters during the pivot.

---

## 17. Recommended first task in the next chat

Start with **Ember Moon Volume 1 product definition and gap analysis**, not new
generation immediately.

The next chat should:

1. Read this file.
2. Verify repository `main` and the six current Ember Moon exports.
3. Create the pack manifest with proposed final pair count, supported devices,
   delivery format, target dimensions, product name, and pending decisions.
4. Build a visual contact sheet of the three existing pairs so the user can
   judge the pack as a whole.
5. Identify the exact variety gaps—subject scale, environment, camera angle,
   palette, action, negative space, and narrative role.
6. Propose the next three to five scene concepts designed specifically to fill
   those gaps.
7. Generate only after the product structure and missing visual roles are clear.

### Short prompt the user can paste into a new chat

> Continue Blaze as a downloadable theme-pack business using
> `docs/BLAZE_THEME_PACKS_HANDOFF_2026-09-21.md` in
> `mkinsey29-source/Blaze_Wallpapers`. Read it first, verify current `main`, and
> begin with the Ember Moon Volume 1 product manifest and gap analysis. Do not
> resume Android app development or build an APK unless I specifically ask.

---

## 18. Completed milestones at handoff

- [x] Evaluated quick-turn game/app possibilities.
- [x] Chose premium wallpapers as a low-cost digital-product direction.
- [x] Created the Blaze Wallpapers repository.
- [x] Built and installed a working native Android prototype.
- [x] Established no-slider Home/Lock/Both behavior.
- [x] Established collection-first naming and clean preview rules.
- [x] Created and approved Neon Solitude.
- [x] Developed the detailed Red Signal written art direction.
- [x] Created and approved the tiger-family 4K sequence.
- [x] Created and approved two glowing-skater 4K scenes.
- [x] Created and approved three Ember Moon narrative concepts.
- [x] Recovered all six Ember Moon originals after the earlier local workspace
      was pruned.
- [x] Produced coordinated 1440×3120 Ember Moon pairs and thumbnails.
- [x] Committed Ember Moon to `main`.
- [x] Verified Android Build 45 passed.
- [x] Pivoted the primary commercial model from a wallpaper app to downloadable
      theme packs.
- [ ] Produce the first customer-ready theme-pack ZIP.
- [ ] Create and publish the first theme-pack listing.

