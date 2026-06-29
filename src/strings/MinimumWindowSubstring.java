package strings;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeetCode #76 - Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Given strings s and t, return the smallest substring of s that contains every
 * character of t (including duplicates). Return "" if no such window exists.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Long> map = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));
        int start = 0, end = 0, min = Integer.MAX_VALUE;
        String minString = "";
        //ADOBECODEBANC
        while (end < s.length()) {
            if(map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
            }
            end++;
            while (map.values().stream().allMatch(c -> c <=0)) {
                if(end - start < min) {
                    minString = s.substring(start, end);
                    min = end - start;
                }
                if(map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                }
                start++;
            }
        }
        return minString;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();

        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));  // "BANC"
        System.out.println(sol.minWindow("a", "a"));                // "a"
        System.out.println(sol.minWindow("a", "aa"));               // ""   (need two a's, only one)
        System.out.println(sol.minWindow("aa", "aa"));              // "aa"
        System.out.println(sol.minWindow("ab", "b"));               // "b"
        System.out.println(sol.minWindow("cabwefgewcwaefgcf", "cae")); // "cwae"
    }
}
