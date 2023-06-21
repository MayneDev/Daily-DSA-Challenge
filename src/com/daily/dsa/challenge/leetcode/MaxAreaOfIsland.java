package src.com.daily.dsa.challenge.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        Set<String> visited = new HashSet<>();


        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == 1 && !visited.contains(r + "," + c)) {
                    Queue<int[]> nodes = new LinkedList<>();
                    nodes.offer(new int[]{r, c});
                    int area = 0;

                    while (!nodes.isEmpty()) {
                        int[] curr = nodes.poll();
                        int row = curr[0];
                        int col = curr[1];

                        if (grid[row][col] == 1 && !visited.contains(row + "," + col)) {
                            area++;
                            visited.add(row + "," + col);

                            if (row + 1 < grid.length) {
                                nodes.offer(new int[]{row + 1, col});
                            }

                            if (row - 1 >= 0) {
                                nodes.offer(new int[]{row - 1, col});
                            }
                            if (col + 1 < grid[0].length) {
                                nodes.offer(new int[]{row, col + 1});
                            }

                            if (col - 1 >= 0) {
                                nodes.offer(new int[]{row, col - 1});
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }

            }
        }
        return maxArea;

    }

}
