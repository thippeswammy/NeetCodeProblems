package neetcode.Java;

import java.util.Arrays;

public class _59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int l = 0, u = 0, r = n - 1, b = n - 1;
        int count = 0;
        while (l <= r && u <= b) {
            for (int i = l; i <= r; i++)
                result[u][i] = ++count;
            u++;
            for (int i = u; i <= b; i++)
                result[i][r] = ++count;
            r--;
            for (int i = r; i >= l && u <= b; i--)
                result[b][i] = ++count;
            b--;
            for (int i = b; i >= u && l <= r; i--)
                result[i][l] = ++count;
            l++;
        }
        return result;
    }

    public static void main(String[] args) {
        _59SpiralMatrixII obj = new _59SpiralMatrixII();
        System.out.println(Arrays.deepToString(obj.generateMatrix(3)));
    }
}
