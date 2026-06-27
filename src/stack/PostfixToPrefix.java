package stack;

import java.util.Stack;

/**
 * Postfix to Prefix Conversion
 * https://takeuforward.org/data-structure/postfix-to-prefix-conversion
 *
 * Convert a postfix expression (e.g. "ab+cd-*") to
 * prefix expression (e.g. "*+ab-cd").
 *
 * Hint:
 *  - Scan LEFT TO RIGHT
 *  - If operand, push onto stack
 *  - If operator, pop two operands, combine as "operator op1 op2", push result back
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class PostfixToPrefix {

    public String convert(String postfix) {
        Stack<String> preToIn = new Stack<>();
        int length = postfix.length();
        for(int i = 0; i<=length-1; i++){
            char ch = postfix.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                preToIn.push(String.valueOf(ch));
            }else {
                String op1 = preToIn.pop();
                String op2 = preToIn.pop();

                preToIn.push( ch +  op2 +op1 );
            }
        }
        return preToIn.pop();
    }

    // --- Test ---
    public static void main(String[] args) {
        PostfixToPrefix sol = new PostfixToPrefix();

        // Test 1: simple
        System.out.println(sol.convert("ab+"));         // Expected: +ab

        // Test 2: nested
        System.out.println(sol.convert("ab+cd-*"));     // Expected: *+ab-cd

        // Test 3: single operand
        System.out.println(sol.convert("a"));           // Expected: a

        // Test 4: all same operator
        System.out.println(sol.convert("ab+c+"));       // Expected: ++abc

        // Test 5: power operator
        System.out.println(sol.convert("abc^^"));       // Expected: ^a^bc
    }
}
