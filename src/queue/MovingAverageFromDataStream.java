package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode #346 - Moving Average from Data Stream
 * https://leetcode.com/problems/moving-average-from-data-stream/
 *
 * Given a stream of integers and a window size, calculate the moving
 * average of all integers in the sliding window.
 *
 * Time:  O(1) per next() call
 * Space: O(k) where k is the window size
 */
public class MovingAverageFromDataStream {

    private final int size;
    private final Queue<Integer> window;
    private double sum;

    public MovingAverageFromDataStream(int size) {
        this.size = size;
        this.window = new LinkedList<>();
        this.sum = 0;
    }

    public double next(int val) {
        if (window.size() == size) {
            sum -= window.poll();
        }
        window.offer(val);
        sum += val;
        return sum / window.size();
    }

    // --- Test ---
    public static void main(String[] args) {
        MovingAverageFromDataStream m = new MovingAverageFromDataStream(3);
        System.out.println(m.next(1));   // 1.0
        System.out.println(m.next(10));  // 5.5
        System.out.println(m.next(3));   // 4.666...
        System.out.println(m.next(5));   // 6.0
    }
}
