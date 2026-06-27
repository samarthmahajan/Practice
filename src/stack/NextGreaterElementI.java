package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode #496 - Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/
 *
 * nums1 is a subset of nums2. For each value in nums1, find the next greater
 * element to its right in nums2; if none exists, the answer is -1.
 *
 * Implement nextGreaterElement, then run main to check against the test cases.
 */
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreatest = new HashMap<>();
        converToNextgreatest(nums2, nextGreatest);
        for (int i=0; i<=nums1.length-1; i++){
            nums1[i] = nextGreatest.get(nums1[i]);
        }
        return nums1;
    }

    private void converToNextgreatest(int[] nums2, Map<Integer, Integer> nextGreatest) {
        Stack<Integer> helperStack = new Stack<>();
        for (int i = nums2.length-1; i>= 0; i--){

            Integer support = nums2[i];

            while (!helperStack.isEmpty() && helperStack.peek() <= support) {
                helperStack.pop();
            }

            if(helperStack.isEmpty()){
                nextGreatest.put(support, -1);
            } else {
                nextGreatest.put( support, helperStack.peek());


            }
            helperStack.push(support);


        }


    }

    // --- Test ---
    private static int passed = 0, failed = 0;

    private static void check(String name, int[] nums1, int[] nums2, int[] expected) {
        int[] actual = new NextGreaterElementI().nextGreaterElement(nums1, nums2);
        boolean ok = Arrays.equals(actual, expected);
        if (ok) passed++; else failed++;
        System.out.printf("%-7s %-16s nums1=%s nums2=%s -> got=%s expected=%s%n",
                ok ? "PASS" : "FAIL", name,
                Arrays.toString(nums1), Arrays.toString(nums2),
                Arrays.toString(actual), Arrays.toString(expected));
    }

    public static void main(String[] args) {
        check("example1", new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}, new int[]{-1, 3, -1});
        check("example2", new int[]{2, 4}, new int[]{1, 2, 3, 4}, new int[]{3, -1});
        check("singleNoGreater", new int[]{2}, new int[]{2}, new int[]{-1});
        check("ascending", new int[]{1, 2, 3}, new int[]{1, 2, 3, 4}, new int[]{2, 3, 4});
        check("descending", new int[]{3, 2, 1}, new int[]{3, 2, 1}, new int[]{-1, -1, -1});
        check("lastElement", new int[]{4}, new int[]{1, 3, 4, 2}, new int[]{-1});
        check("firstElement", new int[]{1}, new int[]{1, 3, 4, 2}, new int[]{3});
        check("fullSubset", new int[]{1, 3, 4, 2}, new int[]{1, 3, 4, 2}, new int[]{3, 4, -1, -1});
        check("singlePair", new int[]{1}, new int[]{1, 2}, new int[]{2});
        check("largeJump", new int[]{5}, new int[]{5, 1, 2, 3, 9}, new int[]{9});

        System.out.printf("%n%d passed, %d failed%n", passed, failed);
    }
}
