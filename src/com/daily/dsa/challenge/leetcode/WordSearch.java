package src.com.daily.dsa.challenge.leetcode;

import java.util.*;

public class WordSearch {
    Set<String> visited = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) return true;
        //Base case
        if (r >= board.length
                || r < 0
                || c >= board[r].length || c < 0
                || visited.contains(r + "," + c)
                || board[r][c] != word.charAt(index))
            return false;

        visited.add(r + "," + c);
        boolean res = backtrack(board, word, r + 1, c, index + 1) ||
                backtrack(board, word, r - 1, c, index + 1) ||
                backtrack(board, word, r, c + 1, index + 1) ||
                backtrack(board, word, r, c - 1, index + 1);
        visited.remove(r + "," + c);

        return res;

    }
}
