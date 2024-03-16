package neetcode.Java;

public class _48RotateImage {
    public int[][] rotate1(int[][] matrix) {
        int l = 0, r = matrix.length - 1, t = l, b = r;
        while (t <= b) {
            l = t;
            r = b;
            while (r > t) {
                int tem = matrix[t][l];
                matrix[t][l] = matrix[r][t];
                matrix[r][t] = matrix[b][r];
                matrix[b][r] = matrix[l][b];
                matrix[l][b] = tem;
                l++;
                r--;
            }
            t++;
            b--;
        }
        return matrix;
    }

    public int[][] rotate(int[][] matrix) {
        int l = 0, r = matrix.length - 1;
        while (l < r) {
            for (int i = 0; i < r - l; i++) {
                int topLeft = matrix[l][l + i];
                matrix[l][l + i] = matrix[r - i][l];
                matrix[r - i][l] = matrix[r][r - i];
                matrix[r][r - i] = matrix[l + i][r];
                matrix[l + i][r] = topLeft;
            }
            l++;
            r--;
        }
        return matrix;
    }


    public static void main(String[] args) {
        _48RotateImage obj = new _48RotateImage();
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        {
            int[][] rs = obj.rotate(matrix);
            for (int[] i : matrix) {
                for (int n : i)
                    System.out.print(n + "    ");
                System.out.println("");
            }

        }
        System.out.println();
        System.out.println();

        {
            {
                int[][] rs = obj.rotate1(matrix);
                for (int[] i : matrix) {
                    for (int n : i)
                        System.out.print(n + "    ");
                    System.out.println("");
                }

            }
        }
    }
}
