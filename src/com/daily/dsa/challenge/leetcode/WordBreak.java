package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        List<Integer> ends = new ArrayList<>();
        ends.add(s.length());

        for (int i = s.length(); i >= 0; i--) {
            for (int end : ends) {
                if (wordDict.contains(s.substring(i, end))) {
                    dp[i] = true;
                    ends.add(i);
                    break;
                }
            }
        }
        return dp[0];
    }
}
