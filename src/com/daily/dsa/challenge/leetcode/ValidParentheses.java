package src.com.daily.dsa.challenge.leetcode;

import java.util.Stack;

public class ValidParentheses {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     */

    public boolean isValid(String s) {
        Stack<Character> bracketsStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                //add to stack
                bracketsStack.push(c);
            } else {
                if (bracketsStack.isEmpty()) return false;
                char topBracket = bracketsStack.pop();
                if (c == ')' && topBracket != '(') return false;
                if (c == ']' && topBracket != '[') return false;
                if (c == '}' && topBracket != '{') return false;
            }
        }
        return bracketsStack.isEmpty();
    }
}
