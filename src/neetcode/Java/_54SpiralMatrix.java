package neetcode.Java;

import java.util.ArrayList;
import java.util.List;

public class _54SpiralMatrix {
    List<Integer> list = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix[0].length - 1;
        int m = matrix.length - 1;
        int l = 0, u = 0, r = n, b = m;
        while (l <= r && u <= b) {
            for (int i = l; i <= r; i++)
                list.add(matrix[u][i]);
            u++;
            for (int i = u; i <= b; i++)
                list.add(matrix[i][r]);
            r--;
            for (int i = r; i >= l && u <= b; i--)
                list.add(matrix[b][i]);
            b--;
            for (int i = b; i >= u && l <= r; i--)
                list.add(matrix[i][l]);
            l++;
        }
        return list;
    }

    public static void main(String[] args) {
        _54SpiralMatrix obj = new _54SpiralMatrix();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(obj.spiralOrder(matrix));
    }
}
