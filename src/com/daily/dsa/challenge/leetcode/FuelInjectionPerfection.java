package src.com.daily.dsa.challenge.leetcode;

import java.math.BigInteger;

public class FuelInjectionPerfection {
    public static void main(String[] args) {
        System.out.println(solution("4"));   // Output: 2
        System.out.println(solution("15"));  // Output: 5
    }

    public static int solution(String x) {

        BigInteger pellets = new BigInteger(x);
        int operations = 0;

        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger four = new BigInteger("4");

        while (pellets.compareTo(one) > 0) {
            if (pellets.mod(two).equals(BigInteger.ZERO)) {
                pellets = pellets.divide(two);
            } else if (pellets.add(one).mod(four).equals(BigInteger.ZERO) && !pellets.equals(new BigInteger("3"))) {
                pellets = pellets.add(one);
            } else {
                pellets = pellets.subtract(one);
            }
            operations++;
        }

        return operations;
    }
}
