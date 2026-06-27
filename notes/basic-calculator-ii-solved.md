---

# Basic Calculator II — Medium
Problem Link: https://leetcode.com/problems/basic-calculator-ii/
Solved Date: 2026-06-22
Pattern Tag: expression-parsing / single-pass-infix
Status: ~ ASSISTED (hint → hint hint → hint hint hint → code). Redo cold 2026-06-25.

## SRS Tracking
- Stage: 1
- Review Date: 2026-06-26
- Last Rating: Okay
- Review Count: 1
- Graduated: No

---

# Real World Analogy
- A cashier ringing up items: `+`/`-` items go straight into the basket as-is.
  But a "buy this one, times 3" (`*`) or "split this evenly" (`/`) deal forces you
  to reach back, grab the LAST item you just bagged, transform it, and re-bag it —
  before anything else gets summed at checkout.

## Core Insight
Every value you keep is ultimately an *addend*. Defer `+`/`-` by pushing them
(as +num / -num) onto a stack, but resolve `*`/`/` immediately against the top of
the stack — then the answer is just the sum of the stack. Precedence is handled
structurally, with no operator stack and no parentheses (there are none here).

## Approach
Scan left to right building multi-digit numbers (`num = num*10 + digit`). Hold the
*previous* operator (`prevOp`, seeded to '+'). Each time you hit a new operator OR
the end of the string, the current number is complete — apply `prevOp`: push +num
/ -num, or pop-and-combine for * / /. Update prevOp, reset num. Sum the stack.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Act on prevOp, not the current char      ║ The op just read belongs to the NEXT number          ║
║ Trigger on operator OR last char         ║ Last number has no trailing operator to flush it     ║
║ + / - push (deferred)                    ║ They only matter at the final sum                    ║
║ * / / pop-combine (eager)                ║ Higher precedence must bind before any +/-           ║
║ Seed prevOp = '+'                        ║ First number pushes with zero special-casing         ║
║ Space falls through both branches        ║ Not a digit, not an operator -> skipped, state kept  ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
stack = empty
num = 0
prevOp = '+'
for i, c in s:
    if c is digit: num = num*10 + (c - '0')
    if c is operator OR i == last index:
        switch prevOp:
            '+': push(num)
            '-': push(-num)
            '*': push(pop() * num)
            '/': push(pop() / num)
        prevOp = c
        num = 0
return sum(stack)
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Single scan          ║ O(n)           ║ Each char touched once                       ║
║ push/pop/switch      ║ O(1) each      ║ Constant work per operator                   ║
║ Final sum            ║ O(n)           ║ At most n/2 terms on the stack               ║
║ Total                ║ O(n)           ║ Linear in string length                      ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(n)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ stack            ║ O(n)     ║ All-'+' input pushes every term              ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝
(Reducible to O(1) by tracking running result + lastTerm instead of a stack.)

## Watch Out For
- Acting on the current operator instead of prevOp (off-by-one in logic = the bug I hit live).
- Forgetting the `i == last index` trigger — the final number silently disappears.
- Division operand order: `pop() / num` (popped = LEFT). Opposite of RPN's first-pop-is-right.
- Spaces: must skip without resetting num/prevOp.
- Multi-digit: `num*10 + (c-'0')`, accumulate while digits continue.

## Dry Run
s = "3 + 5 * 2 - 8 / 4"  ->  expected 11
  '3'  build num=3
  '+'  prevOp '+' -> push 3        stack [3]      prevOp='+'
  '5'  build num=5
  '*'  prevOp '+' -> push 5        stack [3,5]    prevOp='*'
  '2'  build num=2
  '-'  prevOp '*' -> push 5*2      stack [3,10]   prevOp='-'
  '8'  build num=8
  '/'  prevOp '-' -> push -8       stack [3,10,-8] prevOp='/'
  '4'  build num=4, LAST char -> prevOp '/' -> push -8/4  stack [3,10,-2]
  sum = 3+10-2 = 11 ✓

## Boiler Plate Template
Single-pass infix evaluator (no parentheses), precedence via deferred operator:

```java
public int calculate(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    int num = 0;
    char prevOp = '+';
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) num = num * 10 + (c - '0');
        if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
            switch (prevOp) {
                case '+' -> stack.push(num);
                case '-' -> stack.push(-num);
                case '*' -> stack.push(stack.pop() * num);
                case '/' -> stack.push(stack.pop() / num);
            }
            prevOp = c;
            num = 0;
        }
    }
    int result = 0;
    for (int t : stack) result += t;
    return result;
}
```
