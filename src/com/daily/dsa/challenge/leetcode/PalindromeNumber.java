package src.com.daily.dsa.challenge.leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        int y = x, x1 = 0;
        //reverse X
        while(y >0){
            x1 *= 10;
            x1 += y%10;
            y = y /10;
        }

        return  x1 == x;
    }
}
