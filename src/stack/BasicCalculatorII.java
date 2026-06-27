package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode #227 - Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * Evaluate a valid arithmetic expression string of non-negative integers and
 * the operators +, -, *, / (with spaces). No parentheses. * and / have higher
 * precedence than + and -. Integer division truncates toward zero.
 *
 * Time:  O(n) - single pass over the string.
 * Space: O(n) - stack holds the +/- terms (worst case all additions).
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;          // the number currently being built, digit by digit
        char prevOp = '+';    // operator BEFORE num; '+' simulates a leading +

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');   // fold next digit in (multi-digit safe)
            }

            // Act when we hit an operator OR the final char (the last number has
            // no operator after it, so end-of-string is its trigger).
            // A space is neither digit nor operator -> it falls through, skipped.
            boolean isOperator = (c == '+' || c == '-' || c == '*' || c == '/');
            if (isOperator || i == s.length() - 1) {
                switch (prevOp) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);  // popped = LEFT operand
                    case '/' -> stack.push(stack.pop() / num);  // popped / num
                }
                prevOp = c;   // remember THIS operator for the next number
                num = 0;      // reset accumulator
            }
        }

        // Everything on the stack is a +/- adjusted term -> just sum them.
        int result = 0;
        for (int term : stack) {
            result += term;
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculatorII sol = new BasicCalculatorII();

        System.out.println(sol.calculate("3+2*2"));             // expected 7
        System.out.println(sol.calculate(" 3/2 "));             // expected 1
        System.out.println(sol.calculate("3+5 / 2"));           // expected 5
        System.out.println(sol.calculate("3 + 5 * 2 - 8 / 4")); // expected 11
        System.out.println(sol.calculate("12+34*5"));           // expected 182
    }
}
