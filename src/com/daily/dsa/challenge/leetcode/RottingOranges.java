package src.com.daily.dsa.challenge.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RottingOranges {
    class Solution {
        public int orangesRotting(int[][] grid) {

            //Have a queue to help do BFS
            //for every iteration = 1 minute untill the queue is empty
            //return mins or -1 if there are fresh oranges -> We can store all fresh oranges in a set

            Set<String> freshOranges = new HashSet<>();
            int mins = 0;

            Queue<int[]> rottenOranges = new LinkedList<>();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        freshOranges.add(i + "," + j);
                    } else if (grid[i][j] == 2) {
                        rottenOranges.offer(new int[]{i, j});
                    }
                }
            }

            while (!rottenOranges.isEmpty() && !freshOranges.isEmpty()) {
                int size = rottenOranges.size();

                while (size > 0) {
                    int[] curr = rottenOranges.remove();
                    int row = curr[0];
                    int col = curr[1];

                    rot(row + 1, col, freshOranges, rottenOranges);
                    rot(row - 1, col, freshOranges, rottenOranges);
                    rot(row, col + 1, freshOranges, rottenOranges);
                    rot(row, col - 1, freshOranges, rottenOranges);
                    size--;
                }
                mins++;
            }

            return freshOranges.isEmpty() ? mins : -1;

        }

        private void rot(int row, int col, Set<String> freshOranges, Queue<int[]> rottenOranges) {
            if (!freshOranges.contains(row + "," + col)) {
                return;
            }
            rottenOranges.offer(new int[]{row, col});
            freshOranges.remove(row + "," + col);
        }
    }
}
