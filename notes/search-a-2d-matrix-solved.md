# Search a 2D Matrix — Medium
Problem Link: https://leetcode.com/problems/search-a-2d-matrix/
Solved Date: 2026-07-07
Pattern Tag: binary-search / 2d-matrix-flatten

## SRS Tracking
- Stage: 1
- Review Date: 2026-07-14
- Last Rating: —
- Review Count: 0
- Graduated: No

<!-- CLASS-B (2026-07-12, reclassified from pending redo): mechanics cold 7/7 in 10 min; gaps = seam-weld WHY + narration skipped before coding. FIRST PROMPT at next review, before anything else: "Why does property 2 (row-start > previous row-end) make discard-half valid?" — and narrate BEFORE coding this time. Drill in GAP-DRILLS.md (due 2026-07-12). -->


---

# Real World Analogy
- A dictionary printed across multiple pages: each page is alphabetized AND every page starts after the previous page ends. You never need page-by-page search — the whole book is one sorted list, pages are just line breaks.

## Core Insight
Property 2 (each row's first element > previous row's last) welds the sorted rows into ONE globally sorted sequence, so a flat index `i ∈ [0, m·n)` addresses a genuine sorted array via `matrix[i/n][i%n]` — plain binary search applies.

## Approach
Pretend the matrix is a single sorted array of length m·n without building it. Binary search on the flat index range `[0, m·n−1]`, decoding each probe back to 2D with row = `mid / n`, col = `mid % n`.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Search flat indices, not (row,col) pairs ║ Two nested binary searches work but are clumsier;    ║
║                                          ║ one index space = one standard loop, same O(log mn)  ║
║ row = mid / n, col = mid % n             ║ Each row holds exactly n flat indices; quotient      ║
║ (n = number of COLUMNS)                  ║ counts full rows skipped, remainder is offset within ║
║ Loop while lo <= hi                      ║ Window [lo,hi] of never-compared cells; at lo==hi    ║
║                                          ║ one candidate remains and MUST still be probed       ║
║ Requires BOTH matrix properties          ║ Rows-sorted alone leaves descents at row seams       ║
║                                          ║ (e.g. [1,3,5],[2,4,6] → 1,3,5,2,4,6) — discard-half  ║
║                                          ║ step then throws away the half holding the target    ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
n = cols, lo = 0, hi = m*n - 1
while lo <= hi:
    mid = lo + (hi - lo) / 2
    val = matrix[mid / n][mid % n]
    if val == target  → true
    if val <  target  → lo = mid + 1
    else              → hi = mid - 1
return false
```

## Complexity

### Time: O(log(m·n))

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Binary search         ║ O(log(m·n))    ║ Search space = m·n flat indices, halved      ║
║                       ║                ║ every iteration; index decode is O(1)        ║
║ Total                 ║ O(log(m·n))    ║ = O(log m + log n) — define the variable!    ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ lo, hi, mid      ║ O(1)     ║ Matrix is never copied or flattened for      ║
║                  ║          ║ real — the 1D view is arithmetic only        ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- Divide/mod by **n (columns)**, never m — `mid / n` = row, `mid % n` = col. Swapping them silently works on square matrices and breaks on rectangular ones.
- This flatten trick needs the matrix **fully sorted end-to-end (LC 74)**. LC 240 (rows and columns each sorted, but rows overlap) breaks it — that one needs the staircase walk.
- Overflow-safe mid: `lo + (hi - lo) / 2`.
- `lo <= hi`, not `<` — at lo==hi one never-compared cell remains (same derivation as #704).
- 1×1 matrix and target outside [min, max] range — both fall out naturally; don't special-case.

## Dry Run
target = 13, matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], n = 4, flat len 12

| lo | hi | mid | val = matrix[mid/4][mid%4] | action |
|---|---|---|---|---|
| 0 | 11 | 5 | matrix[1][1] = 11 < 13 | lo = 6 |
| 6 | 11 | 8 | matrix[2][0] = 23 > 13 | hi = 7 |
| 6 | 7  | 6 | matrix[1][2] = 16 > 13 | hi = 5 |
| 6 | 5  | — | lo > hi → window empty | return false |

## Boiler Plate Template
```java
int m = matrix.length, n = matrix[0].length;
int lo = 0, hi = m * n - 1;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;
    int val = matrix[mid / n][mid % n];   // 1D index → 2D
    if (val == target) return true;
    else if (val < target) lo = mid + 1;
    else hi = mid - 1;
}
return false;
```
