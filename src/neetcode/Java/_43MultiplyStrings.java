package neetcode.Java;

public class _43MultiplyStrings {
    public String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        final int len1 = num1.length(), len2 = num2.length();
        int[] dp = new int[len1 + len2];
        for (int i = len2 - 1; i >= 0; i--) {
            int ch2 = Integer.parseInt(num2.charAt(i) + "");
            for (int n = len1 - 1; n >= 0; n--) {
                final int sum = (num1.charAt(n) - '0') * ch2 + dp[i + n + 1];
                dp[i + n] += sum / 10;
                dp[i + n + 1] = sum % 10;
            }
        }
        for (final int i : dp)
            if (i > 0 || !result.isEmpty()) {
                result.append(i);
            }
        return result.isEmpty() ? "0" : result.toString();
    }

    public String multiply1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int[] pos = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; --i)
            for (int j = len2 - 1; j >= 0; --j) {
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = multiply + pos[i + j + 1];
                pos[i + j] += sum / 10;
                pos[i + j + 1] = sum % 10;
            }

        for (final int p : pos)
            if (p > 0 || !sb.isEmpty())
                sb.append(p);

        return sb.isEmpty() ? "0" : sb.toString();
    }


    public static void main(String[] args) {
        _43MultiplyStrings obj = new _43MultiplyStrings();
        System.out.println(obj.multiply("9999", "99"));
        System.out.println(obj.multiply1("9999", "99"));
    }
}
