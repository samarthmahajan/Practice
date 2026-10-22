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
| Signal | Now (2026-10-18) | Target |
|---|---|---|
| Streak / recovery | Tier-3 restart 10-13 · 6 of 8 days non-zero (10-17 unlogged · 10-19 Tier 0, recovered in 1d) · last outage: **89d** (07-16 → 10-13) · next lapse must recover in <4 days | never 0 two days running |
| Mastery gates | **1/5 · 🟢 A&H GREEN (10-18, 2/2 clean)** · next green gate → book a human mock that day | all green |
| Ladder coverage | Stacks ██████████ · A&H ██████████ 🟢 · TP ██████████ · SW █████████░ 5/6 (SWM → Queues) · BS █████████░ 4/5 · rest ⬜ | 100% |
| Blind sets recorded | 0 · **first datum: Sat 10-24 calibration half-set (1M/1H, blameless)** | rolling ≥10/12 |
| Human mocks | 0 · booking is now **trigger-based: 2 gates green → book that day** (standing "book today" items rot — removed) | last 2 per track "would advance" |
| Assets (only go up) | **39 cards banked · 25 cold redos run, 19 passed (76%) · 3 ladders at 100% · 1 gate green · Vault: 16 WHYs claimed · Decay Audit: A&H 3/3, Stacks 4/5 Strong after ~100 days** | grows every week |
| Self-rated confidence | **60% (10-18)** · prev 10% (07-12) · evidence today: 1/5 gates, 0 blind sets, 0 mocks — Saturday's half-set is the first check | tracked against evidence |
| Next checkpoint | **CP-R (restart check) — Sat 2026-10-31** | restart held: ≥10/14 non-zero days |

## Operating model — checkpoints re-baselined 2026-10-18 after the 89-day outage (4-week cadence unchanged)
- **Behavioral track OPEN from 10-18** (was CP2 10-03 — overdue): 1 STAR story/week. → **CP-R Sat 10-31:** restart held? (≥10/14 non-zero days · audit complete · Koko + MWS cleared · BS closed) → **CP3 Sat 11-28** → **CP4 Sat 2027-01-23 — apply backstop, regardless.**
- **The price list (cost stays visible, never moralized):** the 37-day outage moved the backstop Oct 31 → Nov 28; the 89-day outage moved it Nov 28 → **Jan 23** and offers to ~Mar–Apr. Another outage that size pushes offers past mid-2027; a <4-day lapse costs ~nothing. That's the exchange rate — spend accordingly.
- **Apply trigger (a) unchanged:** rolling blind-set ≥10/12 AND latest DSA + design mocks both "would advance" → applications within the week. Warm-up companies first while DP II lands; dream companies 2–3 weeks behind.
- **Projection at the protocol's own norm (1 new/weekday, probe included → ~4–5 ladder items/week): core (≈87 left) lands late Feb–Mar 2027.** 6–8/week would need 2-problem days — the July binge pattern; not assumed. **Therefore CP4 Jan 23 = "start applying," never "core finished":** realistic Jan-23 state is foundations' gates green + Queues/LL/Trees/Heaps/Backtracking done + blind-set record + 2 mocks, Graphs/DP in progress → warm-up companies first, dream companies Feb–Mar as DP lands. **CP4 is the latest start, not the earliest** — trigger (a) fires whenever it's met.

## Weekly budget + the floor (consistency contract, menu widened)
- **~8–10 h/week both tracks · weekday hard cap 2 h · overshooting is a red flag, not a win.** NEW slot as a ~40-min morning block when possible — precision dies at 9 pm, lives at 8 am.
- **Minimum Viable Day = 15 min — a menu now, pick ANY one:** 3 Blitz cards · 1 gap drill · 1 vault re-derivation (pick a claimed WHY, produce it cold again) · 1 STAR story draft · 1 HLD redraw. A dead day + MVD = a green day, guilt-free.
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
- **Tier 3 (14+ days):** full re-entry — prediction sheet + Decay Audit week (the 08-22 RE-ENTRY week in git history, commit 8362a2a, is the reusable template) · checkpoints re-baselined · first Saturday = half-set calibration · MTTR updated on the scoreboard. **After Tier 3 the plan gets a postmortem, not a guilt trip — one section, five lines, closed.**
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
- [ ] Behavioral: 8 STAR stories written + spoken aloud (track opened 10-18 · 1/week).

## Topic sequence (order fixed, dates float — flavor is free)
Binary Search (1 left — **closes Tue 10-20**) → **Queues/Deques — opens with SWM, the deferred boss** → Linked Lists (9 — LRU Cache ⭐, the interview celebrity) → **Trees (15 — the money topic, deliberately uncut)** → Tries (3) → Heaps (5) → Backtracking (8 — where recursion becomes a tool, not a fear) → Graphs (12 — where senior loops separate people) → Greedy & Intervals (9) → **DP I (10) → DP II (9) — protected; the fear tax, paid once, stays paid** → Bits (4).
≈87 core + weekly gate probes ≈ 18–20 weeks from 10-19 → core late Feb–Mar 2027. `(s)` stretch only when a topic finishes under budget.

