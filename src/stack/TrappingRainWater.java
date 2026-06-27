package stack;

/**
 * LeetCode #42 - Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Given n non-negative integers representing an elevation map where the width of
 * each bar is 1, compute how much water it can trap after raining.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int left =0, right = height.length -1 ;
        int leftMax = 0, rightMax = 0, total =0;
        while (left < right){
            if (height[left] < height[right]) {
                if(height[left] >= leftMax )
                    leftMax = height[left];
                else
                    total += leftMax - height[left];
                left++;
            } else {
                if(height[right] >= rightMax )
                    rightMax = height[right];
                else
                    total += rightMax - height[right];
                right--;
            }


        }
        return total;
    }

    public static void main(String[] args) {
        TrappingRainWater sol = new TrappingRainWater();

        System.out.println(sol.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // expected 6
        System.out.println(sol.trap(new int[]{4, 2, 0, 3, 2, 5}));                   // expected 9
        System.out.println(sol.trap(new int[]{}));                                   // expected 0
        System.out.println(sol.trap(new int[]{5}));                                  // expected 0
        System.out.println(sol.trap(new int[]{3, 3, 3}));                            // expected 0
    }
}
