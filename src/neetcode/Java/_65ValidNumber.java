package neetcode.Java;

public class _65ValidNumber {

    public boolean isNumber(String s) {
        boolean num = false;
        boolean exp = false;
        boolean dot = false;
        char last = '0';
        int firstTime = 0;
        for (char ch : s.toCharArray()) {
            ch = Character.toLowerCase(ch);
            if (Character.isDigit(ch)) {
                num = true;
            } else if (ch == 'e') {
                if (exp || !num)
                    return false;
                exp = true;
                num = false;
            } else if (ch == '.') {
                if (dot || exp)
                    return false;
                dot = true;
            } else if (ch == '-' || ch == '+') {
                if (firstTime != 0 && last != 'e')
                    return false;
            } else {
                return false;
            }
            last = ch;
            firstTime++;
        }
        return num;
    }

    public static void main(String[] args) {
        _65ValidNumber obj = new _65ValidNumber();
        String[] s = {"0", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", "46.e3"};
        String[] ss = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", ".e1", "."};
        for (String i : s)
            System.out.println(obj.isNumber(i));
        for (String i : ss)
            System.out.println(obj.isNumber(i));
    }
}
