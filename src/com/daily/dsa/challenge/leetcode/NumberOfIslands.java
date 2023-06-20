package src.com.daily.dsa.challenge.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;
        Set<String> visited = new HashSet<>();

        for(int i = 0; i < grid.length; i++){
            for(int j =0; j< grid[i].length; j++){
                char c = grid[i][j];
                if(c == '1' && !visited.contains(i+","+j)){

                    islands++;
                    //visit neigbours
                    Queue<int[]> nodes = new LinkedList<>();
                    nodes.offer(new int[]{i, j});
                    while (!nodes.isEmpty()){
                        int[] curr = nodes.poll();
                        int row = curr[0];
                        int col = curr[1];

                        if(grid[row][col] == '1' && !visited.contains(row+","+col)){

                            visited.add(row+","+col);
                            if (row + 1 < grid.length){
                                nodes.offer(new int[]{row + 1, col});
                            }
                            if (row - 1 >= 0){
                                nodes.offer(new int[]{row - 1, col});
                            }
                            if (col + 1 < grid[0].length){
                                nodes.offer(new int[]{row, col + 1});
                            }
                            if (col - 1 >= 0){
                                nodes.offer(new int[]{row, col - 1});
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}
