# DSA Mastery Plan — Samarth

Goal: by the end, walk into ANY DS&Algo round with an earned ~90% expected pass rate.
DSA only (LLD / system design / behavioral deliberately out of scope).

## The honest contract
- No plan guarantees 90–95% on a single round — variance is real (an unfamiliar hard, nerves).
- What earns the confidence is the EXIT CRITERIA below. "Done with the course" = those gates are green, NOT "finished the list."
- If you fudge "cold-solve" or skip mocks, the number is fiction. The rules are the plan.

## Timeline decision (OPEN — decide by 2026-07-12, after the calibration mock)
Start was 2026-06-21 → Week 11 ends ~**2026-09-05**, and the exit criteria (3 consecutive green blind-set weeks, 8 human mocks) cannot all be green before Week 11–12 **even with zero slips**. The old "~2 months" target contradicts this plan — resolve it deliberately, don't discover it in Week 9.
- **Recommended:** target interviews **≥ 2026-09-07** and tell recruiters mid-September. Costs nothing now, buys the slack the plan currently lacks.
- **If August is immovable:** pre-decided cuts = compress Bit Manipulation, shrink Tries. **Never cut DP or mocks.**
- Lead-level loops also weight system design / LLD (deliberately out of scope here) — September needs reserved bandwidth for it either way.

---

## Definition of SOLVED (this is the whole game)
A problem counts as SOLVED only if ALL hold:
1. **Unaided** — no hint, no `hint hint`, no pattern name from the coach, no peeking at the solution.
2. **In time box** — Easy ≤15 min · Medium ≤30 min · Hard ≤45 min.
3. **Narrated** — you stated the **governing invariant and WHY it holds** (e.g. "pop on `<=` because cooler-or-equal can never be the answer") out loud / in writing before coding (interview sim). This is the step you skip and the points you lose — enforce it.
4. **Clean + optimal Big-O**, edge cases handled, runs against the test harness.

If you used a hint, ran over time, or saw the answer → it's **NOT solved**. Mark it `~` (assisted) and it goes back in the queue to **redo cold in 3 days**. Only a later unaided pass flips it to `[x]`.

## Per-pattern MASTERY GATE
A pattern is "owned" when: you cold-solve a *fresh* medium of that pattern, in time, **2 of your last 3 attempts**. Don't advance a pattern's weight until its gate is met. Track gate status in each section below.

## Weekly BLIND SET (every Saturday — your real readiness signal)
- 4 problems drawn at RANDOM across ALL patterns learned so far. Timed. No hints. Narrated. Graded by `/mock`.
- Record the cold-solve rate. This number, trending up, is the only metric that matters.

## Reviews & recall
- Daily: `/review-dsa` (SRS) for spaced repetition of solved cards. **Capacity: up to 5/day weekdays, up to 15/day weekends while a backlog exists** (Blitz/Snippet modes preferred — without weekend catch-up capacity the queue mathematically never clears).
- **Queue-dedupe rule (added 2026-07-02):** a problem with a pending redo-cold is **SUSPENDED from SRS review** — the redo supersedes it. A passed redo counts as a Strong review (reschedule from the pass date); a failed redo requeues +3 days and keeps the card suspended. This kills double-billing AND protects cold-test validity — seeing a card's pseudocode hours before its redo-cold would contaminate the "cold."
- Recall drill (daily — kept SMALL so it actually runs): **5 minutes, ≤2 patterns**, cold-write "trigger words → pattern → **the governing invariant + WHY, DERIVED from first principles, not memorized**" into GAP-DRILLS.md. **Contamination guard:** never drill a pattern whose redo-cold is due within 2 days — drill it right AFTER that redo attempt instead (win or lose; post-attempt is when encoding sticks). Interviews are won at recognition speed *and* invariant precision — see **## Your failure mode** below.

## Your failure mode (precision, not recognition)
Diagnosis from real attempts: your pattern **recognition is fine** — you name the right pattern fast. You lose points on the **precise governing invariant**: the exact operator (`>=` vs `>`), the exact guard (`if (output.isEmpty())`), the boundary *why*. So far every miss has been an invariant, never a misread pattern.
- **The cure is derivation, not volume.** For each pattern, be able to *derive* its rule from "what can never be the answer / boundary?" — never memorize the symbol.
- **Highest-ROI review material = each card's "Watch Out For" + the invariant's WHY.** Re-read these, not new problems, when time is short.
- The gap-drill (cold-write the rule + its justification) is the medicine — run it whenever a pattern logs a Weak.

