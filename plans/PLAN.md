# DSA Mastery Plan — Samarth (v3 · consistency-first · rewritten 2026-07-12 after full multi-lens review)

Goal: walk into ANY tier-one DS&Algo round with an earned, MEASURED ~90% expected pass rate — on a schedule a working Lead can sustain indefinitely.
DSA only. HLD → `plans/HLD-PLAN.md` (LLD gated there) · behavioral track starts at Checkpoint 2 (see EXIT CRITERIA).
Attempt history & flags → `plans/LOG.md` (append-only). This file stays a plan, not a journal.

## The honest contract (unchanged — the spine)
- No plan guarantees a single round; variance is real. Confidence is EARNED through the exit criteria and measured — never felt into existence.
- If you fudge "cold-solve" or skip measurement (blind sets, mocks), every number below is fiction.
- v3 changed the COST of a near-miss and the VISIBILITY of progress. It did not move the bar.

---

## PROGRESS — the scoreboard (coach updates after every session; morning hook leads with this)
| Signal | Now (2026-07-12) | Target |
|---|---|---|
| Mastery gates | 0/5 met · **A&H probed 07-16: 1 pass / 1 attempt** (needs 2 of last 3) | all green |
| Core ladder coverage | Stacks 100% · A&H 100% · TP 100% · SW 4/6 · BS 3/6 (07-16) | 100% |
| Redo pass rate (July) | ~18/22 cold ≈ 82% | ≥80% |
| Blind sets recorded | 0 — **first: Sat 2026-07-18** | rolling ≥10/12 |
| Human mocks | 0 — DSA calibration: BOOK TODAY · design calibration: Jul 18/19 | last 2 per track "would advance" |
| Streak (≥ minimum day) | starts 2026-07-12 | never 0 two days running |
| Self-rated confidence | 10% (2026-07-12 baseline) | logged weekly at retro, tracked against evidence |
| Next checkpoint | **CP1 — Sat 2026-08-08** | — |

## Operating model — consistency-first, evidence-gated
Interview timing is no longer a deadline; it is a TRIGGER. The calendar can slide — the weekly rhythm cannot.
- **Checkpoints every 4 weeks:** CP1 Aug 8 · CP2 Sep 5 · CP3 Oct 3 · CP4 Oct 31. At each: gates reviewed, PROGRESS snapshotted, load re-tuned, staged tracks started (behavioral + LLD at CP2), apply-decision evaluated.
- **Apply trigger — whichever fires first:**
  (a) rolling blind-set ≥10/12 AND the latest DSA + design mocks both "would advance" → applications start within the week;
  (b) **CP4 (Oct 31) backstop — applications start regardless.** On record: confidence lags competence, so "when I feel ready" never fires on its own; loops starting Nov land offers Dec–Jan, inside your stated comfort. Warm-up companies first, dream companies 2–3 weeks behind them.
- Projection at sustainable pace (6–8 new/week): core coverage mid-Oct, mock-hardened early Nov. Dec/Jan is slack, not the plan.

## Weekly budget (BOTH tracks combined — the consistency contract)
- **~8–10 h/week total. Weekday hard cap 2 h. Overshooting is a red flag, not a win** — binge-and-crash is what July proved.
- **Minimum Viable Day (the streak unit): 15 min** — 3 Blitz cards OR 1 gap drill OR 1 redraw. On a dead day, do the MVD and stop, guilt-free. Consistency is built on the floor, not the target.
- Recommended (not mandatory): run the NEW-problem slot as a ~40-min MORNING block before work. Your misses are precision misses, and precision dies first at 9 pm, last at 8 am. Evenings then carry only light debt (drills / Blitz / redos).

