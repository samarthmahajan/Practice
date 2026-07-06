package redo.strings;

import java.util.Arrays;

/**
 * LeetCode #567 - Permutation in String
 * https://leetcode.com/problems/permutation-in-string/
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1
 * as a substring (i.e., some contiguous chunk of s2 is a rearrangement of s1).
 *
 * REDO COLD 2026-07-06 — originally assisted 2026-06-29.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()> s2.length())
            return  false;
        int[] count = new int[26];
        int win = s1.length();
        for (int x = 0; x < win; x++) {
            count[s1.charAt(x) - 'a']++;   // s1 contributes +1
            count[s2.charAt(x) - 'a']--;   // first window contributes -1
        }

        boolean allZeros = Arrays.stream(count).allMatch(x -> x == 0);

        int left = 0;
        while (left +win < s2.length() && !allZeros) {
            count[s2.charAt(left) - 'a']++;
            count[s2.charAt(left + win) - 'a']--;
            allZeros = Arrays.stream(count).allMatch(x -> x == 0);
            left++;

        }

        return allZeros;
    }
    
    // --- Test ---
    public static void main(String[] args) {
        PermutationInString sol = new PermutationInString();

        System.out.println(sol.checkInclusion("ab", "eidbaooo"));   // Expected: true
        System.out.println(sol.checkInclusion("ab", "eidboaoo"));   // Expected: false
        System.out.println(sol.checkInclusion("adc", "dcda"));      // Expected: true
        System.out.println(sol.checkInclusion("abc", "ab"));        // Expected: false
        System.out.println(sol.checkInclusion("a", "a"));           // Expected: true
        System.out.println(sol.checkInclusion("abab", "aabb"));     // Expected: true (a:2,b:2 both — whole s2 is the window)
    }
}
