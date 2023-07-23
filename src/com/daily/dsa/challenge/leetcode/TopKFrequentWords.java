package src.com.daily.dsa.challenge.leetcode;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Counter> counterMap = new HashMap<>();

        PriorityQueue<Counter> maxHeap = new PriorityQueue<>((a, b) -> {
            // Compare based on frequency in descending order (max-heap)
            //int frequencyComparison = Integer.compare(b.frequency, a.frequency);

            if (b.frequency != a.frequency) {
                // If frequencies are different, return the comparison result
                return b.frequency - a.frequency;
            } else {
                // If frequencies are the same, compare words lexicographically
                return a.word.compareTo(b.word);
            }
        });

        for (String s : words) {
            if (counterMap.containsKey(s)) {
                counterMap.get(s).frequency = counterMap.get(s).frequency + 1;
            } else {
                Counter counter = new Counter(s, 1);
                counterMap.put(s, counter);
            }
        }

        for (Map.Entry<String, Counter> entry : counterMap.entrySet()) {
            maxHeap.offer(entry.getValue());
        }

        List<String> result = new ArrayList<>();
        while (k > 0 && !maxHeap.isEmpty()) {
            result.add(maxHeap.poll().word);
            k--;
        }
        return result;
    }
}

class Counter {
    int frequency;
    String word;

    public Counter() {
    }

    public Counter(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}