---

# Binary Search — Easy
Problem Link: https://leetcode.com/problems/binary-search/
Solved Date: 2026-06-30
Pattern Tag: binary-search / standard

## SRS Tracking
- Stage: 1
- Review Date: 2026-07-01
- Last Rating: —
- Review Count: 0
- Graduated: No

---

# Real World Analogy
- Looking up a word in a physical dictionary: open to the middle, decide "earlier or later half," tear the other half away, repeat. Each peek halves the pages left.

## Core Insight
The loop runs while the window `[low, high]` is NON-EMPTY — which is exactly `low <= high`. When `low == high` the window still holds one cell that has never been compared to target, so the loop MUST run on it. That single fact decides `<=` vs `<`.

## Approach
Hold a candidate window `[low, high]`. Peek at `mid`; if it equals target, return it. Otherwise the half on the wrong side of `mid` provably can't contain target, so discard it by moving `low = mid + 1` or `high = mid - 1`. Window strictly shrinks every step until it's empty.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ while (low <= high)                      ║ window [low,high] is non-empty iff low<=high; at     ║
║                                          ║ low==high one UNCHECKED cell remains → must run      ║
║ mid = low + (high-low)/2                 ║ overflow-safe midpoint (avoids low+high overflow)    ║
║ nums[mid] < target → low = mid+1         ║ mid and everything left of it are too small → drop   ║
║ nums[mid] > target → high = mid-1        ║ mid and everything right of it are too big → drop    ║
║ exclude mid via +1/-1                    ║ guarantees window strictly shrinks → always reaches  ║
║                                          ║ [i,i] then empties → terminates, no special cases    ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
low = 0, high = n - 1
while low <= high:
    mid = low + (high - low) / 2
    if nums[mid] == target: return mid
    else if nums[mid] < target: low = mid + 1
    else: high = mid - 1
return -1
```

## Complexity

### Time: O(log n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ each iteration        ║ O(1)           ║ one compare + one pointer move               ║
║ iterations            ║ O(log n)       ║ window halves every step                     ║
║ Total                 ║ O(log n)       ║                                              ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ low/high/mid     ║ O(1)     ║ three int pointers, iterative (no recursion) ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- `while (low < high)` is the classic bug: it skips the final single-cell window `[i,i]`, so a target isolated to one cell returns -1. Use `<=`. (This was the miss on this attempt.)
- Do NOT patch it with an early "if length == 1" guard — the single-cell window forms mid-search too (e.g. [2,5] target 5 collapses to [1,1]); only `<=` fixes the cause.
- Use `low + (high-low)/2`, not `(low+high)/2`, to avoid integer overflow on large indices.

## Dry Run
nums = [2,5], target = 5  (the case that exposes the `<` bug)
- low=0, high=1, mid=0, nums[0]=2 < 5 → low=1
- low=1, high=1 → `1 <= 1` true (with `<` this would wrongly exit)
- mid=1, nums[1]=5 == 5 → return 1 ✓

## Boiler Plate Template
Standard exact-match binary search on a sorted array:

```java
int low = 0, high = nums.length - 1;
while (low <= high) {
    int mid = low + (high - low) / 2;
    if (nums[mid] == target) return mid;
    else if (nums[mid] < target) low = mid + 1;
    else high = mid - 1;
}
return -1;
```
