package src.com.daily.dsa.challenge.leetcode;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];

        int[] parents = new int[edges.length + 1];
        for (int[] e : edges) {
            int iParent = findParent(e[0], parents);
            int jParent = findParent(e[1], parents);

            if (iParent != jParent) {
                //Join the edges

                parents[jParent] = iParent;

            } else {
                res = e;
            }
        }
        return res;
    }

    private int findParent(int node, int[] parents) {
        if (parents[node] == node || parents[node] == 0) return node;
        return findParent(parents[node], parents);
    }
}
