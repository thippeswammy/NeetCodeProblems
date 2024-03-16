package neetcode.Java;

public class _29DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long a = dividend, b = divisor;
        if (b == -1 && a <= -Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (b == -1) return -dividend;
        if (b == 1) return dividend;
        boolean isNeg = false;
        if (a < 0) {
            isNeg = !isNeg;
            a = -a;
        }
        if (b < 0) {
            isNeg = !isNeg;
            b = -b;
        }
        long k = 0;
        while (a >= b) {
            a -= b;
            k++;
        }
        if (k >= (long) Integer.MAX_VALUE)
            if (isNeg) return -Integer.MAX_VALUE;
            else return Integer.MAX_VALUE;
        return isNeg ? -(int) k : (int) k;
    }

    public int divide1(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE&& divisor == 1)
            return Integer.MIN_VALUE;
        int sub = dividend % divisor;
        return (dividend - sub)/divisor;
    }

    public static void main(String[] args) {
        _29DivideTwoIntegers obj = new _29DivideTwoIntegers();
        System.out.println(obj.divide(-2147483648, -1));
        System.out.println(obj.divide1(-2147483648, 1));
    }
}
