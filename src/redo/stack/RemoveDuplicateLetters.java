package redo.stack;

/**
 * LeetCode #316 - Remove Duplicate Letters
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Remove duplicate letters so every letter appears once and only once,
 * and the result is the smallest in lexicographical order among all possible results.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        boolean[] inResult = new boolean[26];
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            if (inResult[c - 'a']) continue;


            while (stack.length() > 0
                    && stack.charAt(stack.length() - 1) > c
                    && count[stack.charAt(stack.length() - 1) - 'a'] > 0) {
                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                inResult[removed - 'a'] = false;
            }

            stack.append(c);
            inResult[c - 'a'] = true;
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters sol = new RemoveDuplicateLetters();
        System.out.println(sol.removeDuplicateLetters("bcabc"));    // expected: "abc"
        System.out.println(sol.removeDuplicateLetters("cbacdcbc")); // expected: "acdb"
    }
}
