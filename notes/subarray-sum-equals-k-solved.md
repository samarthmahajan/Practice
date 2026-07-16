---

# Subarray Sum Equals K — Medium
Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/
Solved Date: 2026-07-16
Pattern Tag: hashing / prefix-sum-frequency

<!-- GATE PROBE #1 (Arrays & Hashing rotation, 2026-07-16) — clean [x], 22 min, 4-axis pure.
     Not a curated-ladder item. Counts toward the A&H mastery gate: 1 pass / 1 attempt (gate needs 2 of last 3). -->

## SRS Tracking
- Stage: 2
- Review Date: 2026-07-19
- Last Rating: —
- Review Count: 0
- Graduated: No

---

# Real World Analogy
You're walking a trail, logging your **cumulative altitude** at every step — not the height of each individual climb, but total-so-far. Someone asks: "how many stretches of this trail had a net gain of exactly k?" You don't re-walk every stretch. At each step you ask: *"have I ever previously stood at altitude (current − k)?"* — because if you had, the stretch from there to here gained exactly k. And if you stood at that altitude **three separate times**, that's **three** different stretches ending here. So you keep a tally of how many times you've stood at each altitude, not just whether you have.

## Core Insight
`sum(i..j) = prefix[j] − prefix[i−1]`, so "does a subarray ending at j sum to k?" becomes "have I seen the prefix value `prefix[j] − k` before?" — and because a prefix value can **recur**, the map must store a **frequency**, not a boolean: every earlier occurrence is a distinct left endpoint, hence a distinct subarray.

## Approach
Sweep once, keeping a running total. At each element, ask how many earlier running totals equal `total − k`; every one of them marks the start of a subarray ending here that sums to k, so add that *count* to the answer. Then record the current total in the map. Seed the map with `{0: 1}` for the empty prefix, so subarrays starting at index 0 are counted. Check before inserting, never after.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Map stores FREQUENCY, not a boolean      ║ The same prefix sum recurs; each occurrence is a     ║
║ count += map.get(total-k), NOT count++   ║ distinct left endpoint = a distinct subarray.        ║
║                                          ║ [1,-1,1,-1,1], k=1 → prefixes 1,0,1,0,1; the value   ║
║                                          ║ 1 recurs 3× . count++ throws that multiplicity away. ║
║ Seed map.put(0, 1)                       ║ It is the EMPTY PREFIX — the altitude before the     ║
║                                          ║ walk starts. Without it, any subarray beginning at   ║
║                                          ║ index 0 is invisible: [3], k=3 → total=3, look for   ║
║                                          ║ 0, absent → returns 0 instead of 1.                  ║
║ CHECK total-k BEFORE inserting total     ║ Insert-first breaks at k=0: total-k == total, which  ║
║                                          ║ you just inserted, so every index counts the EMPTY   ║
║                                          ║ subarray of length 0 against itself → overcounts by  ║
║                                          ║ exactly n. k=0 is the trigger; k≠0 hides the bug.    ║
║ Prefix-frequency, NOT a sliding window   ║ A window needs the sum to move MONOTONICALLY as you  ║
║                                          ║ extend/shrink, so "too big → shrink" is a valid      ║
║                                          ║ inference. nums[i] can be NEGATIVE → shrinking may   ║
║                                          ║ INCREASE the sum → the grow/shrink decision procedure║
║                                          ║ is undefined. Negatives are the tell.                ║
║ int is safe — no long needed             ║ |prefix| ≤ 2×10⁴ × 10³ = 2×10⁷; max count is         ║
║                                          ║ n(n+1)/2 ≈ 2×10⁸. Both inside int. (Contrast Koko,   ║
║                                          ║ where the feasibility sum DOES overflow.)            ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

**The invariant (say this OUT LOUD before writing a line):**
> After processing index j, the map holds the frequency of every prefix sum for indices `-1 .. j`, and `count` holds the number of subarrays ending at or before j that sum to k.

