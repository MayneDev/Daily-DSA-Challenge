package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        getCombinations(digits,0,res, "");
        return res;
    }

    private void getCombinations(String digits, int index, List<String> res, String current){
        if(index == digits.length()){
            res.add(current);
            return;
        }
        int digit = digits.charAt(index) - '0';

        int start = (digit - 2)*3 + (digit > 7 ? 1:0);
        int digChars = digit == 7 || digit == 9 ? 4:3;

        for(int i = start; i <  start + digChars; i++){
            current += (char)('a'+ i);
            getCombinations(digits,index+1,res, current);
            current = current.substring(0, current.length() - 1);
        }



    }
}
