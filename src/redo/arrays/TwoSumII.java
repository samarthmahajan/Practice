package redo.arrays;

import java.util.Arrays;

/**
 * LeetCode #167 - Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Given a 1-indexed array sorted in non-decreasing order, return the 1-indexed
 * positions [index1, index2] (index1 < index2) of the two numbers that add up
 * to target. Exactly one solution exists. Aim for O(1) extra space.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target)      return new int[]{left + 1, right + 1};
            else if (sum > target)  right--;
            else                    left++;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSumII solver = new TwoSumII();

        int[] t1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solver.twoSum(t1, 9))); // [1, 2]

        int[] t2 = {2, 3, 4};
        System.out.println(Arrays.toString(solver.twoSum(t2, 6))); // [1, 3]

        int[] t3 = {-1, 0};
        System.out.println(Arrays.toString(solver.twoSum(t3, -1))); // [1, 2]

        int[] t4 = {1, 2, 3, 4, 4, 9};
        System.out.println(Arrays.toString(solver.twoSum(t4, 8))); // [4, 5]  (duplicate values)

        int[] t5 = {5, 25, 75};
        System.out.println(Arrays.toString(solver.twoSum(t5, 100))); // [2, 3]
    }
}
