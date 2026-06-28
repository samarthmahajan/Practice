package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        // your solution here
        int left =0, right = numbers.length-1;
        while ( left < right){
            if (numbers[left] + numbers[right] == target){
                return new  int[]{left +1, right+1};
            }else if ( numbers[left] + numbers[right]> target){
                right--;
            }else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSumII sol = new TwoSumII();

        System.out.println(Arrays.toString(sol.twoSum(new int[]{2, 7, 11, 15}, 9)));  // [1, 2]
        System.out.println(Arrays.toString(sol.twoSum(new int[]{2, 3, 4}, 6)));       // [1, 3]
        System.out.println(Arrays.toString(sol.twoSum(new int[]{-1, 0}, -1)));        // [1, 2]
    }
}
