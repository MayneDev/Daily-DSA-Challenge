package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        //
        //secret = "1807",
        //guess  = "7810"
        //
        int bulls = 0, cows = 0;
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> gFreq = new HashMap<>();

        for (char c : secret.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : guess.toCharArray()) {
            gFreq.put(c, gFreq.getOrDefault(c, 0) + 1);
        }

        int idx = 0;
        while (idx < guess.length()) {
            char c = guess.charAt(idx);

            //Check if bull
            if (c == secret.charAt(idx)) {
                bulls++;
                freq.put(c, freq.getOrDefault(c, 1) - 1);
                gFreq.put(c, gFreq.getOrDefault(c, 1) - 1);
            }
            idx++;
        }


        idx = 0;
        while (idx < guess.length()) {
            char c = guess.charAt(idx);
            //Check cows
            if (gFreq.containsKey(c) && gFreq.get(c) > 0 && freq.containsKey(c) && freq.get(c) > 0) {
                cows++;
                freq.put(c, freq.getOrDefault(c, 1) - 1);
                gFreq.put(c, gFreq.getOrDefault(c, 1) - 1);
            }
            idx++;
        }


        return bulls + "A" + cows + "B";
    }
}
