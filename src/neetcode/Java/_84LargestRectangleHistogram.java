package neetcode.Java;

import java.util.Stack;

public class _84LargestRectangleHistogram {

    public int largestRectangleArea(int[] heights) {
        int MaxArea = 0;
        Stack<Integer> ind = new Stack<>();
        Stack<Integer> height = new Stack<>();
        ind.add(0);
        height.add(heights[0]);
        for (int i = 1; i < heights.length; i++) {
            int last = i;
            while (!height.isEmpty() && heights[i] < height.peek()) {
                int area = (i - ind.peek()) * height.peek();
                if (area > MaxArea) MaxArea = area;
                last = ind.pop();
                height.pop();
            }
            ind.add(last);
            height.add(heights[i]);
        }
        while (!height.isEmpty()) {
            int area = (heights.length - ind.pop()) * height.pop();
            if (area > MaxArea) MaxArea = area;
        }
        return MaxArea;
    }

    public int largestRectangleArea1(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int pos = i;
            int min = heights[i];
            int temarea = min;
            for (int n = i; n < heights.length; n++) {
                if (min > heights[n]) {
                    min = heights[n];
                }
                if (min * (n - i + 1) >= temarea) temarea = min * (n - i + 1);
                else if (min == heights[n]) pos = n;
            }
            i = pos;
            area = Math.max(area, temarea);
        }
        return area;
    }

    public static void main(String[] args) {
        _84LargestRectangleHistogram obj = new _84LargestRectangleHistogram();
        {
            int[] nums = {2, 1, 5, 6, 2, 3};
            System.out.println(obj.largestRectangleArea(nums));
        }
        {
            int[] nums = {2, 4};
            System.out.println(obj.largestRectangleArea(nums));
        }
    }
}
