package src.com.daily.dsa.challenge.leetcode;

public class MaximumProductSubarray {
    /**
     * Keeping track of max and min
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int maxProd = 1, minProd = 1;
        for (int num : nums) {
            int tempMax = maxProd * num;
            maxProd = Math.max(maxProd * num, Math.max(minProd * num, num));
            minProd = Math.min(tempMax, Math.min(minProd * num, num));
            res = Math.max(res, maxProd);
        }
        return res;
    }


    /**
     * Using prefi xan suffix
     *
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int pref = 1, suf = 1;

        for (int x = 0; x < nums.length; x++) {
            int num = nums[x];
            int num1 = nums[nums.length - 1 - x];

            if (pref == 0) {
                pref = 1;
            }
            if (suf == 0) {
                suf = 1;
            }

            pref = pref * num;
            suf = suf * num1;
            res = Math.max(res, Math.max(pref, suf));

        }

        return res;
    }
}
