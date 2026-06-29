package strings;

/**
 * LeetCode #424 - Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Given string s (uppercase A-Z) and int k, you may change at most k characters
 * to any uppercase letter. Return the length of the longest substring containing
 * a single repeating letter achievable after the changes.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        char[] freq = new  char[26];
        int maxfequency = 0,  i = 0, res = 0;
        for (int j= 0; j<s.length(); j++){
            char c = s.charAt(j);
            freq[c - 'A']++;
            maxfequency = Math.max(maxfequency, freq[c - 'A']);
            while (j-i+1- maxfequency > k){
                char left = s.charAt(i);
                freq[left-'A']--;
                i++;
            }

            res = Math.max(res,j - i + 1 );
        }
        // your solution here
        return res;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();

        System.out.println(sol.characterReplacement("ABAB", 2));     // 4
        System.out.println(sol.characterReplacement("AABABBA", 1));  // 4
        System.out.println(sol.characterReplacement("AAAB", 0));     // 3
        System.out.println(sol.characterReplacement("AAAA", 2));     // 4
        System.out.println(sol.characterReplacement("ABCDE", 1));    // 2
    }
}
