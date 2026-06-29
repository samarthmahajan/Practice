---

# Permutation in String — Medium
Problem Link: https://leetcode.com/problems/permutation-in-string/
Solved Date: 2026-06-29
Pattern Tag: sliding-window / fixed-window-anagram

## SRS Tracking
- Stage: 1
- Review Date: 2026-06-30
- Last Rating: —
- Review Count: 0
- Graduated: No

---

# Real World Analogy
- A fixed-width scanning slot dragged across a shelf of letters, asking "does the slot right now hold exactly the same multiset of letters as my target word?" — you don't re-count the whole slot each step, you just account for the one item that slid out and the one that slid in.

## Core Insight
A window of length `len(s1)` is a permutation of `s1` iff its letter-counts exactly match `s1`'s. Keep ONE running count array (s1 as +1, window as −1); the window matches when all 26 slots are zero.

## Approach
Seed a single `int[26]`: add `s1`'s letters, subtract the first window of `s2`. Check all-zero. Then slide one step at a time — add back the char leaving (+1), subtract the char entering (−1) — re-checking all-zero after each slide. Never rebuild the array.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ window is FIXED size = len(s1)           ║ an anagram has exactly the same length                ║
║ seed = s1 (+1) − first window (−1)       ║ all-zero ⇔ identical letter multiset                  ║
║ slide = +out, −in (two slots only)       ║ only one char leaves and one enters per step → O(1)   ║
║ guard s1.length() > s2.length()          ║ no window can exist → return false up front           ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
if s1.len > s2.len: return false
count[26]; win = s1.len
for x in 0..win-1: count[s1[x]]++ ; count[s2[x]]--
if allZero(count): return true
for left in 0.. while left+win < s2.len:
    count[s2[left]]++          // char leaving → add back
    count[s2[left+win]]--      // char entering → subtract
    if allZero(count): return true
return false
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ slide across s2       ║ O(n)           ║ each index enters/leaves once                 ║
║ all-zero check        ║ O(26)=O(1)     ║ fixed alphabet per step                       ║
║ Total                 ║ O(n)           ║ n = len(s2)                                   ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ count array      ║ O(26)    ║ fixed alphabet → constant                    ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- Don't forget to check the FIRST window (after seeding, before sliding) — easy to skip and miss `s2 = s1`.
- Guard `s1.length() > s2.length()` up front, else `s2.charAt(left+win)` overflows.
- Slide updates exactly TWO slots — do NOT rebuild the array each step (the assisted-gap on this attempt).
- Use a plain `allZero(int[])` loop, not `Arrays.stream(...).allMatch` per iteration (allocates a stream every slide).
- Pro polish: track a `matches` counter (# slots == 0), adjust ±1 as slots change → O(1) check, true single pass.

## Dry Run
```
s1 = "ab", s2 = "eidbaooo", win = 2
seed s1(+) − "ei"(−):  {a:+1, b:+1, e:-1, i:-1}      not zero
slide → "id":  e:+1 d:-1 → {a:+1, b:+1, i:-1, d:-1}  not zero
slide → "db":  i:+1 b:-1 → {a:+1, d:-1}              not zero
slide → "ba":  d:+1 a:-1 → { all zero }              → true
```

## Boiler Plate Template
Fixed-size sliding window matching an anagram / exact frequency target:

```java
public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;
    int[] count = new int[26];
    int win = s1.length();
    for (int x = 0; x < win; x++) {
        count[s1.charAt(x) - 'a']++;
        count[s2.charAt(x) - 'a']--;
    }
    if (allZero(count)) return true;
    for (int left = 0; left + win < s2.length(); left++) {
        count[s2.charAt(left) - 'a']++;        // leaving
        count[s2.charAt(left + win) - 'a']--;  // entering
        if (allZero(count)) return true;
    }
    return false;
}

private boolean allZero(int[] count) {
    for (int v : count) if (v != 0) return false;
    return true;
}
```
```
