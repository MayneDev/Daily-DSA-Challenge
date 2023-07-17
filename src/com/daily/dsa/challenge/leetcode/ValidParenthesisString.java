package src.com.daily.dsa.challenge.leetcode;

import java.util.Stack;

public class ValidParenthesisString {
    /**
     * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
     * <p>
     * The following rules define a valid string:
     * <p>
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
     * <p>
     * Input: s = "()"
     * Output: true
     * Example 2:
     * <p>
     * Input: s = "(*)"
     * Output: true
     * Example 3:
     * <p>
     * Input: s = "(*))"
     * Output: true
     */

    public static void main(String[] args) {
        System.out.println(new ValidParenthesisString().checkValidString("(*))"));
    }


    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                maxOpen += 1;
                minOpen += 1;
            } else if (c == ')') {
                maxOpen -= 1;
                minOpen -= 1;
            } else {
                maxOpen += 1;
                minOpen -= 1;
            }
            if (maxOpen < 0) return false;
            if (minOpen < 0) minOpen = 0;
        }
        return minOpen == 0;
    }

    public boolean checkValidString1(String s) {
        return checkValidStringBF(s, new Stack<>(), 0);
    }

    public boolean checkValidStringBF(String s, Stack<Character> stack, int index) {
        if (index == s.length()) {
            return stack.isEmpty();
        }
        char c = s.charAt(index);
        if (c == '(') {
            stack.push(c);
            return checkValidStringBF(s, stack, index + 1);
        } else if (c == ')') {
            if (stack.isEmpty() || stack.peek() == ')') {
                return false;
            }
            stack.pop();
            return checkValidStringBF(s, stack, index + 1);
        } else {
            //Assume it's an opening bracket
            stack.push('(');
            boolean pushValid = checkValidStringBF(s, (Stack<Character>) stack.clone(), index + 1);
            stack.pop();
            if (pushValid) return true;

            if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                boolean popValid = checkValidStringBF(s, (Stack<Character>) stack.clone(), index + 1);
                if (popValid) {
                    return true;
                }
                stack.push('(');
            }
            return checkValidStringBF(s, stack, index + 1);
        }
    }
}