## Definition of SOLVED (unchanged 4 axes) + miss classes (new)
`[x]` requires ALL: unaided · in time box (E≤15 / M≤30 / H≤45) · invariant + WHY narrated BEFORE coding · clean optimal Big-O.
A miss is now classed by WHAT failed:
- **Class A — the solution failed:** wrong output on any test, saw a hint/pattern name/solution, or over the time box → `~`, full **redo-cold +3 days**, card SUSPENDED from SRS (dedupe rule), gap drill if a mechanic caused it.
- **Class B — the solution stood, the articulation didn't:** correct output, in time, unaided — but narration skipped or the governing WHY not produced under probing → logged **`[x]*`**: the ladder ADVANCES, no redo. The missing sentence becomes a 5-min derivation drill (next morning) AND the first prompt at the card's next SRS review (card stays LIVE, Stage 1).
- Guards: a compile typo fixed in ≤1 min is not wrong output. **One class-B per problem, ever** — a second class-B on the same problem escalates to class A. **`[x]*` never counts toward mastery gates or blind-set stats** — those stay 4-axis pure.
Why the split: every recorded miss is one operator or one WHY sentence on an otherwise-cold solve (see LOG.md). A 30-min re-solve plus 3-day suspension is the most expensive possible cure for a one-sentence gap; the drill machinery targets the actual deficit. LRCR spent three full re-solves on a single missing sentence — never again.

## Per-pattern MASTERY GATE (unchanged) + gate probes (new)
Gate: cold-solve a FRESH medium of that pattern, in time, 2 of the last 3 attempts. `[x]*` does not count.
- **Gate probe — once a week the new-problem slot draws a fresh, unseen medium from a finished topic** (rotation: A&H → Two Pointers → Stacks → SW → BS → …). This is the only mechanism that moves 0/5, it doubles as interleaving (pattern-discrimination practice — the actual interview skill), and it is narrated OUT LOUD.
- A finished ladder schedules that topic's first probe the following week. A topic is CLOSED only when its gate is green.

## Daily protocol — ONE precedence list (supersedes every older ordering; /start follows this)
1. **Class-A redo overdue >5 days** → it opens the session. Otherwise:
2. **NEW slot (one problem):** next ⬜ in the active ladder — or this week's gate probe. 30–45 min box. Skipped only while class-A due > 3 (**WIP lock counts class-A only**).
3. **Class-A redos due** (oldest first).
4. **Gap drills due** (5 min each — cold-write invariant + WHY into GAP-DRILLS.md).
5. **SRS reviews, in budget:** ≤30 min/day, ≤5/session, Blitz-first per Overdue Triage; weekends ≤2 sessions. **Late reviews are FINE — SRS bends, streaks don't.** Overflow drops here, never above.
6. Done early? Stop. Banked rest is tomorrow's precision.

## Weekly rhythm
- **Mon–Fri:** the protocol above, ≤2 h/day.
- **Saturday — BLIND SET (never skipped again):** 4 problems via `/mock blind`, fixed mix **1E / 2M / 1H**, drawn only from learned patterns (class-A-suspended cards excluded), **narrated out loud** (phone recording), self-written edge tests before coding. Score lands in PROGRESS. On human-mock weeks the mock runs the same day and the blind set shrinks to 2 (1M/1H).
- **Sunday:** overflow debt · HLD rep (its plan) · **10-min retro: 3 concrete wins FIRST, then gaps, then next week's 3 priorities · update PROGRESS + the confidence number.**
- **Mocks (cadence, not count):** DSA calibration this week (interviewing.io / Pramp — book today). Design calibration Jul 18/19 (HLD-PLAN). Then ~1 human mock/week ALTERNATING DSA/design; the ≤2/week combined cap stands. Verdicts land in PROGRESS.

