package neetcode.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(inter -> inter[0]));
        //Arrays.sort(intervals, (inter1, inter2) -> Integer.compare(inter1[0], inter2[0]));
        List<int[]> list = new ArrayList<>();
        int l = 0, r = 1;
        int max = intervals[l][1];
        while (r < size) {
            if (max >= intervals[r][0]) {
                max = Math.max(max, intervals[r][1]);
                r++;
            } else {
                int[] a = {intervals[l][0], max};
                list.add(a);
                r++;
                l = r - 1;
                max = intervals[l][1];
            }
        }
        if (r < size + 1) {
            intervals[0][0] = intervals[l][0];
            intervals[0][1] = max;
            list.add(intervals[0]);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        _56MergeIntervals obj = new _56MergeIntervals();
        {
            int[][] matrix = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
            System.out.println(Arrays.deepToString(obj.merge(matrix)));
        }
        {
            int[][] matrix = {{1, 4}, {2, 3}};
            System.out.println(Arrays.deepToString(obj.merge(matrix)));
        }
        {
            int[][] matrix = {{2, 3}, {1, 4}};
            System.out.println(Arrays.deepToString(obj.merge(matrix)));
        }
        {
            int[][] matrix = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
            System.out.println(Arrays.deepToString(obj.merge(matrix)));
        }
    }
}
