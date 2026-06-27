package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #49 - Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings, group the anagrams together (same letters, any order). Return groups in any order.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = new char[26];
            for (char ch : str.toCharArray())
                chars[ch - 'a']++;

            String keyStr = String.valueOf(chars);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(str);
        }
        return  new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        System.out.println(sol.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        // expected (any order): [[eat, tea, ate], [tan, nat], [bat]]
        System.out.println(sol.groupAnagrams(new String[]{""}));
        // expected: [[]]   (single empty string forms its own group)
        System.out.println(sol.groupAnagrams(new String[]{"a"}));
        // expected: [[a]]
    }
}
