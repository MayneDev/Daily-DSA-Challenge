package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    List<int[]> stack = new ArrayList<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.add(new int[]{val, Math.min(val,stack.isEmpty() ? val : stack.get(stack.size() - 1)[1])});
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1)[0];
    }

    public int getMin() {
        return stack.get(stack.size() - 1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

