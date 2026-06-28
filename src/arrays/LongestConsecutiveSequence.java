package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * LeetCode #128 - Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Given an unsorted array, return the length of the longest run of consecutive
 * integers (each +1 above the previous). Must run in O(n) time — sorting is ruled out.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int best = 0;
        for (int x : set) {
            if (set.contains(x + 1)) continue;       // not a run-top → skip
            int len = 0;
            while (set.contains(x - len)) len++;     // walk down, single counter
            best = Math.max(best, len);
        }
        return best;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        System.out.println(sol.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));       // 4
        System.out.println(sol.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
        System.out.println(sol.longestConsecutive(new int[]{}));                            // 0
        System.out.println(sol.longestConsecutive(new int[]{1, 2, 0, 1}));                  // 3
    }
}
