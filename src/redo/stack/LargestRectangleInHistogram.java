package redo.stack;

import java.util.Stack;

/**
 * LeetCode #84 - Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given bar heights (width 1 each), return the area of the largest
 * rectangle that fits entirely inside the histogram.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Nearest Smaller to Left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();

            left[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear(); // Reuse stack

        // Nearest Smaller to Right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram sol = new LargestRectangleInHistogram();
        System.out.println(sol.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})); // expected: 10
        System.out.println(sol.largestRectangleArea(new int[]{2, 4}));             // expected: 4
    }
}
