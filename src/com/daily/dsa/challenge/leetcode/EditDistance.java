package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {
    Map<String, Integer> memo;

    public int minDistance(String word1, String word2) {
        memo = new HashMap<>();
        return match(word1, word2, 0, 0);
    }

    private int match(String word1, String word2, int l1, int l2) {
        String key = l1 + ":" + l2;

        if (l1 == word1.length() && l2 == word2.length()) {
            return 0;
        } else if (l1 == word1.length() || l2 == word2.length()) {
            return Math.max(word1.length() - l1, word2.length() - l2);
        }

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (word1.charAt(l1) == word2.charAt(l2)) {
            return match(word1, word2, l1 + 1, l2 + 1);
        }

        memo.put(key, 1 + Math.min(match(word1, word2, l1 + 1, l2 + 1), Math.min(match(word1, word2, l1, l2 + 1), match(word1, word2, l1 + 1, l2))));
        return memo.get(key);
    }
}
