package neetcode.Java;

public class _7ReverseInteger {

    public static int reverse(int x) {
        System.out.println(x);
        long ans = solving(x);
        System.out.println(ans);
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
        return (int) ans;
    }

    private static long solving(int num) {
        long ans = 0;
        while (num != 0) {
            int rem = num % 10;
            ans = (ans * 10) + rem;
            num /= 10;
        }
        return ans;
    }

    public static int reverse1(int x) {
        boolean isNeg;
        isNeg = x >= 0 ? false : true;
        double xn = x;
        xn = isNeg ? 0.0 - xn : xn;
        String s = xn + "";
        String ss = "";
        for (int i = 0; i < s.length(); i++) {
            ss = s.charAt(i) + ss;
        }
        try {
            xn = Double.parseDouble(ss);
        } catch (Exception e) {
            return 0;
        }
        xn = isNeg ? -xn : xn;
        if (xn >= Integer.MIN_VALUE && xn < Integer.MAX_VALUE) {
            return (int) xn;
        }
        return 0;
    }

    public static void main(String[] args) {
        int res = reverse(-2147483648);
        System.out.println(res);
    }
}
