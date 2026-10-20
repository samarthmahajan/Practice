package redo.arrays;

import java.util.Arrays;

/**
 * LeetCode #875 - Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 *
 * Koko eats k bananas/hour from one pile per hour (a smaller pile still costs the whole hour).
 * Return the minimum integer k that lets her finish all piles within h hours.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        // your solution here
        int max = Arrays.stream(piles).parallel().max().getAsInt();

        int left = 0, right = max , ans = max;
        while (left<= right){
            int mid = left + (right - left) / 2;
            long totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }

            if (totalHours <= h){
                ans = mid;
                right = mid - 1;
            }else
                left = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        KokoEatingBananas sol = new KokoEatingBananas();
        System.out.println(sol.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));        // 4
        System.out.println(sol.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));  // 30
        System.out.println(sol.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));  // 23
    }
}
