package redo.arrays;

/**
 * LeetCode #704 - Binary Search
 * https://leetcode.com/problems/binary-search/
 *
 * Given a sorted ascending array of distinct integers and a target, return the
 * index of target, or -1 if it is not present. Must run in O(log n).
 *
 * REDO COLD 2026-07-06 — originally assisted 2026-06-30 (loop operator coach-supplied).
 * Time:  O(?)
 * Space: O(?)
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // --- Test ---
    public static void main(String[] args) {
        BinarySearch sol = new BinarySearch();

        System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));  // Expected: 4
        System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));  // Expected: -1
        System.out.println(sol.search(new int[]{5}, 5));                   // Expected: 0
        System.out.println(sol.search(new int[]{5}, -5));                  // Expected: -1
        System.out.println(sol.search(new int[]{2, 5}, 5));                // Expected: 1
        System.out.println(sol.search(new int[]{2, 5}, 2));                // Expected: 0
        System.out.println(sol.search(new int[]{1, 2, 3}, 1));             // Expected: 0
        System.out.println(sol.search(new int[]{1, 2, 3}, 4));             // Expected: -1
    }
}
