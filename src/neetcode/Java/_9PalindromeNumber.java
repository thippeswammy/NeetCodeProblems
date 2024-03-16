package neetcode.Java;

public class _9PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int ref = x;
        int rev = 0;
        while (x != 0) {
            rev = 10 * rev + x % 10;
            x = x / 10;
        }
        return ref == rev;
    }

    public static boolean isPalindrome1(int x) {
        if (x == 0) return true;
        if (x % 10 == 0 || x < 0) return false;
        int i = 0;
        String s = x + "";
        int len = s.length() - 1;
        while (i <= len / 2) {
            if (s.charAt(i) != s.charAt(len - i)) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean val = isPalindrome(-212);
        System.out.println(val);
    }
}
