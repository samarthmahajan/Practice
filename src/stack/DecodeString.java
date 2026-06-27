package stack;

import java.util.Objects;
import java.util.Stack;

/**
 * LeetCode #394 - Decode String
 * https://leetcode.com/problems/decode-string/
 *
 * Decode a string encoded as k[encoded_string], where the inner string is
 * repeated k times. Brackets can be nested. Input is always valid.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Handle multi-digit numbers (e.g., 12 or 100)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current count and current string to their respective stacks
                countStack.push(k);
                stringStack.push(currentString);

                // Reset for the content inside the brackets
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Decode the current segment
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();

                // Repeat the currentString currentK times and append to the popped base
                //current = previous + (count × current).
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // Normal character, just append to the active string
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        DecodeString sol = new DecodeString();

        System.out.println(sol.decodeString("3[a]2[bc]"));      // expected: aaabcbc
        System.out.println(sol.decodeString("3[a2[c]]"));        // expected: accaccacc
        System.out.println(sol.decodeString("2[abc]3[cd]ef"));   // expected: abcabccdcdcdef
    }
}
