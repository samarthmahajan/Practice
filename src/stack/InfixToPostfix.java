package stack;

import java.util.Stack;

/**
 * Infix to Postfix Conversion
 * https://takeuforward.org/data-structure/infix-to-postfix
 *
 * Convert an infix expression (e.g. "a+b*(c-d)") to
 * postfix/RPN expression (e.g. "abcd-*+").
 *
 * Rules:
 *
 *  - '(' is pushed onto the stack
 *  - ')' pops from stack to output until '(' is found
 *  - Operators: pop stack while top has >= precedence, then push current
 *
 * Precedence:
 *  ^ (right-associative) → 3
 *  * /                   → 2
 *  + -                   → 1
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class InfixToPostfix {

    // TODO: implement precedence helper
    private int precedence(char op) {
        if (op == '^')
            return  3;
        else if (op == '/' || op == '*') {
            return 2;
        }
        else
            return 1;
    }

    public String convert(String infix) {
        //"(a+b)*(c-d)"));   // Expected: ab+cd-*
        Stack<Character> helperStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : infix.toCharArray()){
            if (ch == '(') {
                helperStack.push(ch);
            }else if(ch == ')'){
                while (helperStack.peek() != '(')
                    sb.append(helperStack.pop());
                helperStack.pop();
            }
            else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            } else {
                while (!helperStack.isEmpty() && helperStack.peek() != '(' &&
                       (ch == '^' ? precedence(helperStack.peek()) > precedence(ch)
                                  : precedence(helperStack.peek()) >= precedence(ch))) {
                    sb.append(helperStack.pop());
                }
                helperStack.push(ch);
            }
        }

        // flush remaining operators
        while (!helperStack.isEmpty())
            sb.append(helperStack.pop());

        return sb.toString();
    }

    // --- Test ---
    public static void main(String[] args) {
        InfixToPostfix sol = new InfixToPostfix();

        // Test 1: simple addition and multiplication
        System.out.println(sol.convert("a+b*c"));         // Expected: abc*+

        // Test 2: parentheses override precedence
        System.out.println(sol.convert("(a+b)*c"));       // Expected: ab+c*

        // Test 3: nested parentheses
        System.out.println(sol.convert("a+b*(c-d)"));     // Expected: abcd-*+

        // Test 4: multiple operators same precedence (left to right)
        System.out.println(sol.convert("a+b+c"));         // Expected: ab+c+

        // Test 5: power operator (right-associative)
        System.out.println(sol.convert("a^b^c"));         // Expected: abc^^

        // Test 6: complex expression
        System.out.println(sol.convert("(a+b)*(c-d)"));   // Expected: ab+cd-*
    }
}
