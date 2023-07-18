package src.com.daily.dsa.challenge.leetcode;

import java.util.*;

public class MinimumTimeDifference {
    public static void main(String[] args) {
        String time1 = "02:01";
        String time2 = "03:00";

        String[] time = time1.split(":");
        String[] second = time2.split(":");

        int hoursInMins = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        int hours2InMins = Integer.parseInt(second[0]) * 60 + Integer.parseInt(second[1]);
        int minDiff = Math.min(Math.max(hours2InMins, hoursInMins) - Math.min(hoursInMins, hours2InMins),
                Math.min(hours2InMins, hoursInMins) - Math.max(hoursInMins, hours2InMins) + 24 * 60);


        System.out.println(minDiff);
    }

    public int findMinDifference(List<String> timePoints) {
        PriorityQueue<String> timeInHours = new PriorityQueue<>();
        timeInHours.addAll(timePoints);

        int min = Integer.MAX_VALUE;
        String first = timeInHours.poll();
        String prev = first;


        while (!timeInHours.isEmpty()) {
            String curr = timeInHours.poll();
            System.out.println(prev + " " + curr);
            System.out.println(getDiff(curr, prev));
            min = Math.min(getDiff(curr, prev), min);
            prev = curr;
        }

        return Math.min(getDiff(first, prev), min);
    }

    private int getDiff(String time1, String time2) {
        String[] time = time1.split(":");
        String[] second = time2.split(":");

        int hoursInMins = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        int hours2InMins = Integer.parseInt(second[0]) * 60 + Integer.parseInt(second[1]);
        return Math.min(Math.max(hours2InMins, hoursInMins) - Math.min(hoursInMins, hours2InMins),
                Math.min(hours2InMins, hoursInMins) - Math.max(hoursInMins, hours2InMins) + 24 * 60);
    }
}
