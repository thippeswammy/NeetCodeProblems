package neetcode.kotlin

import kotlin.math.max

class _44WildcardMatching {
    var s_len: Int = 0
    var p_len: Int = 0

    fun isMatch(s: String, p: String): Boolean {
        s_len = s.length
        p_len = p.length
        return Helper(s, p, 0, 0)
    }

    fun Helper(s: String, p: String, i: Int, n: Int): Boolean {
        var n = n
        if (i == s_len && n == p_len) return true
        if (s_len != i && p_len == n) return false
        if (i < s_len && (s[i] == p[n] || p[n] == '?')) return Helper(s, p, i + 1, n + 1)
        if (p[n] == '*') {
            while (n < p_len - 1 && p[n + 1] == '*') {
                n++
            }
            return if (i < s_len && s_len - i >= p_len - n) (Helper(s, p, i + 1, n)
                    || Helper(s, p, i, n + 1))
            else Helper(s, p, i, n + 1)
        }
        return false
    }

    fun isMatch1(s: String, p: String): Boolean {
        val a = StringBuilder()
        var j = 0
        while (j + 1 < p.length) {
            if (p[j] == '*' && p[j + 1] == '*') j++
            else a.append(p[j++])
        }
        if (!p.isEmpty()) a.append(p[j])
        val dp = Array(s.length) { IntArray(a.length) }
        return Help(s, a.toString(), 0, 0, dp) == 1
    }

    private fun Help(s: String, p: String, i: Int, j: Int, dp: Array<IntArray>): Int {
        if (i == s.length && j == p.length) return 1
        if (i == s.length && p[j] == '*') return Help(s, p, i, j + 1, dp)
        if (i == s.length || j == p.length) return -1
        if (dp[i][j] != 0) return dp[i][j]
        if (s[i] == p[j] || p[j] == '?') return Help(s, p, i + 1, j + 1, dp).also { dp[i][j] = it }
        if (p[j] != '*') return -1.also { dp[i][j] = it }
        return max(
            Help(s, p, i + 1, j, dp).toDouble(),
            max(
                Help(s, p, i + 1, j + 1, dp).toDouble(),
                Help(s, p, i, j + 1, dp).toDouble()
            )
        ).also { dp[i][j] = it.toInt() }.toInt().toInt()
    }


    fun isMatch2(s: String, p: String): Boolean {
        val m = s.length
        val n = p.length

        // Create a 2D array to store the intermediate results of matching.
        val dp = Array(m + 1) { BooleanArray(n + 1) }
        dp[0][0] = true // Empty string matches empty pattern.

        // Fill in the first row of the dp array.
        for (j in 0 until n) {
            if (p[j] == '*') {
                dp[0][j + 1] = dp[0][j]
            }
        }
        // Fill in the rest of the dp array.
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (p[j] == '*') {
                    // '*' can either match one character or an empty sequence.
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j]
                } else if (p[j] == '?' || s[i] == p[j]) {
                    // '?' matches any single character, or characters match.
                    dp[i + 1][j + 1] = dp[i][j]
                }
            }
        }
        return dp[m][n]
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _44WildcardMatching()
            println(obj.isMatch("abva", "*a*a"))
            println(obj.isMatch1("abva", "*a*a"))
            println(obj.isMatch2("abva", "*a*a"))
        }
    }
}
