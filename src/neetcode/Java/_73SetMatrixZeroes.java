package neetcode.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _73SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int n = 0; n < matrix[0].length; n++) {
                if (matrix[i][n] == 0) list.add(new int[]{i, n});
            }
        }
        for (int[] l : list) {
            int i = l[0], n = l[1];
            //row
                for (int j = 0; j < matrix[0].length; j++)
                    matrix[i][j] = 0;
            //col
                for (int j = 0; j < matrix.length; j++)
                    matrix[j][n] = 0;
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        _73SetMatrixZeroes obj = new _73SetMatrixZeroes();
        {
            int[][] matrix = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
            obj.setZeroes(matrix);
        }
//        {
//            int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//            obj.setZeroes(matrix);
//        }
//        {
//            int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//            obj.setZeroes(matrix);
//        }
    }
}
