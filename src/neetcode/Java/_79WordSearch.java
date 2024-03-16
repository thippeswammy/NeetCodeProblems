package neetcode.Java;

import java.util.ArrayList;
import java.util.List;

public class _79WordSearch {
    public boolean exist1(char[][] board, String word) {
        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int n = 0; n < board[0].length; n++) {
                if (board[i][n] == c && Helper(i, n, board, 0, word, new ArrayList<>())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Helper(int i, int n, char[][] board, int pointer, String word, List<String> list) {
        if (word.charAt(pointer) == board[i][n] && (!list.contains((i + "" + n)))) {
            if (pointer == word.length() - 1)
                return true;
            list.add((i + "" + n));
            if (n + 1 < board[0].length)
                if (Helper(i, n + 1, board, pointer + 1, word, list)) return true;
            if (i + 1 < board.length)
                if (Helper(i + 1, n, board, pointer + 1, word, list)) return true;
            if (i - 1 >= 0)
                if (Helper(i - 1, n, board, pointer + 1, word, list)) return true;
            if (n - 1 >= 0)
                if (Helper(i, n - 1, board, pointer + 1, word, list)) return true;
            list.remove(list.size() - 1);
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int pointer, int i, int n) {
        if (pointer == word.length())
            return true;
        if (i < 0 || i >= board.length || n < 0 || n >= board[i].length || board[i][n] != word.charAt(pointer))
            return false;
        char temp = board[i][n];
        board[i][n] = '.';
        boolean result = dfs(board, word, pointer + 1, i - 1, n) ||
                dfs(board, word, pointer + 1, i, n - 1) ||
                dfs(board, word, pointer + 1, i, n + 1) ||
                dfs(board, word, pointer + 1, i + 1, n);
        board[i][n] = temp;
        return result;
    }


    public static void main(String[] args) {
        _79WordSearch obj = new _79WordSearch();
        {
            char[][] board = {{'A'}};
            System.out.println(obj.exist(board, "A"));
        }
        {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
            System.out.println(obj.exist(board, "ABCEFSADEESE"));
        }
        {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
            System.out.println(obj.exist(board, "ABCESEEEFS"));
        }
        {
            char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
            System.out.println(obj.exist(board, "AAB"));
        }
        {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            System.out.println(obj.exist(board, "ABCB"));
        }
        {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            System.out.println(obj.exist(board, "ABC"));
        }
        {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            System.out.println(obj.exist(board, "SEE"));
        }
        {
            char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
            System.out.println(obj.exist(board, "AAB"));
        }
        {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
            System.out.println(obj.exist1(board, "ABCEFSADEESE"));
        }
        {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
            System.out.println(obj.exist1(board, "ABCESEEEFS"));
        }
        {
            char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
            System.out.println(obj.exist1(board, "AAB"));
        }
        {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            System.out.println(obj.exist1(board, "ABCB"));
        }
        {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            System.out.println(obj.exist1(board, "ABC"));
        }
        {
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            System.out.println(obj.exist1(board, "SEE"));
        }
        {
            char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
            System.out.println(obj.exist1(board, "AAB"));
        }
    }
}