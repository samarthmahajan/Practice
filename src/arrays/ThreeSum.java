package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #15 - 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * Return all unique triplets [nums[i], nums[j], nums[k]] with distinct indices
 * that sum to 0. The result must not contain duplicate triplets.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        // The array must be sorted for the two-pointer approach and duplicate skipping to work
        Arrays.sort(nums);

        // Outer loop iterates through the "anchor" element.
        // We stop at nums.length - 2 because we need at least 3 elements for a triplet.
        for (int i = 0; i < nums.length - 2; i++) {

            // Fix 2: Skip duplicate anchors to avoid identical triplets in the result
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Fix 1: Reset both pointers fresh for every new anchor
            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];

                if (sum == 0) {
                    lists.add(List.of(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;

                    // Fix 3: Skip duplicate elements for the second and third pointers after a hit
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == nums[hi + 1]) {
                        hi--;
                    }
                } else if (sum > 0) {
                    // Sum is too large, move the right pointer left to decrease the sum
                    hi--;
                } else {
                    // Sum is too small, move the left pointer right to increase the sum
                    lo++;
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();

        System.out.println(sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(sol.threeSum(new int[]{0, 1, 1}));             // []
        System.out.println(sol.threeSum(new int[]{0, 0, 0}));            // [[0, 0, 0]]
    }
}
