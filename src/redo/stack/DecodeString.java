package redo.stack;

import java.util.Stack;

/**
 * LeetCode #394 - Decode String (REDO COLD - 2026-07-02)
 * https://leetcode.com/problems/decode-string/
 *
 * Given an encoded string where k[encoded_string] means the bracketed string
 * is repeated k times (brackets can nest), return the decoded string.
 *
 * Redo result: PASSED cold - 19/30 min, 4/5, unaided.
 *
 * Time:  O(n + D) where D = decoded output length (output-sensitive, D <= 1e5)
 * Space: O(D) - builder holds the answer; prefix stack can hold expanded prefixes
 */
public class DecodeString {

    public String decodeString(String s) {
        int k= 0;
        Stack<Integer> valueStack = new Stack<>();
        Stack<String> stringSoFar = new Stack<>();
        StringBuilder currentString = new StringBuilder();

        for (char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                int chr = ch- '0';
                k= k*10 + chr;
            } else if(ch == '['){
                valueStack.push(k);
                stringSoFar.push(currentString.toString());
                k = 0;
                currentString = new StringBuilder();
            }  else if(ch == ']'){
                StringBuilder string = new StringBuilder();
                if(!stringSoFar.isEmpty()){
                   string = new StringBuilder(stringSoFar.pop());
                }
                int val = valueStack.pop();
                for ( int i = 0 ; i< val ;i++){
                    string.append(currentString);
                }

                currentString = string;


            } else {
                currentString.append(ch);
            }


        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
        System.out.println(sol.decodeString("3[a]2[bc]"));    // expected: aaabcbc
        System.out.println(sol.decodeString("3[a2[c]]"));     // expected: accaccacc
        System.out.println(sol.decodeString("2[abc]3[cd]ef")); // expected: abcabccdcdcdef
    }
}
