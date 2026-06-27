package stack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * LeetCode #739 - Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Given an array temperatures, return an array answer such that answer[i] is the
 * number of days you have to wait after the i-th day to get a warmer temperature.
 * If there is no future day for which this is possible, answer[i] == 0.
 *
 * Implement dailyTemperatures, then run main to check against the test cases.
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> highTempMonotonicStack = new ArrayDeque<>();
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
    private static int passed = 0, failed = 0;

    private static void check(String name, int[] temperatures, int[] expected) {
        int[] actual = new DailyTemperatures().dailyTemperatures(temperatures);
        boolean ok = Arrays.equals(actual, expected);
        if (ok) passed++; else failed++;
        System.out.printf("%-7s %-16s temps=%s -> got=%s expected=%s%n",
                ok ? "PASS" : "FAIL", name,
                Arrays.toString(temperatures), Arrays.toString(actual), Arrays.toString(expected));
    }

    public static void main(String[] args) {
        check("example1", new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0});
        check("example2", new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0});
        check("example3", new int[]{30, 60, 90}, new int[]{1, 1, 0});
        check("allSame", new int[]{50, 50, 50}, new int[]{0, 0, 0});
        check("decreasing", new int[]{90, 80, 70, 60}, new int[]{0, 0, 0, 0});
        check("single", new int[]{55}, new int[]{0});
        check("lastWarmest", new int[]{70, 71, 72, 73, 74}, new int[]{1, 1, 1, 1, 0});
        check("plateauThenWarm", new int[]{60, 60, 60, 65}, new int[]{3, 2, 1, 0});
        check("oneSpike", new int[]{40, 100, 40, 40, 40}, new int[]{1, 0, 0, 0, 0});
        check("mixed", new int[]{55, 38, 53, 81, 61, 93, 97, 32, 43, 78}, new int[]{3, 1, 1, 2, 1, 1, 0, 1, 1, 0});

        System.out.printf("%n%d passed, %d failed%n", passed, failed);
    }
}
