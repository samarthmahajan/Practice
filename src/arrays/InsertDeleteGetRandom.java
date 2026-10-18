package arrays;

import java.util.*;

/**
 * LeetCode #380 - Insert Delete GetRandom O(1)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 *
 * Design a set supporting insert, remove, and getRandom (each element equally likely),
 * all in average O(1) time.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class InsertDeleteGetRandom {

    static class RandomizedSet {

        private final List<Integer> list;
        private final Map<Integer, Integer> map;
        private final Random random;

        public RandomizedSet() {
            // your solution here
            list = new ArrayList<>();
            map= new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            // your solution here
            if (map.containsKey(val)) return false;

            map.put(val, list.size());
            list.add(val);
            return true;




        }

        public boolean remove(int val) {
            // your solution here
            if (!map.containsKey(val)) return false;

            int index = map.get(val);
            int last = list.get(list.size() - 1);

            list.set(index, last);
            map.put(last, index);

            list.remove(list.size() - 1);
            map.remove(val);

            return  true;


        }

        public int getRandom() {
            // your solution here
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1));   // true
        System.out.println(rs.remove(2));   // false
        System.out.println(rs.insert(2));   // true
        System.out.println(rs.getRandom()); // 1 or 2
        System.out.println(rs.remove(1));   // true
        System.out.println(rs.insert(2));   // false
        System.out.println(rs.getRandom()); // 2

        // Uniformity sanity check: {10, 20, 30} -> each ~33,333 of 100,000
        RandomizedSet u = new RandomizedSet();
        u.insert(10); u.insert(20); u.insert(30);
        int c10 = 0, c20 = 0, c30 = 0;
        for (int i = 0; i < 100_000; i++) {
            int r = u.getRandom();
            if (r == 10) c10++; else if (r == 20) c20++; else if (r == 30) c30++;
        }
        System.out.println(c10 + " " + c20 + " " + c30); // each ≈ 33333
    }
}
