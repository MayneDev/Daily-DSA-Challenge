package src.com.daily.dsa.challenge.leetcode;

public class ReverseLinkedList {

    /**
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     * <p>
     * Example 1:
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     */

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


}
