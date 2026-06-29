---

# Container With Most Water — Medium
Problem Link: https://leetcode.com/problems/container-with-most-water/
Solved Date: 2026-06-28
Pattern Tag: two-pointer / converging-ends

## SRS Tracking
- Stage: 1
- Review Date: 2026-06-29
- Last Rating: —
- Review Count: 0
- Graduated: No

> Note: logged `~` ASSISTED. Code was cold, optimal, bug-free on first run; recognition was cold. BUT the governing-invariant WHY ("the short wall has already achieved its max possible area at the current widest span") was coach-supplied during the dry run, not produced cold. Redo cold 2026-07-01 — flips to `[x]` only when the WHY is stated unaided.

---

# Real World Analogy
- Two people holding up a banner between them across a field. The banner can only hang as low as the SHORTER person's hand (water spills over the lower wall). To hold more, the shorter person should step toward the other — staying put only ever shrinks the field width without ever raising the cap.

## Core Insight
The water a pair holds is capped by the SHORTER wall, so the shorter wall has already extracted its best-possible area at the current (widest) span — keep it and you can only get shorter-or-equal AND narrower, strictly worse. So discard the shorter wall every step.

## Approach
Put one pointer at each end (max width to start). Compute area = min(heights) × width, track the max. Then move the pointer at the shorter wall inward — never the taller one, because the shorter wall is the limiting factor and has nothing more to give. Repeat until pointers meet.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Start pointers at both ends              ║ Width starts maximal; only width can shrink onward   ║
║ height = min(left, right)                ║ Water spills over the SHORTER wall                    ║
║ Move the pointer at the shorter wall     ║ Short wall already maxed its area at widest span;     ║
║                                          ║ keeping it → shorter-or-equal AND narrower = worse    ║
║ On a tie, move either                    ║ Both walls have maxed their width-area; safe          ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
maxArea = 0
left = 0, right = n - 1
while left < right:
    area = min(height[left], height[right]) * (right - left)
    maxArea = max(maxArea, area)
    if height[left] <= height[right]:
        left++
    else:
        right--
return maxArea
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Pointer sweep         ║ O(n)           ║ Each step moves one pointer inward by 1      ║
║ Total                 ║ O(n)           ║ Pointers meet after at most n-1 moves        ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ scalars only     ║ O(1)     ║ maxArea, left, right — no extra structure    ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- Move the SHORTER wall, not the taller — the whole O(n) hinges on this. Get the comparison direction wrong and you discard the wrong containers.
- Width is `right - left` (index distance), NOT a count of bars between.
- `min` of the two heights BEFORE multiplying — the cap is the shorter wall, not either one.
- The invariant WHY (interview-ready): "the shorter wall has already achieved its max possible area at the current widest span, so any container keeping it is strictly worse — shorter-or-equal and narrower."

## Dry Run
height = [1, 8, 6, 2, 5, 4, 8, 3, 7]

```
left=0(h=1) right=8(h=7): area = min(1,7)*8 = 8   → maxArea=8 ; h[left]<=h[right] → left++
left=1(h=8) right=8(h=7): area = min(8,7)*7 = 49  → maxArea=49; h[left]>h[right]  → right--
left=1(h=8) right=7(h=3): area = min(8,3)*6 = 18  → maxArea=49; right--
left=1(h=8) right=6(h=8): area = min(8,8)*5 = 40  → maxArea=49; tie → left++
... no pair ever beats 49 ...
return 49
```

## Boiler Plate Template
Converging two-pointer where each step provably eliminates one endpoint:

```java
int left = 0, right = n - 1, best = 0;
while (left < right) {
    best = Math.max(best, scoreOf(left, right));
    if (limitingSideIsLeft(left, right)) left++;
    else right--;
}
return best;
```
Key: at each step you must be able to PROVE the side you discard can never be part of a better answer given everything remaining.
```
