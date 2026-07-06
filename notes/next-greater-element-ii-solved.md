# Next Greater Element II — Medium
Problem Link: https://leetcode.com/problems/next-greater-element-ii/
Solved Date: 2026-06-21
Pattern Tag: monotonic-stack

## SRS Tracking
- Stage: 4
- Review Date: 2026-07-21
- Last Rating: Strong
- Review Count: 2
- Graduated: No

---

> Backfilled from your solved code. Analogy / Mental-Model table / Dry Run to be filled on first review.

## Core Insight
Circular array: iterate 2n with i%n over a monotonic decreasing stack.

## Watch Out For
- Store values (answer is a value, not a distance); strict-greater pop with duplicates.

## Boiler Plate Template
```java
package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode #503 - Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/
 *
 * Given a circular array nums, return the next greater number for every element.
 * The next greater number of x is the first greater number to its traversing
 * order next in the array, searching circularly. If none exists, output -1.
 *
 * Implement nextGreaterElements, then run main to check against the test cases.
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        ArrayDeque<Integer>  stack = new ArrayDeque<>();
        int length = nums.length;
        int[] res = new int[length];
        for(int i = 2*length-1; i>=0 ; i--){
            int currentIndex  = i%length;
            while (!stack.isEmpty() && nums[currentIndex]>=stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[currentIndex]= -1;
            }else {
                res[currentIndex]= stack.peek();
            }
            stack.push(nums[currentIndex]);
        }
        return res;
    }

    // --- Test ---
    private static int passed = 0, failed = 0;

    private static void check(String name, int[] nums, int[] expected) {
        int[] actual = new NextGreaterElementII().nextGreaterElements(nums);
        boolean ok = Arrays.equals(actual, expected);
        if (ok) passed++; else failed++;
        System.out.printf("%-7s %-14s nums=%s -> got=%s expected=%s%n",
                ok ? "PASS" : "FAIL", name,
                Arrays.toString(nums), Arrays.toString(actual), Arrays.toString(expected));
    }

    public static void main(String[] args) {
        check("example1", new int[]{1, 2, 1}, new int[]{2, -1, 2});
        check("example2", new int[]{1, 2, 3, 4, 3}, new int[]{2, 3, 4, -1, 4});
        check("allSame", new int[]{5, 5, 5}, new int[]{-1, -1, -1});
        check("descending", new int[]{4, 3, 2, 1}, new int[]{-1, 4, 4, 4});
        check("ascending", new int[]{1, 2, 3}, new int[]{2, 3, -1});
        check("single", new int[]{1}, new int[]{-1});
        check("wrapAround", new int[]{5, 4, 3, 2, 6}, new int[]{6, 6, 6, 6, -1});
        check("mixed", new int[]{3, 8, 4, 1, 2}, new int[]{8, -1, 8, 2, 3});
        check("duplicates", new int[]{2, 1, 2, 4, 3}, new int[]{4, 2, 4, -1, 4});
        check("twoEqualMax", new int[]{1, 5, 3, 5, 2}, new int[]{5, -1, 5, -1, 5});

        System.out.printf("%n%d passed, %d failed%n", passed, failed);
    }
}
```
