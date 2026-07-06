package redo.arrays;

import java.util.HashSet;
import java.util.Set;

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
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int best = 0;
        for (int x : set) {
            if (set.contains(x + 1)) continue;
            int len = 0, cur = x;
            while (set.contains(cur)) { len++; cur--; }
            best = Math.max(best, len);
        }
        return best;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solver = new LongestConsecutiveSequence();

        int[] t1 = {100, 4, 200, 1, 3, 2};
        System.out.println(solver.longestConsecutive(t1)); // 4  (1,2,3,4)

        int[] t2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solver.longestConsecutive(t2)); // 9  (0..8, duplicate 0)

        int[] t3 = {};
        System.out.println(solver.longestConsecutive(t3)); // 0

        int[] t4 = {5};
        System.out.println(solver.longestConsecutive(t4)); // 1

        int[] t5 = {1, 2, 0, 1};
        System.out.println(solver.longestConsecutive(t5)); // 3  (0,1,2 — duplicates present)
    }
}