## Mocks
- **From Week 3:** one **calibration** human mock in Week 3, then **1 human mock/week from Week 5** (Pramp / interviewing.io / peer). The coach can't reproduce pressure or follow-ups — get an external read before banking a month of self-grading.
- `/mock` (AI) any time for timed, no-hint, graded reps between human mocks.
- **Blind set #1: Sat 2026-07-04**, mid-sprint, no excuses — it's a measurement, not a reward. Expect a humbling baseline; take it anyway. Every skipped Saturday is a missing data point the exit criteria need (the first one, 2026-06-27, was skipped for new problems — never again).
- **Calibration human mock: BOOK NOW (2026-07-02)** for the Jul 6–12 window — Pramp / interviewing.io have lead times.

## Capacity
≤4 problems/weekday (9–5 job), heavier weekends. ~25–35/week. Quality (cold + narrated) over raw count.

## When the day overflows (triage rule)
When due-reviews + redo-colds + planned-new exceed the day's capacity, drop in this order:
1. **New problems first** — carry them forward.
2. Then Stage 3+ SRS reviews.
3. **Never** drop a redo-cold or a Stage-1 sprint — those are mastery-critical.
Carry dropped *new* problems; never carry dropped *redos*.

## WIP limit (standing rule — added 2026-07-02, the one-sentence fix for Weeks 1–2)
- **No new problem while more than 3 redo-colds are DUE** (redo date ≤ today). Due redos always outrank new work.
- **No new TOPIC while any redo-cold from earlier topics is due**, or while the previous topic's gate has never been attempted.
- The rule counts **due** redos, not pending ones — a fresh `~` schedules its redo +3 days out and must not block tomorrow's work. Deadlock-proof: due redos are always playable, and clearing them unblocks everything.

---

## North-star metric (what `/status` leads with)
- **PRIMARY — blind-set cold-solve rate** (Saturday `/mock`, random, no-hint): your true readiness signal. Target ≥85%, 3 weeks running.
- **SECONDARY — new-problem cold rate** (rolling 2 weeks): a process check, NOT a verdict. It looks ugly early because it includes first-contact hards — watch the *trend*, never panic at the *level*.
- Problem count is a guardrail, not the goal. If the rate isn't climbing, more volume won't help — slow down and fix the invariant.

## EXIT CRITERIA — the 90% gate (all must be green)
- [ ] Every pattern below at its MASTERY GATE.
- [ ] Blind-set cold-solve rate ≥85% for **3 consecutive weeks**.
- [ ] ≥8 human mocks done; last 5 with a "would advance" verdict.
- [ ] DP specifically: cold-solve a fresh medium DP in ≤30 min (the make-or-break topic).
- [ ] ~250–330 problems attempted, ≥60% logged as fully cold `[x]`.

When these are green, the confidence is real. Not before.

---

## 11-Week Schedule
Backbone = the NeetCode-150 set (the proven minimal-complete coverage for tier-one). Each new pattern: conceptual dive (Concept / When to use / How to identify) FIRST, then the curated ladder ranked by PATTERN difficulty.

| Week | Focus |
|---|---|
| 1 (now) | **Stacks** — finish Tier D–F + queue bridge |
| 2 | **Arrays & Hashing** → **Two Pointers** (foundations skipped earlier — fast but mandatory) |
| 3 | **Sliding Window** → **Binary Search** · 1 calibration human mock |
| 4 | **Queues & Deques** → **Linked Lists** |
| 5 | **Trees** (traversals, BST) → **Tries** · weekly human mocks begin |
| 6 | **Heaps / Priority Queue** → **Backtracking** · +1 spaced 1D-DP rep |
| 7 | **Graphs** (BFS/DFS, topo, union-find, shortest path) · +1 spaced DP rep |
| 8 | **Greedy & Intervals** → start **DP** |
| 9 | **DP I** (1D, knapsack, decision) |
| 10 | **DP II** (2D/grid, strings: LCS/edit distance, intervals) + **Bit Manipulation** |
| 11 | **Pure mocks + weak-spot revision** — blind sets daily, human mocks, redo every `~` |

DP gets ~2.5 weeks (8–10). Protect it — don't let earlier topics bleed into it. **Seed it early: 1 spaced 1D-DP rep/week from Week 6** (once recursion matures post-Trees/Backtracking), so Week 8 is *deepening*, not first contact.

