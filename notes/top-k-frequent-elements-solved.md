---

# Top K Frequent Elements — Medium
Problem Link: https://leetcode.com/problems/top-k-frequent-elements/
Solved Date: 2026-06-24
Pattern Tag: bucket-sort / top-k-frequency

## SRS Tracking
- Stage: 3
- Review Date: 2026-07-10
- Last Rating: Strong
- Review Count: 2
- Graduated: No

---

# Real World Analogy
- Election tally: drop each ballot into the pile for its candidate (frequency map), then read the leaderboard from the tallest pile down — you never alphabetize all candidates, you just skim from the top until you have the winners.

## Core Insight
"Top k / k most frequent" is a **selection** problem, not a sort problem: build a frequency map, then place each value into a bucket **indexed by its frequency**, and read buckets from high index downward — O(n), no comparison sort.

## Approach
Count frequencies into a `Map<value,count>`. Make an array `buckets[0..n]` where `buckets[f]` is the list of values that occur exactly `f` times (frequency can be at most `n`). Walk buckets from the highest index down, collecting values until you have `k`.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Bucket index = frequency                 ║ counting-sort idea → O(n), beats O(n log n) sort     ║
║ Bucket array size = n + 1                ║ a value can occur n times → need index n to exist    ║
║ Scan high index → low, stop at k         ║ most frequent first; only need top k, skip the rest  ║
║ "top k / k most frequent" → SELECTION    ║ trigger: reach for bucket/heap, never a full sort    ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
freq = {}                              // value -> count
for x in nums: freq[x]++
buckets = new List[n + 1]              // index = frequency
for (val, f) in freq: buckets[f].add(val)
result = []
for i = n down to 1, while result.size < k:
    for val in buckets[i] (if any):
        result.add(val); if result.size == k: stop
return result
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Frequency map         ║ O(n)           ║ one pass over nums                           ║
║ Fill buckets          ║ O(u)           ║ u = unique values ≤ n                        ║
║ Scan buckets          ║ O(n)           ║ array length n+1, total values ≤ n           ║
║ Total                 ║ O(n)           ║ no comparison sort → beats O(n log n)        ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(n)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ Frequency map    ║ O(u)     ║ one entry per unique value                   ║
║ Bucket array     ║ O(n)     ║ length n+1                                   ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- **Bucket array size MUST be `n + 1`** — max frequency is `n` (all equal), indexed by frequency → size `n` crashes on `[7,7,7]`.
- "Top k / k most frequent / k largest" is the **selection** trigger — bucket sort O(n) or heap O(n log k), NEVER a full O(n log n) sort. The follow-up exists precisely to punish the sort.
- Stop as soon as `idx == k`; don't keep filling past `result` (size exactly `k`; safe because `k ≤ #unique`).
- `List<Integer>[]` generic-array creation throws an unchecked warning — harmless on LeetCode.

## Dry Run
nums = [1,1,1,2,2,3], k = 2
- freq = {1:3, 2:2, 3:1}
- buckets: [3]→[1], [2]→[2], [1]→[3]
- scan i=6..: i=3 → take 1 (idx 1); i=2 → take 2 (idx 2 == k, break)
- result = [1, 2]

## Boiler Plate Template
Bucket-sort selection (top-k by frequency):

```java
Map<Integer, Integer> freq = new HashMap<>();
for (int x : nums) freq.merge(x, 1, Integer::sum);

List<Integer>[] buckets = new List[nums.length + 1];   // index = frequency
for (var e : freq.entrySet()) {
    int f = e.getValue();
    if (buckets[f] == null) buckets[f] = new ArrayList<>();
    buckets[f].add(e.getKey());
}

int[] result = new int[k];
int idx = 0;
for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
    if (buckets[i] == null) continue;
    for (int val : buckets[i]) {
        result[idx++] = val;
        if (idx == k) break;
    }
}
return result;
```

## Solve Log
- 2026-06-24 — `~` assisted (Medium, in time). Frequency-map baseline cold; first instinct was O(n log n) sort, needed a pointed nudge ("structure that gives top-k without full ordering") to reach bucket sort. Once nudged, derived + implemented bucket sort cleanly (correct n+1 sizing, high→low scan). Requeued redo cold 2026-06-27. MAANG 4/5.
