package src.com.daily.dsa.challenge.leetcode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int steps1 = 1;
        int steps2 = 2;
        int x = 3;

        while (x <= n) {
            int temp = steps2;
            steps2 = steps1 + steps2;
            steps1 = temp;
            x++;
        }
        return steps2;
    }

    public int climbStairsBottomUp(int n) {
        n = n - 1;
        int steps1 = 1;
        int steps2 = 1;

        while (n > 0) {
            int temp = steps1;
            steps1 = steps1 + steps2;
            steps2 = temp;
            n--;
        }
        return steps1;
    }
}
