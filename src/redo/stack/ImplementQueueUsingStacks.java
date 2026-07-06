package redo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode #232 - Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Implement a FIFO queue using only two stacks (push-to-top,
 * peek/pop-from-top, size, isEmpty allowed).
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class ImplementQueueUsingStacks {
    static class MyQueue {

        public MyQueue() {
            // your solution here
        }

        private final Deque<Integer> input = new ArrayDeque<>();
        private final Deque<Integer> output = new ArrayDeque<>();

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            peek();
            return output.pop();
        }

        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) output.push(input.pop());
            }
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());  // expected: 1
        System.out.println(q.pop());   // expected: 1
        System.out.println(q.empty()); // expected: false
        q.push(3);
        System.out.println(q.pop());   // expected: 2
        System.out.println(q.pop());   // expected: 3
        System.out.println(q.empty()); // expected: true
    }
}
