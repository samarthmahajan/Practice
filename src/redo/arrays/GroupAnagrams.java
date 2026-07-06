package redo.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #49 - Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *
 * Group the anagrams together; return the groups in any order.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] counts = new char[26];
            for (char ch : str.toCharArray())
                counts[ch - 'a']++;
            String key = String.valueOf(counts);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        System.out.println(sol.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        // expected: [[bat], [nat, tan], [ate, eat, tea]] (any order)
        System.out.println(sol.groupAnagrams(new String[]{""}));  // expected: [[]] -> one group holding ""
        System.out.println(sol.groupAnagrams(new String[]{"a"})); // expected: [[a]]
    }
}
