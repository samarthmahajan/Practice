package stack;

import java.util.Stack;

/**
 * Postfix to Infix Conversion
 * https://takeuforward.org/data-structure/postfix-to-infix
 *
 * Convert a postfix expression (e.g. "ab+cd-*") to
 * infix expression (e.g. "((a+b)*(c-d))").
 *
 * Hint:
 *  - Scan LEFT TO RIGHT
 *  - If operand, push onto stack
 *  - If operator, pop two operands, combine as "(op1 operator op2)", push result back
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class PostfixToInfix {

    public String convert(String postfix) {
        Stack<String> postToIn = new Stack<>();
        int length = postfix.length();
        for(int i = 0; i<= length-1; i++){
            char ch = postfix.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                postToIn.push(String.valueOf(ch));
            } else {
                String op2 = postToIn.pop();
                String op1 = postToIn.pop();
                postToIn.push("("+ op1+ ch+op2+")" );


            }
        }
        return postToIn.pop();
    }

    // --- Test ---
    public static void main(String[] args) {
        PostfixToInfix sol = new PostfixToInfix();

        // Test 1: simple
        System.out.println(sol.convert("ab+"));         // Expected: (a+b)

        // Test 2: nested
        System.out.println(sol.convert("ab+cd-*"));     // Expected: ((a+b)*(c-d))

        // Test 3: single operand
        System.out.println(sol.convert("a"));           // Expected: a

        // Test 4: all same operator
        System.out.println(sol.convert("ab+c+"));       // Expected: ((a+b)+c)

        // Test 5: power operator
        System.out.println(sol.convert("abc^^"));       // Expected: (a^(b^c))
    }
}
