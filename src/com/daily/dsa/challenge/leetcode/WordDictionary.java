package src.com.daily.dsa.challenge.leetcode;

import java.util.Map;

public class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        int x = 0;
        while (x < word.length()) {
            if (!curr.children.containsKey(word.charAt(x))) {
                curr.children.put(word.charAt(x), new TrieNode(word.charAt(x)));
            }
            curr = curr.children.get(word.charAt(x));
            x++;
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode curr) {
        int x = 0;
        while (x < word.length()) {

            char c = word.charAt(x); //Check if
            boolean proceed = false;
            if (c == '.') {
                //Backtrack all children to check if any is a match

                //Treat curr as root and start from next
                for (Map.Entry<Character, TrieNode> entry : curr.children.entrySet()) {
                    proceed = search(word.substring(x + 1), entry.getValue());
                    if (proceed) break;
                }

                return proceed;
            }
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
            x++;
        }

        return curr.endOfWord;
    }
}
