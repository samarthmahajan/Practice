package redo.strings;

/**
 * LeetCode #76 - Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Return the shortest substring of s containing every character of t (duplicates included),
 * or "" if no such substring exists.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] need = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int required = 0;
        for (int count : need) {
            if (count > 0) {
                required++;
            }
        }

        int have = 0;
        int start = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (--need[c] == 0) {
                have++;
            }

            while (have == required) {
                int windowLen = end - start + 1;

                if (windowLen < bestLen) {
                    bestLen = windowLen;
                    bestStart = start;
                }

                char d = s.charAt(start++);

                if (++need[d] == 1) {
                    have--;
                }
            }
        }

        return bestLen == Integer.MAX_VALUE
                ? ""
                : s.substring(bestStart, bestStart + bestLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(sol.minWindow("a", "a"));             // a
        System.out.println(sol.minWindow("a", "aa"));            // ""
    }
}
