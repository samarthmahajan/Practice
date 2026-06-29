---

# Minimum Window Substring — Hard
Problem Link: https://leetcode.com/problems/minimum-window-substring/
Solved Date: 2026-06-29
Pattern Tag: sliding-window / variable-window-cover

## SRS Tracking
- Stage: 2
- Review Date: 2026-07-02
- Last Rating: —
- Review Count: 0
- Graduated: No

---

# Real World Analogy
- A shopping list (t) and a receipt tape (s): slide a window across the tape, growing right until your basket holds everything on the list, then trimming the left edge as far as possible while the basket still satisfies the list — recording the shortest such stretch.

## Core Insight
Grow the right edge until the window covers all of `t`; then shrink the left edge while it still covers `t`, recording the smallest valid window. Validity = every required char's remaining-need is satisfied.

## Approach
Build a need-count map from `t`. Expand `end`, decrementing a char's count when it's a required char. When the window is complete (all needs met), contract from `start`: record the window if smaller, add the dropped char's count back, advance `start` — stop contracting the moment a required count goes unmet. Repeat to the end.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ grow right until complete                ║ can't shrink a window that isn't even valid yet       ║
║ complete ⇔ have == need (counter)         ║ O(1) check vs scanning every count each step          ║
║ contract left while still complete       ║ the minimum valid window ends exactly at the stop     ║
║ record BEFORE start++ inside shrink       ║ current [start,end) is the smallest at this end        ║
║ stop shrink when a required count > 0     ║ dropping that char broke coverage → must grow again   ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
need = countMap(t);  have = 0;  required = need.distinctCount
start = 0; bestLen = INF; bestStart = 0
for end in 0..n-1:
    c = s[end]
    if c in need:
        need[c]--          // (array form) and if need[c] == 0 → have++
    while have == required:                 // window complete
        if end - start + 1 < bestLen: record [start, end]
        d = s[start]
        if d in need:
            need[d]++       // and if need[d] == 1 → have--  (broke coverage)
        start++
return bestLen == INF ? "" : s.substring(bestStart, bestStart + bestLen)
```

## Complexity

### Time: O(|s| + |t|)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ build need map        ║ O(|t|)         ║ count t once                                 ║
║ two pointers over s   ║ O(|s|)         ║ each index enters and leaves at most once     ║
║ have/need check       ║ O(1)           ║ counter, not a per-step scan                  ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(|t|)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ need map / int[] ║ O(|t|)   ║ distinct chars of t (≤ alphabet)             ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- Use a `have/need` counter for completeness, NOT `values().allMatch(<=0)` per step — the scan is the perf gap that kept this `~` instead of `[x]`.
- Record the answer INSIDE the shrink loop, before `start++`.
- The shrink-STOP is the bug-spot: stop the instant a required count goes back unmet (count crosses from 0 to 1 on add-back).
- Only required chars affect validity — ignore chars not in t.
- No-window case: return "" (track bestLen == INF).
- Duplicate requirement (t = "aa") needs two of that char — counter/decrement handles it for free.

## Dry Run
```
s = "ADOBECODEBANC", t = "ABC"  (need A,B,C)
grow → "ADOBEC" complete (A,B,C all met) → record len 6
shrink: drop A → need A again, stop. grow...
... eventually window "BANC" complete → record len 4 (smaller) → best
answer = "BANC"
```

## Boiler Plate Template
Variable window that must COVER a target multiset, minimized (have/need counter form):

```java
public String minWindow(String s, String t) {
    if (s.length() < t.length()) return "";
    int[] need = new int[128];
    for (char c : t.toCharArray()) need[c]++;
    int required = 0;
    for (int v : need) if (v > 0) required++;

    int have = 0, start = 0, bestLen = Integer.MAX_VALUE, bestStart = 0;
    for (int end = 0; end < s.length(); end++) {
        char c = s.charAt(end);
        if (--need[c] == 0) have++;          // a requirement just fully met
        while (have == required) {
            if (end - start + 1 < bestLen) { bestLen = end - start + 1; bestStart = start; }
            char d = s.charAt(start++);
            if (++need[d] == 1) have--;      // dropping d broke coverage
        }
    }
    return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
}
```
```
