package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #3 - Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Time:  O(n)
 * Space: O(min(n, alphabet))
 */
public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>(); // chars currently in [left..right]
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Invariant: window must stay duplicate-free.
            // If c is already inside, SHRINK FROM THE LEFT one char at a time
            // until the offending duplicate is evicted — never advance right while invalid.
            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(c);
            max = Math.max(max, right - left + 1); // window size = right - left + 1
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating sol = new LongestSubstringWithoutRepeating();

        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // expected 3  ("abc")
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));    // expected 1  ("b")
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));   // expected 3  ("wke")
        System.out.println(sol.lengthOfLongestSubstring("abba"));     // expected 2  ("ab" / "ba")
        System.out.println(sol.lengthOfLongestSubstring(""));         // expected 0
    }
}
