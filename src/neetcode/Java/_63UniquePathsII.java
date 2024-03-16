package neetcode.Java;

public class _63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) obstacleGrid[i][j] = -obstacleGrid[i][j];
        boolean isNeg = false;
        for (int i = m - 1; i >= 0; i--)
            if (obstacleGrid[i][n - 1] == -1 || isNeg) {
                isNeg = true;
                obstacleGrid[i][n - 1] = -1;
            } else obstacleGrid[i][n - 1] = 1;
        isNeg = false;
        for (int i = n - 1; i >= 0; i--)
            if (obstacleGrid[m - 1][i] == -1 || isNeg) {
                isNeg = true;
                obstacleGrid[m - 1][i] = -1;
            } else obstacleGrid[m - 1][i] = 1;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == -1) continue;
                if (obstacleGrid[i + 1][j] == -1 && obstacleGrid[i][j + 1] == -1) obstacleGrid[i][j] = -1;
                if (obstacleGrid[i + 1][j] != -1) obstacleGrid[i][j] = obstacleGrid[i + 1][j];
                if (obstacleGrid[i][j + 1] != -1) obstacleGrid[i][j] += obstacleGrid[i][j + 1];
                if (obstacleGrid[i][j] == 0) obstacleGrid[i][j] = -1;
            }
        }
        return Math.max(obstacleGrid[0][0], 0);
    }


    static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] uniquePaths = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                uniquePaths[i][0] = 0;
                break; // on the first column, if there is an obstacle, the rest are blocked.
            } else {
                uniquePaths[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                uniquePaths[0][j] = 0;
                break; // on the first row, if there is an obstacle, the rest are blocked.
            } else {
                uniquePaths[0][j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    uniquePaths[i][j] = 0;
                } else {
                    uniquePaths[i][j] = uniquePaths[i - 1][j] + uniquePaths[i][j - 1];
                }
            }
        }
        return uniquePaths[m - 1][n - 1];
    }


    public static void main(String[] args) {
        _63UniquePathsII obj = new _63UniquePathsII();
        {
            int[][] obstacleGrid = {{0, 0}, {1, 1}, {0, 0}};
            System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
        }
        {
            int[][] obstacleGrid = {{0, 0}, {0, 1}};
            System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
        }
        {
            int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
            System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
        }
        {
            int[][] obstacleGrid = {{0, 1}, {0, 0}};
            System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
        }
        {
            int[][] obstacleGrid = {{1, 0}};
            System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
        }

        ////////////////////////////////////////////////////////////////////////////////////

        {
            int[][] obstacleGrid = {{0, 0}, {1, 1}, {0, 0}};
            System.out.println(obj.uniquePathsWithObstacles1(obstacleGrid));
        }
        {
            int[][] obstacleGrid = {{0, 0}, {0, 1}};
            System.out.println(obj.uniquePathsWithObstacles1(obstacleGrid));
        }
        {
            int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
            System.out.println(obj.uniquePathsWithObstacles1(obstacleGrid));
        }
        {
            int[][] obstacleGrid = {{0, 1}, {0, 0}};
            System.out.println(obj.uniquePathsWithObstacles1(obstacleGrid));
        }
        {
            int[][] obstacleGrid = {{1, 0}};
            System.out.println(obj.uniquePathsWithObstacles1(obstacleGrid));
        }
    }
}