## Pseudocode
```
map = {0: 1}                       // the empty prefix — altitude before the walk
total = 0, count = 0

for num in nums:
    total += num
    count += map.getOrDefault(total - k, 0)   // CHECK FIRST — every earlier occurrence is one subarray
    map.merge(total, 1, sum)                  // insert AFTER — or k=0 self-counts the empty subarray

return count
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Single sweep          ║ O(n)           ║ Each element visited exactly once.           ║
║ Map lookup + insert   ║ O(1) amortized ║ HashMap; worst case O(n) per op on adversarial║
║                       ║                ║ collisions, irrelevant for int keys here.    ║
║ Total                 ║ O(n)           ║ n iterations × O(1) amortized.               ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(n)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ prefix-count map ║ O(n)     ║ Worst case every prefix sum is distinct →     ║
║                  ║          ║ n+1 entries (incl. the seed).                ║
║ total, count     ║ O(1)     ║ Two ints.                                    ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Why this is optimal
You must read every element (any unread element could change the answer), so O(n) time is the floor and this hits it. The O(n) space is what buys the single pass — it's the classic time-for-space trade against the O(n²) all-pairs scan. You cannot do O(n) time *and* O(1) space in general, because with negatives there's no monotonic structure to exploit and no way to discard prefix history.

## Watch Out For
- **`count += freq`, never `count++`.** The map's value is a *count* of earlier occurrences, and each one is a distinct subarray. `[1,-1,1,-1,1]`, k=1 exposes it.
- **The `{0: 1}` seed is not a hack** — it's the empty prefix. Drop it and every subarray starting at index 0 vanishes. Minimal breaker: `[3]`, k=3 → returns 0.
- **Check before insert. k=0 is the trigger.** Insert-first makes `total - k == total` hit the entry you just added → counts the length-0 subarray at every index → overcounts by exactly n. Every other k hides this bug, so a test suite without k=0 will pass a broken solution.
- **`[0,0,0]`, k=0 → 6**, not 3. All six contiguous subarrays sum to 0. If your answer is 3 you're counting elements, not subarrays.
- **Negatives are the whole reason this isn't a window.** If the problem said "all positive," a sliding window WOULD work — and that's the discrimination an interviewer is testing.
- Subarrays are **contiguous** and **non-empty**; overlapping ones each count separately.

## Dry Run
`nums = [1, 2, 3]`, `k = 3` — expected 2

```
map = {0:1}   total=0   count=0

i=0, num=1 → total = 1
     look for total-k = 1-3 = -2  → absent, count stays 0
     insert 1                      → map {0:1, 1:1}

i=1, num=2 → total = 3
     look for 3-3 = 0              → PRESENT ×1  → count = 1
                                     (the empty prefix → subarray [1,2]) ✓
     insert 3                      → map {0:1, 1:1, 3:1}

i=2, num=3 → total = 6
     look for 6-3 = 3              → PRESENT ×1  → count = 2
                                     (prefix after [1,2] → subarray [3]) ✓
     insert 6                      → map {0:1, 1:1, 3:1, 6:1}

return 2  ✓
```

Multiplicity check — `nums = [1,-1,1,-1,1]`, k=1:
```
prefix sums:  1, 0, 1, 0, 1
i=0 total=1: look 0 → ×1 → count=1        map {0:1, 1:1}
i=1 total=0: look -1 → absent → count=1   map {0:2, 1:1}
i=2 total=1: look 0 → ×2 → count=3        map {0:2, 1:2}   ← count++ would have given 2. WRONG.
i=3 total=0: look -1 → absent → count=3   map {0:3, 1:2}
i=4 total=1: look 0 → ×3 → count=6        map {0:3, 1:3}
return 6   (count++ would return 3 — half the answer)
```

Verified beyond the samples: 60,005 randomized cases vs brute force — small value ranges to force duplicate prefix sums, negatives, zeros, k∈[-4,4]. Zero failures. Targeted edges all pass: `[0]`/k=0→1, `[0,0,0]`/k=0→6, `[-1,-1,1]`/k=-1→3, `[1,-1,0]`/k=0→3.

## Boiler Plate Template
Reusable for any "count/find contiguous subarrays whose sum (or count-difference) equals a target" question — including the map-a-condition-to-±1 variants.

```java
public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);                                   // the EMPTY prefix — enables subarrays from index 0
    int total = 0, count = 0;

    for (int num : nums) {
        total += num;
        count += prefixCount.getOrDefault(total - k, 0);     // CHECK FIRST — freq, not boolean (each = one subarray)
        prefixCount.merge(total, 1, Integer::sum);           // INSERT AFTER — else k=0 self-counts the empty subarray
    }
    return count;
}
```

**Style note:** the solved version used `containsKey` + `get` + `put(..., getOrDefault(...)+1)`. `getOrDefault` and `merge` are the idiomatic equivalents — identical semantics, less surface area. Worth adopting; it's the form the § HASHMAP cheatsheet uses.

**Transfer note:** the moment a problem says *contiguous subarray* + *sum/count equals a target* + values can be **negative**, this is the shape — NOT a window. Direct descendants: Contiguous Array (map 0→−1, 1→+1, then it's this problem with k=0), Subarray Sums Divisible by K (key on `sum % k`, watch negative modulo), Binary Subarrays With Sum, Continuous Subarray Sum. The generalization: *any* condition you can turn into a running scalar becomes this template.
