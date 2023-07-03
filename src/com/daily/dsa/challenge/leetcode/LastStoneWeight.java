package src.com.daily.dsa.challenge.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int x : stones) {
            queue.add(-x);
        }

        while (queue.size() > 1) {
            int stone1 = queue.poll();
            int stone2 = queue.remove();
            queue.add(-Math.abs(stone1 - stone2));
        }
        return queue.isEmpty() ? 0 : -queue.poll();


    }
}
