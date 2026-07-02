package arrays;

/**
 * LeetCode #704 - Binary Search
 * https://leetcode.com/problems/binary-search/
 *
 * Given a sorted (ascending) array of unique integers and a target,
 * return the index of target, or -1 if not present. Must run in O(log n).
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch sol = new BinarySearch();

        // Example 1: target present
        System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));   // expected: 4

        // Example 2: target absent
        System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));   // expected: -1
    }
}
