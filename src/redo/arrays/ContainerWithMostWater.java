package redo.arrays;

/**
 * LeetCode #11 - Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Given an integer array height of length n, where height[i] is the height of a
 * vertical line at x = i, find the two lines that together with the x-axis form
 * a container holding the most water. Return the maximum amount of water.
 * You may not slant the container.
 *
 * REDO COLD 2026-07-06 — originally assisted 2026-06-28.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        var maxArea = 0;
        var left = 0;
        var right = height.length - 1;

        while (left < right) {
            var h = Math.min(height[left], height[right]);
            var w = right - left;
            maxArea = Math.max(maxArea, h * w);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // --- Test ---
    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();

        System.out.println(sol.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // Expected: 49
        System.out.println(sol.maxArea(new int[]{1, 1}));                      // Expected: 1
        System.out.println(sol.maxArea(new int[]{4, 3, 2, 1, 4}));             // Expected: 16
        System.out.println(sol.maxArea(new int[]{1, 2, 1}));                   // Expected: 2
        System.out.println(sol.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));     // Expected: 17
    }
}
