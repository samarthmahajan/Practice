---

# Best Time to Buy and Sell Stock — Easy
Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Solved Date: 2026-06-28
Pattern Tag: sliding-window / running-min

## SRS Tracking
- Stage: 3
- Review Date: 2026-07-11
- Last Rating: Strong
- Review Count: 2
- Graduated: No

> Note: logged `~` ASSISTED. Final code was clean/optimal/bug-free, but: (1) first invariant was WRONG — "increment both pointers" — exposed only by a coach counterexample [3,5,1,4]; (2) the precise WHY ("left = running minimum") was coach-supplied; (3) the 5 steps were scaffolded into the file. Redo cold 2026-07-01 — flips to `[x]` when the running-min invariant + WHY are produced unaided.

---

# Real World Analogy
- Walking a hiking trail left to right, you want the biggest climb from a valley to a later peak. You remember the LOWEST point you've passed (the best place you "could have bought in"). Every time you hit a new lower valley, that becomes your new reference, because no earlier (higher) valley can ever beat it for a future peak.

## Core Insight
The best sell on day `right` always pairs with the cheapest buy day seen so far. So sweep once, keep `left` = running minimum price, and at each day measure `prices[right] - left`.

## Approach
One forward scan. Keep `left` as the cheapest buy day so far. For each `right`: if it's higher than `left`, it's a profit candidate — update max. If it's lower-or-equal, it's a new cheapest buy day, so jump `left = right`. Return the best profit.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ left = cheapest price seen so far        ║ Best sell pairs with cheapest prior buy              ║
║ prices[right] > prices[left] → profit    ║ Selling higher than the running min = gain          ║
║ prices[right] <= prices[left] → left=right║ New global min; every earlier buy is strictly worse  ║
║ JUMP left=right (not left++)             ║ right is already below the min of [left..right-1]     ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
max = 0
left = 0                      // cheapest buy day so far
for right in 1 .. n-1:
    profit = prices[right] - prices[left]
    if profit <= 0:
        left = right          // new cheapest buy day — JUMP, don't ++
    else:
        max = Math.max(max, profit)
return max
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Single scan           ║ O(n)           ║ right advances each step; left only jumps fwd ║
║ Total                 ║ O(n)           ║ One pass                                      ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ scalars only     ║ O(1)     ║ max, left, right                             ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- THE bug to avoid: on a new low, `left = right` (jump), NOT `left++`. Incrementing one step fails when left has lagged behind right (e.g. [3,5,1,4] returns 2 instead of 3 with left++).
- Return 0 (not negative) when prices only fall — `max` initialized to 0 handles it.
- This is the DEGENERATE sliding window: window never needs to hold internal state, you only track the running min. The "real" window pattern (variable shrink on a constraint) comes next with Longest Substring Without Repeating.

## Dry Run
prices = [7, 1, 5, 3, 6, 4]

```
left=0(7) right=1(1): profit=-6 <=0  → left=1
left=1(1) right=2(5): profit=4  >0   → max=4
left=1(1) right=3(3): profit=2  >0   → max=4
left=1(1) right=4(6): profit=5  >0   → max=5
left=1(1) right=5(4): profit=3  >0   → max=5
return 5
```

Counterexample that breaks `left++`:
```
prices = [3,5,1,4]   correct answer = 3 (buy@1 sell@4)
  left++ version returns 2 (loses the buy@idx2=1)
  left=right version: at idx2 jump left→2(price1), then 4-1=3 ✓
```

## Boiler Plate Template
Single-pass "running best reference" — keep a running extreme and measure each element against it:

```java
int best = 0, ref = arr[0];          // ref = running min (or max)
for (int i = 1; i < arr.length; i++) {
    if (arr[i] <= ref) ref = arr[i];          // new better reference — JUMP
    else best = Math.max(best, arr[i] - ref); // measure against reference
}
return best;
```
Key: when the new element beats your reference, the reference RESETS to it — it can never be beaten by an earlier, worse reference.
```
