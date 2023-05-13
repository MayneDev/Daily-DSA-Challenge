package src.com.daily.dsa.challenge.leetcode;

public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right){
            char tempC = s[left];
            s[left] = s[right];
            s[right] = tempC;
            right--;
            left++;
        }
    }
}
