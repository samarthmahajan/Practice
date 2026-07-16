# HLD / System Design Mastery Plan — Samarth (v2, post-review 2026-07-02)
Companion to `PLAN.md` (DSA). Same honesty rules, different muscle.
Goal: walk into a Lead-level system design round with an earned "would advance" — at your level this round often outweighs DSA.

## The honest contract
- Design has NO test harness. A wrong design "runs fine" in your head, so self-grading lies far more easily than DSA. Human mocks carry MORE weight here — 4 is the floor, not the goal.
- Knowledge is not the bar. You run production systems at MakeMyTrip; the bar is the FORMAT: 45 minutes, you drive, numbers steer decisions, trade-offs get committed to — not surveyed.
- Gates green = ready. "Read Alex Xu twice" = nothing.

## How this coexists with DSA (capacity honesty — the whole design of this plan)
Until DSA's core coverage completes (Phase 3 start, ~mid-Oct), DSA owns weekday evenings and weekend mornings. HLD lives in slots DSA can't use:
- **2 × 30–40 min weekday LUNCH concept blocks** (Tue + Thu). The teach-back quiz is the LAST 5 minutes of the same lunch block, in chat — weekday evenings stay 100% DSA, no exceptions.
- **1 × ~90 min weekend design rep, Sunday-afternoon default** (45 timed + 30 compare-vs-reference + card). Saturday belongs to the DSA blind set and DSA human mocks.
- **10-min blank-page redraws** (morning coffee slot) once cards exist.
**When Phase 3 starts, the budget flips: HLD inherits weekday evenings** (DSA core done), and DSA drops to a maintenance dose (see Phase 3).

**Weekend inventory & precedence (what actually competes):** Sat = DSA blind set → DSA human mock (from wk 5) → SRS catch-up. Sun = DSA remainder → **HLD rep** → redraws. On overflow, drop order: HLD concept block → HLD rep → DSA new problems. DSA redo-colds and the blind set are never dropped.
**If a Phase-1 weekend collapses, that week's rep is DROPPED, not stacked** — Tier A/B systems reappear as Phase-3 redo material. No fantasy catch-up debt.

