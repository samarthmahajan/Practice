package sprint;

/**
 * SPRINT WRITE 2026-07-06 — Remove K Digits (LeetCode #402)
 * Cold boilerplate rep for SRS Sprint Day+3. No card, no cheatsheet.
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        StringBuilder sb = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (k > 0 && sb.length() > 0
                    && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }

        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String res = sb.substring(i);

        return res.length() == 0 ? "0" : res;
    }

    // --- Test ---
    public static void main(String[] args) {
        RemoveKDigits sol = new RemoveKDigits();

        System.out.println(sol.removeKdigits("1432219", 3)); // Expected: 1219
        System.out.println(sol.removeKdigits("10200", 1));   // Expected: 200
        System.out.println(sol.removeKdigits("10", 2));      // Expected: 0
        System.out.println(sol.removeKdigits("1121", 1));    // Expected: 111
        System.out.println(sol.removeKdigits("1519", 1));    // Expected: 119
        System.out.println(sol.removeKdigits("112", 1));     // Expected: 11
        System.out.println(sol.removeKdigits("100", 1));     // Expected: 0
    }
}
