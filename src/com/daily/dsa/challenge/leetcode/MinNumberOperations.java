package src.com.daily.dsa.challenge.leetcode;

public class MinNumberOperations {
    public static void main(String[] args) {
        System.out.println(new MinNumberOperations().minNumberOperations(new int[]{1, 2, 3, 2, 1, 4}));
    }

    public int minNumberOperations(int[] target) {
        int ans = target[0];
        int idx = 1;
        while (idx < target.length) {
            int diff = target[idx] - target[idx - 1];
            if (diff > 0) {
                ans += diff;
            }
            idx++;
        }
        return ans;
    }
}
