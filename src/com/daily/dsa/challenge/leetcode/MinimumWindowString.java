package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowString {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        String subString = "";
        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> available = new HashMap<>();

        int found = 0;

        for (char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
            available.put(c, 0);
        }

        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (required.containsKey(c)) {

                available.put(c, available.getOrDefault(c, 0) + 1);

                if (available.get(c) == required.get(c)) {
                    found++;
                }

                while (found == required.size()) {

                    String tempString = s.substring(l, r + 1);
                    if (subString.length() == 0 || tempString.length() < subString.length()) {
                        subString = tempString;
                    }

                    c = s.charAt(l);
                    if (required.containsKey(c)) {
                        available.put(c, available.get(c) - 1);
                        if (available.get(c) < required.get(c)) {
                            found--;
                        }
                    }
                    l++;
                }

            }
            r++;
        }


        return subString;
    }
}
