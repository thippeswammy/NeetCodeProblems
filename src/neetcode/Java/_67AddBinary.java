package neetcode.Java;

import java.util.Stack;

public class _67AddBinary {
    public String addBinary1(String a, String b) {
        Stack<Integer> aa = new Stack<>();
        Stack<Integer> bb = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            aa.add(Integer.parseInt(a.charAt(i) + ""));
        }
        for (int i = 0; i < b.length(); i++) {
            bb.add(Integer.parseInt(b.charAt(i) + ""));
        }
        int carr = 0;
        while (!aa.isEmpty() || !bb.isEmpty() || carr != 0) {
            if (!aa.isEmpty()) {
                carr += aa.pop();
            }
            if (!bb.isEmpty()) {
                carr += bb.pop();
            }
            res.insert(0, carr % 2);
            carr = carr / 2;
        }
        return res.toString();
    }

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int c = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || c == 1) {
            if (i >= 0)
                c += a.charAt(i--) - '0';
            if (j >= 0)
                c += b.charAt(j--) - '0';
            result.append(c % 2);
            c /= 2;
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        _67AddBinary obj = new _67AddBinary();
        System.out.println(obj.addBinary("1010", "1010"));
    }
}
