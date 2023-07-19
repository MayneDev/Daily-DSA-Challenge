package src.com.daily.dsa.challenge.leetcode;

import java.util.Arrays;

public class TheKthStrongestValuesinAnArray {
    public int[] getStrongest(int[] arr, int k) {
        //Find median
        int n = arr.length;
        Arrays.sort(arr);
        int m = arr[(n - 1) / 2];

        int[] res = new int[k];
        int left = 0;
        int right = n - 1;

        while (k > 0) {
            if (Math.abs(arr[left] - m) > Math.abs(arr[right] - m)) {
                res[k - 1] = arr[left];
                left++;
            } else {
                res[k - 1] = arr[right];
                right--;
            }
            k--;
        }
        return res;
    }
}
