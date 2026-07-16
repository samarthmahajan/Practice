# Decode String — Medium
Problem Link: https://leetcode.com/problems/decode-string/
Solved Date: 2026-06-22
Pattern Tag: simulation-stack

## SRS Tracking
- Stage: 3
- Review Date: 2026-07-12
- Last Rating: Strong
- Review Count: 5
- Graduated: No

<!-- NOTE: logged ~ assisted (received the core "push chunk back" correction). Cold redo due 2026-06-25. -->

---

# Real World Analogy
- Russian nesting dolls (matryoshka): you can't finish painting the outer doll until you've finished the inner one and slotted it back inside. The stack remembers every half-painted outer doll while you go deeper.

## Core Insight
When you hit `[`, you must PAUSE the string you were building and the count in front of it — push both onto stacks — then start fresh inside. On `]`, pop the paused string and count, repeat the inside, and merge it BACK into the paused string. The chunk never leaves the stack until all wrapping brackets close.

## Approach
Walk the string. Build a running number for digits (multi-digit safe). On `[`, push the current number and current string, then reset both. On `]`, pop the saved string + count, append the current string `count` times to the saved string, and make that the new current string. Plain characters just append to the current string.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ k = k*10 + (ch-'0') for digits           ║ Numbers can be multi-digit (100[a]); build them up   ║
║ On '[': push (k, currentString), reset   ║ The outer context must wait while inner is built     ║
║ On ']': pop, repeat inside, merge back   ║ Resolved chunk is an INGREDIENT for the outer bracket║
║ currentString = decoded (push back)      ║ Stack is the accumulator — chunk stays until done    ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
k = 0, currentString = ""
countStack = [], stringStack = []
for ch in s:
  if digit:        k = k*10 + (ch - '0')
  elif ch == '[':  push k -> countStack
                   push currentString -> stringStack
                   k = 0, currentString = ""
  elif ch == ']':  base = stringStack.pop()
                   times = countStack.pop()
                   base += currentString * times
                   currentString = base
  else:            currentString += ch
return currentString
```

## Complexity

### Time: O(n + maxK * outputLen)  ≈ O(output length)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Single scan           ║ O(n)           ║ Each input char visited once                 ║
║ Append/repeat work    ║ O(total chars) ║ Bounded by total characters in the output    ║
║ Total                 ║ O(output len)  ║ Dominated by size of decoded string          ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(output len)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ Two stacks       ║ O(depth) ║ One frame per open bracket (nesting depth)   ║
║ currentString    ║ O(out)   ║ Holds the growing decoded text               ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- Multi-digit counts (`100[a]`) — accumulate `k`, don't push single digit chars.
- The resolved chunk on `]` must go BACK into the popped base string, NOT into a separate final result. (This was the slip — a "final result + reverse at end" approach breaks on nesting.)
- Order: append `currentString` to the popped `base` (base + inside), not the reverse.
- Reset BOTH `k` and `currentString` after pushing on `[`.

## Dry Run
Input: `3[a2[c]]`
```
'3' -> k=3
'[' -> push k=3, push ""        ; countStack=[3] strStack=[""] cur=""
'a' -> cur="a"
'2' -> k=2
'[' -> push k=2, push "a"       ; countStack=[3,2] strStack=["","a"] cur=""
'c' -> cur="c"
']' -> base="a", times=2 -> "a"+"cc"="acc" ; cur="acc"  countStack=[3] strStack=[""]
']' -> base="", times=3 -> ""+"acc"*3="accaccacc" ; cur="accaccacc"
end -> "accaccacc"  ✓
```

## Boiler Plate Template
Standard two-stack "decode / nested simulation" skeleton:

```java
public String decodeString(String s) {
    Deque<Integer> countStack = new ArrayDeque<>();
    Deque<StringBuilder> stringStack = new ArrayDeque<>();
    StringBuilder cur = new StringBuilder();
    int k = 0;
    for (char ch : s.toCharArray()) {
        if (Character.isDigit(ch)) {
            k = k * 10 + (ch - '0');
        } else if (ch == '[') {
            countStack.push(k);
            stringStack.push(cur);
            cur = new StringBuilder();
            k = 0;
        } else if (ch == ']') {
            StringBuilder base = stringStack.pop();
            int times = countStack.pop();
            while (times-- > 0) base.append(cur);
            cur = base;
        } else {
            cur.append(ch);
        }
    }
    return cur.toString();
}
```
