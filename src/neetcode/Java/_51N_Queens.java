package neetcode.Java;

import java.util.ArrayList;
import java.util.List;

public class _51N_Queens {
    List<List<String>> lists = new ArrayList<>();
    List<String> l = new ArrayList<>();
    StringBuilder ss = new StringBuilder();

    public List<List<String>> solveNQueens1(int n) {
        boolean[] col = new boolean[n];
        boolean[] posSlope = new boolean[n * 2 - 1];
        boolean[] negSlope = new boolean[n * 2 - 1];
        ss.append(".".repeat(n));
        Helper(n, col, posSlope, negSlope, 0);
        return lists;
    }

    public void Helper(int len, boolean[] col, boolean[] posSlope, boolean[] negSlope, int i) {
        if (l.size() == len) {
            lists.add(new ArrayList<>(l));
            return;
        }
        for (int n = 0; n < len; n++) {
            if (!col[n] && !posSlope[i + n] && !negSlope[i - n + len - 1]) {
                col[n] = posSlope[i + n] = negSlope[i - n + len - 1] = true;
                StringBuilder sss = new StringBuilder(ss);
                l.add(sss.replace(n, n + 1, "Q").toString());
                Helper(len, col, posSlope, negSlope, i + 1);
                col[n] = posSlope[i + n] = negSlope[i - n + len - 1] = false;
                l.remove(l.size() - 1);
            }
            if (n + 1 == len) return;
        }
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] pos = new boolean[n * 2 - 1];
        boolean[] neg = new boolean[n * 2 - 1];
        Help(0, n, board, col, pos, neg, res);
        return res;
    }

    protected void Help(int i, int n, char[][] board, boolean[] col, boolean[] pos, boolean[] neg, List<List<String>> res) {
        if (i == n) {
            res.add(join(board));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!col[j] && !pos[i + j] && !neg[i - j + n - 1]) {
                board[i][j] = 'Q';
                col[j] = pos[i + j] = neg[i - j + n - 1] = true;
                Help(i + 1, n, board, col, pos, neg, res);
                col[j] = pos[i + j] = neg[i - j + n - 1] = false;
                board[i][j] = '.';
            }
            if (j + 1 == n) return;
        }
    }

    protected List<String> join(char[][] b) {
        List<String> l = new ArrayList<>();
        for (char[] chars : b) {
            String str = new String(chars);
            l.add(str);
        }
        return l;
    }



    public static void main(String[] args) {
        _51N_Queens obj = new _51N_Queens();
        System.out.println(obj.solveNQueens(4));
    }
}
