package src.com.daily.dsa.challenge.leetcode;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int l = 0;
        int r = citations.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (mid > citations[mid]){
                r = mid - 1;
            }else {
                l = mid;
            }

        }

        return l;
    }
}
