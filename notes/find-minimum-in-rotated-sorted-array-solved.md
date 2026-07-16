<!-- CLASS-B (2026-07-16, [x]*): narration skipped — went straight to code. TWO missed WHYs, these are the FIRST prompts at the next review, before any code:
     (1) Why compare mid to nums[right] and NOT nums[left]? Name the breaking family: the UNROTATED array. [1,2,3] → nums[mid]=2 >= nums[left]=1 says "go right", but the min was at index 0. The left-comparison is AMBIGUOUS (same signal for "unrotated, min at left" and "pivot is right of mid"); the right-comparison is DECISIVE.
     (2) Why `while (left < right)` and not `<=`? Not "slower" — INFINITE LOOP. At left==right, mid==left==right, so nums[mid] <= nums[right] is trivially true → right = mid changes nothing → spin forever.
     Gap (2) is the SECOND `< vs <=` miss in one week (Koko 2026-07-12 shipped wrong output on the same cell). Treat as a live wound. -->

---

# Find Minimum in Rotated Sorted Array — Medium
Problem Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
Solved Date: 2026-07-16
Pattern Tag: binary-search / rotated-array-find-pivot

## SRS Tracking
- Stage: 1
- Review Date: 2026-07-18
- Last Rating: —
- Review Count: 0
- Graduated: No

---

# Real World Analogy
A sorted deck of cards was cut once and the two halves swapped. Reading left to right, the numbers climb, fall off a **cliff exactly once**, then climb again. The minimum is the card at the bottom of that cliff. You can't scan every card — but you can stand at any card and ask "is the cliff ahead of me or behind me?", and each answer throws away half the deck.

## Core Insight
Compare `nums[mid]` to `nums[right]`, never to `nums[left]` — because `nums[mid] <= nums[right]` **proves** the stretch `[mid..right]` contains no cliff, which pins the minimum to `mid` or left of it, whereas the left-comparison gives the same signal for two opposite situations and therefore proves nothing.

## Approach
Keep a window `[left, right]` that always contains the minimum. Look at the middle card and compare it to the **rightmost** card. If the middle is `<=` the rightmost, the whole right stretch is a clean climb — no cliff in it — so the minimum is the middle card or something to its left; keep the middle and pull `right` in to `mid`. Otherwise the middle sits on the high run before the cliff, so the minimum is strictly to its right; discard the middle with `left = mid + 1`. When the window collapses to one index, that index is the answer.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Compare to nums[right], NOT nums[left]   ║ nums[mid] <= nums[right] means [mid..right] has no   ║
║                                          ║ cliff — a PROOF, one meaning only. nums[mid] >=      ║
║                                          ║ nums[left] is AMBIGUOUS: true when unrotated (min    ║
║                                          ║ at left) AND when the pivot is right of mid. Same    ║
║                                          ║ signal, opposite actions → cannot drive a decision.  ║
║ nums[mid] <= nums[right] → right = mid   ║ mid is itself a live candidate for the minimum —     ║
║                                          ║ discarding it (right = mid - 1) can drop the answer. ║
║ else → left = mid + 1                    ║ mid > nums[right] proves mid is on the pre-cliff     ║
║                                          ║ high run, so mid is provably NOT the min. Safe to    ║
║                                          ║ throw away. This asymmetry is the whole template.    ║
║ while (left < right), not <=             ║ <= is an INFINITE LOOP, not a slow answer: at        ║
║                                          ║ left==right, mid==left==right, nums[mid]<=nums[right]║
║                                          ║ is trivially true → right = mid is a no-op → spin.   ║
║ return nums[left], no bounds check       ║ Loop exits only at left==right, and the invariant    ║
║                                          ║ says the min is always inside [left,right] — so a    ║
║                                          ║ one-cell window IS the answer. Never empty (n>=1).   ║
║ No special case for the unrotated array  ║ [11,13,15,17]: every compare hits the <= branch, the ║
║                                          ║ window walks left, lands on index 0. Falls out free. ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

**The invariant (say this OUT LOUD before writing a line):**
> The minimum always lies within `[left, right]`. Every iteration shrinks the window while preserving that. When the window is one cell wide, that cell is the minimum.

## Pseudocode
```
left = 0, right = n - 1
while left < right:                      // strict — <= spins forever
    mid = left + (right - left) / 2      // never (left + right) / 2 — overflow
    if nums[mid] <= nums[right]:
        right = mid                      // [mid..right] cliff-free → min is mid or left of it; KEEP mid
    else:
        left = mid + 1                   // mid is on the pre-cliff high run → provably not the min; DROP it
return nums[left]                        // left == right, window is one cell = the min
```

## Complexity

