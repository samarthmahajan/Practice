# 3Sum — Medium
Problem Link: https://leetcode.com/problems/3sum/
Solved Date: 2026-06-27
Pattern Tag: two-pointer / triplet-dedup

## SRS Tracking
- Stage: 1
- Review Date: 2026-06-28
- Last Rating: —
- Review Count: 0
- Graduated: No

---

# Real World Analogy
Pin one runner at a fixed spot (the anchor). Two other runners start at the ends
of the remaining track and walk toward each other; the sorted track tells them
which way to step to hit the target. When several runners wear the same number
(duplicate values), only let the first of each number play — the rest produce the
same team you've already recorded.

## Core Insight
Fix one number (anchor), then the problem collapses to Two Sum II on the rest:
find two numbers summing to -anchor with a converging two-pointer. Sorting is the
enabler — it powers both the pointer moves AND O(1) duplicate skipping (equal
values are adjacent).

## Approach
Sort. For each anchor i, run two pointers lo=i+1, hi=n-1 looking for sum 0.
Suppress duplicates in three places: skip an anchor equal to the previous one,
and after recording a hit, skip lo/hi past repeated values.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ for-loop over anchor, reset lo/hi inside ║ Guarantees BOTH pointers restart per anchor; a while ║
║                                          ║ loop invites forgetting to reset hi (stale pointer). ║
║ skip anchor if nums[i]==nums[i-1]        ║ Same anchor value reproduces identical triplets.     ║
║ after a hit, skip dup lo and dup hi      ║ Same lo/hi values with same anchor = same triplet.   ║
║ use for-loop so continue is safe         ║ i++ is in the loop header → continue can't infinite. ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
sort(nums)
for i in 0 .. n-3:
    if i > 0 and nums[i] == nums[i-1]: continue      # dup anchor
    lo = i+1, hi = n-1
    while lo < hi:
        sum = nums[i] + nums[lo] + nums[hi]
        if sum == 0:
            record (nums[i], nums[lo], nums[hi])
            lo++; hi--
            while lo < hi and nums[lo] == nums[lo-1]: lo++    # dup lo
            while lo < hi and nums[hi] == nums[hi+1]: hi--    # dup hi
        elif sum > 0: hi--
        else: lo++
```

## Complexity

### Time: O(n^2)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Sort                  ║ O(n log n)     ║ Arrays.sort.                                 ║
║ Anchor + two-pointer  ║ O(n^2)         ║ n anchors, each an O(n) converging sweep.    ║
║ Total                 ║ O(n^2)         ║ n^2 dominates n log n.                        ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1) (excluding output / sort)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ Pointers         ║ O(1)     ║ Sorted order replaces any hash set for dedup.║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- DEDUP IS THE PROBLEM. Three spots: anchor, lo-after-hit, hi-after-hit. Missing
  any one → duplicate triplets.
- Reset BOTH lo and hi per anchor. Resetting lo but carrying a stale hi silently
  DROPS valid triplets (passes sample tests, fails on harder inputs).
- "Passes the given examples" != correct. Build a duplicate-heavy input yourself
  (e.g. [-2,-2,0,0,2,2]) before trusting an "all unique" solution.
- Loop bound n-2 (or i < n) so empty / 1-element arrays don't blow up.
- Prefer for-loop over anchor so `continue` can't skip the increment.

## Dry Run
nums = [-1,0,1,2,-1,-4] → sort → [-4,-1,-1,0,1,2]
  i=0(-4): lo=1 hi=5 → -3<0 lo++; ... never hits 0
  i=1(-1): lo=2(-1) hi=5(2): -1-1+2=0 ✓ [-1,-1,2]; lo=3 hi=4: -1+0+1=0 ✓ [-1,0,1]; lo=4 hi=3 stop
  i=2(-1): nums[2]==nums[1] → skip (dup anchor)  ← this is what prevents the repeat
  i=3(0): lo=4 hi=5: 0+1+2=3>0 hi-- → lo=4 hi=4 stop
  result [[-1,-1,2],[-1,0,1]]  ✓

Counterexample that broke the buggy version:
  [-4,-2,-1,0,1,3] → must include [-2,-1,3]; the stale-hi bug missed it.

## Boiler Plate Template
Anchor + converging two-pointer with 3-spot dedup:

```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;       // dup anchor
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum == 0) {
                res.add(List.of(nums[i], nums[lo], nums[hi]));
                lo++; hi--;
                while (lo < hi && nums[lo] == nums[lo - 1]) lo++;   // dup lo
                while (lo < hi && nums[hi] == nums[hi + 1]) hi--;   // dup hi
            } else if (sum > 0) hi--;
            else lo++;
        }
    }
    return res;
}
```
