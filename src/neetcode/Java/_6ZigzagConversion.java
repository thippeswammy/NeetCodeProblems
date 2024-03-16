package neetcode.Java;

import static java.lang.Math.max;

public class _6ZigzagConversion {

    public static String convert(String s, int numRows) {
        int n = s.length();
        StringBuffer[] arr = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) arr[i] = new StringBuffer();
        int i = 0;
        while (i < n) {
            for (int ind = 0; ind < numRows && i < n; ind++) {
                arr[ind].append(s.charAt(i++));
            }
            for (int ind = numRows - 2; ind > 0 && i < n; ind--) {
                arr[ind].append(s.charAt(i++));
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer e : arr) {
            ans.append(e);
        }
        return ans.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1 || s.length() == 1) return s;

        String rs = "";
        for (int i = 0; i < numRows; i++) {
            int pos = i;
            int pro;
            if (i == 0 || i == numRows - 1) {
                pro = 0;
            } else {
                pro = i;
            }
            while (pos < s.length()) {
                if (pro == 0) {
                    rs = rs + s.charAt(pos);
                    pos = pos + (numRows - 1) * 2;
                } else {
                    rs = rs + s.charAt(pos);
                    pos = pos + (numRows - 1) * 2 - pro * 2;
                    if (pos < s.length()) {
                        rs = rs + s.charAt(pos);
                        pos = pos + pro * 2;
                    }
                }
            }
        }
        return rs;
    }

    public static String convert1(String s, int numRows) {
        System.out.println(1 % 3 + " " + 5 % 3);
        if (s.length() <= 2) return s;
        if (numRows <= 1) return s;
        int len = s.length();
        String ss = "";
        int jump = max(numRows + numRows - 2, 1);
        for (int i = 0; i < len; i = i + jump) {
            ss += s.charAt(i);
        }
        int j = 1;
        while (j < (numRows - 1)) {
            for (int i = j; ; ) {
                if (i < len)
                    ss = ss + s.charAt(i);
                else break;
                i += jump - j * 2;//long jump
                if (i < len)
                    ss = ss + s.charAt(i);//short jump
                else break;
                i += j * 2;
            }
            j++;
        }
        for (int i = numRows - 1; i < len; i = i + jump) {
            ss += s.charAt(i);
        }
        return ss;
    }

    public static void main(String[] args) {
        String s = convert("ABCDEFGHIJKLMNOPQRSTWXYZ", 5);
        System.out.println(s);
    }
}