*Adjustment 2026-07-02: coverage ran ~1 week ahead (Sliding Window + Binary Search opened in Week 2) while 21 redo-colds piled up and 0/5 touched gates closed. Week 2 therefore ends with a **consolidation sprint (Jul 2–5)** — see CURRENT POSITION — and Week 3 resumes exactly on the written schedule: gate attempts + Binary Search ladder + calibration mock. The sprint costs zero calendar time; it spends the coverage lead to bank the ownership.*

---

## CURRENT POSITION
- **Topic:** 🔒 **CONSOLIDATION SPRINT (2026-07-02 → 07-05): zero new problems until ≤3 redo-colds are due.** Coverage ran a week ahead (A&H, Two Pointers, Sliding Window fully attempted; Binary Search opened) but 0 of 5 touched gates are met and 21 redo-colds are pending — the sprint spends the coverage lead to bank the ownership. Stacks gate stays open until its redo-colds pass cold.
- **Sprint schedule (oldest debt first — most decay = truest cold test):**
  - Thu 07-02 (tonight): ✅ Decode String (4/5) · ✅ Basic Calculator II (5/5) · ✅ Remove K Digits (4/5) — 3/3 DONE
  - Fri 07-03: Remove Duplicate Letters · Largest Rectangle in Histogram · Implement Queue using Stacks · Binary Search #704
  - Sat 07-04: **BLIND SET #1 first**, then Valid Anagram · Group Anagrams · Top K Frequent · Product of Array Except Self
  - Sun 07-05: Encode/Decode Strings · Longest Consecutive Sequence · Two Sum II · 3Sum · Container With Most Water · Longest Substring w/o Repeating · LRCR · Permutation in String · Min Window Substring · Sliding Window Maximum
  - Overflow rolls to Mon 07-06 — the new-problem lock holds until ≤3 due. A failed redo requeues +3 days; that's the system working, not a setback.
