package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    public static void main(String[] args) {
        List<String> res = new EncodeDecode().decode(new EncodeDecode().encode(new String[]{"wew", "qwertyuiop"}));
        System.out.println(res.toString());
    }

    public String encode(String[] strs) {
        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(s.length()).append("#").append(s);
        }
        return result.toString();
    }

    public List<String> decode(String encodedString) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < encodedString.length() - 1) {
            String wordLength = encodedString.substring(index, encodedString.indexOf("#", index));
            result.add(encodedString.substring(index + wordLength.length() + 1, index + wordLength.length() + 1 + Integer.parseInt(wordLength)));
            index += (Integer.parseInt(wordLength) + wordLength.length() + 1);
        }
        return result;
    }
}
