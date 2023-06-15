package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        int x = 0;
        while (x < word.length()) {
            char c = word.charAt(x);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode(c));
            }
            curr = curr.children.get(c);
            x++;
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        int x = 0;
        while (x < word.length()) {
            char c = word.charAt(x);
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
            x++;
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int x = 0;
        while (x < prefix.length()) {
            char c = prefix.charAt(x);
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
            x++;
        }
        return true;
    }
}


class TrieNode {
    char val;
    boolean endOfWord;
    Map<Character, TrieNode> children;

    TrieNode() {
        this.endOfWord = false;
        this.children = new HashMap<>();
    }

    TrieNode(char val) {
        this.endOfWord = false;
        this.val = val;
        this.children = new HashMap<>();
    }
}
