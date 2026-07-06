# Largest Rectangle in Histogram — Hard
Problem Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
Solved Date: 2026-06-22
Pattern Tag: monotonic-stack

## SRS Tracking
- Stage: 3
- Review Date: 2026-07-10
- Last Rating: Strong
- Review Count: 4
- Graduated: No

---

> Logged `~` ASSISTED (guided dry-run + couldn't yet justify the `>=` invariant). Redo cold 2026-06-25.

# Real World Analogy
- Each bar is a person standing in a line. A banner held at one person's height can stretch sideways through everyone at least as tall, and stops the instant it meets someone shorter on either side. The widest banner at that height, for every person, is the answer.

## Core Insight
For each bar as the rectangle's HEIGHT, the rectangle stretches left and right until the nearest **strictly shorter** bar on each side. Width = `rightSmaller − leftSmaller − 1`.

## Approach
For every bar compute the index of the nearest strictly-smaller bar to its left and to its right — both in O(n) with a monotonic stack of indices. The rectangle using bar `i` as height spans exactly the bars between those two boundaries, so area = `heights[i] * (right[i] - left[i] - 1)`. Answer = max over all bars.

## Mental Model
| Decision | Why |
|---|---|
| Stack stores **indices**, not heights | width needs positions; height is just `heights[idx]` |
| Pop while `heights[top] >= heights[i]` (`>=`, not `>`) | skip *equal* bars so the boundary is the nearest **strictly** smaller — `>` would let a duplicate stop the rectangle early and undercount |
| left = −1 / right = n when stack empties | sentinels so the width math works at the array edges |
| width = `right − left − 1` | count of bars strictly between the two smaller boundaries (exclusive on both ends) |

## Pseudocode
```
left[i]  = index of nearest strictly-smaller bar to the LEFT  (or -1)
right[i] = index of nearest strictly-smaller bar to the RIGHT (or n)

left[]:  scan i = 0..n-1 with a monotonic stack
   while stack nonempty AND height[top] >= height[i]: pop
   left[i] = empty ? -1 : top
   push i

right[]: reset stack, scan i = n-1..0
   while stack nonempty AND height[top] >= height[i]: pop
   right[i] = empty ? n : top
   push i

answer = max over i of  height[i] * (right[i] - left[i] - 1)
```

## Complexity

### Time: O(n)
| Component | Cost | Why |
|---|---|---|
| Build left[] | O(n) | each index pushed and popped at most once |
| Build right[] | O(n) | symmetric second pass |
| Area sweep | O(n) | one linear pass |
| Total | O(n) | three linear passes |

### Space: O(n)
| Structure | Size | Why |
|---|---|---|
| left[] + right[] | O(n) | boundary index arrays |
| stack | O(n) | worst case = strictly increasing heights (nothing pops) |

## Watch Out For
- **`>=` not `>`** in the pop test — on equal heights you must skip past to the strictly-smaller boundary, or duplicates like `[2,2,2]` undercount the width.
- Store **indices**, not heights.
- Sentinels: left `-1`, right `n`; width = `right − left − 1`.
- **Reset the stack** between the two passes.
- `int` is fine here (max `10^4 × 10^5 = 10^9 < 2.1×10^9`), but it's only ~2× from overflow — know the edge.

## Dry Run
```
heights = [2, 1, 5, 6, 2, 3]
left    = [-1,-1, 1, 2, 1, 4]   nearest strictly-smaller LEFT  (index, -1 = none)
right   = [ 1, 6, 4, 4, 6, 6]   nearest strictly-smaller RIGHT (index,  6 = none)
area    = [ 2, 6,10, 6, 8, 3]   heights[i] * (right[i]-left[i]-1)
                  ^^
max = 10  (height 5 across idx 2..3, width 2)
```

## Boiler Plate Template
```java
package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];    // nearest strictly-smaller to LEFT  (index, -1 if none)
        int[] right = new int[n];   // nearest strictly-smaller to RIGHT (index,  n if none)
        Deque<Integer> stack = new ArrayDeque<>();   // monotonic, stores INDICES

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }
}
```
