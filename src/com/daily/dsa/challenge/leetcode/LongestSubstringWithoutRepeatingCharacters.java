package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Optimal
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        int start = 0;
        for (int x = 0; x < s.length(); x++) {
            char c = s.charAt(x);
            if (lastOccurrence.containsKey(c) && lastOccurrence.get(c) >= start) {
                start = lastOccurrence.get(c) + 1;
            } else {
                maxLength = Math.max(maxLength, x - start + 1);
            }
            lastOccurrence.put(c, x);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            int tempMaxLen = 0;
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) {
                    break;
                } else {
                    charSet.add(s.charAt(j));
                    tempMaxLen++;
                }
                maxLength = Math.max(maxLength, tempMaxLen);
            }
        }
        return maxLength;
    }

}
