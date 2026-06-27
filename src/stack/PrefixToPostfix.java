package stack;

import java.util.Stack;

/**
 * Prefix to Postfix Conversion
 * https://takeuforward.org/data-structure/prefix-to-postfix-conversion
 *
 * Convert a prefix expression (e.g. "*+ab-cd") to
 * postfix expression (e.g. "ab+cd-*").
 *
 * Hint:
 *  - Scan the prefix string RIGHT TO LEFT
 *  - If operand, push it onto the stack
 *  - If operator, pop two operands, combine as "op1 op2 operator", push result back
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class PrefixToPostfix {

    public String convert(String prefix) {
        Stack<String> preToPost = new Stack<>();
        int length = prefix.length();
        for (int i = length-1; i>=0; i--){
            char ch = prefix.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                preToPost.push(String.valueOf(ch));
            }else{
                String op1 = preToPost.pop();
                String op2 = preToPost.pop();
                preToPost.push(op1 +op2 + ch);
            }
        }
        return preToPost.pop();
    }

    // --- Test ---
    public static void main(String[] args) {
        PrefixToPostfix sol = new PrefixToPostfix();

        // Test 1: simple
        System.out.println(sol.convert("+ab"));         // Expected: ab+

        // Test 2: nested
        System.out.println(sol.convert("*+ab-cd"));     // Expected: ab+cd-*

        // Test 3: single operand
        System.out.println(sol.convert("a"));           // Expected: a

        // Test 4: all same operator
        System.out.println(sol.convert("++abc"));       // Expected: ab+c+

        // Test 5: power operator
        System.out.println(sol.convert("^a^bc"));       // Expected: abc^^
    }
}
