package neetcode.Java;

public class _8StringtoInteger {

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        long ans = 0;
        boolean neg = false;


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i == 0) {
                if (ch == '-') {
                    neg = true;
                    continue;
                } else if (ch == '+') {
                    continue;
                }
            }
            if (ch >= '0' && ch <= '9') {
                int dig = ch - '0';
                ans = ans * 10 + dig;
                if (neg) {
                    long check = -ans;
                    if (check < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else if (ans > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        if (neg) {
            ans = -ans;
        }
        return (int) ans;
    }

    public static int myAtoi1(String s) {
        String ss = "";
        boolean isPos = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ' && ss.length() == 0) continue;
            if (ch == '-') {
                if (ss.length() >= 1) break;
                isPos = false;
                ss = "-";
                continue;
            }
            if (ch == '+') {
                if (ss.length() >= 1) break;
                isPos = true;
                ss = "+";
                continue;
            }
            if (Character.isDigit(ch)) ss += ch;
            else break;
        }

        if (ss.length() == 0) return 0;
        if (ss.length() == 1 && (ss.charAt(0) == '-' || ss.charAt(0) == '+')) return 0;
        long ans;
        try {
            if (isPos)
                ans = Long.parseLong(ss);
            else
                ans = Long.parseLong((ss));
        } catch (Exception e) {
            if (isPos) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int) ans;
    }

    public static void main(String[] args) {
        int res = myAtoi("20000000000000000000");
        System.out.println(res);
    }
}
