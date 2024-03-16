package neetcode.Java;

public class _50Pow_x_n_ {
    public double myPow1(double x, int n) {
        return Math.pow(x, n);
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n > 0) {
            return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
        } else if (n == Integer.MIN_VALUE) {
            return myPow(x * x, n / 2);
        } else {
            return myPow(1.0 / x, -1 * n);
        }
    }

    public static void main(String[] args) {
        _50Pow_x_n_ obj = new _50Pow_x_n_();
        System.out.println(obj.myPow(2.0, -2147483648));
    }
}
