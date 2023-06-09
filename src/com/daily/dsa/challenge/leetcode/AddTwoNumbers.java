package src.com.daily.dsa.challenge.leetcode;


public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode output = new ListNode();
        ListNode sum = output;

        while (l1 != null && l2 != null) {
            int tempSum = carry + l2.val + l1.val;
            carry = tempSum > 9 ? 1 : 0;
            output.next = new ListNode(tempSum > 9 ? tempSum % 10 : tempSum);
            output = output.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int tempSum = carry + l1.val;
            carry = tempSum > 9 ? 1 : 0;
            output.next = new ListNode(tempSum > 9 ? tempSum % 10 : tempSum);
            output = output.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int tempSum = carry + l2.val;
            carry = tempSum > 9 ? 1 : 0;
            output.next = new ListNode(tempSum > 9 ? tempSum % 10 : tempSum);
            output = output.next;
            l2 = l2.next;
        }

        if (carry != 0)
            output.next = new ListNode(1);

        return sum.next;
    }

}
