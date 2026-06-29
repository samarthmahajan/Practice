---

# Longest Substring Without Repeating Characters — Medium
Problem Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
Solved Date: 2026-06-28
Pattern Tag: sliding-window / variable-shrink

## SRS Tracking
- Stage: 1
- Review Date: 2026-06-29
- Last Rating: —
- Review Count: 0
- Graduated: No

> Note: logged `~` — SOLUTION WAS READ, not solved. Recognition was correct (variable window + HashSet), but the shrink step was fuzzy ("remove the duplicate character" instead of "evict from the LEFT end until valid"). This is the FOUNDATIONAL variable-window template — redo cold 2026-07-01 is high priority; it underpins Longest Repeating Char Replacement, Permutation in String, Minimum Window Substring.

---

# Real World Analogy
- A conveyor belt of guests entering a room where no two guests may share a name. New guest walks in on the right. If their name clashes with someone already inside, you keep ushering people out from the LEFT (oldest first) until the clash is gone — then let the new guest in. Track the largest the room ever got.

## Core Insight
Keep a duplicate-free window. When the incoming char would break that, don't hunt for the offender — just shrink from the left end until the window is valid again. Each char enters and leaves at most once → O(n).

## Approach
Expand `right` across the string. Maintain a HashSet of chars in the current window. Before adding `s[right]`, if it's already in the set, evict `s[left]` and `left++` repeatedly until it's gone. Add `s[right]`, then record window size `right - left + 1` against the max.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ HashSet = chars in current window        ║ O(1) duplicate check                                 ║
║ right is the for-loop (always advances)  ║ Every char gets a turn as the window's new right end  ║
║ on duplicate: while-loop shrink from left║ Window must stay CONTIGUOUS — evict oldest first      ║
║ shrink BEFORE adding s[right]            ║ Restore the invariant first, then extend             ║
║ size = right - left + 1                  ║ inclusive both ends                                  ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
window = empty set
left = 0, max = 0
for right in 0 .. n-1:
    c = s[right]
    while c in window:            # shrink from LEFT until valid
        window.remove(s[left])
        left++
    window.add(c)
    max = Math.max(max, right - left + 1)
return max
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ right advance         ║ O(n)           ║ for-loop visits each index once              ║
║ left advance (shrink) ║ O(n) amortized ║ left only moves forward, total <= n          ║
║ set ops               ║ O(1) each      ║ HashSet add/remove/contains                  ║
║ Total                 ║ O(n)           ║ each char added once + removed once          ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(min(n, k))

╔══════════════════╦══════════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size         ║ Why                                          ║
╠══════════════════╬══════════════╬══════════════════════════════════════════════╣
║ HashSet window   ║ O(min(n,k))  ║ at most one of each distinct char (k=alphabet)║
╚══════════════════╩══════════════╩══════════════════════════════════════════════╝

## Watch Out For
- The shrink is a `while`, not an `if`, and it removes from the LEFT — not "remove the duplicate char directly". Test `"abba"`: needs to evict both 'a' and 'b' to clear the clash.
- Shrink BEFORE adding s[right], or you corrupt the set.
- Window size is `right - left + 1` (inclusive) — classic off-by-one.
- Empty string → loop never runs → returns 0 (handled naturally).
- Optimization (not used here): a HashMap<char,index> lets `left` JUMP past the duplicate in O(1) instead of stepping — but the set version is the cleaner mental template.

## Dry Run
s = "abba"  (the trap)
```
right=0 'a': add {a}                 max=1
right=1 'b': add {a,b}               max=2
right=2 'b': dup → remove a(left0→1); remove b(left1→2); add b {b}   max=2
right=3 'a': add {b,a}               max=2
return 2
```

## Boiler Plate Template
THE variable sliding-window skeleton (expand right, shrink left on broken constraint):

```java
int left = 0, best = 0;
Set<Character> window = new HashSet<>();   // or freq map / counter
for (int right = 0; right < s.length(); right++) {
    char c = s.charAt(right);
    while (/* adding c breaks the constraint */ window.contains(c)) {
        window.remove(s.charAt(left));     // shrink from the LEFT
        left++;
    }
    window.add(c);                         // now valid — extend
    best = Math.max(best, right - left + 1);
}
return best;
```
Swap the `while` condition + the window state (set / freq map / counts) and this same skeleton solves the whole variable-window family.
```