### Time: O(log n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Window shrink         ║ O(log n)       ║ Each iteration discards ~half the window;     ║
║                       ║                ║ n → n/2 → n/4 → 1 is log₂n steps.            ║
║ Work per iteration    ║ O(1)           ║ One mid calc, one comparison, one assign.    ║
║ Total                 ║ O(log n)       ║ log₂n iterations × O(1) each.                ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ left/right/mid   ║ O(1)     ║ Three ints. Iterative — no recursion stack,  ║
║                  ║          ║ no copy of the input, no auxiliary array.    ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Why this is optimal
You can't beat O(log n): the array gives you one usable structural fact (a single cliff), and each comparison yields one bit of information about which side it's on — so log₂n comparisons is the information-theoretic floor for locating it. Anything faster would have to read fewer than log n cells and still distinguish n possible pivot positions, which is impossible.

## Watch Out For
- **`right = mid`, NOT `mid - 1`.** In the `<=` branch mid is a live candidate; `mid - 1` silently drops the answer. (Contrast the `else` branch, where `mid + 1` is correct *because* mid is provably not the min. The asymmetry is load-bearing, not sloppiness.)
- **`while (left < right)` — `<=` HANGS.** Not slow, not off-by-one: an infinite spin. ⚠️ Second miss on `<` vs `<=` in one week (Koko, 2026-07-12). This cell is the recurring wound.
- **Never compare to `nums[left]`.** Breaks on the unrotated array `[1,2,3]` — the classic trap, and the reason "one half is always sorted" reasoning needs care here.
- **`mid = left + (right - left) / 2`**, never `(left + right) / 2` — overflow.
- **Unrotated input is legal** (rotated n times = rotated 0 times). If your solution needs a special case for it, the template is wrong.
- **n = 1** must work: loop never runs, returns `nums[0]`.
- This is #153 (**unique** elements). #154 allows duplicates and the `<=` decisiveness collapses — `nums[mid] == nums[right]` proves nothing, forcing a `right--` fallback and O(n) worst case. Different problem; don't blur them.

## Dry Run
`nums = [4, 5, 6, 7, 0, 1, 2]` — expected 0

```
        idx:   0  1  2  3  4  5  6
        val:   4  5  6  7  0  1  2
                          ↑ cliff (min at idx 4)

Init: left=0, right=6
─────────────────────────────────────────────────────────────────
Iter 1: mid = 0 + (6-0)/2 = 3   → nums[3]=7, nums[right]=nums[6]=2
        7 <= 2? NO  → mid sits on the pre-cliff high run
        left = mid + 1 = 4                      window [4..6] = [0,1,2]

Iter 2: mid = 4 + (6-4)/2 = 5   → nums[5]=1, nums[6]=2
        1 <= 2? YES → [5..6] is cliff-free, mid is a candidate
        right = mid = 5                         window [4..5] = [0,1]

Iter 3: mid = 4 + (5-4)/2 = 4   → nums[4]=0, nums[5]=1
        0 <= 1? YES → keep mid
        right = mid = 4                         window [4..4] = [0]

Exit: left(4) == right(4) → loop ends
Return nums[4] = 0   ✓
```

Unrotated check — `nums = [11,13,15,17]`, expected 11:
```
left=0,right=3: mid=1, 13<=17 YES → right=1     window [0..1]
left=0,right=1: mid=0, 11<=13 YES → right=0     window [0..0]
exit → nums[0] = 11  ✓   (no special case needed — it falls out)
```

Verified beyond the samples: every sorted-unique array of size 1–9 at every rotation, plus 20,000 randomized arrays (negatives, arbitrary values). 20,045 cases, 0 failures.

## Boiler Plate Template
Reusable for any "find the pivot / discontinuity in a rotated sorted array" question.

```java
public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;

    while (left < right) {                    // STRICT — <= spins forever (right = mid is a no-op at left==right)
        int mid = left + (right - left) / 2;  // never (left + right) / 2 — overflow

        if (nums[mid] <= nums[right]) {
            right = mid;                      // [mid..right] cliff-free → min is mid or left of it; KEEP mid
        } else {
            left = mid + 1;                   // mid is pre-cliff → provably not the min; DROP it
        }
    }
    return nums[left];                        // window collapsed to one cell = the min
}
```

**Transfer note:** this is the same skeleton as LOWER BOUND and FIND PEAK — `while (lo < hi)` + `hi = mid` on the keep-branch + `lo = mid + 1` on the drop-branch + `return arr[lo]`. Whenever the answer is a *boundary* rather than an exact match, reach for this shape, not the `lo <= hi` / `return -1` standard-search shape. Cross the two templates and you get the Koko failure.
