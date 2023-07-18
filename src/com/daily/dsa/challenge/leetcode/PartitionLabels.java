package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 * <p>
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * <p>
 * Return a list of integers representing the size of these parts.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 * <p>
 * Input: s = "eccbbbbdec"
 * Output: [10]
 */

public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println(-121/10);
    }
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int x = 0; x < s.length(); x++) {
            lastIndex[s.charAt(x) - 'a'] = x;
        }

        int lastPartition = 0;
        int border = 0;
        for (int x = 0; x < s.length(); x++) {
            border = Math.max(border, lastIndex[s.charAt(x) - 'a']);
            if (border == x) {
                result.add((x + 1) - lastPartition);
                lastPartition = x+1;
            }
        }

        return result;
    }
}
