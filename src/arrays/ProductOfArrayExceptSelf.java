package arrays;

import java.util.Arrays;

/**
 * LeetCode #238 - Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all elements of nums except nums[i].
 * Must run in O(n) time without using the division operator.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;

    }

    // --- Test ---
    private static int passed = 0, failed = 0;

    private static void check(String name, int[] nums, int[] expected) {
        int[] actual = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        boolean ok = Arrays.equals(actual, expected);
        if (ok) passed++; else failed++;
        System.out.printf("%-8s %-16s nums=%s -> got=%s expected=%s%n",
                ok ? "PASS" : "FAIL", name,
                Arrays.toString(nums), Arrays.toString(actual), Arrays.toString(expected));
    }

    public static void main(String[] args) {
        check("example1", new int[]{1, 2, 3, 4},      new int[]{24, 12, 8, 6});
        check("example2", new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0});
        check("withZero", new int[]{0, 1, 2, 3},       new int[]{6, 0, 0, 0});
        check("twoZeros", new int[]{0, 0, 2, 3},       new int[]{0, 0, 0, 0});
        check("twoElems", new int[]{3, 4},              new int[]{4, 3});

        System.out.printf("%n%d passed, %d failed%n", passed, failed);
    }
}
