# HLD Design Card Template
# Location: templates/hld-design-card.md
# Used by: plans/HLD-PLAN.md session protocol (on `design <system>` completion)
# Save to: notes/hld/<system>-designed.md
# On save: coach APPENDS a row to notes/hld/REVIEW-HLD.md (the redraw queue) — never skip this

---

# [System Name] — Tier [A–F]
Designed Date: [YYYY-MM-DD]
Rating: [1–5] · Time: [min]/45 · Unaided: [Yes / `~`]
Groups: [e.g. H5, H2]
Redraw Due: [rating 5 → +10d · rating 4 → +4d · ≤3 → blind REDO +4–5d]

## Requirements
- Functional (the 3–5 that matter):
- Non-functional (the 2–3 that DROVE the design — scale, latency, consistency):

## Envelope — numbers that steered decisions
| Number | Value | Decision it drove |
|---|---|---|
| | | |

## API & Data
- Core entities:
- Key endpoints (signature-level):
- Schema / partition-key choices:

## High-Level Diagram (ASCII — must be redrawable from memory)
```
[client] → [LB] → ...
```

## Deep Dives (2–3 — trade-off pair → committed choice → WHY)
1.
2.

## What breaks at 10×
- First bottleneck + blast radius:
- Evolution path:

## Gaps vs reference  ← THE review material
-

## War stories mined (behavioral seeds from real MakeMyTrip work)
-
