package src.com.daily.dsa.challenge.leetcode;

public class CakeIsNotALie {
    public static void main(String[] args) {
        System.out.println(solution("assasa"));
    }

    public static int solution(String x) {

        for (int i = 1; i <= x.length(); i++) {
            String piece = x.substring(0, i);

            int next = i;

            while (next + i <= x.length() && piece.equals(x.substring(next, next + i))) {
                next = next + i;
            }

            if (next >= x.length()) {
                return x.length() / piece.length();
            }
        }

        return 1;
    }
}
