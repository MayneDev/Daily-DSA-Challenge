package src.com.daily.dsa.challenge.leetcode;

import java.util.*;

public class PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        Set<String> pacificVisit = new HashSet<>();
        Set<String> atlanticVisit = new HashSet<>();
        //Cells feeding pacific
        for (int i = 0; i < cols; i++) {
            getFeedingCells(heights, 0, i, heights[0][i], pacificVisit);
            getFeedingCells(heights, rows - 1, i, heights[rows - 1][i], atlanticVisit);
        }

        for (int i = 0; i < rows; i++) {
            getFeedingCells(heights, i, 0, heights[i][0], pacificVisit);
            getFeedingCells(heights, i, cols - 1, heights[i][cols - 1], atlanticVisit);
        }


        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (pacificVisit.contains(i + "," + j) && atlanticVisit.contains(i + "," + j)) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void getFeedingCells(int[][] heights, int row, int col, int currentHeight, Set<String> visit) {

        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visit.contains(row + "," + col) || heights[row][col] < currentHeight) {
            return;
        }

        int height = heights[row][col];

        visit.add(row + "," + col);

        getFeedingCells(heights, row + 1, col, height, visit);
        getFeedingCells(heights, row - 1, col, height, visit);

        getFeedingCells(heights, row, col - 1, height, visit);
        getFeedingCells(heights, row, col + 1, height, visit);
    }

}
