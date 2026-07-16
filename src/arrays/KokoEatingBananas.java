package arrays;

/**
 * LeetCode #875 - Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 *
 * n piles, piles[i] bananas each. Guards return in h hours. Koko picks one fixed
 * speed k (bananas/hour); each hour she eats up to k from a single pile (leftover
 * time in the hour is wasted). Return the minimum integer k to finish within h hours.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        int left = 1;
        int right = maxPile;
        int minSpeed = right;
        while (left<= right){
            int mid = left + (right - left) / 2;
            long totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }
            if (totalHours <= h) {
                minSpeed = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return  minSpeed;
    }

    public static void main(String[] args) {
        KokoEatingBananas sol = new KokoEatingBananas();

        System.out.println(sol.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));          // expected: 4
        System.out.println(sol.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));    // expected: 30 (h == n, must eat the biggest pile in 1 hour)
        System.out.println(sol.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));    // expected: 23
        System.out.println(sol.minEatingSpeed(new int[]{1000000000}, 2));           // expected: 500000000 (ceiling + overflow watch)
        System.out.println(sol.minEatingSpeed(new int[]{312884470}, 968709));       // expected: 323
    }
}
