package src.com.daily.dsa.challenge.leetcode;

import java.util.*;


public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> nodesCopyMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node copy = new Node(node.val);
        nodesCopyMap.put(node, copy);

        List<Node> neighborCopies = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            if (nodesCopyMap.containsKey(neighbor)) {
                neighborCopies.add(nodesCopyMap.get(neighbor));
            } else {
                neighborCopies.add(cloneGraph(neighbor));
            }
        }

        copy.neighbors = neighborCopies;
        return copy;
    }

}
