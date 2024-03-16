package neetcode.Java;

import java.util.HashSet;
import java.util.Set;

public class _36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> s = new HashSet<>();
        for (char[] i : board) {
            Set<Character> set = new HashSet<>();
            for (char n : i) {
                if (n != '.') if (set.contains(n)) return false;
                else set.add(n);
            }
        }
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int n = 0; n < board.length; n++) {
                if (board[n][i] != '.') if (set.contains(board[n][i])) return false;
                else set.add(board[n][i]);
            }
        }
        for (int ii = 0; ii < 3; ii++) {
            for (int nn = 0; nn < 3; nn++) {
                Set<Character> set = new HashSet<>();
                for (int i = ii * 3; i < 3 + ii * 3; i++) {
                    for (int n = nn * 3; n < 3 + nn * 3; n++) {
                        if (board[i][n] != '.') if (set.contains(board[i][n])) return false;
                        else set.add(board[i][n]);
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        boolean[][] m1 = new boolean[9][9];
        boolean[][] m2 = new boolean[9][9];
        boolean[][] m3 = new boolean[9][9];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int k = i / 3 * 3 + j / 3;

                    if (m1[i][num] || m2[j][num] || m3[k][num])
                        return false;

                    m1[i][num] = m2[j][num] = m3[k][num] = true;
                }

        return true;
    }

    public static void main(String[] args) {
        _36ValidSudoku obj = new _36ValidSudoku();
        {
            char[][] board = {
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

            System.out.println(obj.isValidSudoku(board));
        }
        {
            char[][] board = {
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

            System.out.println(obj.isValidSudoku1(board));
        }
    }
}
