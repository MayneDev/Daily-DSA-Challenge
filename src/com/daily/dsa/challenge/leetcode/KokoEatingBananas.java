package src.com.daily.dsa.challenge.leetcode;

public class KokoEatingBananas {

    /**
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
     * <p>
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
     * <p>
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     * <p>
     * Return the minimum integer k such that she can eat all the bananas within h hours.
     */
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1; //Possible min speed
        int max = 1;  //Possible max speed. Assume Koko's speed = max(pile)

        for (int x : piles) max = Math.max(x, max);

        while (min <= max) {
            int mid = min + (max - min) / 2;

            //Check the mid speed if its the optimal speed
            int hours = 0;
            for (int x = 0; x < piles.length; x++) {
                hours += Math.ceil((double) piles[x] / mid);
            }

            if (hours > h) min = mid + 1;
            else if (hours <= h) {
                max = mid - 1;
            }
        }

        return min;
    }
}
