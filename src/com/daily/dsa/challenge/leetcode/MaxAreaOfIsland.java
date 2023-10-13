package src.com.daily.dsa.challenge.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland1(int[][] grid) {

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

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        Queue<int[]> nodes = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited.contains(i + "," + j)) {
                    visited.add(i + "," + j);
                    nodes.offer(new int[]{i, j});
                    int area = 0;

                    while (!nodes.isEmpty()) {
                        int[] curr = nodes.poll();
                        area++;
                        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

                        for (int[] dir : dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[2];

                            if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0 || visited.contains(r+","+c)) {
                                continue;
                            }

                            visited.add(r+","+c);
                            nodes.offer(new int[]{r, c});
                        }
                    }

                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }


    // [ 3 4 ]
    // / 5 6]
}
