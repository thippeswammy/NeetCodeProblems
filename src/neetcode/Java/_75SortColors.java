package neetcode.Java;

import java.util.Arrays;

public class _75SortColors {
    public void sortColors1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int pos = i;
            for (int n = i + 1; n < nums.length; n++) {
                if (nums[pos] > nums[n]) pos = n;
            }
            int temp = nums[pos];
            nums[pos] = nums[i];
            nums[i] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int i = 0, start = 0, end = nums.length - 1;
        while (i <= end) {
            if (nums[i] == 0) swap(nums, start++, i++);
            else if (nums[i] == 2) swap(nums, end--, i);
            else i++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        _75SortColors obj = new _75SortColors();
        {
            int[] nums = {2, 0, 2, 1, 1, 0};
            obj.sortColors(nums);
        }
    }
}
