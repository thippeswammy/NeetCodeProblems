package neetcode.Java;

public class _5LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        String _longStr = "";
        int _longS = 1;
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            int start = i, end = i;
            while (start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
                if (end - start >= _longS) {
                    _longStr = s.substring(start, end + 1);
                    _longS = end - start;
                }
                start--;
                end++;
            }
            start = i;
            end = i + 1;
            while (start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
                if (end - start >= _longS) {
                    _longStr = s.substring(start, end + 1);
                    _longS = end - start;
                }
                start--;
                end++;
            }
        }
        return _longStr;
    }

    //if (len < 3 && s.charAt(0) == s.charAt(1)) return s;
    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) return s;
        String longStr = s.charAt(0) + "";
        int LongStr = 0;
        for (int i = 0; i < len && (len - i - 1) > LongStr; i++) {
            for (int n = len - 1; n > i && ((n - i) > LongStr); n--) {
                String NewlongStr = check(s.substring(i, n + 1));
                if (NewlongStr != "") {
                    if ((n - i) > LongStr) {
                        longStr = NewlongStr;
                        LongStr = n - i;
                    }
                }
            }
        }
        return longStr;
    }

    public static String check(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return "";
            l++;
            r--;
        }
        return s;
    }


    public static void main(String[] args) {
        String s = longestPalindrome("cbbd");
        System.out.println(s);
    }
}
