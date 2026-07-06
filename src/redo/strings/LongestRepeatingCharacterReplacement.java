package redo.strings;

/**
 * LeetCode #424 - Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Given a string s of uppercase letters and an integer k, you may change at most
 * k characters to any other uppercase letter. Return the length of the longest
 * substring containing the same letter you can get after performing the changes.
 *
 * REDO COLD 2026-07-06 — originally assisted 2026-06-29.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxCount = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    // --- Test ---
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();

        System.out.println(sol.characterReplacement("ABAB", 2));       // Expected: 4
        System.out.println(sol.characterReplacement("AABABBA", 1));    // Expected: 4
        System.out.println(sol.characterReplacement("AAAA", 0));       // Expected: 4
        System.out.println(sol.characterReplacement("ABCDE", 1));      // Expected: 2
        System.out.println(sol.characterReplacement("BAAA", 0));       // Expected: 3
        System.out.println(sol.characterReplacement("AABA", 0));       // Expected: 2
    }
}
