package redo.stack;

/**
 * LeetCode #402 - Remove K Digits (REDO COLD - 2026-07-02)
 * https://leetcode.com/problems/remove-k-digits/
 *
 * Given a string num representing a non-negative integer and an integer k,
 * remove exactly k digits so the remaining number is the smallest possible.
 * Return it as a string - no leading zeros; if nothing remains, return "0".
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        // your solution here

        if(k == num.length())
            return  "0";
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : num.toCharArray()){
            while (k>0 && stringBuilder.length()>0 && stringBuilder.charAt(stringBuilder.length()-1)>c){
                stringBuilder.deleteCharAt(stringBuilder.length() -1);
                k--;
            }
            stringBuilder.append(c);
        }
        while (k>0){
            stringBuilder.deleteCharAt(stringBuilder.length() -1);
            k--;
        }

        int start =0;

        while (start <stringBuilder.length() && stringBuilder.charAt(start) == '0'){
            start++;
        }
        String res = stringBuilder.substring(start);
        return res.isEmpty()? "0": res;
    }

    public static void main(String[] args) {
        RemoveKDigits sol = new RemoveKDigits();
        System.out.println(sol.removeKdigits("1432219", 3)); // expected: 1219
        System.out.println(sol.removeKdigits("10200", 1));   // expected: 200
        System.out.println(sol.removeKdigits("10", 2));      // expected: 0
    }
}
