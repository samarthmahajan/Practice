# DSA Mastery Plan — Samarth (v4 · restart-proof · rewritten 2026-08-22 after the 37-day outage postmortem)

Goal unchanged: walk into ANY tier-one DS&A round with an earned, MEASURED ~90% expected pass rate — on a schedule a working Lead can sustain indefinitely.
DSA only. HLD → `plans/HLD-PLAN.md` (its Phase-3 evening-flip date slides with the re-baseline below; that file is otherwise untouched). Attempt history & flags → `plans/LOG.md`.

## Postmortem — the 37-day outage (blameless; five lines, then it's closed)
- **Incident:** last green 2026-07-16 → restart 2026-08-22. Blind set #1 and both calibration mocks never ran. CP1 (Aug 8) passed unheld.
- **Root cause 1 — restart cost:** the protocol had no concept of a layoff. Day-1-back served a 40-day-stale Hard redo + 35 overdue cards + 5 blocked drills: an all-debt wall, the documented burnout trigger (see 07-12 entry in LOG).
- **Root cause 2 — no graceful degradation:** one missed day cost the same as thirty ("streak broken"), so day 2 had nothing left to protect. Binary streaks fail open.
- **Root cause 3 — invisible assets:** the scoreboard counted only what was missing. 38 banked cards and an 82% cold-redo pass rate were nowhere on the board.
- **Fixes shipped in v4:** Lapse Protocol (tiered restarts) · Decay Audit (re-measure, don't grind) · warm starts + debt ceiling · asset sheet + MTTR on the scoreboard · captain's calls (sanctioned autonomy) · Invariant Vault (`notes/VAULT.md`). **The bar did not move: 4-axis SOLVED, A/B miss classes, gate purity, budgets — all unchanged.**

## The honest contract (unchanged — still the spine)
- No plan guarantees a single round; variance is real. Confidence is EARNED through the exit criteria and measured — never felt into existence.
- If you fudge "cold-solve" or skip measurement (blind sets, mocks), every number below is fiction.
- v4 changed the RESTART COST of a lapse and the VISIBILITY of assets. It did not move the bar.

## PROGRESS — the scoreboard (coach updates every session; morning hook leads with this)
| Signal | Now (2026-08-22) | Target |
|---|---|---|
| Streak / recovery | restart day · last outage: 37d · **MTTR is now paired with the streak — next lapse must recover in <4 days** | never 0 two days running |
| Mastery gates | 0/5 · **A&H is ONE clean probe from green (1 pass / 1 attempt)** — closest boss on the board | all green |
| Ladder coverage | Stacks ██████████ · A&H ██████████ · TP ██████████ · SW ████████░░ 4/6 · BS █████████░ 4/5 · rest ⬜ | 100% |
| Blind sets recorded | 0 · **first datum: Sat 08-29 calibration half-set (blameless)** | rolling ≥10/12 |
| Human mocks | 0 · booking is now **trigger-based: 2 gates green → book that day** (standing "book today" items rot — removed) | last 2 per track "would advance" |
| Assets (only go up) | **38 cards banked · 22 cold redos run, 18 passed (82%) · 3 ladders at 100% · Vault: 12 WHYs claimed, 6 bounties open** | grows every week |
| Self-rated confidence | re-log at Sunday retro 08-23 (last: 10% on 07-12) | tracked against evidence |
| Next checkpoint | **CP-R (restart check) — Sat 2026-09-05** | restart held: ≥10/14 non-zero days |

## RE-ENTRY — Comeback Week (08-22 → 08-29 · this section is deleted at CP-R)
Rust is data, not shame. A 37-day gap is an unscheduled retention experiment — predict first, then measure, and let results retune the board.
- **Sat 08-22 — Audit s1 (~20 min):** 60-second prediction sheet (rank your families: still-cold → gone), then 3 Blitz: Valid Parentheses · Contains Duplicate · Daily Temperatures (uncontaminated). Non-zero on the board.
- **Sun 08-23 — Audit s2 (≤30 min):** TP + A&H family sample (Two Sum II · Trapping Rain Water · Group Anagrams · Longest Consecutive Sequence · Product of Array Except Self). Score predictions vs reality. 10-min retro-lite.
- **Mon 08-24 — BOSS: Koko redo** (M, 30' box, morning if possible) → immediately claim the `< vs <=` bounty (the highest-priority drill rides this boss) → fuzz-verify the win.
- **Tue 08-25 — Audit s3 (≤30 min):** BS-family cards (uncontaminated once Koko is done) + rotated-array decisiveness drill + S2DM seam-weld drill.
- **Wed 08-26 — BOSS: Minimum Window Substring redo** (H, 45' box). Open bounty: the have/need O(1) WHY, produced cold BEFORE coding — never claimed in 3 touches. Take it and it's the biggest scalp in the vault.
- **Thu 08-27 — NEW slot returns: Search in Rotated Sorted Array → CLOSES the Binary Search ladder.** https://leetcode.com/problems/search-in-rotated-sorted-array/
- **Fri 08-28 — light (≤30 min):** SW drills now unblocked (LSWR failure-direction · LRCR record-mechanism) + audit stragglers.
- **Sat 08-29 — CALIBRATION SET:** half blind set (1M/1H), owned patterns only, narrated aloud, recorded. Blameless: the score tunes the schedule, not the self-image. Then one captain's call: week-2 probe = A&H (nearest win) or Two Pointers (rotation)?
Week objective: **"Comeback held: 2 bosses down, BS ladder CLOSED, first calibration datum on the board."**

## Operating model — checkpoints re-baselined (4-week cadence unchanged)
- **CP-R Sat 09-05:** restart held? (≥10/14 non-zero days · audit complete · both redos cleared · BS closed) → **CP2 Sat 10-03** (behavioral track starts: 1 STAR story/week) → **CP3 Sat 10-31** → **CP4 Sat 11-28 — apply backstop, regardless.**
- **The price list (cost stays visible, never moralized):** the 37-day outage moved the backstop Oct 31 → Nov 28 and offers Dec–Jan → Jan–Feb. A second outage that size costs the winter window entirely; a <4-day lapse costs ~nothing. That's the exchange rate — spend accordingly.
- **Apply trigger (a) unchanged:** rolling blind-set ≥10/12 AND latest DSA + design mocks both "would advance" → applications within the week. Warm-up companies first while DP II lands; dream companies 2–3 weeks behind.
- **Projection at the protocol's own norm (1 new/weekday, probe included → ~4–5 ladder items/week): core (≈88 left) lands late Dec–Jan.** 6–8/week would need 2-problem days — the July binge pattern; not assumed. **Therefore CP4 Nov 28 = "start applying," never "core finished":** realistic Nov-28 state is foundations' gates green + Queues/LL/Trees done + blind-set record + 2 mocks, DP in progress → warm-up companies first, dream companies peak Jan–Feb as DP lands.

## Weekly budget + the floor (consistency contract, menu widened)
- **~8–10 h/week both tracks · weekday hard cap 2 h · overshooting is a red flag, not a win.** NEW slot as a ~40-min morning block when possible — precision dies at 9 pm, lives at 8 am.
- **Minimum Viable Day = 15 min — a menu now, pick ANY one:** 3 Blitz cards · 1 gap drill · 1 vault re-derivation (pick a claimed WHY, produce it cold again) · 1 STAR story draft (floor-eligible NOW, before CP2) · 1 HLD redraw. A dead day + MVD = a green day, guilt-free.
- **Debt ceiling (new):** ≤1 boss (class-A redo) per day · SRS ≤30 min · ≤2 drills/day · **every session opens with a 2-min warm start** (one Blitz card you own — never open a session cold on debt). No day is 100% debt.

## Definition of SOLVED + miss classes — UNCHANGED (this is the bar)
`[x]` requires ALL: unaided · in time box (E≤15 / M≤30 / H≤45) · invariant + WHY narrated BEFORE coding · clean optimal Big-O.
- **Class A — the solution failed** (wrong output, any hint/peek, or over time) → `~`, redo-cold +3 days, card SUSPENDED from SRS.
- **Class B — the solution stood, the articulation didn't** → `[x]*`: ladder advances, no redo; the missing WHY becomes a 5-min drill + the card's next review prompt. One class-B per problem EVER — a repeat escalates to class A.
- Guards: compile typo fixed ≤1 min ≠ wrong output. `[x]*` never feeds gates or blind sets — those stay 4-axis pure. A soft "solved" is still the one thing that breaks the whole plan.

## Per-pattern MASTERY GATE + probes (mechanics unchanged · nearest-win surfaced)
Gate: cold-solve a FRESH unseen medium of that pattern, in time, **2 of the last 3** — `[x]` only. One probe per week in the NEW slot, drawn from a finished topic.
- **Rotation is the default; a captain's call may redirect one probe at a nearest win** — A&H needs exactly ONE clean pass to become the first green gate of the campaign. After a redirect, rotation resumes (A&H → TP → Stacks → SW → BS → …).
- A finished ladder schedules that topic's first probe the following week. A topic is CLOSED only when its gate is green.

## Daily protocol v4 — ONE precedence list (/start follows this)
0. **Warm start (2 min): one owned Blitz card.** Then:
1. **Class-A redo overdue >5 days** opens the session (max 1 boss/day). Otherwise:
2. **NEW slot (one problem):** next ⬜ in the active ladder — or this week's gate probe. 30–45 min box. Blocked only while class-A due >3 (WIP lock counts class-A only).
3. **Class-A redos due** (oldest first — still max 1/day).
4. **Gap drills due** (≤2/day · contamination guard per SRS rules).
5. **SRS in budget:** ≤30 min, ≤5 cards, Blitz-first. Late reviews are FINE — SRS bends, streaks don't.
6. Done early? **Stop.** Banked rest is tomorrow's precision.
- **Fuzz ritual:** every boss/redo pass gets brute-force fuzz-verified when a brute force exists — the 20,045-case green bar IS the trophy (FindMin precedent, 07-16).
- **Captain's calls — 2/week, one-line log in LOG.md:** may resequence anything (defer a redo, swap a probe, take a preview). May NEVER touch grading axes, gate purity, or honesty rules. Precedent: the SWM deferral and the 07-16 double-day — both explicit calls, both worked.
- **Flex Friday (only when no boss is due):** the slot may preview the NEXT topic's first problem instead of the ladder item — forward interleaving, logged `(p)`, never counts toward the future topic's gate.

## Weekly rhythm — run it like the sprints you already run at work
- **Mon (5 min): sprint planning** — name the week's ONE objective and put it on the scoreboard ("BS ladder CLOSED" · "SWM slain, Queues open"). A week with a name beats seven task lists.
- **Tue–Fri:** the protocol above, ≤2 h/day.
- **Sat: DEMO DAY — blind set:** 4 problems via `/mock blind`, fixed 1E/2M/1H, learned patterns only (class-A-suspended excluded), narrated aloud (phone recording), self-written edge tests before coding. Score → PROGRESS. Half-set (1M/1H) on human-mock weeks and on the first Saturday after any Tier-2+ lapse.
- **Sun: retro** — 3 concrete wins FIRST, then gaps, then next week's 3 priorities · update scoreboard + confidence number · purge expired sections.
- **Mocks:** trigger-based (2 gates green → book same day) · then ~1/week alternating DSA/design · ≤2/week combined cap stands.

## Lapse Protocol — the circuit breaker (new; this is what was missing)
The system now degrades gracefully. On any gap, /start applies the tier — no shame arithmetic, just the runbook:
- **Tier 0 (1 day):** nothing happened. MVD today, normal protocol tomorrow.
- **Tier 1 (2–3 days):** warm start + one Blitz session today; bosses resume tomorrow. Log "recovered in Nd" — recovery time is the stat.
- **Tier 2 (4–13 days):** day 1 = MVD only (uncontaminated Blitz) · day 2 = easiest due boss · overdue SRS mass re-spreads forward, Blitz-first · no Hard boss before day 3.
- **Tier 3 (14+ days):** full re-entry — prediction sheet + Decay Audit week (§RE-ENTRY above is the reusable template) · checkpoints re-baselined · first Saturday = half-set calibration · MTTR updated on the scoreboard. **After Tier 3 the plan gets a postmortem, not a guilt trip — one section, five lines, closed.**
The streak metric is now a pair: current streak + MTTR of last lapse. "Never 0 two days running" stays the alert threshold; a fast recovery is a WIN on the board, not a stain.

## Reviews & recall (engine unchanged — .claude/skills/srs-revision-coach/ — one comeback overlay)
- **Decay Audit (one-time, this week):** the 35 overdue cards are NOT 35 debts. Re-test by FAMILY sample (2–3 cards per family, Blitz): family passes → all its cards KEEP stage, dates re-spread forward — surviving 40 days unprompted is stronger evidence than the schedule ever had. Family fails → only its cards drop one stage and queue normally. ~3 audit sessions replace 7+ treadmill days, and the result is an honest decay map.
- Suspension (class-A only) · class-B cards live with the missed WHY as first prompt · Blitz fast-track Stages 3–5 · contamination guard (never drill a pattern whose class-A redo is due within 2 days) — all unchanged.
- **Invariant Vault — `notes/VAULT.md` (new):** every WHY produced COLD gets one line, in your words, dated. Open bounties = WHYs never yet produced cold (named only — no answer text; claiming one = producing it at the redo/review). The vault is the highest-ROI skim before any mock, and the trophy shelf: your failure mode was precision-WHYs, so the weakness is now the collection.

## Your failure mode (diagnosis unchanged)
Recognition is fine; precision (operator, guard, boundary WHY) is the entire miss record — zero pattern-recognition misses to date. The cure is DERIVATION, not volume. Highest-ROI review material: each card's Watch Out For + the invariant's WHY — i.e., the vault.

## EXIT CRITERIA — the 90% gate (bar unchanged, dates re-pegged)
- [ ] Every pattern gate green.
- [ ] Rolling blind-set ≥10 of last 12 (fixed 1E/2M/1H mix).
- [ ] Human mocks: latest 2 DSA verdicts "would advance".
- [ ] DP: a fresh medium DP cold in ≤30 min.
- [ ] Behavioral: 8 STAR stories written + spoken aloud (track opens CP2 Oct 3 · drafts floor-eligible now).

## Topic sequence (order fixed, dates float — flavor is free)
Binary Search (1 left — **closes Thu 08-27**) → **Queues/Deques — opens with SWM, the deferred boss** → Linked Lists (9 — LRU Cache ⭐, the interview celebrity) → **Trees (15 — the money topic, deliberately uncut)** → Tries (3) → Heaps (5) → Backtracking (8 — where recursion becomes a tool, not a fear) → Graphs (12 — where senior loops separate people) → Greedy & Intervals (9) → **DP I (10) → DP II (9) — protected; the fear tax, paid once, stays paid** → Bits (4).
≈88 core + weekly gate probes ≈ 12–14 weeks from 08-24 → core mid/late Nov. `(s)` stretch only when a topic finishes under budget.

---

## Curated ladders (✅ cold · `[x]*` class-B pass · ~ pending class-A redo · ⬜ todo · (p) preview · (s) stretch)

### Stacks — gate NOT MET (first probe: this rotation)
Tier A ✅ NGE-II ✅ Daily Temperatures · Tier B ✅ Asteroid Collision ✅ Simplify Path · Tier C ✅ Evaluate RPN ✅ Decode String · Tier D ✅ Basic Calculator II · Tier E ✅ Remove K Digits ✅ Remove Duplicate Letters · Tier F ✅ Largest Rectangle in Histogram ✅ Trapping Rain Water · Bridge ✅ Implement Queue using Stacks · (earlier: ✅ Valid Parentheses ✅ Min Stack ✅ Prefix→Postfix ✅ NGE-I)

### Arrays & Hashing — gate NOT MET · **1 pass / 1 attempt — ONE clean probe from green**
✅ Two Sum · ✅ Contains Duplicate · ✅ Valid Anagram · ✅ Group Anagrams · ✅ Top K Frequent Elements · ✅ Product of Array Except Self · ✅ Encode/Decode Strings · ✅ Longest Consecutive Sequence
**Gate probes** (fresh unseen mediums — NOT ladder items): ✅ Subarray Sum Equals K (07-16, 22 min, 4-axis pure) → **1 more clean pass closes this gate.**

### Two Pointers — gate NOT MET (probe pending)
✅ Valid Palindrome · ✅ Two Sum II · ✅ 3Sum · ✅ Container With Most Water

### Sliding Window — gate NOT MET
✅ Best Time to Buy/Sell Stock · ✅ Longest Substring Without Repeating · `[x]*` Longest Repeating Character Replacement (record-mechanism WHY → drill, card live) · ✅ Permutation in String · ~ **Minimum Window Substring — class-A redo: BOSS Wed 08-26** (have/need O(1) check never produced cold — open bounty) · ~ Sliding Window Maximum (class-A; DEFERRED by captain's call: it opens the Queues topic)

### Binary Search — gate NOT MET
✅ Binary Search #704 (5/5, derivation-level) · `[x]*` Search a 2D Matrix (seam-weld WHY → drill, card live) · ~ **Koko Eating Bananas — class-A redo: BOSS Mon 08-24** (`<` vs `<=` shipped wrong output — bounty rides this boss) · `[x]*` Find Minimum in Rotated Sorted Array (fuzz-clean 20,045 cases; 2 WHYs → drills, card live) · ⬜ **Search in Rotated Sorted Array ← Thu 08-27, closes the ladder** · (s) Median of Two Sorted Arrays (hard)

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
- **Tue 2026-10-13 — Tier-3 restart, day 1 GREEN** (89-day gap; recovering from flu → MVD only). Audit s1 Blitz: Valid Parentheses ✅ · Contains Duplicate ✅ · Daily Temperatures ❌ Blank → Stage 1. Prediction sheet deferred. Comeback-week dates below are stale — re-spread once he's well; checkpoint re-baseline pending audit data.
- **Wed 2026-10-14 — day 2 GREEN** (still recovering → MVD again). Blitz: Two Sum II 🟡 Okay (approach right; said "return values" not 1-based indices; elimination WHY generic — "left is the smallest partner" not produced) · Group Anagrams ✅ Strong (Stage 4) · Daily Temperatures ✅ Strong (Blank → Strong in 24h: decreasing-index invariant + pop rule + first-warmer WHY) → Stage 2, due 10-16. Extended (his call) to finish Audit s2: Longest Consecutive ✅ Strong (iterate-the-set trap flagged) · Product Except Self ✅ Strong (O(1) follow-up after one probe) · Trapping Rain Water 🟡 Okay (mechanics right; proof bridged to height[left] not leftMax — needs `leftMax < rightMax ≤ trueRightMax`). **Decay Audit verdicts: A&H family PASSES (3/3 Strong) · TP family PASSES on mechanics, WHY-precision soft (2 Okay)** → unsampled cards keep stage, re-spread 10-17…10-23 (one/day). Bosses wait until he's well.
- **Class-A due: 2** — Koko (BOSS Mon 08-24) · MWS (BOSS Wed 08-26) — plus SWM deferred-by-call (opens Queues). WIP lock OFF (threshold >3).
- **New slot:** carried by re-entry until **Thu 08-27 → Search in Rotated Sorted Array** closes Binary Search.
- **Drills:** BS pair unblocks after Koko (Mon/Tue) · SW pair after MWS (Fri) · `< vs <=` bounty rides the Koko boss.
- **This week's gate probe:** none (comeback week) — week 2's probe is Saturday's captain's call (A&H nearest-win vs TP rotation).
- **Week objective:** "Comeback held: 2 bosses down, BS ladder CLOSED, first calibration datum on the board."
- History & flags → `plans/LOG.md`.

## How a problem is logged (unchanged + preview marker)
`[x]` cold · `[x]*` class-B (drill queued, card live) · `~` class-A (redo +3d, card suspended) · `(p)` preview, gate-neutral · time taken · gate it feeds. Position advances on `[x]` and `[x]*`. Gates and blind sets count pure `[x]` only.
