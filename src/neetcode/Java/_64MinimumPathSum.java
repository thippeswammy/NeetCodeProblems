package neetcode.Java;

public class _64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j + 1 < n && i + 1 < m) grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                else if (i + 1 < m) grid[i][j] += grid[i + 1][j];
                else if (j + 1 < n) grid[i][j] += grid[i][j + 1];
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        _64MinimumPathSum obj = new _64MinimumPathSum();
        {
            int[][] grid = {{1,2,3}, {4,5,6}};
            System.out.println(obj.minPathSum(grid));
        }
        {
            int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
            System.out.println(obj.minPathSum(grid));
        }
    }
}
