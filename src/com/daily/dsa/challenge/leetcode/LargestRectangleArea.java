package src.com.daily.dsa.challenge.leetcode;

import java.util.Stack;


public class LargestRectangleArea {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{0}));
    }
    static class Tuple {
        public int index;
        public int height;

        Tuple(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Tuple> tuples = new Stack<>();
        for (int x = 0; x < heights.length; x++) {
            if (tuples.isEmpty()) {
                tuples.push(new Tuple(x, heights[x]));
            } else {
                int index = x;
                while (!tuples.isEmpty() && tuples.peek().height > heights[x]) {
                    Tuple tuple = tuples.pop();
                    maxArea = Math.max(maxArea, tuple.height * (x - tuple.index));
                    index = tuple.index;
                }
                tuples.push(new Tuple(index, heights[x]));
            }
        }

        while (!tuples.isEmpty()) {
            Tuple tuple = tuples.pop();
            maxArea = Math.max(maxArea, tuple.height * (heights.length - tuple.index));
        }

        return maxArea;
    }
}
