package src.com.daily.dsa.challenge.leetcode;

import java.util.*;


public class SwimInWater {

    /**
     * You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
     * <p>
     * The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
     * <p>
     * Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
    }

    static class Grid {
        public int height;
        public int row;
        public int col;

        Grid(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }

    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Grid> minHeap = new PriorityQueue<>(Comparator.comparing(val -> val.height));
        minHeap.offer(new Grid(grid[0][0], 0, 0));
        Set<String> visited = new HashSet<>();

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!minHeap.isEmpty()) {
            Grid curr = minHeap.poll();

            if (curr.row == n - 1 && curr.col == n - 1) {
                return curr.height;
            }
            for (int[] dir : dirs) {
                int neigR = curr.row + dir[0];
                int neigC = curr.col + dir[1];
                if (neigR < 0 || neigR == n || neigC < 0 || neigC == n || visited.contains(neigR + "," + neigC)) {
                    continue;
                }
                visited.add(neigR + "," + neigC);
                minHeap.offer(new Grid(Math.max(curr.height, grid[neigR][neigC]), neigR, neigC));
            }
        }

        return 0;
    }

}
