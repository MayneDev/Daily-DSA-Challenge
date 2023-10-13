package src.com.daily.dsa.challenge.leetcode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int x = 0;
        while (x < k && fast != null) {
            fast = fast.next;
            x++;
        }
        return head;
    }

    private ListNode reverse(ListNode slow, ListNode fast) {
        ListNode tempHead = slow;
        ListNode prev = null;
        ListNode next = slow.next;

        while (next != null && slow != fast) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
        }
        return slow;
    }
}
