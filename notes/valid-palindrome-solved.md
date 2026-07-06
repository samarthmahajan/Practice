# Valid Palindrome — Easy
Problem Link: https://leetcode.com/problems/valid-palindrome/
Solved Date: 2026-06-27
Pattern Tag: two-pointer / converging-ends

## SRS Tracking
- Stage: 2
- Review Date: 2026-07-09
- Last Rating: Okay
- Review Count: 1
- Graduated: No

---

# Real World Analogy
Two people start at opposite ends of a corridor walking toward each other, each
skipping over any clutter on the floor (commas, spaces). At every step they hold
up the letter they're standing on and check it matches the other's. If anyone
ever sees a mismatch, it's not symmetric. They stop when they meet in the middle.

## Core Insight
A palindrome is symmetric about its center, so the character at distance k from
the left must equal the character at distance k from the right — verify with two
pointers converging inward; a lone middle char (odd length) is never compared and
is always fine.

## Approach
Put one pointer at each end. While they haven't crossed, compare the characters.
Either preprocess the string to strip non-alphanumerics and lowercase first
(simple, O(n) space), or skip junk inline and case-fold on the fly (O(1) space,
the interview-preferred version).

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ while (left < right), not <=             ║ When they meet (odd length) the center char is its   ║
║                                          ║ own mirror — comparing it to itself is pointless.    ║
║ Skip non-alphanumeric WITHOUT comparing  ║ Problem says consider only alphanumerics; junk is    ║
║                                          ║ invisible, so advance the pointer past it silently.  ║
║ Inner skip loops re-check left < right   ║ An all-junk tail (",,,,") could walk a pointer past  ║
║                                          ║ the other → charAt out of bounds without the guard.  ║
║ toLowerCase both sides before compare    ║ "Panama" must match case-insensitively.              ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
left = 0, right = n - 1
while left < right:
    while left < right and s[left] not alphanumeric:  left++
    while left < right and s[right] not alphanumeric: right--
    if lower(s[left]) != lower(s[right]): return false
    left++; right--
return true
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Two-pointer sweep     ║ O(n)           ║ Each index visited at most once total.       ║
║ Total                 ║ O(n)           ║ Linear scan from both ends.                  ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1) in-place  /  O(n) if preprocessed

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ In-place skip    ║ O(1)     ║ Just two int pointers, no copy.              ║
║ Preprocess (regex)║ O(n)    ║ replaceAll + toLowerCase build a new string. ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- The `left < right` guard INSIDE the inner skip loops — without it, all-junk
  input (",,,,", "  ") overruns the array.
- Digits count as alphanumeric: "0P" → '0' vs 'p' → false. Don't only handle letters.
- Empty string / whitespace-only → true (no alphanumerics to violate symmetry).
- Use `Character.isLetterOrDigit` and `Character.toLowerCase`, not hand-rolled
  ASCII ranges that forget digits.

## Dry Run
s = "race a car"
  preprocessed = "raceacar"
  left=0 'r', right=7 'r'  match → 1,6
  left=1 'a', right=6 'a'  match → 2,5
  left=2 'c', right=5 'c'  match → 3,4
  left=3 'e', right=4 'a'  MISMATCH → return false  ✓

s = "0P"  → lower "0p"  → '0' vs 'p' mismatch → false  ✓
s = " "   → no alnum, left=0 right=-1, loop never runs → true  ✓

## Boiler Plate Template
Converging two pointers with inline junk-skip (O(1) space):

```java
public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        while (left < right && !Character.isLetterOrDigit(s.charAt(left)))  left++;
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
            return false;
        left++;
        right--;
    }
    return true;
}
```