## Reviews & recall (deltas only — the SRS engine lives in .claude/skills/srs-revision-coach/)
- **Suspension applies to class-A pending redos only.** Class-B cards stay live; their first review prompt is the missed WHY.
- REVIEW.md convention: suspended rows carry `SUSP → redo YYYY-MM-DD` in the Review Date column, so the morning hook never reports them as due.
- Stage 3–4 cards with Last Rating = Strong review in **Blitz**; Double-Strong Fast-Track now applies at Stages 3–5 (skill updated). Trust the engine — July's pile-up was mode weight + suspension bleed, not interval math.
- Recall drill: unchanged (5 min, ≤2 patterns, DERIVE don't memorize, contamination guard: never drill a pattern whose class-A redo is due within 2 days).

## Your failure mode (diagnosis unchanged — treatment now matches)
Recognition is fine; precision (operator, guard, boundary WHY) is the gap — every recorded miss, zero exceptions. The cure is DERIVATION, not volume; class-B drills are that cure implemented. Highest-ROI review material: each card's Watch Out For + the invariant's WHY.

## EXIT CRITERIA — the 90% gate (v3)
- [ ] Every pattern gate green.
- [ ] **Rolling blind-set ≥10 of last 12** (3 Saturdays, fixed 1E/2M/1H mix). *(Replaces "3 consecutive weeks ≥85%" — on n=4 that demanded 12/12 straight and held the gate hostage to one unlucky hard. Same rigor, sane variance.)*
- [ ] Human mocks: **latest 2 DSA verdicts "would advance"** (cadence-based; the count target is dropped).
- [ ] DP: a fresh medium DP cold in ≤30 min.
- [ ] **Behavioral: 8 STAR stories written + spoken aloud** (track starts CP2, ~1/week — a Lead loop can die in this round; it was in nobody's scope before).
*(Removed: "250–330 problems attempted." The plan itself called count "a guardrail, not the goal," then enshrined it as a goal. At measured throughput it demanded fiction. Ladders + gates + blind sets ARE the coverage guarantee.)*

## Topic sequence (replaces the 11-week calendar — order fixed, dates float, checkpoints steer)
Binary Search (2 core left) → **Queues/Deques (opens with the SWM class-A redo)** → Linked Lists (9) → Trees (15 — the money topic, deliberately uncut) → Tries (3) → Heaps (5) → Backtracking (8) → Graphs (12) → Greedy & Intervals (9) → **DP I (10) → DP II (9) — protected; nothing bleeds into DP** → Bits (4).
≈ 89 core problems + weekly gate probes ≈ 12–14 weeks at 6–8 new/week → core done mid-Oct. `(s)` stretch items only when a topic finishes under budget.

---

## Curated ladders (✅ cold · `[x]*` class-B pass · ~ pending class-A redo · ⬜ todo · (s) stretch)

### Stacks — gate NOT MET (first probe: this rotation)
Tier A ✅ NGE-II ✅ Daily Temperatures · Tier B ✅ Asteroid Collision ✅ Simplify Path · Tier C ✅ Evaluate RPN ✅ Decode String · Tier D ✅ Basic Calculator II · Tier E ✅ Remove K Digits ✅ Remove Duplicate Letters · Tier F ✅ Largest Rectangle in Histogram ✅ Trapping Rain Water · Bridge ✅ Implement Queue using Stacks · (earlier: ✅ Valid Parentheses ✅ Min Stack ✅ Prefix→Postfix ✅ NGE-I)

### Arrays & Hashing — gate NOT MET · **1 pass / 1 attempt** (needs 2 of last 3)
✅ Two Sum · ✅ Contains Duplicate · ✅ Valid Anagram · ✅ Group Anagrams · ✅ Top K Frequent Elements · ✅ Product of Array Except Self · ✅ Encode/Decode Strings · ✅ Longest Consecutive Sequence
**Gate probes** (fresh unseen mediums — NOT ladder items, do not count toward coverage): ✅ Subarray Sum Equals K (07-16, 22 min, 4-axis pure — narrated first, all 4 probe WHYs cold incl. the k=0 insert-order trap) → **1 more clean pass closes this gate.**

### Two Pointers — gate NOT MET (probe pending)
✅ Valid Palindrome · ✅ Two Sum II · ✅ 3Sum · ✅ Container With Most Water

### Sliding Window — gate NOT MET
✅ Best Time to Buy/Sell Stock (redo passed 06-30 — this line was stale, now fixed) · ✅ Longest Substring Without Repeating · `[x]*` Longest Repeating Character Replacement (code cold 6/6 twice; record-mechanism WHY → drill, card live) · ✅ Permutation in String · ~ **Minimum Window Substring — class-A redo DUE (07-09)**: the have/need O(1) check has never been produced cold · ~ Sliding Window Maximum (saw solution — class-A; DEFERRED by deliberate call: it opens the Queues topic)

### Binary Search — gate NOT MET
✅ Binary Search #704 (5/5, derivation-level) · `[x]*` Search a 2D Matrix (code 7/7 in 10 min; seam-weld WHY → drill, card live) · ~ **Koko Eating Bananas — class-A redo DUE 07-12** (`<` vs `<=` shipped wrong output) · `[x]*` Find Minimum in Rotated Sorted Array (07-16, 15 min — code cold + fuzz-clean 20,045 cases, keep/drop asymmetry nailed; narration skipped, 2 WHYs → drills, card live) · ⬜ **Search in Rotated Sorted Array ← next new** · (s) Median of Two Sorted Arrays (hard)

### Queues & Deques — gate: monotonic deque cold medium
✅ Implement Queue using Stacks (cleared via Stacks bridge) · ⬜ **Sliding Window Maximum — MUST OPEN THE TOPIC (class-A redo; no new deque problem before it)** · ⬜ Number of Recent Calls · ⬜ Design Circular Queue

### Linked Lists — gate: pointer-rewiring + fast/slow cold medium
⬜ Reverse Linked List · ⬜ Merge Two Sorted Lists · ⬜ Linked List Cycle · ⬜ Reorder List · ⬜ Remove Nth Node From End · ⬜ Copy List With Random Pointer · ⬜ Add Two Numbers · ⬜ **LRU Cache ⭐ (disproportionately frequent — must-do)** · ⬜ Merge K Sorted Lists (heap bridge)

### Trees — gate: DFS recursion + BFS level-order cold medium (uncut — the money topic)
⬜ Invert Binary Tree · ⬜ Max Depth · ⬜ Diameter · ⬜ Balanced Binary Tree · ⬜ Same Tree · ⬜ Subtree of Another Tree · ⬜ LCA of BST · ⬜ Level Order Traversal · ⬜ Right Side View · ⬜ Count Good Nodes · ⬜ Validate BST · ⬜ Kth Smallest in BST · ⬜ Construct Tree from Preorder/Inorder · ⬜ Binary Tree Max Path Sum (hard) · ⬜ Serialize/Deserialize (hard)

### Tries — gate: prefix-tree build + search cold medium
⬜ Implement Trie · ⬜ Design Add and Search Words · ⬜ Word Search II (hard)

### Heaps / Priority Queue — gate: top-K + two-heap cold medium
⬜ Kth Largest Element in Array · ⬜ Last Stone Weight · ⬜ K Closest Points to Origin · ⬜ Task Scheduler · (s) Design Twitter · ⬜ Find Median From Data Stream (hard)

### Backtracking — gate: choose/explore/un-choose cold medium
⬜ Subsets · ⬜ Combination Sum · ⬜ Permutations · ⬜ Subsets II · ⬜ Combination Sum II · ⬜ Word Search · ⬜ Palindrome Partitioning · ⬜ Letter Combinations of a Phone Number · (s) N-Queens (hard)

### Graphs — gate: BFS/DFS grid + topo sort + union-find cold medium
⬜ Number of Islands · (s) Max Area of Island · ⬜ Clone Graph · ⬜ Pacific Atlantic Water Flow · (s) Surrounded Regions · ⬜ Rotting Oranges · ⬜ Course Schedule · ⬜ Course Schedule II · ⬜ Graph Valid Tree · ⬜ Number of Connected Components · ⬜ Redundant Connection · ⬜ Word Ladder (hard) · ⬜ Network Delay Time (Dijkstra) · ⬜ Cheapest Flights Within K Stops

### Greedy & Intervals — gate: exchange-argument + interval sort cold medium
⬜ Maximum Subarray · ⬜ Jump Game · ⬜ Jump Game II · ⬜ Gas Station · ⬜ Hand of Straights · ⬜ Merge Intervals · ⬜ Insert Interval · ⬜ Non-overlapping Intervals · ⬜ Meeting Rooms II

### DP I (1D) — gate: define state + transition cold medium (all core, protected)
⬜ Climbing Stairs · ⬜ Min Cost Climbing Stairs · ⬜ House Robber · ⬜ House Robber II · ⬜ Coin Change · ⬜ Maximum Product Subarray · ⬜ Word Break · ⬜ Longest Increasing Subsequence · ⬜ Partition Equal Subset Sum · ⬜ Decode Ways

### DP II (2D / strings / intervals) — gate: 2D state cold medium
⬜ Unique Paths · ⬜ Longest Common Subsequence · ⬜ Best Time to Buy/Sell With Cooldown · ⬜ Coin Change II · ⬜ Target Sum · ⬜ Longest Palindromic Substring · ⬜ Palindromic Substrings · ⬜ Edit Distance · ⬜ Longest Increasing Path in Matrix · (s) Distinct Subsequences · (s) Burst Balloons (hard) · (s) Regular Expression Matching (hard)

### Bit Manipulation — gate: XOR / masking cold easy-medium
⬜ Single Number · ⬜ Number of 1 Bits · ⬜ Counting Bits · ⬜ Missing Number · (s) Reverse Bits · (s) Sum of Two Integers

---

## CURRENT POSITION
- **Today (Thu 2026-07-16) — TWO new problems, over the one/day norm, by explicit call:** ① Find Minimum in Rotated Sorted Array `[x]*` class-B, 15 min · ② **GATE PROBE: Subarray Sum Equals K `[x]` CLEAN, 22 min** — first gate movement all week. Debt deferred to the weekend by explicit call. ~37 min of the 2h cap.
- **This week's gate probe is SPENT.** Next probe: next week, rotation moves A&H → Two Pointers.
- **Class-A due: 2** (Koko — redo was due 07-12, 4d overdue · MWS — same) → WIP lock OFF (lock counts class-A only, threshold >3). ⚠️ At >5d overdue (i.e. from 07-18) Koko/MWS OPEN the session ahead of the new slot.
- **Next problem (new slot, tomorrow — ONE, not a third today):** Search in Rotated Sorted Array — last Binary Search core item. No stub yet.
- **Tomorrow (Fri 07-17) drills due — 4:** binary-search `< vs <=` infinite-loop (**HIGHEST — 2nd miss in a week**) · rotated-array left-vs-right decisiveness · S2DM seam-weld WHY · LRCR record-mechanism WHY. The last two were due 07-12 and are 5d late.
- **SRS backlog: 23 cards due**, worst 8d overdue. Cap is ≤5/session, ≤30 min — drains over days, not in one sitting.
- **This week:** finish Binary Search core (Search in Rotated) · first gate probe (fresh A&H medium) — **not yet started, 2 days left** · **Sat 07-18: BLIND SET #1 (recorded) + design calibration mock** · DSA calibration mock **still unbooked** (was "book today" on 07-12).
- History & flags → `plans/LOG.md`.

## How a problem is logged
`[x]` cold · `[x]*` class-B (drill queued, card live) · `~` class-A (redo +3d, card suspended) · time taken · gate it feeds. Position advances on `[x]` and `[x]*`. Gates and blind sets count `[x]` only.
