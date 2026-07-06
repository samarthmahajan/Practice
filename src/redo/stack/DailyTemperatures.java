package redo.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode #739 - Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Given an array temperatures, return an array answer such that answer[i] is the
 * number of days you have to wait after the i-th day to get a warmer temperature.
 * If there is no future day for which this is possible, answer[i] == 0.
 *
 * SPRINT REVIEW 2026-07-06 — cold write, back-to-front method.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        Deque<Integer> highTempMonotonicStack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int i= temperatures.length -1 ; i>=0; i--){
            int temperature = temperatures[i];
            while (!highTempMonotonicStack.isEmpty() && temperatures[highTempMonotonicStack.peek()]<= temperature)
                highTempMonotonicStack.pop();
            if(!highTempMonotonicStack.isEmpty())
                result[i]=highTempMonotonicStack.peek()-i;
            else
                result[i]=0;
            highTempMonotonicStack.push(i);
        }

        return result;
    }

    // --- Test ---
    public static void main(String[] args) {
        DailyTemperatures sol = new DailyTemperatures();

        System.out.println(Arrays.toString(sol.dailyTemperatures(
                new int[]{73, 74, 75, 71, 69, 72, 76, 73}))); // Expected: [1, 1, 4, 2, 1, 1, 0, 0]

        System.out.println(Arrays.toString(sol.dailyTemperatures(
                new int[]{73, 74}))); // Expected: [1, 0]  ← the drill case

        System.out.println(Arrays.toString(sol.dailyTemperatures(
                new int[]{50, 50, 50}))); // Expected: [0, 0, 0]

        System.out.println(Arrays.toString(sol.dailyTemperatures(
                new int[]{90, 80, 70, 60}))); // Expected: [0, 0, 0, 0]

        System.out.println(Arrays.toString(sol.dailyTemperatures(
                new int[]{60, 60, 60, 65}))); // Expected: [3, 2, 1, 0]
    }
}
