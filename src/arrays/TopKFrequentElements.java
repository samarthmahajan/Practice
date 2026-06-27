package arrays;

import java.util.*;

/**
 * LeetCode #347 - Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Return the k most frequent elements of nums, in any order. Follow-up: beat O(n log n).
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        // your solution here
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int num : freq.keySet()) {
            int f = freq.get(num);

            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }

            buckets[f].add(num);
        }

        int[] result = new int[k];
        int idx = 0;

        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[idx++] = num;
                    if (idx == k) {
                        break;
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();
        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        // expected (any order): [1, 2]
        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1}, 1)));
        // expected: [1]
        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{4, 4, 4, 5, 5, 6, 7}, 2)));
        // expected (any order): [4, 5]
    }
}
