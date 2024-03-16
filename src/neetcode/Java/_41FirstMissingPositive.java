package neetcode.Java;

import java.util.Arrays;

public class _41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int c = 1;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] < 1) continue;
            if (i > 0 && !(nums[i - 1] < nums[i])) continue;
            if (c == nums[i]) c++;
            else return c;
        }
        return c;
    }

    public int firstMissingPositive1(int[] nums) {
        for (int i = 0; i < nums.length; i++) if (nums[i] < 0) nums[i] = 0;
        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]);
            if (ind > 0 && ind <= nums.length) {
                ind--;
                if (nums[ind] > 0) nums[ind] *= -1;
                else if (nums[ind] == 0) nums[ind] = ((nums.length) + 1) * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) if (nums[i] >= 0) return i + 1;
        return nums.length + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int[] dp = new int[nums.length + 1];

        for (int i : nums) {
            if (i > 0 && i <= nums.length) {
                dp[i]++;
            }
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (dp[i] == 0) {
                return i;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        _41FirstMissingPositive obj = new _41FirstMissingPositive();

        {
            int[] num = {1, 2, 0};
            System.out.println(obj.firstMissingPositive(num));
        }
        {
            int[] num = {3, 4, -1, 2};
            System.out.println(obj.firstMissingPositive(num));
        }
        {
            int[] num = {7, 8, 9, 11, 12};
            System.out.println(obj.firstMissingPositive(num));
        }
        {
            int[] num = {0, 2, 2, 1, 1};
            System.out.println(obj.firstMissingPositive(num));
        }

        System.out.println("\n\n\n");

        {
            int[] num = {1, 2, 0};
            System.out.println(obj.firstMissingPositive1(num));
        }
        {
            int[] num = {3, 4, -1, 2};
            System.out.println(obj.firstMissingPositive1(num));
        }
        {
            int[] num = {7, 8, 9, 11, 12};
            System.out.println(obj.firstMissingPositive1(num));
        }
        {
            int[] num = {0, 2, 2, 1, 1};
            System.out.println(obj.firstMissingPositive1(num));
        }

        System.out.println("\n\n\n");

        {
            int[] num = {1, 2, 0};
            System.out.println(obj.firstMissingPositive2(num));
        }
        {
            int[] num = {3, 4, -1, 2};
            System.out.println(obj.firstMissingPositive2(num));
        }
        {
            int[] num = {7, 8, 9, 11, 12};
            System.out.println(obj.firstMissingPositive2(num));
        }
        {
            int[] num = {0, 2, 2, 1, 1};
            System.out.println(obj.firstMissingPositive2(num));
        }
    }
}
