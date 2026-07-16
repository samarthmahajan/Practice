package redo.arrays;

import java.util.Arrays;

/**
 * LeetCode #875 - Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 *
 * Koko eats up to k bananas/hour from one pile per hour; guards return in h hours.
 * Return the minimum integer speed k that finishes all piles within h hours.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
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
        KokoEatingBananas s = new KokoEatingBananas();
        System.out.println(s.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));        // expected 4
        System.out.println(s.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));  // expected 30
        System.out.println(s.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));  // expected 23
        System.out.println(s.minEatingSpeed(new int[]{312884470}, 312884469));  // expected 2
    }
}
