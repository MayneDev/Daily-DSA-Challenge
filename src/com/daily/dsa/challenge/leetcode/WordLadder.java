package src.com.daily.dsa.challenge.leetcode;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        wordList.add(beginWord);

        Map<String, List<String>> wordMap = new HashMap<>();
        Map<String, List<String>> wordPattern = new HashMap<>();

        //create adjacency list
        for (String curr : wordList) {
            List<String> patterns = new ArrayList<>();
            for (int x = 0; x < curr.length(); x++) {
                StringBuilder key = new StringBuilder(curr);
                key.setCharAt(x, '*');

                List<String> words = wordMap.getOrDefault(key.toString(), new ArrayList<>());
                words.add(curr);
                wordMap.put(key.toString(), words);
                patterns.add(key.toString());
            }
            wordPattern.put(curr, patterns);
        }

        Queue<String> wordQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        wordQueue.offer(beginWord);
        visited.add(beginWord);

        int length = 0;
        while (!wordQueue.isEmpty()) {
            int queueSize = wordQueue.size();
            while (queueSize > 0) {
                String curr = wordQueue.remove();
                if (curr.equals(endWord)) {
                    return length + 1;
                }
                for (String pattern : wordPattern.get(curr)) {
                    for (String word : wordMap.get(pattern)) {
                        if (!visited.contains(word)) {
                            wordQueue.offer(word);
                            visited.add(word);
                        }
                    }
                }
                queueSize--;
            }
            length++;
        }
        return 0;
    }
}
