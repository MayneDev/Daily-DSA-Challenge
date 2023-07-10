package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    Map<String, Integer> memo = new HashMap<>();

    public int longestCommonSubsequence(String X, String Y) {
        return LCS(X, Y, 0, 0);
    }

    public int LCS(String text1, String text2, int i, int j) {
        int m = text1.length();
        int n = text2.length();
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (i == m || j == n) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            int lcs = 1 + LCS(text1, text2, i + 1, j + 1);
            memo.put(key, lcs);
            return lcs;
        }

        int lcs = Math.max(LCS(text1, text2, i + 1, j), LCS(text1, text2, i, j + 1));
        memo.put(key, lcs);
        return lcs;
    }
}
