package redo.arrays;

import java.util.Arrays;

/**
 * LeetCode #238 - Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * answer[i] = product of all elements except nums[i].
 * O(n) time, no division; follow-up: O(1) extra space (output excluded).
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) ans[i] = ans[i-1] * nums[i-1];  // ans = prefix
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf sol = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1, 2, 3, 4})));     // expected: [24, 12, 8, 6]
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{-1, 1, 0, -3, 3}))); // expected: [0, 0, 9, 0, 0]
    }
}
