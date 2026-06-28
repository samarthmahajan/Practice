package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #271 - Encode and Decode Strings
 * https://leetcode.com/problems/encode-and-decode-strings/
 *
 * Encode a list of strings into a single string for transmission, then decode
 * that single string back into the exact original list. Strings may contain
 * any characters (digits, spaces, '#', commas, empty string).
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class EncodeDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String input : strs){
            stringBuilder.append(input.length()+ "#");
            stringBuilder.append(input);
        }

        return stringBuilder.toString();
    }

    // Decodes a single string back to a list of strings.
    public List<String> decode(String str) {
        int digit =0;
        List<String> res = new ArrayList<>();
        for(int i= 0 ;i<= str.length()-1;i++ ){
            if(Character.isDigit(str.charAt(i))){
                digit = digit*10 +Integer.parseInt(String.valueOf(str.charAt(i)));

            }else if(str.charAt(i) == '#'){
                res.add(str.substring(i+1, i+digit+1));
                i+=digit;
                digit=0;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        EncodeDecodeStrings sol = new EncodeDecodeStrings();

        List<String> t1 = Arrays.asList("neet", "code", "love", "you");
        System.out.println(sol.decode(sol.encode(t1))); // [neet, code, love, you]

        List<String> t2 = Arrays.asList("4#neet", "12", "");
        System.out.println(sol.decode(sol.encode(t2))); // [4#neet, 12, ]

        List<String> t3 = Arrays.asList("", "");
        System.out.println(sol.decode(sol.encode(t3))); // [, ]

        List<String> t4 = Arrays.asList();
        System.out.println(sol.decode(sol.encode(t4))); // []
    }
}
