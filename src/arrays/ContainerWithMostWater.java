package arrays;

/**
 * LeetCode #11 - Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Given an array of vertical line heights, pick two lines that with the x-axis
 * form a container holding the most water. Return the maximum area.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int maxArea = 0, left = 0, right =height.length-1;
        while (left<right){
           int area = Math.min(height[left], height[right]) * (right-left);
           maxArea = Math.max(maxArea,area);

           if (height[left] <= height[right]){
               left++;
           }else
               right--;

        }
        // your solution here
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();

        System.out.println(sol.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // expected 49
        System.out.println(sol.maxArea(new int[]{1, 1}));                       // expected 1
        System.out.println(sol.maxArea(new int[]{4, 3, 2, 1, 4}));             // expected 16
        System.out.println(sol.maxArea(new int[]{1, 2, 1}));                   // expected 2
    }
}
