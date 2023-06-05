package src.com.daily.dsa.challenge.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

//    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

//    Each row must contain the digits 1-9 without repetition.
//    Each column must contain the digits 1-9 without repetition.
//    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//    Note:
//    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//    Only the filled cells need to be validated according to the mentioned rules.

//    Input: board =
//            [["5","3",".",".","7",".",".",".","."]
//            ,["6",".",".","1","9","5",".",".","."]
//            ,[".","9","8",".",".",".",".","6","."]
//            ,["8",".",".",".","6",".",".",".","3"]
//            ,["4",".",".","8",".","3",".",".","1"]
//            ,["7",".",".",".","2",".",".",".","6"]
//            ,[".","6",".",".",".",".","2","8","."]
//            ,[".",".",".","4","1","9",".",".","5"]
//            ,[".",".",".",".","8",".",".","7","9"]]
//    Output: true


//    Input: board =
//            [["8","3",".",".","7",".",".",".","."]
//            ,["6",".",".","1","9","5",".",".","."]
//            ,[".","9","8",".",".",".",".","6","."]
//            ,["8",".",".",".","6",".",".",".","3"]
//            ,["4",".",".","8",".","3",".",".","1"]
//            ,["7",".",".",".","2",".",".",".","6"]
//            ,[".","6",".",".",".",".","2","8","."]
//            ,[".",".",".","4","1","9",".",".","5"]
//            ,[".",".",".",".","8",".",".","7","9"]]
//    Output: false
//    Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


//    Constraints:
//
//    board.length == 9
//    board[i].length == 9
//    board[i][j] is a digit 1-9 or '.'.

    public boolean isValidSudoku(char[][] board) {

        //Validate rows
        for (int i = 0; i < 9; i++) {
            int[] entries = new int[9];
            for (int j = 0; j < 9; j++) {
                int c = board[i][j];
                if (c >= '1' && c <= '9') {
                    //check if entries already contains
                    if (entries[c - (int) '1'] != 0) return false;
                    entries[c - (int) '1'] = 1;
                }
            }
        }


        //Validate columns
        for (int i = 0; i < 9; i++) {
            int[] entries = new int[9];
            for (int j = 0; j < 9; j++) {
                int c = board[j][i];
                if (c >= '1' && c <= '9') {
                    //check if entries already contains
                    if (entries[c - (int) '1'] != 0) return false;
                    entries[c - (int) '1'] = 1;
                }
            }
        }


        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                int[] entries = new int[9];
                //traverse the 3X3 box
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        int c = board[x][y];
                        if (c >= '1' && c <= '9') {
                            //check if entries already contains
                            if (entries[c - (int) '1'] != 0) return false;
                            entries[c - (int) '1'] = 1;
                        }
                    }
                }
            }
        }


        return true;
    }

    public boolean isValidSudokuUsingSet(char[][] board) {
        //Validate row
        for (int i = 0; i < 9; i++) {
            Set<Character> foundChars = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    if (foundChars.contains(val)) {
                        return false;
                    }
                    foundChars.add(val);
                }
            }
        }

        //Validate column
        int column = 0;
        while (column < 9) {
            Set<Character> foundChars = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char val = board[i][column];
                if (val != '.') {
                    if (foundChars.contains(val)) {
                        return false;
                    }
                    foundChars.add(val);
                }

            }
            column++;
        }

        //Validate 3X3 box
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> foundChars = new HashSet<>();
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {

                        char val = board[x][y];
                        if (val != '.') {
                            if (foundChars.contains(val)) {
                                return false;
                            }
                            foundChars.add(val);
                        }
                    }
                }
            }
        }


        return true;
    }
}