package neetcode.Java;

public class _85MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int MaxArea = 0;
        int area = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int n = 0; n < matrix[0].length; n++) {
                if (matrix[i][n] != 0) {
                    area += matrix[i][n];
                }else {
                    MaxArea=Math.max(MaxArea,area)
                }

            }
        }

        return area + 1;
    }

    public static void main(String[] args) {
        _85MaximalRectangle obj = new _85MaximalRectangle();
        {
            char[][] nums = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
            System.out.println(obj.maximalRectangle(nums));
        }
    }
}
