package arrays;

/**
 * LeetCode #153 - Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * A sorted ascending array of UNIQUE elements is rotated 1..n times. Return the
 * minimum element. Must run in O(log n).
 *
 * Time:  O(log n)
 * Space: O(1)
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left<right){
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();

        System.out.println(sol.findMin(new int[]{3, 4, 5, 1, 2}));          // expected: 1
        System.out.println(sol.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));    // expected: 0
        System.out.println(sol.findMin(new int[]{11, 13, 15, 17}));         // expected: 11 (not rotated)
        System.out.println(sol.findMin(new int[]{2, 1}));                   // expected: 1
        System.out.println(sol.findMin(new int[]{1}));                      // expected: 1 (single element)
    }
}
