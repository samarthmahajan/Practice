# Valid Anagram — Easy
Problem Link: https://leetcode.com/problems/valid-anagram/
Solved Date: 2026-06-24
Pattern Tag: hashing / frequency-count

## SRS Tracking
- Stage: 2
- Review Date: 2026-06-29
- Last Rating: Strong
- Review Count: 2
- Graduated: No

---

# Real World Analogy
- Two bags of Scrabble tiles. Pour `s` onto the table laying each tile down (+1), then pick up one matching tile for every letter in `t` (−1). If the table is perfectly empty at the end, both bags held the exact same letters → anagram. A single counter is the table; the sign says which bag a tile came from.

## Core Insight
An anagram is defined entirely by **character-multiset equality**, so one shared `int[26]` that you increment for `s` and decrement for `t` will be zero in every slot **iff** the two strings have identical letter counts — no sorting, no second map.

## Approach
Use a single 26-slot counter. Add 1 for each char of `s`, subtract 1 for each char of `t`. If any slot is non-zero at the end, some character's count differs → not an anagram. Optionally fast-fail in O(1) when the lengths differ.

## Mental Model

╔══════════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                     ║ Why                                                  ║
╠══════════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ One int[26], not two maps                    ║ The sign encodes which string; net zero = match.     ║
║ ++ for s, -- for t                           ║ A leftover (+) = s has extra of that char; (-) = t   ║
║                                              ║ does. Either way the multisets differ.               ║
║ Loop bound i < length (== i <= length-1)     ║ Must visit EVERY char incl. the last; < length-1     ║
║                                              ║ silently drops the last char.                        ║
║ Length guard is optional                     ║ Zero-sum already covers it: Σcounts = |s|-|t|, so    ║
║                                              ║ unequal lengths force a non-zero bucket. Guard is    ║
║                                              ║ purely a constant-factor early-out.                  ║
╚══════════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
if s.length != t.length: return false      // optional fast-fail
count = int[26]
for c in s: count[c - 'a']++
for c in t: count[c - 'a']--
for v in count:
    if v != 0: return false
return true
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Pass over s           ║ O(n)           ║ One increment per char.                       ║
║ Pass over t           ║ O(n)           ║ One decrement per char.                       ║
║ Scan counter          ║ O(26) = O(1)   ║ Fixed alphabet size.                          ║
║ Total                 ║ O(n)           ║ Linear in string length.                      ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ int[26] counter  ║ O(1)     ║ Fixed 26 slots regardless of input size.      ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- **Loop bound is the trap:** use `i < s.length()` (or `i <= s.length()-1`). Writing `< length-1` drops the LAST character — and symmetric test cases won't catch it. This is exactly what bit this solve.
- **Test asymmetrically:** `"ab"` vs `"ba"` exposes off-by-one boundary bugs; `"anagram"`/`"nagaram"` and other symmetric examples hide them.
- `int[26]` only works for lowercase a–z. For unicode / mixed case, switch to `HashMap<Character,Integer>`.
- You do NOT need both a length guard and the zero-sum check for correctness — the zero-sum already handles unequal lengths. The guard is a fast-fail only.
- One shared array is enough — no need for two arrays plus a compare.

## Dry Run
s = "ab", t = "ba"  (asymmetric — the case that catches the off-by-one)
- s: 'a' → count[0]=1 ; 'b' → count[1]=1
- t: 'b' → count[1]=0 ; 'a' → count[0]=0
- scan → all zero → **return true** ✅

Contrast — s = "rat", t = "car"
- s: r=+1, a=+1, t=+1
- t: c=-1, a=0, r=0
- final: t=+1, c=-1 → scan hits a non-zero bucket → **return false** ✅

## Boiler Plate Template
Reusable for any "are these two strings/collections the same multiset of lowercase letters?" check.

```java
// Anagram / multiset-equality via a fixed frequency counter (lowercase a-z)
if (s.length() != t.length()) return false;          // optional O(1) fast-fail
int[] count = new int[26];
for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
for (int i = 0; i < t.length(); i++) count[t.charAt(i) - 'a']--;
for (int v : count) if (v != 0) return false;        // any imbalance ⇒ not an anagram
return true;
```
