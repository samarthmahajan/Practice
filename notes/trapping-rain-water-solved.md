# Trapping Rain Water — Hard
Problem Link: https://leetcode.com/problems/trapping-rain-water/
Solved Date: 2026-06-23
Pattern Tag: two-pointer / converging-max

## SRS Tracking
- Stage: 4
- Review Date: 2026-07-21
- Last Rating: Strong
- Review Count: 2
- Graduated: No

<!-- Cold-solved unaided in time box, 4/5. Derived the O(1)-space two-pointer formulation
     and justified the shorter-side invariant without hints. -->

---

# Real World Analogy
- Two people walk toward each other across the skyline, each remembering the tallest wall they've passed. Whoever stands in front of the **shorter outer wall** can safely measure the puddle at their feet — the taller far wall guarantees the water can't drain out their side, so their own running max is the only thing that caps it.

## Core Insight
With two pointers converging from both ends, the side whose bar is **shorter** is always safe to resolve: a taller bar on the opposite side guarantees water cannot spill that way, so trapped water at the shorter pointer is fully determined by the running max on **its own** side — no need to know the true opposite wall yet.

## Approach
Place a pointer at each end, track `leftMax` and `rightMax`. Each step, process whichever bar is shorter: if it's a new max, raise that side's wall (adds 0 water); otherwise it traps `sideMax − height` units. Move that pointer inward; repeat until the pointers meet.

## Mental Model

| Decision | Why |
|---|---|
| `height[left] < height[right]` → resolve the **LEFT** side | A taller right wall guarantees containment on the right, so `leftMax` alone caps the water — safe to settle now. |
| `height[left] >= height[right]` → resolve the **RIGHT** side | Symmetric: the left wall is tall enough; `rightMax` is the binding cap. |
| `cur >= sideMax` → update `sideMax`, add **0** | A bar can't trap water on top of itself; it just becomes the new wall. |
| `cur < sideMax` → `total += sideMax − cur` | The taller wall behind it holds water over this dip. |

## Pseudocode
```
left=0, right=n-1, leftMax=0, rightMax=0, total=0
while left < right:
  if height[left] < height[right]:
     if height[left] >= leftMax: leftMax = height[left]
     else:                       total += leftMax - height[left]
     left++
  else:
     if height[right] >= rightMax: rightMax = height[right]
     else:                         total += rightMax - height[right]
     right--
return total
```

## Complexity

### Time: O(n)

| Component | Cost | Why |
|---|---|---|
| Pointer sweep | O(n) | left and right move inward only; together they cross the array once |
| Per-step work | O(1) | one compare + one add, no nested loop |
| Total | O(n) | single linear convergence |

### Space: O(1)

| Structure | Size | Why |
|---|---|---|
| left, right, leftMax, rightMax, total | O(1) | five scalars; no arrays |

> Upgrade over the **prefix-max** version (build `leftMax[]` + `rightMax[]` = O(n) space) and the **monotonic-stack** "fill by horizontal layers" version. All three are valid — two-pointer is the cleanest and the only O(1)-space one.

## Watch Out For
- **Resolve the SHORTER side** — advance the pointer whose bar is smaller. Picking the taller side breaks the containment guarantee.
- `>=` on the max update: when `cur` equals the max it adds **0** water and raises the wall. Correct, not a bug.
- **Empty array**: `right = length - 1 = -1`, `while (0 < -1)` never runs → returns 0. No explicit guard needed.
- Don't reach for the opposite wall's real value — the whole trick is that you *don't need it* when you resolve the shorter side.

## Dry Run
```
height = [4, 2, 0, 3, 2, 5]   → 9

left=0 right=5  leftMax=0 rightMax=0 total=0
h[0]=4 < h[5]=5 → left: 4 >= 0 → leftMax=4            left=1
h[1]=2 < h[5]=5 → left: 2 <  4 → total += 4-2 = 2     left=2  (total 2)
h[2]=0 < h[5]=5 → left: 0 <  4 → total += 4-0 = 4     left=3  (total 6)
h[3]=3 < h[5]=5 → left: 3 <  4 → total += 4-3 = 1     left=4  (total 7)
h[4]=2 < h[5]=5 → left: 2 <  4 → total += 4-2 = 2     left=5  (total 9)
left(5) < right(5)? no → stop → return 9  ✓
(rightMax never used — left wall stayed the binding cap the whole way)
```

## Boiler Plate Template
Standard "converging two-pointer with running max from both ends" skeleton (resolve the shorter side):

```java
public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0, total = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) leftMax = height[left];
            else                         total += leftMax - height[left];
            left++;
        } else {
            if (height[right] >= rightMax) rightMax = height[right];
            else                           total += rightMax - height[right];
            right--;
        }
    }
    return total;
}
```
