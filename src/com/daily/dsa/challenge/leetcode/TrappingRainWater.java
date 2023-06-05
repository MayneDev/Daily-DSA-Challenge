package src.com.daily.dsa.challenge.leetcode;

public class TrappingRainWater {
//    Given n non-negative integers representing an elevation map where the width of each bar is 1,
//    compute how much water it can trap after raining.
//    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//    Output: 6
//    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
//    In this case, 6 units of rain water (blue section) are being trapped.

    /**
     * Using 2 pointers
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int water = 0;
        int maxLeft = 0, maxRight = 0, left = 0, right = height.length - 1;

        while (left < right) {
            if (maxLeft > height[left]) {
                water += maxLeft - height[left];
            }
            if (maxRight > height[right]) {
                water += maxRight - height[right];
            }
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if (height[left] < height[right]) left++;
            else right--;
        }
        return water;
    }

    /**
     * Dynamic Programming
     *
     * @param height
     * @return
     */
    public int trap0(int[] height) {
        int[] reservoir = new int[height.length];
        int maxHeight = 0;
        for (int x = 0; x < height.length; x++) {
            maxHeight = Math.max(height[x], maxHeight);
            reservoir[x] = maxHeight;
        }

        maxHeight = 0;
        int water = 0;
        for (int x = height.length - 1; x > 0; x--) {
            maxHeight = Math.max(height[x], maxHeight);
            int capacity = Math.min(maxHeight, reservoir[x]) - height[x];
            water += Math.max(capacity, 0);
        }

        return water;
    }


    /**
     * Brute force
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int waterVolume = 0;

        for (int x = 0; x < height.length; x++) {
            int maxLeft = 0;
            int maxRight = 0;
            int left = x, right = x;

            while (left >= 0) {
                maxLeft = Math.max(maxLeft, height[left]);
                left--;
            }
            while (right < height.length) {
                maxRight = Math.max(maxRight, height[right]);
                right++;
            }
            if (Math.min(maxLeft, maxRight) > height[x])
                waterVolume += Math.min(maxLeft, maxRight) - height[x];
        }

        return waterVolume;
    }
}
