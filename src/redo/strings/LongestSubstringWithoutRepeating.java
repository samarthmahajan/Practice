package redo.strings;

import java.util.Arrays;

/**
 * LeetCode #3 - Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring (contiguous)
 * without duplicate characters.
 *
 * REDO COLD 2026-07-06 — saw solution 2026-06-28.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        int best = 0; int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, lastSeen[c] + 1);
            lastSeen[c] = right;
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    // --- Test ---
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating sol = new LongestSubstringWithoutRepeating();

        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // Expected: 3 ("abc")
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));    // Expected: 1 ("b")
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));   // Expected: 3 ("wke")
        System.out.println(sol.lengthOfLongestSubstring(""));         // Expected: 0
        System.out.println(sol.lengthOfLongestSubstring("abba"));     // Expected: 2 ("ab")
        System.out.println(sol.lengthOfLongestSubstring("dvdf"));     // Expected: 3 ("vdf")
    }
}
