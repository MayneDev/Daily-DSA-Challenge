package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        splitString(s, 0, result, new ArrayList<>());
        return result;
    }

    private void splitString(String s, int index, List<List<String>> result, List<String> current) {
        if (index == s.length()) {
            result.add(new ArrayList<>(current));
        }

        for (int x = index; x < s.length(); x++) {
            if (isPalindrome(s.substring(index, x + 1))) {
                current.add(s.substring(index, x + 1));
                splitString(s, x + 1, result, current);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
