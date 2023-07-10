package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int res = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int L = 0;

        for (int R = 0; R < s.length(); R++) {
            freq.put(s.charAt(R), freq.getOrDefault(s.charAt(R), 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(R)));
            while ((R - L + 1) - maxFreq > k) {
                freq.put(s.charAt(L), freq.get(s.charAt(L)) - 1);
                L += 1;
            }
            res = Math.max(res, R - L + 1);
        }

        return res;
    }


    public int characterReplacementBF(String s, int k) {
        int longest = 0;

        for (int x = 0; x < s.length(); x++) {
            int tmp = k;
            int L = x;
            int R = x;

            while (L >= 0 && (tmp > 0 || s.charAt(L) == s.charAt(x))) {
                if (s.charAt(L) != s.charAt(x)) {
                    tmp--;
                }
                L--;
            }


            while (R < s.length() && (tmp > 0 || s.charAt(R) == s.charAt(x))) {
                if (s.charAt(R) != s.charAt(x)) {
                    tmp--;
                }
                R++;
            }

            longest = Math.max(longest, (R - 1 - L));
        }

        return longest;
    }
}