## Pipeline math (single source of truth for interview staging — PLAN.md points here)
**Re-anchored 2026-07-12, consistency-first:** staging keys off PLAN.md's checkpoints and apply trigger, not the calendar. Apply trigger = rolling blind-set ≥10/12 AND latest DSA + design mocks both "would advance" — **or the CP4 (Oct 31) backstop, whichever fires first.**
- **Now → apply trigger:** warm referrers continuously — referrals beat cold applies and cost zero study time.
- **Applications / outreach:** within one week of the trigger; **no later than Oct 31.** Warm-up companies first, dream companies 2–3 weeks behind them (screens as free calibration).
- **Phone screens:** ~4–6 weeks after applying (request the window explicitly; recruiters accommodate). Confirm per company what a "screen" tests — Amazon screens are LP-heavy; some Lead pipelines add a design or HM screen. Keep one screen-grade Tier-C design warm from the News Feed rep onward.
- **Onsites:** ~3–4 weeks after screens → realistic loop window **Nov–Jan**, inside the stated comfort zone. HLD exit criteria green before the first onsite; DSA held by the maintenance dose below.
- **Company list (DECIDED 2026-07-12 — coach's call, edit freely):** Tier 1: Google · Meta · Amazon · Microsoft · Uber · Atlassian. Warm-up tier (first screens): Flipkart / Swiggy / Razorpay-class product companies. **Amazon + Atlassian + Uber on the list ⇒ the LLD mini-track (4–6 evening sessions) IS IN** — staged at CP2 (Sep 5) alongside behavioral, executed inside Phase 3.

---

## Definition of DESIGNED (a rep only counts if ALL hold)
1. **45-min box**, framework budget respected: ~5 requirements · ~5 envelope math · ~10 API + data model · ~10 high-level · ~15 deep dives + wrap.
2. **Unaided** — no reference, no notes, no cheatsheet mid-rep. `reveal` during the box → logged `~`.
3. **Numbers drove a decision.** At least one computed number (QPS, storage, fan-out, connections) visibly changed the architecture. Estimation that steers nothing is theater.
4. **≥2 deep dives with a COMMITTED choice** — trade-off pair stated, one side chosen, why said out loud. Listing options is knowledge; committing is design.
5. **Failure story told:** what breaks first at 10×, blast radius, and the evolution path.
After the box: compare against the reference, log every gap on the card — **the Gaps section is the review material.**
Rating 1–5 (MAANG lens): 5 → redraw +10d · 4 → redraw +4d · **≤3 → blind REDO takes the NEXT weekend rep slot, displacing that week's new system** (redos are schedulable or they are fiction). Human mocks and blind redos both count as reps.

## Per-group MASTERY GATE (teach-back)
A concept group is owned when you can cold-write its decision tree + canonical numbers from a blank page and survive 3 probing questions without a stumble. Not before.

---

## Concept groups (H1–H8)
- **H1 · Foundations & Estimation** — request anatomy (client→LB→app→cache→db), latency numbers that matter, envelope math (QPS/storage/bandwidth/connections), SLO thinking.
- **H2 · Storage** — SQL vs NoSQL decision tree, indexes, replication (leader/follower, quorum), partitioning & sharding (hash/range, hot keys, resharding), transactions vs BASE.
- **H3 · Caching & CDN** — cache-aside / write-through / write-back, TTL + invalidation, stampede protection, Redis patterns, CDN behavior.
- **H4 · Async & Streaming** — queues vs logs, delivery semantics + idempotency + retries/backoff, backpressure, fan-out on write vs read, stream windows.
- **H5 · Consistency & Coordination** — CAP/PACELC in practice, quorums, 2PC vs sagas, outbox, locks & leases, what ZK/etcd actually give you.
- **H6 · Scale patterns** — rate-limiting algorithms, distributed ID generation, consistent hashing, geo indexing (geohash/quadtree), inverted index + top-k.
- **H7 · Realtime & Media** — WebSocket/SSE/long-poll, presence, video pipeline (upload→transcode→HLS→CDN), collaborative editing (OT vs CRDT, overview depth).
- **H8 · Reliability & Ops** — timeouts/retries/jitter, circuit breakers, graceful degradation, observability, multi-region/DR basics.

**Concept calendar — derived FROM the rep schedule so every rep is fed BEFORE it runs (dive-first rule):**
| Week | Tue block | Thu block | Feeds |
|---|---|---|---|
| Jul 6 | **Hello Interview delivery framework** + H1 | H6a (rate limiting, IDs) + H3a (cache basics) | Rate Limiter (Jul 12) |
| Jul 13 | H2a (SQL/NoSQL, indexes, replication) | H2b (partitioning, hot keys) | mock (Jul 18/19), URL Shortener (Jul 26) |
| Jul 20 | H3b (write policies, stampede, CDN) | H4a (queues vs logs, delivery, retries) | Notification (Aug 2) |
| Jul 27 | H4b (fan-out, backpressure, streams) | H5a (CAP, quorums, transactions) | News Feed (Aug 9) |
| Aug 3 | H6b (consistent hashing, geo, top-k) | H8 (reliability & ops) | Web Crawler (Aug 16) |
| Aug 10 | H5b (2PC vs sagas, outbox, locks) | H7 (realtime + media) | Phase 3: Booking, Chat, YouTube |

## Design ladder (ranked by PATTERN difficulty · groups exercised · ✅/~/⬜)
**Tier A** · ⬜ Rate Limiter (H6, H3) · ⬜ URL Shortener (H2, H6, H3)
**Tier B** · ⬜ Notification Service (H4, H8) · ⬜ Web Crawler (H4, H6, H8)
**Tier C** · ⬜ News Feed / Timeline (H3, H4 — the fan-out decision) · ⬜ Instagram (H2 sharding, H3 CDN)
**Tier D** · ⬜ Chat / WhatsApp (H7, H4, H5 — ordering + presence) · ⬜ Search Autocomplete (H6 top-k, H3)
**Tier E** · ⬜ **Hotel / Ticket Booking (H5 locking + sagas, H2) ★ home turf** · ⬜ Uber / Nearby (H6 geo, H7) · ⬜ Ad Click Aggregation (H4 streaming, H5)
**Tier F** · ⬜ YouTube (H7 media, H3, H4) · ⬜ Google Docs collaboration (H7 OT/CRDT, H5) · ⬜ Payment System (H5 idempotency + ledger, H8)

★ Booking is your day job — it opens the Phase-3 bridge for morale and story-mining, and beware: interviewers who see MakeMyTrip will drill exactly here. Home turf must be flawless, not familiar.

## Phases
**(2026-07-12) Re-anchored to PLAN.md checkpoints — sequence and content unchanged, calendar floats.** Phase 1 runs now → CP2 (Sep 5) at 2 lunch blocks + 1 Sunday rep/week; Phase 2 = whenever DSA's DP block runs (protected); Phase 3 starts when DSA core coverage completes (~mid-Oct) and inherits weekday evenings, now also carrying the LLD mini-track + behavioral polish; Phase 4 = the two weeks before first onsites. The dated list in Phase 1 reads as REP ORDER, not hard dates — a collapsed weekend drops that rep (collapse rule), it never stacks.
- **Phase 1 — Concurrent-light (Jul 6 → Aug 16, DSA weeks 3–8):** 12 lunch blocks per the calendar + Sunday reps: Rate Limiter (Jul 12) → **CALIBRATION HUMAN DESIGN MOCK (Jul 18/19 — book by Jul 12)** → URL Shortener (Jul 26) → Notification Service (Aug 2) → News Feed (Aug 9) → Web Crawler (Aug 16). Note Jul 11/12 is a stacked weekend (DSA blind set + DSA calibration mock window) — the collapse rule above applies.
- **Phase 2 — Maintenance (Aug 17 → Aug 30, DSA DP weeks — PROTECTED):** no new designs. 2 lunch blocks/week of DDIA (ch. 5–9, selectively — first thing dropped if DP needs the fuel) + 1 weekend redraw. DP owns the brain.
- **Phase 3-bridge (Aug 31 → Sep 6, DSA week 11 — its decisive week):** ≤1 rep, weekend only: **Booking ★ (Sun Sep 6)**. Redraws continue. Nothing else — DSA's exit is being decided this week.
- **Phase 3 — Ramp (Sep 7 → Sep 20):** **HLD inherits weekday evenings.** 4–5 reps/week through Tiers C–F, 1 human design mock/week (book ALL Phase-3/4 mocks by Aug 24 — senior design mocks need 1–2 weeks' lead and real money), daily 10-min redraw. **DSA maintenance dose starts here and runs through the last onsite: daily SRS reviews + 3 timed problems/week + Saturday blind set stays.** LLD mini-track slots here if the Jul-12 company list demands it.
- **Phase 4 — Polish (Sep 21 → Sep 27):** company-specific formats (Meta product-architecture vs Google infra vs Amazon), max 2 final mocks, and deliberate REMEDIATION SPACE — if the Sep 19/20 mock verdict is bad, this week fixes it before onsites.

## Failure-mode watch-list (unverified priors — the Jul 18/19 calibration mock replaces this with data)
Until real data exists, the observer watches for the classic Lead-engineer misses: fluent option-surveying without committing, skipping envelope math ("I know it's big"), letting the interviewer pick the deep dives, and home-domain fluency masking gaps outside booking/travel.

## Session protocol (chat triggers — mirror of DSA's `redo`)
- `concept <topic>` — coach delivers the conceptual dive DSA-style (Concept / When to use / How to identify / Core patterns); your lunch reading wraps around it. Last 5 min of the block: `teachback` — I quiz, your words build the concept card (notes/hld/concepts/).
- `design <system>` — prompt + constraints, 45-min clock, I play interviewer: probe, push back, inject twists ("now reads are 100×"). I never draw boxes for you.
- `redraw <system>` — 10-min blank-page redraw: architecture + the 3 governing trade-offs from memory.
- `hint` — one nudge question · `stuck` — framework-step pointer · `reveal` — reference comparison (mid-box = logged `~`).
- Cards → `notes/hld/<system>-designed.md` via `templates/hld-design-card.md`. **On every card save the coach appends a row to `notes/hld/REVIEW-HLD.md`** — that table IS the redraw queue; untracked redraws silently die.

## EXIT CRITERIA — the "would advance" gate (all must be green)
- [ ] All 8 concept-group gates green (teach-back, 3 probes deep).
- [ ] **≥20 reps counting human mocks and blind redos (~25% redo budget is EXPECTED, not failure)** · ≥12 distinct systems · every Tier A–E cleared at 4+/5 (redos allowed) · ≥2 Tier F attempted, one at 4+/5.
- [ ] 4 human design mocks (calibration Jul 18/19 · then roughly every 3 weeks · final one the week before onsites); **last 2 verdict "would advance at Lead/Senior level."**
- [ ] Redraw sample 5/5: any five past systems from REVIEW-HLD.md, 10 min each, governing trade-offs present.
- [ ] Numbers reflex: estimation opened unprompted in the last 3 reps/mocks.
(War-story mining is a card habit, not a gate — behavioral prep is explicitly OUT of this plan's scope beyond the template row that collects seeds for free.)

---

## CURRENT POSITION
- **Phase 1, week 1 — with a slip on record:** the Jul 7 (H1) and Jul 9 (H6a+H3a) lunch blocks left no concept cards and REVIEW-HLD.md is empty — either skipped or unlogged; the system only noticed via manual audit on 07-12. Fix, no stacking (collapse rule): rerun `concept H1` Tue Jul 14 and `concept H6a+H3a` Thu Jul 16. From now on **a block that saves no card counts as skipped** — the card is the proof of work.
- **Today (Sun 2026-07-12):** `design rate-limiter` (rep #1). Dive-first rule is waived ONCE for this rep — it runs as a calibration-grade first rep (format gaps surfacing mid-box are expected data, log them on the card); from rep #2 the rule is hard. **Book today:** the design calibration mock (interviewing.io / Hello Interview) for Jul 18/19.
- **Company list:** DECIDED — see Pipeline (LLD mini-track IS IN, staged CP2). Mock budget: ≤2 human mocks/week across BOTH tracks (this week: DSA calibration + design calibration = exactly 2).
- **Hour budget is SHARED with PLAN.md: ~8–10 h/week across both tracks — HLD's slots live inside it, not on top of it.**
- **Redraw queue:** `notes/hld/REVIEW-HLD.md` (empty — no cards yet).

## How a rep is logged
`[x]` designed (unaided, in-box, rating 4+) · `~` assisted / over-box / gaps (blind redo takes next weekend slot) · time · rating · groups it feeds. Coach updates the ladder, REVIEW-HLD.md, and this position block after every rep. Position advances only on `[x]`.

## Resource spine (deliberately tight — depth over hoarding)
- **Hello Interview delivery framework** — read FIRST (scheduled: Tue Jul 7 block; it IS the 45-min format).
- **Alex Xu, System Design Interview vol. 1** — framework + Tier A–D references.
- **Alex Xu vol. 2** — Tier E–F references (Hotel Reservation, Ad Click, Payment — your exact ladder).
- **DDIA ch. 5–9** — Phase-2 maintenance reading only (replication, partitioning, transactions, consistency).
- Company engineering blogs — only when a card's Gaps section demands depth. Nothing else. No playlist-collecting.
