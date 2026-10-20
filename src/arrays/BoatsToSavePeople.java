package arrays;

import java.util.Arrays;

/**
 * LeetCode #881 - Boats to Save People
 * https://leetcode.com/problems/boats-to-save-people/
 *
 * Each boat carries at most 2 people with total weight <= limit.
 * Return the minimum number of boats needed to carry everyone.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int noOfBoats = 1,  left =0, right = people.length-1;

        if (people[right]>limit)
            return 0;

        while ( left<right){
            if (people[left] + people[right]> limit ){
                noOfBoats ++;
                right--;
            }
            if (people[left] + people[right] <= limit){
                left++;
            }
        }




        return noOfBoats;
    }

    public static void main(String[] args) {
        BoatsToSavePeople sol = new BoatsToSavePeople();
        System.out.println(sol.numRescueBoats(new int[]{1, 2}, 3));        // 1
        System.out.println(sol.numRescueBoats(new int[]{3, 2, 2, 1}, 3));  // 3
        System.out.println(sol.numRescueBoats(new int[]{3, 5, 3, 4}, 5));  // 4
    }
}
