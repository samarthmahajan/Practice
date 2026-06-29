package arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode #239 - Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Given array nums and window size k, return the maximum of each window as it
 * slides one step at a time from left to right. Target O(n).
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];      // one max per window position
        int ri = 0;                              // write index into result

        // Deque holds INDICES, kept so that nums[...] is strictly decreasing
        // front to back. nums[deque.peekFirst()] is always the current max.
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Expire the front if its index has slid out of the window.
            //    Window currently covers [i - k + 1, i], so any index <= i - k is gone.
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. Maintain decreasing order: the newcomer dominates (shadows) any
            //    tail element with a smaller-or-equal value, so pop those.
            //    '<=' evicts equal earlier values (the newer duplicate outlives them).
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 3. Add the current index at the back.
            deque.offerLast(i);

            // 4. Once the first full window is formed, the front is its max.
            if (i >= k - 1) {
                result[ri++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum sol = new SlidingWindowMaximum();

        System.out.println(Arrays.toString(
            sol.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));  // [3, 3, 5, 5, 6, 7]
        System.out.println(Arrays.toString(
            sol.maxSlidingWindow(new int[]{1}, 1)));                          // [1]
        System.out.println(Arrays.toString(
            sol.maxSlidingWindow(new int[]{9, 8, 7, 6, 5}, 2)));             // [9, 8, 7, 6]  (decreasing)
        System.out.println(Arrays.toString(
            sol.maxSlidingWindow(new int[]{1, 2, 3, 4, 5}, 2)));             // [2, 3, 4, 5]  (increasing)
        System.out.println(Arrays.toString(
            sol.maxSlidingWindow(new int[]{1, -1}, 1)));                      // [1, -1]      (k=1)
    }
}
