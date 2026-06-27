package stack;

import java.util.Stack;

/**
 * LeetCode #155 - Min Stack
 * https://leetcode.com/problems/min-stack/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 * Time:  O(?) for each operation
 * Space: O(?)
 */
public class MinStack {
    public record LongPair(int val, int minSoFar) {}
    Stack<LongPair> stackVal = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        int newMin = stackVal.isEmpty() ? val : Math.min(val, stackVal.peek().minSoFar());
        stackVal.push(new LongPair(val, newMin));

    }

    public void pop() {
       stackVal.pop();

    }

    public int top() {
        // TODO
        return stackVal.peek().val();
    }

    public int getMin() {
        // TODO
        return stackVal.peek().minSoFar();
    }

    // --- Test ---
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        // Test 1: basic push and getMin
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin()); // Expected: -3
        stack.pop();
        System.out.println(stack.top());    // Expected: 0
        System.out.println(stack.getMin()); // Expected: -2

        System.out.println("---");

        // Test 2: single element
        MinStack stack2 = new MinStack();
        stack2.push(5);
        System.out.println(stack2.top());    // Expected: 5
        System.out.println(stack2.getMin()); // Expected: 5

        System.out.println("---");

        // Test 3: min updates correctly on pop
        MinStack stack3 = new MinStack();
        stack3.push(3);
        stack3.push(1);
        stack3.push(2);
        System.out.println(stack3.getMin()); // Expected: 1
        stack3.pop();                        // remove 2
        System.out.println(stack3.getMin()); // Expected: 1
        stack3.pop();                        // remove 1
        System.out.println(stack3.getMin()); // Expected: 3
    }
}
