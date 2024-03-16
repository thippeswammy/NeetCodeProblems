package neetcode.Java;

public class _44WildcardMatching {
    int s_len, p_len;

    public boolean isMatch(String s, String p) {
        s_len = s.length();
        p_len = p.length();
        return Helper(s, p, 0, 0);
    }

    public boolean Helper(String s, String p, int i, int n) {
        if (i == s_len && n == p_len) return true;
        if (s_len != i && p_len == n) return false;
        if (i < s_len && (s.charAt(i) == p.charAt(n) || p.charAt(n) == '?'))
            return Helper(s, p, i + 1, n + 1);
        if (p.charAt(n) == '*') {
            for (; n < p_len - 1 && p.charAt(n + 1) == '*'; n++) ;
            if (i < s_len && s_len - i >= p_len - n)
                return (Helper(s, p, i + 1, n)
                        || Helper(s, p, i, n + 1));
            else
                return (Helper(s, p, i, n + 1));
        }
        return false;
    }

    public boolean isMatch1(String s, String p) {
        StringBuilder a = new StringBuilder();
        int j = 0;
        while (j + 1 < p.length()) {
            if (p.charAt(j) == '*' && p.charAt(j + 1) == '*')
                j++;
            else
                a.append(p.charAt(j++));
        }
        if (!p.isEmpty()) a.append(p.charAt(j));
        int[][] dp = new int[s.length()][a.length()];
        return Help(s, a.toString(), 0, 0, dp) == 1;
    }

    private int Help(String s, String p, int i, int j, int[][] dp) {
        if (i == s.length() && j == p.length()) return 1;
        if (i == s.length() && p.charAt(j) == '*') return Help(s, p, i, j + 1, dp);
        if (i == s.length() || j == p.length()) return -1;
        if (dp[i][j] != 0) return dp[i][j];
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return dp[i][j] = Help(s, p, i + 1, j + 1, dp);
        if (p.charAt(j) != '*') return dp[i][j] = -1;
        return dp[i][j] = Math.max(Help(s, p, i + 1, j, dp),
                Math.max(Help(s, p, i + 1, j + 1, dp),
                        Help(s, p, i, j + 1, dp)));
    }


    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();

        // Create a 2D array to store the intermediate results of matching.
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // Empty string matches empty pattern.

        // Fill in the first row of the dp array.
        for (int j = 0; j < n; j++) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j];
            }
        }
        // Fill in the rest of the dp array.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '*') {
                    // '*' can either match one character or an empty sequence.
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                    // '?' matches any single character, or characters match.
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        _44WildcardMatching obj = new _44WildcardMatching();
        System.out.println(obj.isMatch("abva", "*a*a"));
        System.out.println(obj.isMatch1("abva", "*a*a"));
        System.out.println(obj.isMatch2("abva", "*a*a"));
    }
}
