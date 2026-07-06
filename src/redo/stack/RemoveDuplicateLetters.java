package redo.stack;

/**
 * LeetCode #316 - Remove Duplicate Letters
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Remove duplicate letters so every letter appears once and only once,
 * and the result is the smallest in lexicographical order among all possible results.
 *
 * Time:  O(n)
 * Space: O(1)  — fixed 26-letter bookkeeping
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {

// Pass 1 — learn the future: how many of each letter exist in total.
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        boolean[] inResult = new boolean[26];   // is this letter already placed?
        StringBuilder stack = new StringBuilder(); // doubles as stack + output

        // Pass 2 — build left-to-right.
        for (char c : s.toCharArray()) {
            count[c - 'a']--;                 // we've now consumed this occurrence

            if (inResult[c - 'a']) {
                continue;                     // rule: one copy of each letter only
            }

            // Evict a previously kept letter when:
            //   it's LARGER than c            -> dropping it makes the prefix smaller
            //   AND it still appears later     -> count > 0, so it's safe to drop
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
