package neetcode.Java;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _12IntegertoRoman {
    public static String intToRoman(int num) {
        String[] val = {"I", "IV", "V", "IX", "X",
                "XL", "L", "XC", "C", "CD", "D", "CM", "M",
        };
        int[] key = {1, 4, 5, 9, 10, 40,
                50, 90, 100, 400, 500, 900, 1000
        };
        StringBuilder s = new StringBuilder();
        for (int i = key.length - 1; i >= 0 && num != 0; ) {
            if (num / key[i] >= 1) {
                s.append(val[i]);
                num = num - key[i];
                continue;
            }
            i--;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String res = intToRoman(1994);
        System.out.println(res);
    }
}
