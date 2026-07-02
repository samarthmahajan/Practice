package arrays;

import java.util.*;

/**
 * Sliding Window Maximum — terminal visualizer (learning aid, not a LeetCode solution).
 *
 * Mental model: stand at the RIGHT edge of the window and look LEFT.
 * You can "see" an element only if nothing taller stands between it and you.
 * The visible elements form a DESCENDING staircase (front = tallest = window max).
 * That staircase IS the deque.
 *
 * Run from IntelliJ (green ▶ on main) or:  java src/arrays/SWMViz.java
 * Tweak the nums / k on the first line of main() to try your own arrays.
 */
public class SWMViz {
    public static void main(String[] args) {
        run(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    static void run(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();   // holds INDICES, values decreasing front->back
        List<Integer> out = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // (1) expire the front if it slid out of the window
            Integer expired = null;
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                expired = nums[dq.peekFirst()];
                dq.pollFirst();
            }
            // (2) the newcomer hides every shorter-or-equal element to its left
            List<Integer> hidden = new ArrayList<>();
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                hidden.add(nums[dq.peekLast()]);
                dq.pollLast();
            }
            // (3) newcomer joins at the back
            dq.offerLast(i);

            // ---- draw the frame ----
            System.out.println("============ i=" + i + "  enter value " + nums[i] + " ============");
            System.out.println(renderArray(nums, i, k));
            if (expired != null)
                System.out.println("  (1) window's left edge passed the front -> EXPIRE max " + expired);
            if (!hidden.isEmpty())
                System.out.println("  (2) " + nums[i] + " is taller, hides to its left -> DROP " + hidden);
            if (expired == null && hidden.isEmpty())
                System.out.println("  (1,2) nothing expired, nothing hidden");
            System.out.println("  staircase (you see, left=tallest): " + renderDeque(dq, nums));
            if (i >= k - 1) {
                int mx = nums[dq.peekFirst()];
                out.add(mx);
                System.out.println("  >> WINDOW MAX = " + mx);
            } else {
                System.out.println("  .. first window still filling ..");
            }
            System.out.println("  answer so far: " + out);
            System.out.println();
        }
        System.out.println("FINAL ANSWER: " + out);
    }

    static String renderArray(int[] nums, int i, int k) {
        int lo = Math.max(0, i - k + 1);
        StringBuilder v = new StringBuilder("  nums:");
        StringBuilder u = new StringBuilder("       ");
        for (int j = 0; j < nums.length; j++) {
            v.append(String.format("%5d", nums[j]));
            u.append(j >= lo && j <= i ? "  ===" : "     ");
        }
        u.append("   <- window you look across");
        return v + "\n" + u;
    }

    static String renderDeque(Deque<Integer> dq, int[] nums) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int idx : dq) {            // ArrayDeque iterates front -> back
            if (!first) sb.append("  >  ");
            sb.append(nums[idx]);
            first = false;
        }
        return "[ " + sb + " ]";
    }
}
