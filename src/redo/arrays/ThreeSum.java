package redo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #15 - 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, j != k, and nums[i] + nums[j] + nums[k] == 0.
 * The solution set must not contain duplicate triplets.
 *
 * REDO COLD 2026-07-06 — originally assisted 2026-06-27.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;       // dup anchor
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[lo], nums[hi]));
                    lo++; hi--;
                    while (lo < hi && nums[lo] == nums[lo - 1]) lo++;   // dup lo
                    while (lo < hi && nums[hi] == nums[hi + 1]) hi--;   // dup hi
                } else if (sum > 0) hi--;
                else lo++;
            }
        }
        return res;

    }

    // --- Test ---
    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();

        System.out.println(sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // Expected: [[-1, -1, 2], [-1, 0, 1]] (order of triplets doesn't matter)

        System.out.println(sol.threeSum(new int[]{0, 1, 1}));
        // Expected: []

        System.out.println(sol.threeSum(new int[]{0, 0, 0}));
        // Expected: [[0, 0, 0]]

        System.out.println(sol.threeSum(new int[]{-2, 0, 0, 2, 2}));
        // Expected: [[-2, 0, 2]]

        System.out.println(sol.threeSum(new int[]{-1, -1, -1, 2, 2, 0, 0}));
        // Expected: [[-1, -1, 2]] (only two zeros, so no [0,0,0]; each triplet reported once)
    }
}
