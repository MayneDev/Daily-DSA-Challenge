package src.com.daily.dsa.challenge.leetcode;

import java.util.Stack;

public class ReversePolishNotation {
    /**
     * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
     * <p>
     * Evaluate the expression. Return an integer that represents the value of the expression.
     * <p>
     * Note that:
     * <p>
     * The valid operators are '+', '-', '*', and '/'.
     * Each operand may be an integer or another expression.
     * The division between two integers always truncates toward zero.
     * There will not be any division by zero.
     * The input represents a valid arithmetic expression in a reverse polish notation.
     * The answer and all the intermediate calculations can be represented in a 32-bit integer.
     * <p>
     * Example 1:
     * Input: tokens = ["2","1","+","3","*"]
     * Output: 9
     * Explanation: ((2 + 1) * 3) = 9
     * Example 2:
     * <p>
     * Input: tokens = ["4","13","5","/","+"]
     * Output: 6
     * Explanation: (4 + (13 / 5)) = 6
     */
    public int evalRPN(String[] tokens) {
        Stack<String> tokenStack = new Stack<>();
        for (String c : tokens) {
            tokenStack.push(c);
        }
        return getValue(tokenStack);
    }

    private int getValue(Stack<String> stack) {
        String token = stack.pop();
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            int right = getValue(stack);
            int left = getValue(stack);
            return switch (token) {
                case "*" -> left * right;
                case "+" -> left + right;
                case "-" -> left - right;
                default -> left / right;
            };
        } else {
            return Integer.parseInt(token);
        }
    }
}
