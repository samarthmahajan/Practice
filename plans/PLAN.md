# DSA Mastery Plan — Samarth

Goal: by the end, walk into ANY DS&Algo round with an earned ~90% expected pass rate.
DSA only (LLD / system design / behavioral deliberately out of scope).

## The honest contract
- No plan guarantees 90–95% on a single round — variance is real (an unfamiliar hard, nerves).
- What earns the confidence is the EXIT CRITERIA below. "Done with the course" = those gates are green, NOT "finished the list."
- If you fudge "cold-solve" or skip mocks, the number is fiction. The rules are the plan.

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
- Daily: `/review-dsa` (SRS) for spaced repetition of solved cards.
- Recall drill (DAILY — required): for each pattern keep a card of "trigger words → pattern → **the governing invariant, DERIVED from first principles, not memorized**." Interviews are won at recognition speed *and* invariant precision — see **## Your failure mode** below.

## Your failure mode (precision, not recognition)
Diagnosis from real attempts: your pattern **recognition is fine** — you name the right pattern fast. You lose points on the **precise governing invariant**: the exact operator (`>=` vs `>`), the exact guard (`if (output.isEmpty())`), the boundary *why*. So far every miss has been an invariant, never a misread pattern.
- **The cure is derivation, not volume.** For each pattern, be able to *derive* its rule from "what can never be the answer / boundary?" — never memorize the symbol.
- **Highest-ROI review material = each card's "Watch Out For" + the invariant's WHY.** Re-read these, not new problems, when time is short.
- The gap-drill (cold-write the rule + its justification) is the medicine — run it whenever a pattern logs a Weak.

## Mocks
- **From Week 3:** one **calibration** human mock in Week 3, then **1 human mock/week from Week 5** (Pramp / interviewing.io / peer). The coach can't reproduce pressure or follow-ups — get an external read before banking a month of self-grading.
- `/mock` (AI) any time for timed, no-hint, graded reps between human mocks.

## Capacity
≤4 problems/weekday (9–5 job), heavier weekends. ~25–35/week. Quality (cold + narrated) over raw count.

## When the day overflows (triage rule)
When due-reviews + redo-colds + planned-new exceed the day's capacity, drop in this order:
1. **New problems first** — carry them forward.
2. Then Stage 3+ SRS reviews.
3. **Never** drop a redo-cold or a Stage-1 sprint — those are mastery-critical.
Carry dropped *new* problems; never carry dropped *redos*.

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

---

## CURRENT POSITION
- **Topic:** Week 2 — Arrays & Hashing (in progress). Stacks ladder fully attempted; its mastery gate is still open until the 6 redo-colds below pass cold.
- **Redo cold (2026-06-25):** Decode String (Tier C #6) — `~` 2026-06-22; Basic Calculator II (Tier D) — `~` 2026-06-22; Remove K Digits (Tier E) — `~` 2026-06-22; Remove Duplicate Letters (Tier E) — `~` 2026-06-22; Largest Rectangle in Histogram (Tier F) — `~` 2026-06-22.
- **Redo cold (2026-06-26):** Implement Queue using Stacks (Bridge) — `~` 2026-06-23.
- **Redo cold (2026-06-27):** Valid Anagram (Arrays & Hashing) — `~` 2026-06-24 (off-by-one loop bound; symmetric tests hid it); Group Anagrams (Arrays & Hashing) — `~` 2026-06-24 (int[]-as-key steer; concept was cold, key-precision was the gap); Top K Frequent Elements (Arrays & Hashing) — `~` 2026-06-24 (nudged off O(n log n) sort to bucket-sort; selection-recognition was the gap).
- **Redo cold (2026-06-28):** Product of Array Except Self — `~` 2026-06-25 (level-1 hint used).
- **Next new problem:** Week 2 — Arrays & Hashing: **Encode/Decode Strings** (Product of Array Except Self ~ assisted 2026-06-25).

---

## Curated ladders (✅=cold-solved, ~=assisted/redo, ⬜=todo)

### Stacks  — gate: monotonic + simulation cold medium
Tier A · ✅ Next Greater Element II · ✅ Daily Temperatures
Tier B · ✅ Asteroid Collision · ✅ Simplify Path
Tier C · ✅ Evaluate RPN · ~ Decode String (assisted 2026-06-22 — redo cold 2026-06-25)
Tier D · ~ Basic Calculator II (assisted 2026-06-22 — redo cold 2026-06-25)
Tier E · ~ Remove K Digits (assisted 2026-06-22 — redo cold 2026-06-25) · ~ Remove Duplicate Letters (assisted 2026-06-22 — redo cold 2026-06-25)
Tier F · ~ Largest Rectangle in Histogram (assisted 2026-06-22 — redo cold 2026-06-25) · ✅ Trapping Rain Water (cold 2026-06-23, 4/5)
Bridge · ~ Implement Queue using Stacks (assisted 2026-06-23 — redo cold 2026-06-26)
(Earlier: ✅ Valid Parentheses · ✅ Min Stack · ✅ Prefix→Postfix · ✅ NGE-I)

### Arrays & Hashing — gate: hashing-for-O(1)-lookup cold medium
✅ Two Sum · ✅ Contains Duplicate (cold 2026-06-23, 5/5) · ~ Valid Anagram (assisted 2026-06-24, off-by-one loop bound — redo cold 2026-06-27) · ~ Group Anagrams (assisted 2026-06-24, int[]-as-key steer — redo cold 2026-06-27) · ~ Top K Frequent Elements (assisted 2026-06-24, nudged off sort to bucket-sort — redo cold 2026-06-27) · ~ Product of Array Except Self (assisted 2026-06-25, level-1 hint used — redo cold 2026-06-28) · ⬜ Encode/Decode Strings · ⬜ Longest Consecutive Sequence

### Two Pointers — gate: converging/opposite-ends cold medium
⬜ Valid Palindrome · ⬜ Two Sum II (sorted) · ⬜ 3Sum · ⬜ Container With Most Water

### Sliding Window — gate: variable window + shrink condition cold medium
⬜ Best Time to Buy/Sell Stock · ⬜ Longest Substring Without Repeating · ⬜ Longest Repeating Character Replacement · ⬜ Permutation in String · ⬜ Minimum Window Substring (hard) · ⬜ Sliding Window Maximum (deque)

### Binary Search — gate: "search on the answer" cold medium
⬜ Binary Search · ⬜ Search a 2D Matrix · ⬜ Koko Eating Bananas · ⬜ Find Minimum in Rotated Sorted Array · ⬜ Search in Rotated Sorted Array · ⬜ Median of Two Sorted Arrays (hard)

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
