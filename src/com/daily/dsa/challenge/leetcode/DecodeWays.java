package src.com.daily.dsa.challenge.leetcode;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("2206"));
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int curr = Integer.parseInt(s.substring(i - 1, i));
            int curr2 = Integer.parseInt(s.substring(i - 2, i));

            if (curr >= 1) {
                dp[i] = dp[i - 1];
            }

            if (curr2 >= 10 && curr2 <= 26) {
                dp[i] += dp[i - 2];
            }

        }
        return dp[s.length()];
    }
}
