package neetcode.Java;

public class _42TrappingRainWater {
    public int trap(int[] height) {
        int area = 0;
        int l = 0, r = height.length - 1;
        int LM = height[l], RM = height[r];
        while (l <= r) {
            if (LM > RM) {
                area += Math.max(0, RM - height[r]);
            } else {
                area += Math.max(0, LM - height[l]);
            }
            if (height[r] > RM) RM = height[r];
            if (height[l] > LM) LM = height[l];
            if (LM > RM) r--; else l++;
        }
        return area;
    }

    public static void main(String[] args) {
        _42TrappingRainWater obj = new _42TrappingRainWater();
        {
            int[] num = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
            System.out.println(obj.trap(num));
        }
        {
            int[] num = {4, 2, 0, 3, 2, 5};
            System.out.println(obj.trap(num));
        }
        {
            int[] num = {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3,
                    2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3};
            System.out.println(obj.trap(num));
        }
    }
}
