package src.com.daily.dsa.challenge.leetcode;

import java.util.Arrays;

public class ProductExceptSelf {


    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int preSuf = 1;

        //Calculate prefix product
        for (int x = 0; x < nums.length; x++) {
            answer[x] = preSuf;
            preSuf *= nums[x];
        }

        //calculate suffix product
        preSuf = 1;
        for (int x = nums.length - 1; x >= 0; x--) {
            //  current = nums[x];
            answer[x] *= preSuf;
            preSuf *= nums[x];
        }

        return answer;
    }


    public int[] productExceptSelf1(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] answer = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;

        //Calculate prefix product
        for (int x = 1; x < nums.length; x++) {
            //  current = nums[x];
            prefix[x] = nums[x - 1] * prefix[x - 1];
        }

        //calculate suffix product
        for (int x = nums.length - 2; x >= 0; x--) {
            //  current = nums[x];
            suffix[x] = nums[x + 1] * suffix[x + 1];
        }

        //Calculate prefix product
        for (int x = 0; x < nums.length; x++) {
            //  current = nums[x];
            answer[x] = suffix[x] * prefix[x];
        }

        return answer;
    }
}
