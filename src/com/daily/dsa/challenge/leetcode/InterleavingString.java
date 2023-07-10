package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

    Map<String, Boolean> memo = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(s1, s2, s3, 0, 0);
    }


    private boolean isInterleave(String s1, String s2, String s3, int pointer1, int pointer2) {
        String key = pointer1 + "," + pointer2;

        if (pointer1 + pointer2 >= s3.length()) {
            memo.put(key, true);
            return true;
        }

        if (memo.containsKey(key)) return memo.get(key);

        char s3C = s3.charAt(pointer1 + pointer2);

        if (pointer1 < s1.length() && s1.charAt(pointer1) == s3C && isInterleave(s1, s2, s3, pointer1 + 1, pointer2)) {
            memo.put(key, true);
            return true;
        } else if (pointer2 < s2.length() && s2.charAt(pointer2) == s3C && isInterleave(s1, s2, s3, pointer1, pointer2 + 1)) {

            memo.put(key, true);
            return true;
        }
        memo.put(key, false);
        return false;
    }

}
