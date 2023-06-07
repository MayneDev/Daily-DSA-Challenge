package src.com.daily.dsa.challenge.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {

        Map<Integer, Integer> carSpeed = new HashMap<>();
        for (int x = 0; x < position.length; x++) {
            carSpeed.put(position[x], speed[x]);
        }

        Arrays.sort(position); //O(nlogn)
        Stack<Double> arrivalTime = new Stack<>();

        for (int x = position.length - 1; x >= 0; x--) { //O(n)
            double time = (double)(target - position[x]) / carSpeed.get(position[x]);

            if (arrivalTime.isEmpty() || time > arrivalTime.peek()) {
                arrivalTime.push(time);
            }
        }


        return arrivalTime.size();
    }
}
