# Evaluate Reverse Polish Notation — Medium
Problem Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
Solved Date: 2026-06-21
Pattern Tag: expression-parsing

## SRS Tracking
- Stage: 4
- Review Date: 2026-07-22
- Last Rating: Strong
- Review Count: 3
- Graduated: No

---

> Backfilled from your solved code. Analogy / Mental-Model table / Dry Run to be filled on first review.

## Core Insight
Operand stack: on an operator pop two operands, compute, push the result.

## Watch Out For
- For - and /, the FIRST popped value is the RIGHT operand.

## Boiler Plate Template
```java
package stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.function.DoubleBinaryOperator;

/**
 * LeetCode #150 - Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Evaluate an arithmetic expression in Reverse Polish Notation. Valid operators
 * are +, -, *, /. Each operand is an integer. Division truncates toward zero.
 * The expression is always valid and never divides by zero.
 *
 * Implement evalRPN, then run main to check against the test cases.
 */
public class EvaluateReversePolishNotation {

    private static final Map<String, DoubleBinaryOperator> OPERATORS = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> {
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            }
    );

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String val : tokens){
            if(val != null && val.matches("-?\\d+")){
                stack.push(Integer.parseInt(val));
            } else {
                Integer lat=stack.pop();
                Integer first=stack.pop();
                DoubleBinaryOperator op = OPERATORS.get(val);
                Double res = op.applyAsDouble( first, lat);
                stack.push(res.intValue());

            }
        }
        return stack.pop();

    }

    // --- Test ---
    private static int passed = 0, failed = 0;

    private static void check(String name, String[] tokens, int expected) {
        int actual = new EvaluateReversePolishNotation().evalRPN(tokens);
        boolean ok = actual == expected;
        if (ok) passed++; else failed++;
        System.out.printf("%-7s %-16s tokens=%-40s -> got=%d expected=%d%n",
                ok ? "PASS" : "FAIL", name,
                Arrays.toString(tokens), actual, expected);
    }

    public static void main(String[] args) {
        check("example1", new String[]{"2", "1", "+", "3", "*"}, 9);
        check("example2", new String[]{"4", "13", "5", "/", "+"}, 6);
        check("example3", new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22);
        check("single", new String[]{"42"}, 42);
        check("negResult", new String[]{"3", "4", "-"}, -1);
        check("truncTowardZero", new String[]{"7", "-3", "/"}, -2);
        check("truncNeg", new String[]{"-7", "3", "/"}, -2);
        check("multiplyNeg", new String[]{"-2", "3", "*"}, -6);
        check("chain", new String[]{"1", "2", "+", "3", "+", "4", "+"}, 10);
        check("divThenMul", new String[]{"100", "5", "/", "2", "*"}, 40);

        System.out.printf("%n%d passed, %d failed%n", passed, failed);
    }
}
```
