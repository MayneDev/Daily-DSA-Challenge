package src.com.daily.dsa.challenge.leetcode;

public class PleasePassMeTheCodedMessage {
    public static int[] solution(int[] l, int t) {
        // Your code here
        int start = 0;
        int sum = 0;
        int x = 0;
        while (x <= l.length) {
            if (sum > t) {
                while (sum > t) {
                    sum -= l[start];
                    start++;
                }
            }

            if (sum == t) {
                return new int[]{start, x - 1};
            }

            if (x < l.length){
                sum += l[x];
            }
            x++;
        }

        return new int[]{-1, -1};
    }
}
