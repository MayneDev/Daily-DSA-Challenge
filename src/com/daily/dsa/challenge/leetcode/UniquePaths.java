package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    Map<String, Integer> memo = new HashMap<>();

    public int uniquePaths(int m, int n) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        int res;
        if (m == 1 || n == 1) {
            res = 1;
        } else {
            res = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }
        memo.put(key, res);
        return res;
    }

    private int dp(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m || j == n) {
                    dp[i][j] = 0;
                } else if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
