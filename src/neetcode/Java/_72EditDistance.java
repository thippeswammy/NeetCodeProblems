package neetcode.Java;

public class _72EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) dp[i][dp[0].length - 1] = dp.length - 1 - i;
        for (int i = 0; i < dp[0].length; i++) dp[dp.length - 1][i] = dp[0].length - 1 - i;
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int n = dp[0].length - 2; n >= 0; n--) {
                if (word1.charAt(i) == word2.charAt(n)) dp[i][n] = dp[i + 1][n + 1];
                else dp[i][n] = Math.min(Math.min(dp[i + 1][n], dp[i][n + 1]), dp[i + 1][n + 1]) + 1;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        _72EditDistance obj = new _72EditDistance();
        System.out.println("OUTPUT = " + obj.minDistance("abd", "acd"));
        System.out.println("OUTPUT = " + obj.minDistance("spartan", "part"));
        System.out.println("OUTPUT = " + obj.minDistance("mart", "karma"));
        System.out.println("OUTPUT = " + obj.minDistance("abpp", "abh"));
        System.out.println("OUTPUT = " + obj.minDistance("hor", "ros"));
        System.out.println("OUTPUT = " + obj.minDistance("acl", "acd"));
        System.out.println("OUTPUT = " + obj.minDistance("intention", "execution"));
    }
}
