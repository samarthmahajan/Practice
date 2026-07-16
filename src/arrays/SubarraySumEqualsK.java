package arrays;

import java.util.HashMap;

/**
 * LeetCode #560 - Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Given an integer array nums and an integer k, return the total number of
 * CONTIGUOUS, non-empty subarrays whose sum equals k. Elements may be negative.
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> subNum = new HashMap<>();
        subNum.put(0, 1);
        int total = 0, count = 0;

        for (int n : nums) {
            total += n;

            if (subNum.containsKey(total - k)) {
                count += subNum.get(total - k);
            }

            subNum.put(total, subNum.getOrDefault(total, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK sol = new SubarraySumEqualsK();

        System.out.println(sol.subarraySum(new int[]{1, 1, 1}, 2));    // expected: 2
        System.out.println(sol.subarraySum(new int[]{1, 2, 3}, 3));    // expected: 2

        // Write your own edge tests here BEFORE you trust the two above.
    }
}
