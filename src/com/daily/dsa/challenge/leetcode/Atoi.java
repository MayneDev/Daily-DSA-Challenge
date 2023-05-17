package src.com.daily.dsa.challenge.leetcode;

public class Atoi {
    public static void main(String[] args) {
        System.out.println(new Atoi().myAtoi("-2000dfd42"));
    }

    public int myAtoi(String s) {
        s = s.trim();
        boolean isNegative = false;
        int result = 0;
        for (int x = 0; x < s.length(); x++) {
            char c = s.charAt(x);
            if (Character.isDigit(c)) {
                //Check for int overflow
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && c - '0' > 7))
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

                result = result * 10 + (c - '0');
            } else if (x == 0 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
                isNegative = s.charAt(x) == '-';
            }else{
                break;
            }
        }
        return result * (isNegative ? -1 : 1);
    }
}
