package src.com.daily.dsa.challenge.leetcode;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2,-3));
    }
    public double myPow(double x, int n) {
        return  binaryExp(x,(long)n);
        // return n < 0 ? 1.0/ans : ans;
    }

    private double binaryExp(double x, long n){
        if (n == 0) return 1;

        if (n < 0) {
            return 1.0 / binaryExp(x, -n);
        }

        if (n % 2 == 1){
            return x * binaryExp(x*x, (n-1) / 2);
        }
        return binaryExp(x*x, n/2);
    }
}
