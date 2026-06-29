---

# Longest Repeating Character Replacement — Medium
Problem Link: https://leetcode.com/problems/longest-repeating-character-replacement/
Solved Date: 2026-06-29
Pattern Tag: sliding-window / max-frequency-window

## SRS Tracking
- Stage: 1
- Review Date: 2026-06-30
- Last Rating: —
- Review Count: 0
- Graduated: No

---

# Real World Analogy
- A row of colored tiles and a budget of `k` re-paints. You want the longest run you can make a single color. You keep the color already most common in your span and repaint the rest — affordable only while the repaints needed stay within `k`.

## Core Insight
A window is achievable iff `(windowLength − countOfMostFrequentLetter) ≤ k` — the non-majority letters are exactly the ones you must repaint, and you only have `k` repaints.

## Approach
Grow a window to the right, tracking a 26-slot letter-count array. The cheapest way to make the window uniform is to keep its most frequent letter and change everyone else; that cost is `windowLen − maxCount`. While that cost exceeds `k`, shrink from the left. Track the largest valid window seen.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ keep the MOST frequent letter            ║ minimizes repaints → fewest changes spent            ║
║ changesNeeded = windowLen − maxCount     ║ everything that isn't the keeper must be changed     ║
║ shrink while changesNeeded > k           ║ a window needing > k repairs can never be an answer  ║
║ int[26], not HashMap                     ║ alphabet is fixed A–Z → O(1) constant space + speed  ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
freq[26] = 0; left = 0; maxCount = 0; res = 0
for right in 0..n-1:
    freq[s[right]]++
    maxCount = max(maxCount, freq[s[right]])      // running max
    while (right - left + 1) - maxCount > k:
        freq[s[left]]--; left++
    res = max(res, right - left + 1)
return res
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ each char added once  ║ O(n)           ║ right advances n times                       ║
║ each char removed once║ O(n)           ║ left only moves forward, amortized           ║
║ Total                 ║ O(n)           ║ 26-slot max scan (if used) is a constant     ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ freq array       ║ O(26)    ║ fixed alphabet → constant                    ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- The shrink trigger is `windowLen − maxCount > k`, NOT "more than 2 distinct letters." Works for any number of distinct letters in the window.
- Use `int[26]`, not `char[]`, for counts — a char-typed counter is a semantic smell (though it compiles).
- The "never-decrement maxCount" optimization is valid but subtle: a stale (too-large) maxCount only ever makes the window *fail to shrink*, never falsely grow `res`. `res` can only reach a new high when `maxCount` reaches a new REAL high (driven by an actual current count), so the answer is never inflated. **WHY not yet owned cold — see redo.**

## Dry Run
```
s = "AAABBB", k = 1
r  window   counts     max  need=len-max  action     res
0  A        A:1         1    0             grow       1
1  AA       A:2         2    0             grow       2
2  AAA      A:3         3    0             grow       3
3  AAAB     A:3 B:1     3    1  (=k)       grow       4
4  AAABB    A:3 B:2     3    2  (>k) →shrink twice→ ABB (A:1 B:2)  4
5  ABBB     A:1 B:3     3    1             grow       4
answer = 4
```

## Boiler Plate Template
Variable-size sliding window where validity is a frequency property (here: window − maxFreq ≤ k):

```java
int[] freq = new int[26];
int left = 0, maxCount = 0, res = 0;
for (int right = 0; right < s.length(); right++) {
    freq[s.charAt(right) - 'A']++;
    maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);
    while ((right - left + 1) - maxCount > k) {
        freq[s.charAt(left) - 'A']--;
        left++;
    }
    res = Math.max(res, right - left + 1);
}
return res;
```
```
