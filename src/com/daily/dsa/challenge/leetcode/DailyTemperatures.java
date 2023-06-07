package src.com.daily.dsa.challenge.leetcode;

import java.util.Stack;

public class DailyTemperatures {
    /**
     * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int x = 0; x < temperatures.length; x++) {
            if (stack.isEmpty() || stack.peek()[0] >= temperatures[x]) {
                stack.push(new int[]{temperatures[x], x});
            } else {
                while (!stack.isEmpty() && temperatures[x] > stack.peek()[0]) {
                    int[] prev = stack.pop();
                    result[prev[1]] = x - prev[1];
                }
                stack.push(new int[]{temperatures[x], x});
            }
        }
        return result;
    }
}
