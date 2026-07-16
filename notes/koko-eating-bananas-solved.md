# Koko Eating Bananas — Medium
Problem Link: https://leetcode.com/problems/koko-eating-bananas/
Solved Date: 2026-07-09
Pattern Tag: binary-search / search-on-answer

## SRS Tracking
- Stage: 1
- Review Date: 2026-07-10
- Last Rating: —
- Review Count: 0
- Graduated: No

<!-- ASSISTED (~) 2026-07-09: structure cold + overflow trap defused unprompted, but shipped `<` instead of `<=` (fails ~43% of inputs); reviewer located the line. SUSPENDED from SRS until redo-cold passes 2026-07-12. -->

---

# Real World Analogy
- Turning a thermostat dial: find the LOWEST setting that still gets the room warm enough by the deadline. Nudge down while it still works, stop the moment it doesn't.

## Core Insight
You're not searching an array — you're searching the **answer space** of possible speeds `[1, maxPile]`. Feasibility (`hours(k) <= h`) is **monotonic**: once a speed is fast enough, every faster speed is too. Binary search finds that too-slow / fast-enough boundary, and the boundary IS the minimum answer.

## Approach
Binary search on the eating speed `k` over `[1, max(piles)]`. For each candidate `k`, compute total hours = `Σ ⌈pile/k⌉`; if `<= h` it's feasible so record it and try a *slower* speed, otherwise go *faster*. Return the smallest feasible speed.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Search speeds [1, maxPile], not indices  ║ The answer is a VALUE (a speed) and feasibility is   ║
║                                          ║ monotonic in it; maxPile is the fastest useful speed ║
║                                          ║ (one pile/hour → n hours, and h >= n always holds)   ║
║ hours += (pile + k - 1) / k              ║ Integer CEILING — a pile of 6 at speed 4 costs 2     ║
║                                          ║ whole hours; leftover time in an hour is wasted      ║
║ feasible → ans = mid; hi = mid - 1       ║ It works, so try SLOWER to minimize; record it       ║
║ infeasible → lo = mid + 1                ║ Too slow → the only hope is a faster speed           ║
║ Loop while lo <= hi   (NOT lo < hi)      ║ At lo==hi one never-tested speed remains, sitting    ║
║                                          ║ exactly on the too-slow/fast-enough boundary — it    ║
║                                          ║ may BE the answer. ans records only TESTED mids, so  ║
║                                          ║ `<` drops that cell and returns answer+1             ║
║ totalHours is long                       ║ Per-pile term is int-safe (both <= 1e9 → < 2^31) but ║
║                                          ║ the SUM across up to 1e4 piles overflows int         ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
maxPile = max(piles)
lo = 1, hi = maxPile, ans = maxPile        # maxPile is always feasible (n hours <= h)
while lo <= hi:
    k = lo + (hi - lo) / 2
    hours = 0                              # long
    for pile in piles:
        hours += (pile + k - 1) / k        # ceiling division
    if hours <= h:
        ans = k
        hi = k - 1                         # feasible → hunt for a smaller speed
    else:
        lo = k + 1                         # too slow → need a bigger speed
return ans
```

## Complexity

### Time: O(n · log M)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Binary search steps   ║ O(log M)       ║ M = max(piles); speed range halved each step ║
║ Feasibility per step  ║ O(n)           ║ n = piles.length; one pass to sum the hours  ║
║ Total                 ║ O(n · log M)   ║ n scans × log M iterations                   ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ lo, hi, ans, sum ║ O(1)     ║ Only scalars; no auxiliary structures        ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- **`lo <= hi`, NOT `lo < hi`** — this is the exact bug this attempt shipped. In the candidate-tracking form (`hi = mid - 1` + an `ans` var), `<` exits with one never-tested cell on the boundary and returns **answer + 1**. Fuzzed at ~43% wrong. Two valid templates exist; don't cross them:
  - `lo <= hi` + `ans = mid; hi = mid - 1` → return `ans`  (this card)
  - `lo <  hi` + `hi = mid` (no `ans`) → return `lo`
  - `lo < hi` with `hi = mid - 1` is the trap.
- **Integer ceiling** `(pile + k - 1) / k` — never `Math.ceil((double) pile / k)`; floating point will bite.
- **`long` for the hours sum** — the per-pile term is int-safe, but the running total across up to 1e4 piles overflows `int`.
- **lo = 1, not 0** — speed 0 eats nothing (and divides by zero).
- **hi = maxPile** — any faster is wasted (one pile per hour cap).

## Dry Run
piles = [10, 7], h = 3 — the counterexample where `<` returned 8; `<=` returns 7.

| lo | hi | k | hours = ⌈10/k⌉ + ⌈7/k⌉ | action |
|---|---|---|---|---|
| 1 | 10 | 5 | 2 + 2 = 4 > 3 | too slow → lo = 6 |
| 6 | 10 | 8 | 2 + 1 = 3 ≤ 3 | ans = 8, hi = 7 |
| 6 | 7  | 6 | 2 + 2 = 4 > 3 | too slow → lo = 7 |
| 7 | 7  | 7 | 2 + 1 = 3 ≤ 3 | ans = 7, hi = 6 |
| 7 | 6  | — | lo > hi → stop | return **7** |

The 4th row is the cell `<` never tests — and it was the answer.

## Boiler Plate Template
Generic "search on the answer" (minimize) — candidate-tracking form:
```java
int lo = MIN_ANSWER, hi = MAX_ANSWER, ans = hi;   // ans init = a guaranteed-feasible value
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;
    if (feasible(mid)) {      // condition holds → record and try smaller
        ans = mid;
        hi = mid - 1;
    } else {                  // condition fails → go bigger
        lo = mid + 1;
    }
}
return ans;

// feasible(mid): can we hit the goal at setting = mid?  (monotonic in mid)
```
