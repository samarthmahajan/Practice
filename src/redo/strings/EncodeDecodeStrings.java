package redo.strings;

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

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs)
            sb.append(s.length()).append('#').append(s);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int len = Integer.parseInt(str.substring(i, j));
            String payload = str.substring(j + 1, j + 1 + len);
            res.add(payload);
            i = j + 1 + len;
        }
        return res;
    }
    public static void main(String[] args) {
        EncodeDecodeStrings codec = new EncodeDecodeStrings();

        List<String> t1 = Arrays.asList("neet", "code", "love", "you");
        System.out.println(codec.decode(codec.encode(t1))); // [neet, code, love, you]

        List<String> t2 = Arrays.asList("we", "say", ":", "yes");
        System.out.println(codec.decode(codec.encode(t2))); // [we, say, :, yes]

        List<String> t3 = Arrays.asList("4#neet", "12", "");
        System.out.println(codec.decode(codec.encode(t3))); // [4#neet, 12, ]

        List<String> t4 = Arrays.asList("");
        System.out.println(codec.decode(codec.encode(t4))); // []  ← single empty string, expect [ ] with one element

        List<String> t5 = new ArrayList<>();
        System.out.println(codec.decode(codec.encode(t5))); // []
    }
}
