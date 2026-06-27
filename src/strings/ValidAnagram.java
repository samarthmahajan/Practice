package strings;

import java.util.Arrays;

/**
 * LeetCode #242 - Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 *
 * Return true if t is an anagram of s (same letters, same counts, order irrelevant), else false.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] aphabet = new int[26];

        for (int i = 0 ; i<=s.length()-1; i++)
            aphabet[s.charAt(i)-'a']++;
        for (int i = 0 ; i<= t.length()-1; i++)
            aphabet[t.charAt(i)-'a']--;

        for (int i : aphabet) if (i != 0) return false;

        return true;

    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        System.out.println(sol.isAnagram("anagram", "nagaram")); // true
        System.out.println(sol.isAnagram("rat", "car"));         // false
        System.out.println(sol.isAnagram("a", "ab"));            // false (length mismatch)
    }
}
