package redo.arrays;

import java.util.*;

/**
 * LeetCode #347 - Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Return the k most frequent elements of nums, in any order.
 * Follow-up: better than O(n log n).
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.merge(x, 1, Integer::sum);

        List<Integer>[] buckets = new ArrayList[nums.length + 1];   // index = frequency
        for (var e : freq.entrySet()) {
            int f = e.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(e.getKey());
        }

        int[] result = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] == null) continue;
            for (int val : buckets[i]) {
                result[idx++] = val;
                if (idx == k) break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();
        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))); // expected: [1, 2]
        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1}, 1)));                // expected: [1]
    }
}
