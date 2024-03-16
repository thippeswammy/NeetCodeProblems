package neetcode.Java;

public class _62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) board[i][n - 1] = 1;
        for (int i = 0; i < n; i++) board[m - 1][i] = 1;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                board[i][j] = board[i + 1][j] + board[i][j + 1];
            }
        }
        return board[0][0];
    }

    int count = 0;
    public int uniquePaths1(int m, int n) {
        int[][] board = new int[m][n];
        Helper( m - 1, n - 1);
        return count;
    }

    public void Helper(int m, int n) {
        if (0 == m && 0 == n) {
            count++;
            return;
        }
        if (m - 1 >= 0) Helper(m - 1, n);
        if (n - 1 >= 0) Helper(m, n - 1);
    }

    public static void main(String[] args) {
        _62UniquePaths obj = new _62UniquePaths();
        System.out.println(obj.uniquePaths(3, 7));
        System.out.println(obj.uniquePaths1(3, 7));
    }
}
