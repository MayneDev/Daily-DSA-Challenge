package src.com.daily.dsa.challenge.leetcode;

import java.util.Stack;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            if ((leftC >= '0' && leftC <= '9' || leftC >= 'a' && leftC <= 'z')
                    && (rightC >= '0' && rightC <= '9' || rightC >= 'a' && rightC <= 'z')) {
                if (rightC != leftC) return false;
                right--;
                left++;
            } else if ((rightC < '0' || rightC > '9') && (rightC < 'a' || rightC > 'z')) {
                right--;
            } else {
                left++;
            }
        }
        return true;
    }


    public boolean isPalindrome1(String s) {

        s = s.toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (int x = 0; x < s.length(); x++) {
            if (Character.isLetter(s.charAt(x)) || Character.isDigit(s.charAt(x))) {
                stack.push(s.charAt(x));
            }
        }

        for (int x = 0; x < s.length(); x++) {
            if (Character.isLetter(s.charAt(x)) || Character.isDigit(s.charAt(x))) {
                if (s.charAt(x) != stack.pop()) {
                    return false;
                }
            }
        }
        return true;
    }
}
