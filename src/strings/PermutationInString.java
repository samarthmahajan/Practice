package strings;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * LeetCode #567 - Permutation in String
 * https://leetcode.com/problems/permutation-in-string/
 *
 * Given s1 and s2 (lowercase), return true if s2 contains a permutation of s1
 * as a substring (a contiguous window of s2 that is an anagram of s1).
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        // your solution here

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

    public static void main(String[] args) {
        PermutationInString sol = new PermutationInString();

        System.out.println(sol.checkInclusion("ab", "eidbaooo"));   // true  ("ba")
        System.out.println(sol.checkInclusion("ab", "eidboaoo"));   // false
        System.out.println(sol.checkInclusion("a", "ab"));          // true  ("a")
        System.out.println(sol.checkInclusion("abc", "bbbca"));     // true  ("bca")
        System.out.println(sol.checkInclusion("hello", "hi"));      // false (s1 longer than s2)
        System.out.println(sol.checkInclusion("adc", "dcda"));      // true  ("dca")
    }
}