---

## Curated ladders (✅ cold · `[x]*` class-B pass · ~ pending class-A redo · ⬜ todo · (p) preview · (s) stretch)

### Stacks — gate NOT MET (first probe: this rotation)
Tier A ✅ NGE-II ✅ Daily Temperatures · Tier B ✅ Asteroid Collision ✅ Simplify Path · Tier C ✅ Evaluate RPN ✅ Decode String · Tier D ✅ Basic Calculator II · Tier E ✅ Remove K Digits ✅ Remove Duplicate Letters · Tier F ✅ Largest Rectangle in Histogram ✅ Trapping Rain Water · Bridge ✅ Implement Queue using Stacks · (earlier: ✅ Valid Parentheses ✅ Min Stack ✅ Prefix→Postfix ✅ NGE-I)

### Arrays & Hashing — 🟢 GATE GREEN (2026-10-18) · CLOSED
✅ Two Sum · ✅ Contains Duplicate · ✅ Valid Anagram · ✅ Group Anagrams · ✅ Top K Frequent Elements · ✅ Product of Array Except Self · ✅ Encode/Decode Strings · ✅ Longest Consecutive Sequence
**Gate probes** (fresh unseen mediums — NOT ladder items): ✅ Subarray Sum Equals K (07-16, 22 min, 4-axis pure) · ✅ Insert Delete GetRandom O(1) (10-18, 20 min, 4-axis pure, fuzz-clean 612k ops) → **2/2 — GATE GREEN.**

### Two Pointers — gate NOT MET (probe #1: Fri 10-23)
✅ Valid Palindrome · ✅ Two Sum II · ✅ 3Sum · ✅ Container With Most Water
**Gate probes:** ~ Boats to Save People #881 (10-20, class-A wrong output — 6,191/20,000 fuzz fails, e.g. [1,1,1,1] lim 2 → 1 vs 2; narration said "right moves every time" but code didn't; WHYs not produced before coding; time not given) → 0/1. Redo cold slotted at Sun 10-25 retro.

