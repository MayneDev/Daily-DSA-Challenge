package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingPathInaMatrix {

    /*
    Input: matrix = [
                [9,9,4],
                [6,6,8],
                [2,1,1]
            ]

        Output: 4
        Explanation: The longest increasing path is [1, 2, 6, 9].
     */

    public int longestIncreasingPath(int[][] matrix) {
        int path = 0;
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                path = Math.max(path, dfs(matrix, i, j, Integer.MIN_VALUE, memo));
            }
        }
        return path;
    }

    private int dfs(int[][] matrix, int i, int j, int target, Map<String, Integer> memo) {
        String key = i + "," + j;
        if (i < 0 || j < 0 || i == matrix.length || j == matrix[0].length || matrix[i][j] <= target) {
            return 0;
        }
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = 1 +
                Math.max(
                        Math.max(dfs(matrix, i + 1, j, matrix[i][j], memo), dfs(matrix, i - 1, j, matrix[i][j], memo)),
                        Math.max(dfs(matrix, i, j + 1, matrix[i][j], memo), dfs(matrix, i, j - 1, matrix[i][j], memo))
                );
        memo.put(key, res);
        return res;
    }
}
