# Longest Consecutive Sequence — Medium
Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/
Solved Date: 2026-06-27
Pattern Tag: hashing / set-membership

## SRS Tracking
- Stage: 2
- Review Date: 2026-07-07
- Last Rating: Strong
- Review Count: 2
- Graduated: No

> 2026-07-05 redo-cold: PASSED per suspension rule (pass = Strong review). 20/30 min, 5/5 first run. Set-iteration fix owned (06-27 O(n²) gap closed); O(n) WHY (≤2n, run walked once from its unique top) produced in own words after one prompt. Ding: initial narration arrived LaTeX-formatted, flagged; WHY needed asking.

---

# Real World Analogy
- A pile of shuffled house-number cards. To find the longest unbroken street, you don't sort them — you spot the cards that have NO higher neighbor (no x+1 card exists), and from each of those "end of street" cards you count backwards x-1, x-2, … as long as the card exists. Every card gets walked once because only the street's endpoint kicks off a count.

## Core Insight
Sorting is banned (O(n) required), so trade O(n) space for O(1) membership via a HashSet, then only let a value START a run-walk if it's a boundary (`x+1` absent) — that guarantees each value is walked exactly once → O(n).

## Approach
Dump all numbers into a HashSet (pass 1). Then iterate **over the set** (pass 2); for each value with no `x+1` present (it's the top of its run), walk downward `x-1, x-2, …` counting set hits. Track the max run length.

## Mental Model

╔══════════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                     ║ Why                                                  ║
╠══════════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ HashSet, not sort                            ║ O(1) existence check removes the O(n log n) sort.    ║
║ Build whole set BEFORE testing               ║ Two-pass: order of arrival becomes irrelevant once   ║
║                                              ║ every value is already in the set.                   ║
║ Only start where x+1 is ABSENT               ║ Only the run's boundary walks; interior values skip  ║
║                                              ║ in O(1) → each value walked once → O(n).             ║
║ Iterate over the SET, not the array          ║ The array can have duplicates; a duplicated run-top  ║
║                                              ║ would re-walk its whole run → O(n²). Set dedups it.  ║
╚══════════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
set = HashSet(nums)            // pass 1 — all in
best = 0
for x in set:                  // pass 2 — iterate the SET (dedup!)
    if (x+1) in set: continue  // not a boundary → skip
    len = 0
    cur = x
    while cur in set:          // walk downward
        len++; cur--
    best = max(best, len)
return best
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Build set             ║ O(n)           ║ One insert per element.                       ║
║ Walks                 ║ O(n)           ║ Only boundaries walk; each value visited once ║
║                       ║                ║ across all walks (set-iteration dedups).      ║
║ Total                 ║ O(n)           ║ Linear.                                       ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(n)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ HashSet          ║ O(n)     ║ Up to n distinct values; required working mem.║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- **Iterate the SET, not the input array.** Looping over `nums` with k duplicates of a run-top re-walks that run k times → O(n²) on adversarial input. This was THE miss on the first attempt. Set-iteration makes each boundary walk exactly once.
- **Two passes, not one.** Build the full set before any membership test, else "is x+1 present?" is unreliable while still inserting.
- **Empty array → 0.** `best` starts at 0 and the loop never runs — no crash.
- **Duplicates don't extend a run** — they collapse in the set automatically (`[1,2,0,1]` → run 0,1,2 → 3, not 4).
- Boundary test is `x+1 absent` (walk down) OR symmetric `x-1 absent` (walk up) — pick one, not both.

## Dry Run
nums = [100, 4, 200, 1, 3, 2]  →  set = {1,2,3,4,100,200}
Iterate set, test "is x+1 present?":
- 1 → 2? yes → skip
- 2 → 3? yes → skip
- 3 → 4? yes → skip
- 4 → 5? no → START → walk 4,3,2,1 → len 4 ✅  (best=4)
- 100 → 101? no → START → len 1
- 200 → 201? no → START → len 1
answer = 4

Adversarial (why iterate the set): nums = [5,5,5,5,4,3,2,1]
- Over the ARRAY: each of the four 5s walks 5,4,3,2,1 → 4×5 work → O(n²) ✗
- Over the SET {1,2,3,4,5}: only one 5 → one walk → O(n) ✓

## Boiler Plate Template
Reusable for "longest run of consecutive values in an unsorted collection, O(n)."

```java
public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) set.add(n);            // pass 1: all in

    int best = 0;
    for (int x : set) {                       // pass 2: iterate the SET (dedups)
        if (set.contains(x + 1)) continue;    // not a run-top → skip O(1)
        int len = 0, cur = x;
        while (set.contains(cur)) { len++; cur--; }   // walk down
        best = Math.max(best, len);
    }
    return best;
}
```
