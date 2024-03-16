package neetcode.Java;

public class _3LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int longLength = 1, i = 0, n = 0, j;
        for (; i < s.length() - 1; i++, n = i + 1) {
            Task:
            for (; n < s.length(); ) {

                for (j = i; j < n; j++) {

                    if (s.charAt(j) == (s.charAt(n))) {
                        longLength = Math.max(longLength, n - i);
                        n = n + 1;
                        break Task;
                    }
                }
                if (j == n) {
                    n++;
                    longLength = Math.max(longLength, n - i);
                }
            }
            if (n == s.length()) return longLength;
        }
        return (longLength);
    }

    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);
    }
}