- **SRS during sprint (suspension rule applied):** only 10 cards are live — Simplify Path, Evaluate RPN, Daily Temperatures, NGE-II, Min Stack, Prefix→Postfix, Contains Duplicate, Valid Palindrome, Trapping Rain Water, Best Time Buy/Sell. The other 18 due cards ride on their redo-colds.
- **Redo cold (2026-06-25):** Remove Duplicate Letters (Tier E) — `~` 2026-06-22; Largest Rectangle in Histogram (Tier F) — `~` 2026-06-22.
- **Redo cold (2026-06-26):** Implement Queue using Stacks (Bridge) — `~` 2026-06-23.
- **Redo cold (2026-06-27):** Valid Anagram (Arrays & Hashing) — `~` 2026-06-24 (off-by-one loop bound; symmetric tests hid it); Group Anagrams (Arrays & Hashing) — `~` 2026-06-24 (int[]-as-key steer; concept was cold, key-precision was the gap); Top K Frequent Elements (Arrays & Hashing) — `~` 2026-06-24 (nudged off O(n log n) sort to bucket-sort; selection-recognition was the gap).
- **Redo cold (2026-06-28):** Product of Array Except Self — `~` 2026-06-25 (level-1 hint used).
- **Redo cold (2026-06-30):** Encode/Decode Strings — `~` 2026-06-27 (level-1 hint used to reach the length-prefix idea; encode/decode + invariant then clean, bug-free first run).
- **Redo cold (2026-06-30):** Longest Consecutive Sequence — `~` 2026-06-27 (hint + Socratic unpacking to reach start-point invariant; correct, but iterated the array not the set → duplicate run-tops re-walk → O(n²). Fix: iterate the set).
- **Redo cold (2026-06-30):** Two Sum II (sorted) — `~` 2026-06-27 (reached for HashMap first; needed steer to exploit sorted + O(1) two-pointer. Execution clean once redirected; the miss was recognition).
- **Redo cold (2026-06-30):** 3Sum — `~` 2026-06-27 (recognition cold & correct: sort+anchor+two-pointer; but 2 invariant bugs — dedup entirely missing + reset lo not hi → stale pointer dropped triplets; passed samples, failed dup-heavy/harder inputs. Fixes guided).
- **Redo cold (2026-07-01):** Container With Most Water — `~` 2026-06-28 (code cold/optimal/bug-free first run, recognition cold; but governing-invariant WHY — "shorter wall already maxed its area at the widest span" — was coach-supplied in the dry run, not produced cold. One sentence from `[x]`).
- **[x] CLEARED (2026-06-30):** Best Time to Buy/Sell Stock — redo cold passed Strong. Invariant ("i = running min / cheapest buy so far") + WHY ("a lower buy dominates every future sell, so older higher buys can never win") + O(n)/O(1) all produced unaided.
- **[x] CLEARED (2026-07-02):** Decode String — redo passed cold, 19/30 min, 4/5. Approach + code + two-stack invariant all unaided, first-run green; caught the coach's wrong expected output. Dings: narrated AFTER coding (chronic — 2nd occurrence), and first complexity answer was input-O(n); self-corrected to output-sensitive after one counterexample probe. Gap-drill queued: first-try output-sensitive complexity.
- **[x] CLEARED (2026-07-02):** Basic Calculator II — redo passed cold, 19/30 min, **5/5**. Narrated invariant + WHY + dry run BEFORE coding (habit fixed same night it was called out); complexity O(n)/O(n) stated first-try upfront; first-run green on 9/9 including hidden edges (minus-division truncation 14-3/2=13, single number, negative intermediates). Elegant in-loop end-flush via `i==length-1`. Known follow-up parked: O(1)-space stack-free variant.
- **[x] CLEARED (2026-07-02):** Remove K Digits — redo passed cold, ~24/30 min, 4/5. Rule (strict `>`), code, and all edges unaided — 9/9 first run incl. "1519" k=1 → "119", which disproves the "remove the global largest" rationale he narrated (his CODE implemented the correct leftmost-descent rule; the verbal WHY was the imprecise part). Dings: skipped the requested dry run under time pressure; WHY needed prompting again. Card created (was card-less) → remove-k-digits-solved.md, Stage 2, review 2026-07-05.
- **Redo cold (2026-07-01):** Longest Substring Without Repeating — `~` 2026-06-28 (saw solution; recognition correct — variable window + HashSet — but shrink step fuzzy: "remove the duplicate" instead of "evict from LEFT until valid". Foundational variable-window template; high-priority redo).
- **Redo cold (2026-07-02):** Longest Repeating Character Replacement — `~` 2026-06-29 (heavy conceptual scaffolding to reach `windowLen−maxCount>k`; code correct incl. never-decrement-max trick, but stale-max correctness WHY — "res only hits a new high when maxCount hits a new REAL high" — not produced cold).
- **Redo cold (2026-07-02):** Permutation in String — `~` 2026-06-29 (core idea his — fixed window + freq match; but incremental +out/−in slide and the Java mechanic were coach-supplied, not produced cold).
- **Redo cold (2026-07-02):** Minimum Window Substring (hard) — `~` 2026-06-29 (4/5; recognition + approach + correct code his on a Hard, shrink-stop right; dinged: coach pre-pointed the 2 precision spots, and completeness used per-step `values().allMatch(<=0)` instead of O(1) have/need → not clean-optimal; never verbalized invariant).
- **Redo cold (2026-07-02):** Sliding Window Maximum (hard, deque) — saw solution 2026-06-29 via `code` (full hint ladder → solution). Monotonic-deque pattern is new; redo cold high-priority.
- **Redo cold (2026-07-03):** Binary Search (#704) — `~` 2026-06-30 (recognition cold & correct: standard BS shape, overflow-safe mid, early-return on match; but the governing invariant — loop runs while window non-empty → `<=` not `<` — was coach-supplied after he first reached for a symptom patch (special-case n==1). One operator from a clean solve).
- **Next new problem (🔒 LOCKED until sprint exit — ≤3 redos due):** Search a 2D Matrix (Binary Search ladder; conceptual dive already done).

---

## Curated ladders (✅=cold-solved, ~=assisted/redo, ⬜=todo)

### Stacks  — gate: monotonic + simulation cold medium
Tier A · ✅ Next Greater Element II · ✅ Daily Temperatures
Tier B · ✅ Asteroid Collision · ✅ Simplify Path
Tier C · ✅ Evaluate RPN · ✅ Decode String (redo passed COLD 2026-07-02 — 19/30 min, 4/5, unaided; caught coach's wrong expected output; complexity needed one pushback, then self-corrected to output-sensitive)
Tier D · ✅ Basic Calculator II (redo passed COLD 2026-07-02 — 19/30 min, 5/5: narrated first, complexity first-try, 9/9 incl. hidden edges)
Tier E · ✅ Remove K Digits (redo passed COLD 2026-07-02 — ~24/30 min, 4/5, 9/9 incl. hidden "1519" trap) · ~ Remove Duplicate Letters (assisted 2026-06-22 — redo cold 2026-06-25)
Tier F · ~ Largest Rectangle in Histogram (assisted 2026-06-22 — redo cold 2026-06-25) · ✅ Trapping Rain Water (cold 2026-06-23, 4/5)
Bridge · ~ Implement Queue using Stacks (assisted 2026-06-23 — redo cold 2026-06-26)
(Earlier: ✅ Valid Parentheses · ✅ Min Stack · ✅ Prefix→Postfix · ✅ NGE-I)

### Arrays & Hashing — gate: hashing-for-O(1)-lookup cold medium
✅ Two Sum · ✅ Contains Duplicate (cold 2026-06-23, 5/5) · ~ Valid Anagram (assisted 2026-06-24, off-by-one loop bound — redo cold 2026-06-27) · ~ Group Anagrams (assisted 2026-06-24, int[]-as-key steer — redo cold 2026-06-27) · ~ Top K Frequent Elements (assisted 2026-06-24, nudged off sort to bucket-sort — redo cold 2026-06-27) · ~ Product of Array Except Self (assisted 2026-06-25, level-1 hint used — redo cold 2026-06-28) · ~ Encode/Decode Strings (assisted 2026-06-27, level-1 hint to reach length-prefix — redo cold 2026-06-30) · ~ Longest Consecutive Sequence (assisted 2026-06-27, hint + duplicate→O(n²) miss, iterate set not array — redo cold 2026-06-30)

### Two Pointers — gate: converging/opposite-ends cold medium
✅ Valid Palindrome (cold 2026-06-27, 4/5) · ~ Two Sum II (sorted) (assisted 2026-06-27, defaulted to HashMap, needed steer to two-pointer/sorted — redo cold 2026-06-30) · ~ 3Sum (assisted 2026-06-27, 2 correctness bugs: missing dedup + stale hi pointer; fixes guided — redo cold 2026-06-30) · ~ Container With Most Water (assisted 2026-06-28, code cold/optimal/bug-free first run but invariant WHY coach-supplied in dry run — redo cold 2026-07-01)

### Sliding Window — gate: variable window + shrink condition cold medium
~ Best Time to Buy/Sell Stock (assisted 2026-06-28, first invariant wrong "increment both", fixed via coach counterexample; WHY "left=running min" coach-supplied; steps scaffolded — redo cold 2026-07-01) · ~ Longest Substring Without Repeating (saw solution 2026-06-28, recognition correct but shrink step fuzzy; foundational variable-window template — redo cold 2026-07-01) · ~ Longest Repeating Character Replacement (assisted 2026-06-29, heavy conceptual scaffolding to reach invariant windowLen−maxCount>k; code correct incl. never-decrement-max optimization, but stale-max correctness WHY not owned cold — redo cold 2026-07-02) · ~ Permutation in String (assisted 2026-06-29, core idea his but incremental +out/−in slide + Java mechanic coach-supplied; code correct, edge cases handled; stream-per-slide smell — redo cold 2026-07-02) · ~ Minimum Window Substring (hard) (assisted 2026-06-29, 4/5 — approach his & correct on a Hard incl. shrink-stop; but coach pre-pointed the 2 precision spots and validity check was per-step scan not have/need → not clean-optimal — redo cold 2026-07-02) · ~ Sliding Window Maximum (deque) (saw solution 2026-06-29 via `code` — used full hint ladder then asked for the solution; monotonic-deque pattern new to him — redo cold 2026-07-02)

### Binary Search — gate: "search on the answer" cold medium
~ Binary Search (assisted 2026-06-30, recognition cold & correct but governing invariant `<` vs `<=` coach-supplied; patched-symptom instinct first (special-case n==1) before the cause — redo cold 2026-07-03) · ⬜ Search a 2D Matrix · ⬜ Koko Eating Bananas · ⬜ Find Minimum in Rotated Sorted Array · ⬜ Search in Rotated Sorted Array · ⬜ Median of Two Sorted Arrays (hard)

### Queues & Deques — gate: monotonic deque cold medium
⬜ Implement Queue using Stacks · ⬜ Sliding Window Maximum · ⬜ Number of Recent Calls · ⬜ Design Circular Queue

### Linked Lists — gate: pointer-rewiring + fast/slow cold medium
⬜ Reverse Linked List · ⬜ Merge Two Sorted Lists · ⬜ Linked List Cycle · ⬜ Reorder List · ⬜ Remove Nth Node From End · ⬜ Copy List With Random Pointer · ⬜ Add Two Numbers · ⬜ LRU Cache · ⬜ Merge K Sorted Lists (heap)

### Trees — gate: DFS recursion + BFS level-order cold medium
⬜ Invert Binary Tree · ⬜ Max Depth · ⬜ Diameter · ⬜ Balanced Binary Tree · ⬜ Same Tree · ⬜ Subtree of Another Tree · ⬜ LCA of BST · ⬜ Level Order Traversal · ⬜ Right Side View · ⬜ Count Good Nodes · ⬜ Validate BST · ⬜ Kth Smallest in BST · ⬜ Construct Tree from Preorder/Inorder · ⬜ Binary Tree Max Path Sum (hard) · ⬜ Serialize/Deserialize (hard)

### Tries — gate: prefix-tree build + search cold medium
⬜ Implement Trie · ⬜ Design Add and Search Words · ⬜ Word Search II (hard)

### Heaps / Priority Queue — gate: top-K + two-heap cold medium
⬜ Kth Largest Element in Array · ⬜ Last Stone Weight · ⬜ K Closest Points to Origin · ⬜ Task Scheduler · ⬜ Design Twitter · ⬜ Find Median From Data Stream (hard)

### Backtracking — gate: choose/explore/un-choose template cold medium
⬜ Subsets · ⬜ Combination Sum · ⬜ Permutations · ⬜ Subsets II · ⬜ Combination Sum II · ⬜ Word Search · ⬜ Palindrome Partitioning · ⬜ Letter Combinations of a Phone Number · ⬜ N-Queens (hard)

### Graphs — gate: BFS/DFS grid + topo sort + union-find cold medium
⬜ Number of Islands · ⬜ Max Area of Island · ⬜ Clone Graph · ⬜ Pacific Atlantic Water Flow · ⬜ Surrounded Regions · ⬜ Rotting Oranges · ⬜ Course Schedule · ⬜ Course Schedule II · ⬜ Graph Valid Tree · ⬜ Number of Connected Components · ⬜ Redundant Connection · ⬜ Word Ladder (hard) · ⬜ Network Delay Time (Dijkstra) · ⬜ Cheapest Flights Within K Stops

### Greedy & Intervals — gate: exchange-argument + interval sort cold medium
⬜ Maximum Subarray · ⬜ Jump Game · ⬜ Jump Game II · ⬜ Gas Station · ⬜ Hand of Straights · ⬜ Merge Intervals · ⬜ Insert Interval · ⬜ Non-overlapping Intervals · ⬜ Meeting Rooms II

### DP I (1D) — gate: define state + transition cold medium
⬜ Climbing Stairs · ⬜ Min Cost Climbing Stairs · ⬜ House Robber · ⬜ House Robber II · ⬜ Coin Change · ⬜ Maximum Product Subarray · ⬜ Word Break · ⬜ Longest Increasing Subsequence · ⬜ Partition Equal Subset Sum · ⬜ Decode Ways

### DP II (2D / strings / intervals) — gate: 2D state cold medium
⬜ Unique Paths · ⬜ Longest Common Subsequence · ⬜ Best Time to Buy/Sell With Cooldown · ⬜ Coin Change II · ⬜ Target Sum · ⬜ Longest Palindromic Substring · ⬜ Palindromic Substrings · ⬜ Edit Distance · ⬜ Distinct Subsequences · ⬜ Longest Increasing Path in Matrix · ⬜ Burst Balloons (hard) · ⬜ Regular Expression Matching (hard)

### Bit Manipulation — gate: XOR / masking tricks cold easy-medium
⬜ Single Number · ⬜ Number of 1 Bits · ⬜ Counting Bits · ⬜ Reverse Bits · ⬜ Missing Number · ⬜ Sum of Two Integers

---

## How a problem is logged
After each attempt the coach records: `[x]` cold-solved · `~` assisted (requeue +3 days) · time taken · which mastery gate it feeds. Position advances only on `[x]`.
