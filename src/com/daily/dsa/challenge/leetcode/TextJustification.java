package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    int index  = 0;
    boolean isLast = false;
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        while(index < words.length){
            result.add(createSentence(getWords(words, maxWidth), maxWidth));
        }
        return result;
    }


    private List<String> getWords(String[] words, int maxWidth){
        List<String> wordList = new ArrayList<>();
        while(index < words.length && maxWidth - (wordList.size() + words[index].length()) >= 0){
            wordList.add(words[index]);
            maxWidth -= words[index].length();
            index++;
        }
        isLast = index == words.length;
        return wordList;
    }


    private String createSentence(List<String> words, int maxWidth){
        if(isLast){
            return justifyLast(words, maxWidth);
        }
        StringBuilder builder = new StringBuilder();
        int wordLength = 0;
        for(String s: words){
            wordLength += s.length();
        }
        int spaces = maxWidth - wordLength;
        int remSpaces = spaces % (words.size() == 1 ? 1 :  (words.size() -1));
        int spacesPerWord = spaces / (words.size() == 1 ? 1 :  (words.size() -1));

        StringBuilder space = new StringBuilder();
        while(spacesPerWord > 0) {
            space.append(" ");
            spacesPerWord--;
        }
        for(int x= 0; x < (words.size() == 1 ? 1 :  (words.size() -1)); x++){
            builder.append(words.get(x)).append(space);
            if(remSpaces > 0){
                builder.append(" ");
                remSpaces--;
            }
        }
        if( words.size() > 1)
            builder.append(words.get(words.size() -1));
        return builder.toString();
    }

    private String justifyLast(List<String> words, int maxWidth){
        StringBuilder builder = new StringBuilder();
        int idx = 0;

        for(String s: words){
            builder.append(s).append(idx <words.size() - 1 ?  " ":"");
            idx++;
        }

        int remSpaces = maxWidth - builder.length();
        while(remSpaces > 0) {
            builder.append(" ");
            remSpaces--;
        }
        return builder.toString();
    }
}
