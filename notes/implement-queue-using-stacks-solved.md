# Implement Queue using Stacks — Easy
Problem Link: https://leetcode.com/problems/implement-queue-using-stacks/
Solved Date: 2026-06-23
Pattern Tag: stack / amortized-two-stack

## SRS Tracking
- Stage: 2
- Review Date: 2026-06-27
- Last Rating: Strong
- Review Count: 1
- Graduated: No

<!-- Logged ~ ASSISTED: shipped an unconditional-transfer bug (the core insight), did not
     self-catch it (main false-greened), saw the one-line guard fix. Redo cold 2026-06-26. -->

---

# Real World Analogy
- Two spring-loaded plate dispensers. New plates always go on the `input` dispenser. When a customer wants a plate, you serve from `output`; if `output` is empty you flip the whole `input` stack over into it once — reversing the order so the oldest plate is now on top. You only flip when `output` runs dry, so no plate is ever flipped twice.

## Core Insight
Two stacks. `push` always lands on `input`. `pop`/`peek` serve from `output`, and you refill `output` from `input` **only when `output` is empty**. That lazy, one-time flip turns LIFO into FIFO and guarantees each element is transferred at most once → amortized O(1).

## Approach
Keep an `input` stack and an `output` stack. `push(x)` → `input.push(x)`. For `peek()`/`pop()`: if `output` is empty, drain all of `input` into `output` (reversing order); then read/remove `output`'s top. `empty()` is true only when **both** stacks are empty. The guard `if (output.isEmpty())` is the whole correctness argument — never pour newer `input` on top of older `output` elements.

## Mental Model

| Decision | Why |
|---|---|
| `push` → always `input` | New elements are youngest; they wait at the back. |
| Refill `output` **only if `output.isEmpty()`** | Older elements already in `output` must exit first; pouring newer ones on top would jump the line. |
| `pop` calls `peek()` then `output.pop()` | Reuse the refill logic; after `peek` guarantees `output` non-empty, the top is the true front. |
| `empty` = both empty | An element could be waiting in either stack. |

## Pseudocode
```
push(x):  input.push(x)

peek():   if output.isEmpty():
              while not input.isEmpty(): output.push(input.pop())
          return output.peek()

pop():    peek()                 # ensures output is loaded
          return output.pop()

empty():  return input.isEmpty() AND output.isEmpty()
```

## Complexity

### Time: amortized O(1) per operation

| Op | Cost | Why |
|---|---|---|
| push | O(1) | one push |
| empty | O(1) | two isEmpty checks |
| pop / peek | O(1) amortized (O(n) worst single call) | each element is moved input→output exactly once over its life; total work over m ops is O(m) |

### Space: O(n)

| Structure | Size | Why |
|---|---|---|
| input + output | O(n) | the n live elements split across the two stacks |

## Watch Out For
- **The guard `if (output.isEmpty())` is mandatory.** Transferring unconditionally buries older elements under newer ones → wrong FIFO order. This is the bug that broke `push(1,2) pop push(3,4) pop` (returned 3 instead of 2).
- Test the **interleaved** case (push after a pop), not just push-all-then-pop-all — the latter false-passes a buggy unconditional transfer.
- `empty()` must check **both** stacks.
- `pop` delegating to `peek()` keeps the refill logic in one place — clean, no duplication.

## Dry Run
```
push(1) push(2)        input=[2,1]  output=[]
pop():  output empty → flip → output=[1,2]  input=[]   → output.pop()=1   output=[2]
push(3) push(4)        input=[4,3]  output=[2]
pop():  output NOT empty → NO flip → output.pop()=2  ✓   output=[]
pop():  output empty → flip → output=[4,3]  input=[]   → output.pop()=3
pop():  output NOT empty → output.pop()=4
empty(): both empty → true
returns: 1, 2, 3, 4, true  ✓
```

## Boiler Plate Template
Standard "FIFO queue via two stacks, lazy amortized transfer":

```java
private final Deque<Integer> input = new ArrayDeque<>();
private final Deque<Integer> output = new ArrayDeque<>();

public void push(int x) { input.push(x); }

public int peek() {
    if (output.isEmpty()) {
        while (!input.isEmpty()) output.push(input.pop());
    }
    return output.peek();
}

public int pop() {
    peek();
    return output.pop();
}

public boolean empty() {
    return input.isEmpty() && output.isEmpty();
}
```
