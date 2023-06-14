package src.com.daily.dsa.challenge.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        //init an array to check freq
        int[] s1Freq = new int[26]; //26 a -> z
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        int left = 0;
        int right = s1.length();
        int[] s2Freq = new int[26];
        for (int x = 0; x < right; x++) {
            s2Freq[s2.charAt(x) - 'a']++;
        }

        while (right < s2.length()) { //O(n)
            if (Arrays.equals(s2Freq, s1Freq)) return true; //O(26)
            s2Freq[s2.charAt(left) - 'a']--;
            s2Freq[s2.charAt(right) - 'a']++;

            left++;
            right++;
        }

        return Arrays.equals(s2Freq, s1Freq);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[(nums.length - k) + 1];

        Map<Integer, Integer> window = new HashMap<>();
        int max = Integer.MIN_VALUE;

        //Init the first window
        for (int x = 0; x < k; x++) {
            max = Math.max(nums[x], max);
            //Count the freq of nums[x]
            window.put(nums[x], window.getOrDefault(nums[x], 0) + 1);
        }

        int resIndex = 0;

        while (resIndex < res.length) {
            res[resIndex] = max;

            //Remove from  resIndex
            int l = window.get(nums[resIndex]);
            if (l == 1) {
                window.remove(nums[resIndex]);
            } else
                window.put(nums[resIndex], window.get(nums[resIndex + k]) - 1);

            //add resIndex + k
            window.put(nums[resIndex + k], window.getOrDefault(nums[resIndex + k], 0) + 1);

            //Check what we remove if it was max and it was the only occurence


            resIndex++;
        }

        return res;
    }
}
