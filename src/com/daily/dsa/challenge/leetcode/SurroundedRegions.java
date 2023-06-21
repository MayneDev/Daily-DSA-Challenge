package src.com.daily.dsa.challenge.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {
    public void solve(char[][] board) {

        //Get all the elements on the outer side which are 0s and check their connection from outside

        Set<String> openSet = new HashSet<>();

        //Traverse outer rows and columns

        for (int r = 0; r < board.length; r++) {
            checkOpenings(board, r, 0, openSet);
            checkOpenings(board, r, board[0].length - 1, openSet);
        }

        for (int c = 0; c < board[0].length; c++) {
            checkOpenings(board, 0, c, openSet);
            checkOpenings(board, board.length - 1, c, openSet);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!openSet.contains(i + "," + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void checkOpenings(char[][] board, int row, int col, Set<String> openings) {
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || openings.contains(row + "," + col)
                || board[row][col] == 'X') {
            return;
        }

        openings.add(row + "," + col);
        checkOpenings(board, row + 1, col, openings);
        checkOpenings(board, row - 1, col, openings);
        checkOpenings(board, row, col + 1, openings);
        checkOpenings(board, row, col - 1, openings);
    }

}
