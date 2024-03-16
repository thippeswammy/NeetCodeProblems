package neetcode.kotlin

object _5LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        if (s.length < 2) return s
        var _longStr = ""
        var _longS = 1
        val len = s.length
        for (i in 0 until s.length) {
            var start = i
            var end = i
            while (start >= 0 && end < len && s[start] == s[end]) {
                if (end - start >= _longS) {
                    _longStr = s.substring(start, end + 1)
                    _longS = end - start
                }
                start--
                end++
            }
            start = i
            end = i + 1
            while (start >= 0 && end < len && s[start] == s[end]) {
                if (end - start >= _longS) {
                    _longStr = s.substring(start, end + 1)
                    _longS = end - start
                }
                start--
                end++
            }
        }
        return _longStr
    }

    //if (len < 3 && s.charAt(0) == s.charAt(1)) return s;
    fun longestPalindrome1(s: String): String {
        val len = s.length
        if (len < 2) return s
        var longStr = s[0].toString() + ""
        var LongStr = 0
        var i = 0
        while (i < len && (len - i - 1) > LongStr) {
            var n = len - 1
            while (n > i && ((n - i) > LongStr)) {
                val NewlongStr = check(s.substring(i, n + 1))
                if (NewlongStr !== "") {
                    if ((n - i) > LongStr) {
                        longStr = NewlongStr
                        LongStr = n - i
                    }
                }
                n--
            }
            i++
        }
        return longStr
    }

    fun check(s: String): String {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            if (s[l] != s[r]) return ""
            l++
            r--
        }
        return s
    }


    @JvmStatic
    fun main(args: Array<String>) {
        val s = longestPalindrome("cbbd")
        println(s)
    }
}