### Sliding Window — gate NOT MET
✅ Best Time to Buy/Sell Stock · ✅ Longest Substring Without Repeating · `[x]*` Longest Repeating Character Replacement (record-mechanism WHY → drill, card live) · ✅ Permutation in String · ✅ **Minimum Window Substring** (class-A redo PASSED 10-22 `[x]`, 45 min, fuzz 20,000/20,000 — have/need bounty claimed, Vault #16) · ~ Sliding Window Maximum (class-A; DEFERRED by captain's call: it opens the Queues topic)

### Binary Search — gate NOT MET
✅ Binary Search #704 (5/5, derivation-level) · `[x]*` Search a 2D Matrix (seam-weld WHY → drill, card live) · ~ **Koko Eating Bananas — class-A redo: BOSS Fri 10-23** (07-12: `<` vs `<=` wrong output · 10-16: both WHYs narrated cold, but coded `left = 0` → `/ by zero` whenever answer is 1 — 9,841/20,000 fuzz crashes · 10-20: narration complete incl. `lo = 1` WHY, coded `left = 0` again → 4,947/20,000 crashes, 30 min) · `[x]*` Find Minimum in Rotated Sorted Array (fuzz-clean 20,045 cases; 2 WHYs → drills, card live) · ⬜ **Search in Rotated Sorted Array ← Tue 10-20, closes the ladder** · (s) Median of Two Sorted Arrays (hard)

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
- **Thu 2026-10-15 — day 3, non-zero (partial).** Warm start Simplify Path ✅ Strong (Stage 5; first Stacks audit sample). Koko boss presented but NOT started — headache, stopped before the timer. Boss rolls to Fri 10-16, no penalty. Stub decision pending: old 07-12 attempt sits at src/redo/arrays/KokoEatingBananas.java (rename-to-.bak recommended).
- **Fri 2026-10-16 — day 4 GREEN.** Warm start Eval RPN ✅ Strong (Stage 5; Stacks audit 2/2). **Koko boss → `~` class-A:** narrated monotonic-feasibility WHY + `<=` WHY cold before coding (Vault #13; `< vs <=` bounty half-claimed), then coded `left = 0` against his own narrated range [1, max] → `/ by zero` on every answer-1 input (fuzz: 0 wrong / 9,841 crashed of 20,000). Root cause self-diagnosed in one line. Redo cold Mon 10-19, card stays SUSP. Daily Temperatures ✅ Strong — full invariant + first-warmer WHY UNPROMPTED (needed a probe on 10-14) → Stage 3, due 10-21. Old attempt kept at src/redo/arrays/KokoEatingBananas_0712.java.bak.
- **Sun 2026-10-18 — day 6 GREEN · 🟢 A&H GATE GREEN (1/5).** (Sat 10-17 unlogged.) Captain's call 1/2: probe → A&H. Warm start Valid Anagram ✅ Strong → Stage 5 (11-02). **Gate probe #380 Insert Delete GetRandom `[x]` 20 min**, fuzz-clean; post-code follow-up on swapped put/remove order needed a forced trace (gate-neutral) → 4/5, Stage 2, due 10-21. Remaining today: SRS (SSEK + ≤3 Stacks Blitz) → retro (re-spread Stacks, re-baseline checkpoints, purge RE-ENTRY) → optional STAR #1.
- **Mon 2026-10-19 — zero day (Tier 0, his call: "not in mood").** Nothing logged; normal protocol resumed 10-20.
- **Tue 2026-10-20 — GREEN.** Warm start Encode/Decode ✅ Strong → 3→5 fast-track, 11-04. **Koko boss → `~` class-A again (30 min):** narrated monotonic WHY + `<=` WHY + `lo = 1` / `hi = max` WHYs + O(n log M) — all cold, all correct — then coded `left = 0` → fuzz 15,053 ok / 0 wrong / 4,947 crashed. Fixed to `left = 1` only after seeing the crash (20,000/20,000) — doesn't change the class. He affirmed written from scratch (body matched the 10-16 .bak verbatim — accepted, flag on record). No self-written edge tests. Redo Fri 10-23 with the **boundary read-back ritual** (before first run: read every init/bound constant aloud against the narration).
- **Wed 2026-10-21 — GREEN (light day, MVD via SRS).** NEW slot empty by rule (BS contamination-blocked until Koko). SRS 3 cards, ~15 min: Daily Temperatures ✅ Strong → 3→5 fast-track, 11-05 (Blank 10-13 → Stage 5 in 8 days) · Insert Delete GetRandom 🟡 Okay → Stage 2, 10-24 (code + correct-order trace cold; swapped-order ghost-entry failure asked 3×, never produced → first prompt at 10-24) · Valid Palindrome ✅ Strong → Stage 3, 10-26. **Flag for the MWS boss:** all three "what breaks if…" prompts were answered with working code, not the failure case — same shape as the Boats miss. Narrate the failure case aloud before typing.
- **Thu 2026-10-22 — GREEN · 🗡️ MWS boss SLAIN.** Warm start Container With Most Water ✅ Strong → Stage 3, 10-27 — governing WHY produced cold for the first time (coach-supplied 06-28) → Vault #15. **MWS class-A redo → `[x]` 45 min (at the Hard box), unaided:** invariant + have/need update rule + duplicate trap (t="AABC") + 3 own edge tests + `bestLen = MAX` / return guard ALL narrated before coding (update rule, tests, init came on the plan's required prompts) → fuzz 20,000/20,000 first run. Have/need bounty CLAIMED → Vault #16. Card live: Stage 3, 10-27. The narration→code drift of Koko ×2 / Boats did NOT recur — code matched narration line for line. SW drills + overdue SW cards unblocked. Largest Rectangle (sprint) rolls to 10-23 if not run.
- **Class-A pending: 2** — Koko (BOSS Fri 10-23) · Boats #881 (TP probe redo, Sun 10-25 retro) — plus SWM deferred-by-call (opens Queues). WIP lock OFF (threshold >3).
- Retro 10-18: Stacks Decay Audit PASS (4/5 Strong; Largest Rectangle Blank → Stage 1, due 10-19) · 8 Stacks cards re-spread 10-25→11-04 · checkpoints re-baselined (CP-R 10-31 · CP3 11-28 · CP4 2027-01-23) · RE-ENTRY section purged · confidence 60%.
- **Week of 10-19 (re-sequenced 10-20 — captain's call 1/2: TP probe swaps Fri → Wed, since BS is contamination-blocked until Koko clears):** ~~Wed TP probe~~ → **ran Tue 10-20 in the empty NEW slot (coach's call, delegated "u decide") — missed** · Wed **light: STAR #1 or rest** (BS still contamination-blocked) · Thu **MWS boss** (H, 45') · Fri **Koko boss** · Sat **calibration half-set** (1M/1H) · Sun retro + STAR #1. **Search in Rotated Sorted Array** (closes BS) https://leetcode.com/problems/search-in-rotated-sorted-array/ → Mon 10-26, or Fri after a Koko pass if energy allows (CP-R needs BS closed by 10-31). SWM boss (opens Queues) after that.
- **Drills:** BS pair unblocks after Koko passes · **SW pair UNBLOCKED 10-22** (variable-shrink abba trace · LRCR record-mechanism) · `< vs <=` bounty rides the Koko boss.
- **Gate probes:** A&H 🟢 closed 10-18 · next: TP probe #1 Wed 10-21 (rotation resumes TP → Stacks → SW → BS). **2nd green gate → book a human mock that day.**
- **Week objective (10-19):** "Two bosses down, BS CLOSED, first blind-set datum on the board."
- History & flags → `plans/LOG.md`.

## How a problem is logged (unchanged + preview marker)
`[x]` cold · `[x]*` class-B (drill queued, card live) · `~` class-A (redo +3d, card suspended) · `(p)` preview, gate-neutral · time taken · gate it feeds. Position advances on `[x]` and `[x]*`. Gates and blind sets count pure `[x]` only.
