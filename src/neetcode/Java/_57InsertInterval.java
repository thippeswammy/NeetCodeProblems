package neetcode.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _57InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        boolean is = true;
        for (int[] interval : intervals) {
            if (newInterval[0] >= interval[0] && newInterval[0] <= interval[1]) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
            }
            if (newInterval[1] >= interval[0] && newInterval[0] <= interval[0]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                continue;
            }
            if (is && newInterval[1] < interval[0]) {
                list.add(newInterval);
                is = false;
            }
            list.add(interval);
        }
        if (is) list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        _57InsertInterval obj = new _57InsertInterval();
        {
            int[][] matrix = {{1, 3}, {6, 9}};
            int a[] = {2, 5};
            System.out.println(Arrays.deepToString(obj.insert(matrix, a)));
        }
    }
}
