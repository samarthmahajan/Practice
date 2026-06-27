package stack;

import java.util.Stack;

/**
 * Prefix to Infix Conversion
 * https://takeuforward.org/data-structure/prefix-to-infix-conversion
 *
 * Convert a prefix expression (e.g. "+ab") to
 * infix expression (e.g. "(a+b)").
 *
 * Hint:
 *  - Scan the prefix string RIGHT TO LEFT
 *  - If operand, push it onto the stack
 *  - If operator, pop two operands, combine as "(op1 operator op2)", push result back
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class PrefixToInfix {

    public String convert(String prefix) {
       Stack<String> preToIn = new Stack<>();
       int length = prefix.length();
       for (int i = length-1 ; i>=0; i--){
           char ch = prefix.charAt(i);
           if(Character.isLetterOrDigit(ch)){
               preToIn.push(String.valueOf(ch));
           }else {
               String op1 = preToIn.pop();
               String op2 = preToIn.pop();

               preToIn.push("(" + op1 + ch + op2 + ")");
           }
       }
       return preToIn.pop();
    }

    // --- Test ---
    public static void main(String[] args) {
        PrefixToInfix sol = new PrefixToInfix();

        // Test 1: simple
        System.out.println(sol.convert("+ab"));           // Expected: (a+b)

        // Test 2: nested
        System.out.println(sol.convert("*+ab-cd"));       // Expected: ((a+b)*(c-d))

        // Test 3: single operand
        System.out.println(sol.convert("a"));             // Expected: a

        // Test 4: all same operator
        System.out.println(sol.convert("++abc"));         // Expected: ((a+b)+c)

        // Test 5: power operator
        System.out.println(sol.convert("^a^bc"));         // Expected: (a^(b^c))
    }
}
