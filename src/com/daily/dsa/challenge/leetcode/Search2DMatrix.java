package src.com.daily.dsa.challenge.leetcode;

public class Search2DMatrix {
    /**
     * You are given an m x n integer matrix matrix with the following two properties:
     * <p>
     * Each row is sorted in non-decreasing order.
     * The first integer of each row is greater than the last integer of the previous row.
     * Given an integer target, return true if target is in matrix or false otherwise.
     * <p>
     * You must write a solution in O(log(m * n)) time complexity.
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            int[] row = matrix[mid];

            if (target >= row[0] && target <= row[row.length - 1]) {
                //We search on this row
                int left = 0;
                int right = matrix[mid].length - 1;
                while (left <= right) {
                    mid = left + (right - left) / 2;
                    if (row[mid] == target) return true;
                    if (target > row[mid]) left = mid + 1;
                    else right = mid - 1;
                }
                return false;
            } else {
                //Adjust top and bottom accordingly
                if (target > matrix[mid][0]) {
                    top = mid + 1;
                } else {
                    bottom = mid - 1;
                }
            }
        }
        return false;
    }
}
