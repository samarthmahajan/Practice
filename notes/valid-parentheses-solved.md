# Valid Parentheses — Medium
Problem Link: https://leetcode.com/problems/valid-parentheses/
Solved Date: 2026-06-21
Pattern Tag: matching-stack

## SRS Tracking
- Stage: 4
- Review Date: 2026-07-13
- Last Rating: Strong
- Review Count: 1
- Graduated: No

---

> Backfilled from your solved code. Analogy / Mental-Model table / Dry Run to be filled on first review.

## Core Insight
Push openers; every closer must match the opener on top of the stack — otherwise invalid.

## Watch Out For
- Closer on an empty stack = invalid; the stack must be empty at the end.

## Boiler Plate Template
```java
package stack;

import java.util.Stack;

/**
 * LeetCode #20 - Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string containing '(', ')', '{', '}', '[', ']',
 * determine if the input string is valid.
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    // --- Test ---
    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();
        System.out.println(sol.isValid("()[]{}"));  // true
        System.out.println(sol.isValid("(]"));      // false
        System.out.println(sol.isValid("{[]}"));    // true
    }
}
```
