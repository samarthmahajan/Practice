package redo.arrays;

/**
 * LeetCode #242 - Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 *
 * Return true if t is an anagram of s — same characters with the
 * same counts, in any order.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // your solution here
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) count[t.charAt(i) - 'a']--;
        for (int v : count) if (v != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        System.out.println(sol.isAnagram("anagram", "nagaram")); // expected: true
        System.out.println(sol.isAnagram("rat", "car"));         // expected: false
    }
}
