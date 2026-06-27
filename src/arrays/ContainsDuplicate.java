package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #217 - Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Return true if any value appears at least twice in nums, false if every element is distinct.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        for (int num: nums){
            if(Boolean.FALSE.equals(integers.add(num))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate sol = new ContainsDuplicate();
        System.out.println(sol.containsDuplicate(new int[]{1, 2, 3, 1}));       // true
        System.out.println(sol.containsDuplicate(new int[]{1, 2, 3, 4}));       // false
        System.out.println(sol.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4})); // true
    }
}
