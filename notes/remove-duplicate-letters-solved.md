# Remove Duplicate Letters — Medium
Problem Link: https://leetcode.com/problems/remove-duplicate-letters/
Solved Date: 2026-07-11
Pattern Tag: monotonic-stack / lexicographic-smallest-keep-once

## SRS Tracking
- Stage: 2
- Review Date: 2026-07-14
- Last Rating: —
- Review Count: 0
- Graduated: No

---

# Real World Analogy
Boarding a bus where every distinct passenger must ride exactly once, and you want the
politest possible boarding order (alphabetical-ish). A pushy small letter can bump a bigger
one already in line — but ONLY if that bigger one has another copy still waiting at the stop.
If it's the last of its kind, it stays; kicking it off means it never rides at all.

## Core Insight
Build the answer greedily as a stack: keep the smallest possible unique-letter prefix at every
step. A kept letter may be evicted for a smaller incoming one — but only when it's guaranteed to
reappear later, because a letter with no future copies can never be re-added.

## Approach
Count every letter's total occurrences. Walk left to right maintaining a stack that is the answer.
Skip a letter already in the stack. Otherwise, pop the top while it is larger than the current
letter AND still appears later (count > 0), then push the current letter and mark it present.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Decrement count BEFORE the skip-check    ║ count = "copies still ahead of me"; every occurrence  ║
║                                          ║ consumed must decrement, even skipped duplicates      ║
║ Skip if already in stack (continue)      ║ each letter appears exactly once — one copy is final  ║
║ Pop while top > c                        ║ smaller char earlier ⇒ lexicographically smaller;    ║
║                                          ║ first differing position decides the whole compare    ║
║ ...AND count[top] > 0 (mandatory guard)  ║ if top has no future copy, popping loses it forever   ║
║                                          ║ → result would miss a distinct letter (illegal)       ║
║ Un-mark popped letter (inResult=false)   ║ it must become re-addable when its future copy comes  ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
count[26] <- total occurrences of each letter
inResult[26] <- all false
stack <- empty (StringBuilder doubles as stack + output)

for c in s:
    count[c]--                      // consumed this occurrence
    if inResult[c]: continue        // already placed, keep one copy only
    while stack not empty
          and top(stack) > c
          and count[top(stack)] > 0:   // top reappears later -> safe to drop
        inResult[top] = false
        pop(stack)
    push c; inResult[c] = true
return stack
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Frequency pass        ║ O(n)           ║ one scan to count                            ║
║ Build pass            ║ O(n) amortized ║ each char pushed once, popped at most once    ║
║ Total                 ║ O(n)           ║ must read all chars to know frequencies       ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ count + inResult ║ O(1)     ║ fixed 26-letter arrays                        ║
║ stack/output     ║ O(1)     ║ bounded by 26 distinct letters                ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- Decrement count BEFORE the `continue` skip — decrement after and the pop guard reads stale counts.
- The `count[top] > 0` guard is NOT optional: without it you can pop a last-occurrence letter and lose it forever (result missing a distinct char).
- Un-mark a popped letter (`inResult=false`) or it can never be re-added.
- The pop is `top > c` (strict) — equal never happens here since duplicates are skipped, but strict is the correct intent.

## Dry Run
Input: `"cbacdcbc"`, count = {c:4, b:2, a:1, d:1}
```
'c' cnt c→3  stack empty        push c      -> [c]
'b' cnt b→1  b<c, c later       pop c,push b-> [b]
'a' cnt a→0  a<b, b later       pop b,push a-> [a]
'c' cnt c→2  c>a                push c      -> [a,c]
'd' cnt d→0  d>c                push d      -> [a,c,d]
'c' cnt c→1  already in stack   skip        -> [a,c,d]
'b' cnt b→0  b<d BUT count[d]=0 -> can't pop d; d walls off c; push b -> [a,c,d,b]
'c' cnt c→0  already in stack   skip        -> [a,c,d,b]
```
Answer: `"acdb"`  ✓ (step 7 is the guard in action — `d` is last of its kind, stays)

## Boiler Plate Template
Greedy monotonic-stack for "smallest/largest result, each element kept once, order-preserving":

```java
int[] count = new int[26];
for (char c : s.toCharArray()) count[c - 'a']++;

boolean[] inResult = new boolean[26];
StringBuilder stack = new StringBuilder();

for (char c : s.toCharArray()) {
    count[c - 'a']--;
    if (inResult[c - 'a']) continue;                 // keep one copy only
    while (stack.length() > 0
            && stack.charAt(stack.length() - 1) > c   // improves lex order
            && count[stack.charAt(stack.length() - 1) - 'a'] > 0) { // safe: reappears
        char removed = stack.charAt(stack.length() - 1);
        stack.deleteCharAt(stack.length() - 1);
        inResult[removed - 'a'] = false;              // re-addable later
    }
    stack.append(c);
    inResult[c - 'a'] = true;
}
return stack.toString();
```
