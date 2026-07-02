package redo.stack;

import java.util.Stack;

/**
 * LeetCode #227 - Basic Calculator II (REDO COLD - 2026-07-02)
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * Evaluate a valid expression string containing non-negative integers,
 * the operators + - * / (integer division truncates toward zero), and spaces.
 * No parentheses.
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int res = 0, num =0;
        char preOpr = '+';
        for(int i=0; i<s.length();i++){
            char c =s.charAt(i);
            if (Character.isDigit(c))  num = num*10 +(c-'0');
            if(c =='+' || c =='*' || c =='/' || c =='-' || i == s.length()-1){
                switch (preOpr){
                    case '+' -> stk.push(num);
                    case '-' -> stk.push(-num);
                    case '*' -> stk.push(stk.pop() * num);
                    case '/' -> stk.push(stk.pop() / num);
                }
                preOpr = c;
                num= 0;
            }
        }
        for ( int t: stk) res += t;
        return res;
    }

    public static void main(String[] args) {
        BasicCalculatorII sol = new BasicCalculatorII();
        System.out.println(sol.calculate("3+2*2"));     // expected: 7
        System.out.println(sol.calculate(" 3/2 "));     // expected: 1
        System.out.println(sol.calculate(" 3+5 / 2 ")); // expected: 5
    }
}
