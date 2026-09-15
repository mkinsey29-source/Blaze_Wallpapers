# Catalog naming policy

Blaze names the catalog structures customers browse, not every individual
picture. The public naming hierarchy is:

1. **Collection/category:** the artistic family, such as `Neon Solitude`.
2. **Type:** the technical experience, initially `Static`, with `Parallax` and
   `Motion` reserved for later products.

Every picture still receives a stable internal asset ID used by the app,
purchases, favorites, support, analytics, and provenance. IDs never change after
release. Descriptive slugs may remain in source control to help production, but
they are not customer-facing labels.

## Presentation rules

- The gallery names the collection and marks each card with its type.
- Preview screens show the collection, type, and wallpaper destination question.
- Individual picture names and descriptions do not appear in the selection flow.
- Descriptions remain internal catalog metadata for store listings, search, and
  sharing, but do not clutter the core selection flow.
- Premium status is separate metadata represented by a badge or pack
  entitlement; it is not inferred from the collection or type name.

This keeps a large catalog operationally manageable while preserving the clean
visual presentation of the app.
