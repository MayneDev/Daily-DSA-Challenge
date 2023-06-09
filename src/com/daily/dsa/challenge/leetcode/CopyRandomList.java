package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public Node copyRandomList(Node head) {

        //Iterate thru the list copying curr nodes and their next
        //Assign random to null on first iteration
        //tweak old node and point next no copied node

        //Perform a second iteration of original node and assign randonm node of next to next of its random
        if (head == null) return null;
        Node curr = head;
        Map<Node, Node> oldNewMap = new HashMap<>();

        while (curr != null) {
            //Create a copy of curr
            Node copy = new Node(curr.val);
            oldNewMap.put(curr, copy);

            curr = curr.next;
        }

        //reassign random of copy
        curr = head;
        while (curr != null) {
            //Check if random was pointing to null
            Node copy = oldNewMap.get(curr);
            copy.next = oldNewMap.get(curr.next);
            copy.random = curr.random == null ? null : oldNewMap.get(curr.random);

            curr = curr.next;
        }

        return oldNewMap.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
