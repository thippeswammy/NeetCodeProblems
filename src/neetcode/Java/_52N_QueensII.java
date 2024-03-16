package neetcode.Java;

public class _52N_QueensII {
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] posSlope = new boolean[n * 2 - 1];
        boolean[] negSlope = new boolean[n * 2 - 1];
        return Helper(n, col, posSlope, negSlope, 0, 0, 0);
    }

    public int Helper(int len, boolean[] col, boolean[] posSlope, boolean[] negSlope, int i, int l, int possible) {
        if (l == len) {
            return 1 + possible;
        }
        for (int n = 0; n < len; n++) {
            if (!col[n] && !posSlope[i + n] && !negSlope[i - n + len - 1]) {
                col[n] = posSlope[i + n] = negSlope[i - n + len - 1] = true;
                possible = Helper(len, col, posSlope, negSlope, i + 1, l + 1, possible);
                col[n] = posSlope[i + n] = negSlope[i - n + len - 1] = false;
            }
            if (n + 1 == len) return possible;
        }
        return possible;
    }

    ///////////////////////////////////////////////////////////

    private int res = 0;

    public int totalNQueens1(int n) {
        Helper(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return res;
    }

    private void Helper(int n, int i, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (i == n) {
            ++res;
            return;
        }
        for (int j = 0; j < n; ++j) {
            if (cols[j] || diag1[i + j] || diag2[j - i + n - 1])
                continue;
            cols[j] = diag1[i + j] = diag2[j - i + n - 1] = true;
            Helper(n, i + 1, cols, diag1, diag2);
            cols[j] = diag1[i + j] = diag2[j - i + n - 1] = false;
        }
    }

    public static void main(String[] args) {
        _52N_QueensII obj = new _52N_QueensII();
        System.out.println(obj.totalNQueens(8));
        System.out.println(obj.totalNQueens1(8));
    }
}
