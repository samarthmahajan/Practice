# Contains Duplicate — Easy
Problem Link: https://leetcode.com/problems/contains-duplicate/
Solved Date: 2026-06-23
Pattern Tag: hashing / set-membership

## SRS Tracking
- Stage: 3
- Review Date: 2026-06-30
- Last Rating: —
- Review Count: 0
- Graduated: No

---

# Real World Analogy
- A bouncer with a guest list: each person who walks in gets checked off. The moment a name is *already* checked, you know that person came through before — that's your duplicate. You never need a second pass; the rejection happens on insert.

## Core Insight
A value is a duplicate the instant you try to record it and find it already recorded — `HashSet.add` returning `false` is that signal, giving you the membership test and the insert in a single O(1) operation.

## Approach
Walk the array once, dropping each number into a HashSet. If `add` ever returns `false`, that number was already present → return `true` immediately. If the loop finishes, every element was distinct → return `false`.

## Mental Model

╔══════════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                     ║ Why                                                  ║
╠══════════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ HashSet, not HashMap                         ║ We only care about presence, not counts or values.   ║
║ Use add()'s boolean, not contains()+add()    ║ One O(1) op does the check AND the insert — no        ║
║                                              ║ double hashing of the same key.                      ║
║ Return true on the FIRST false               ║ One repeat is sufficient proof; nothing later can    ║
║                                              ║ un-duplicate it, so bail early.                      ║
╚══════════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
set = empty HashSet
for num in nums:
    if set.add(num) == false:   // already present
        return true
return false                    // loop finished, all distinct
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Loop over nums        ║ O(n)           ║ At most n iterations (early-exits on dup).    ║
║ add() per element     ║ O(1) avg       ║ Hash insert + membership test in one call.    ║
║ Total                 ║ O(n)           ║ Linear single pass.                          ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(n)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ HashSet          ║ O(n)     ║ Stores up to n distinct values (all-unique).  ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- Don't write `contains()` then `add()` — that hashes the key twice. `add()`'s return value does both jobs.
- Early return: bail on the FIRST duplicate; don't keep scanning to the end.
- `Boolean.FALSE.equals(set.add(x))` works but is over-engineered — `add` returns a *primitive* boolean (never null), so just use `!set.add(x)`.
- Empty / single-element array → no duplicates → `false` (the loop handles this naturally, no special case).
- `Set<Integer>` autoboxes every int; fine within constraints, but know the cost is there.

## Dry Run
nums = [1, 1, 1, 3, 3, 4]
- num=1 → add() → true  → set = {1}, continue
- num=1 → add() → false → **return true** ✅ (stops immediately; never touches indices 2–5)

Contrast — nums = [1, 2, 3, 4]
- add 1→true, 2→true, 3→true, 4→true → loop ends → **return false**

## Boiler Plate Template
Reusable for any "have I seen this exact value before?" / dedup check.

```java
// Set membership / dedup — "have I seen this before?"
Set<Integer> seen = new HashSet<>();
for (int x : arr) {
    if (!seen.add(x)) {     // add() == false  ⇒  x already present
        return true;        // duplicate found — bail immediately
    }
}
return false;               // all distinct
```
