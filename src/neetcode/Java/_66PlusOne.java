package neetcode.Java;

import java.util.Arrays;

public class _66PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] < 9) {
            digits[len - 1]++;
            return digits;
        }
        int carr = 0;
        digits[len - 1]++;
        int[] res = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            digits[i] += carr;
            carr = digits[i] / 10;
            if (carr == 0) return digits;
            digits[i] = digits[i] % 10;
            res[i] = digits[i];
        }
        res[0] = 1;
        return res;

    }

    public static void main(String[] args) {
        _66PlusOne obj = new _66PlusOne();
        {
            int[] digits = {1, 2, 3};
            System.out.println(Arrays.toString(obj.plusOne(digits)));
        }
        {
            int[] digits = {8, 9, 9};
            System.out.println(Arrays.toString(obj.plusOne(digits)));
        }
        {
            int[] digits = {9, 9, 9};
            System.out.println(Arrays.toString(obj.plusOne(digits)));
        }
    }
}
