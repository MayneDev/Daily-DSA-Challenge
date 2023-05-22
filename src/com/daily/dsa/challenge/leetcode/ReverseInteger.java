package src.com.daily.dsa.challenge.leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-1463847412));
    }

    public static int reverse(int x) {
        int res = 0;

        while (x != 0) {

            //Check for int overflow
            if ((res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && x % 10 > 7))) {
                return 0;
            }
            if ((res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && x % 10 < -8))) {
                return 0;
            }

            res = (res * 10) + x % 10;
            x = x / 10;
        }
        return res;
    }
}
