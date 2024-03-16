package neetcode.Java;

public class _74Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        for (i = 0; i < matrix.length; i++) {
            if (target <= matrix[i][matrix[0].length-1]) break;
        }
        if(i>= matrix.length) return false;
        int s = 0, e = matrix[0].length - 1, mid;
        while (s <= e) {
            mid = (s + e) / 2;
            if (matrix[i][mid] == target) return true;
            else if (matrix[i][mid] > target) e = mid - 1;
            else s = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        _74Search2DMatrix obj = new _74Search2DMatrix();
        {
            int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
            System.out.println(obj.searchMatrix(matrix, 3));
        }
        {
            int[][] matrix = {{0}};
            System.out.println(obj.searchMatrix(matrix, 3));
        }
    }
}
