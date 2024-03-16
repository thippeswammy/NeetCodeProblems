package neetcode.Java;

public class _69Sqrt_x {
    public int mySqrt1(int x) {
        return (int) Math.sqrt(x * 1.0);
    }

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int start = 1, end = (x / 2) + 1, sqrt = 0;
        long mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                start = (int) mid + 1;
                sqrt = (int) mid;
            } else {
                end = (int) mid - 1;
            }
        }
        return sqrt;
    }

    public static void main(String[] args) {
        _69Sqrt_x obj = new _69Sqrt_x();
        System.out.println(obj.mySqrt(4));
        System.out.println(obj.mySqrt(8));
    }
}
