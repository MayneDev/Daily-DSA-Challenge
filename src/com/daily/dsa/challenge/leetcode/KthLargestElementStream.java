package src.com.daily.dsa.challenge.leetcode;

import java.util.PriorityQueue;

public class KthLargestElementStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int size;

    public KthLargestElementStream(int k, int[] nums) {
        size = k;
        for (int x : nums) {
            minHeap.add(x);
        }
    }

    public int add(int val) {
        minHeap.add(val);

        while (minHeap.size() > size) {
            minHeap.remove();
        }

        return minHeap.peek();
    }
}
