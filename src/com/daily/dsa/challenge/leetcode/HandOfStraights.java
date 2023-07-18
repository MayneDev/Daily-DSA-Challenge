package src.com.daily.dsa.challenge.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize,
 * and consists of groupSize consecutive cards.
 * <p>
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
 * return true if she can rearrange the cards, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * Example 2:
 * <p>
 * Input: hand = [1,2,3,4,5], groupSize = 4
 * Output: false
 * Explanation: Alice's hand can not be rearranged into groups of 4.
 */
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : hand) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        Arrays.sort(hand); //nlogn

        for (int x : hand) { //O(n)
            if (freq.containsKey(x)) {
                int n = 0;
                while (n < groupSize) { //O(1)
                    if (!freq.containsKey(x + n)) break;
                    n++;
                }

                if (n == groupSize) {
                    while (n > 0) {
                        freq.put(x + n - 1, freq.get(x + n - 1) - 1);
                        if (freq.get(x + n - 1) == 0) {
                            freq.remove(x + n - 1);
                        }
                        n--;
                    }
                }
            }
        }
        return freq.isEmpty();
    }
}
