package src.com.daily.dsa.challenge.leetcode;

import java.util.*;

public class CountDistinctIntegers {

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> result = new HashSet<>();
        for (int x : nums) {
            result.add(x);
            result.add(reverseInt(x));
        }
        return result.size();
    }

    private int reverseInt(int x) {
        int rx = 0;
        while (x > 0) {
            rx =  (rx * 10) + (x % 10);
            x = x / 10;
        }
        return rx;
    }
}
