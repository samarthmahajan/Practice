package queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode #232 - Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Implement a FIFO queue (push, pop, peek, empty) using only two stacks and
 * standard stack operations (push to top, peek/pop from top, size, isEmpty).
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class MyQueue {

    private final Deque<Integer> input = new ArrayDeque<>();   // newest pushes land here
    private final Deque<Integer> output = new ArrayDeque<>();  // pop / peek served from here

    public MyQueue() {
    }

    public void push(int x) {
        input.push(x);
        // your solution here
    }

    public int pop() {
        // your solution here
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty())
                output.push(input.pop());
        }
        return output.peek();
    }

    public boolean empty() {
        // your solution here
        return output.isEmpty() && input.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());   // expected 1
        System.out.println(q.pop());    // expected 1
        System.out.println(q.empty());  // expected false
        System.out.println(q.pop());    // expected 2
        System.out.println(q.empty());  // expected true
    }
}
