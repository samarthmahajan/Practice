# Remove K Digits — Medium
Problem Link: https://leetcode.com/problems/remove-k-digits/
Solved Date: 2026-07-02
Pattern Tag: monotonic-stack / remove-k-to-minimize

## SRS Tracking
- Stage: 3
- Review Date: 2026-07-11
- Last Rating: Strong
- Review Count: 1
- Graduated: No

---

# Real World Analogy
- You're editing a price tag down by k digits and want the cheapest price. The leftmost digit is worth the most, so any digit that's bigger than the one right behind it is overpaying at a premium position — fire it and let the smaller digit step forward into the expensive slot.

## Core Insight
Equal-length numbers are decided at the FIRST differing position — so a kept digit that is strictly bigger than the incoming digit can never be part of the smallest answer: popping it is a guaranteed win no matter what the suffix holds.

## Approach
Scan left to right, keeping digits in a stack. While removal budget remains and the last kept digit is strictly bigger than the incoming one, delete it, then append the incoming digit. Any leftover budget chops from the tail (the kept digits are now non-decreasing, so the tail holds the worst digits). Strip leading zeros; if nothing survives, answer is "0".

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Pop while top is STRICTLY > incoming     ║ Popping an equal digit burns budget for zero gain:   ║
║                                          ║ "1121" k=1 → `>=` gives "121", `>` gives "111"       ║
║ It's the leftmost DESCENT, not the       ║ "1519" k=1: kill first descent 5 → "119"; killing    ║
║ global largest digit                     ║ the global largest 9 → "151". Place value decides.   ║
║ Leftover k → chop from the TAIL          ║ After the scan, kept digits are non-decreasing —     ║
║                                          ║ deleting anywhere earlier pulls a ≥ digit forward    ║
║ Strip zeros AFTER all removals           ║ Pops can promote '0' to the front: "10200" → "0200"  ║
║ k == n → early "0"                       ║ Everything deleted = empty = the number zero         ║
║ StringBuilder as the stack               ║ Answer is a string; append / deleteCharAt(last) are  ║
║                                          ║ O(1) and it prints without a rebuild                 ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
if k == num.length: return "0"
sb = empty builder            // stack of KEPT digits
for c in num:
  while k > 0 and sb not empty and sb.last > c:   // strict >
    delete sb.last; k--
  append c
while k > 0: delete sb.last; k--                  // non-decreasing leftover
strip leading '0's
return empty ? "0" : result
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Scan with pops        ║ O(n) amortized ║ each digit appended once, deleted ≤ once     ║
║ Tail chop + zero strip║ O(n)           ║ single passes over ≤ n kept digits           ║
║ Total                 ║ O(n)           ║ no digit is ever touched a third time        ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(n)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ StringBuilder    ║ O(n)     ║ worst case keeps all digits (already sorted) ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- Strict `>` vs `>=` — the equal-digit trap: "1121", k=1 must give "111", not "121".
- "Remove the largest" is the WRONG mental rule — "1519", k=1 → "119" (remove the 5, the leftmost descent), not "151".
- Leftover k after a non-decreasing scan: "112", k=1 → chop tail → "11".
- Leading zeros strip AFTER removals, and empty → "0" ("100", k=1 → "0"; "10", k=2 → "0").
- Only ever delete the LAST builder char — deleteCharAt in the middle is O(n) and never needed.

## Dry Run
"1432219", k=3:
```
'1' → [1]           k=3
'4' → [1 4]         k=3   (1 < 4, no pop)
'3' → pop 4 → [1 3] k=2
'2' → pop 3 → [1 2] k=1
'2' → [1 2 2]       k=1   (2 > 2 is false — STRICT)
'1' → pop 2 → [1 2 1] k=0
'9' → [1 2 1 9]     k=0
tail chop: none · zero strip: none → "1219"
```

## Boiler Plate Template
Greedy keep-stack: build the smallest sequence by deleting k, order preserved.

```java
public String removeKdigits(String num, int k) {
    if (k == num.length()) return "0";
    StringBuilder sb = new StringBuilder();
    for (char c : num.toCharArray()) {
        while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        sb.append(c);
    }
    while (k > 0) { sb.deleteCharAt(sb.length() - 1); k--; }
    int start = 0;
    while (start < sb.length() && sb.charAt(start) == '0') start++;
    String res = sb.substring(start);
    return res.isEmpty() ? "0" : res;
}
```
