package strings;

/**
 * LeetCode #125 - Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 *
 * Return true if s is a palindrome considering only alphanumeric characters
 * and ignoring case; otherwise false.
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left =0 , right = result.length()-1;

        while (left<right){
            if(result.charAt(left) != result.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();

        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(sol.isPalindrome("race a car"));                     // false
        System.out.println(sol.isPalindrome(" "));                              // true
        System.out.println(sol.isPalindrome("0P"));                             // false
    }
}