package src.com.daily.dsa.challenge.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOriginalArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[]{};
        int[] res = new int[changed.length / 2];

        Arrays.sort(changed);

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : changed) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        int idx = 0;
        for (int i : changed) {
            if (freq.containsKey(i) && freq.get(i) > 0) {

                if (!freq.containsKey(i * 2) || freq.get(i * 2) == 0) {
                    return new int[]{};
                }

                freq.put(i, freq.get(i) - 1);
                freq.put(i * 2, freq.get(i * 2) - 1);
                res[idx] = i;
                idx++;
            }
        }

        return res;
    }
}
