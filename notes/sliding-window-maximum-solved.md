---

# Sliding Window Maximum — Hard
Problem Link: https://leetcode.com/problems/sliding-window-maximum/
Solved Date: 2026-06-29
Pattern Tag: monotonic-deque / window-max

## SRS Tracking
- Stage: 1
- Review Date: 2026-06-30
- Last Rating: —
- Review Count: 0
- Graduated: No

---

# Real World Analogy
- A queue of job applicants waiting to be "current best." The moment a stronger candidate arrives, everyone weaker still in line behind them is permanently out — they can never beat someone who is both better and stays longer. The front of the line is always the current best, and people at the front "age out" once they fall outside the hiring window.

## Core Insight
Keep a deque of INDICES whose values are strictly decreasing front→back. The front is always the current window's max. A newcomer shadows (evicts) every smaller-or-equal tail element, because it is both bigger and stays in the window at least as long.

## Approach
Slide one index at a time. (1) Expire the front if its index left the window (`front <= i - k`). (2) Pop the tail while its value `<=` the newcomer (dominated). (3) Push the new index. (4) Once `i >= k-1`, the front index gives the window max.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ store INDICES not values                 ║ front-expiry is arithmetic: front <= i - k            ║
║ front expiry = `if` (not while)          ║ at most one element falls off the left per step       ║
║ pop tail while nums[tail] <= nums[i]      ║ newcomer is bigger AND outlives them → they're dead   ║
║ '<=' (not '<') on the tail pop            ║ evicts equal earlier dups; newer dup outlives them    ║
║ record only once i >= k-1                 ║ first k-1 steps just fill the first window            ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
deque of indices (values decreasing front->back)
result[n-k+1]
for i in 0..n-1:
    if !deque.empty AND deque.front <= i - k: pollFirst       # expire
    while !deque.empty AND nums[deque.last] <= nums[i]: pollLast  # dominate
    offerLast(i)
    if i >= k-1: result[i-k+1] = nums[deque.front]
return result
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ each index push       ║ O(1)           ║ pushed exactly once                          ║
║ each index pop        ║ O(1) amortized ║ popped at most once over the whole run        ║
║ Total                 ║ O(n)           ║ beats naive re-scan O(n*k)                    ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(k)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ deque            ║ O(k)     ║ never holds more than one window of indices  ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- Front expiry is `if`, NOT `while` — only one index can leave per step.
- Store indices, not values (front-expiry test needs the index).
- Tail pop uses `<=` so equal earlier duplicates are evicted.
- Start writing results only at `i >= k-1`; result length is `n - k + 1`.
- This solve was via `code` (saw solution) — redo cold 2026-07-02.

## Dry Run
```
nums = [1,3,-1,-3,5,3,6,7], k=3  (deque = indices)
i2: deque[1,2] → 3
i3: deque[1,2,3] → 3
i4: expire idx1, pop -3,-1 → deque[4] → 5
i5: deque[4,5] → 5
i6: pop 3,5 → deque[6] → 6
i7: pop 6 → deque[7] → 7
out = [3,3,5,5,6,7]
```

## Boiler Plate Template
Monotonic deque for window max (store indices, decreasing values):

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    int ri = 0;
    Deque<Integer> deque = new ArrayDeque<>();   // indices, decreasing values
    for (int i = 0; i < n; i++) {
        if (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
        while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
        deque.offerLast(i);
        if (i >= k - 1) result[ri++] = nums[deque.peekFirst()];
    }
    return result;
}
// For window MIN: flip the tail comparison to nums[deque.peekLast()] >= nums[i].
```
```
