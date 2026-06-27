package utils;

// Definition for singly-linked list (used in most LeetCode linked list problems)
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Helper: build a linked list from an array
    public static ListNode of(int... vals) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals) cur = cur.next = new ListNode(v);
        return dummy.next;
    }

    // Helper: print the linked list
    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        return sb.append("]").toString();
    }
}
