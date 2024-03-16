package neetcode.kotlin

import kotlin.math.max

object _3LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length <= 1) return s.length
        var longLength = 1
        var i = 0
        var n = 0
        var j: Int
        while (i < s.length - 1) {
            Task@ while (n < s.length) {
                j = i
                while (j < n) {
                    if (s[j] == (s[n])) {
                        longLength = max(longLength.toDouble(), (n - i).toDouble()).toInt()
                        n = n + 1
                        break@Task
                    }
                    j++
                }
                if (j == n) {
                    n++
                    longLength = max(longLength.toDouble(), (n - i).toDouble()).toInt()
                }
            }
            if (n == s.length) return longLength
            i++
            n = i + 1
        }
        return (longLength)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val res = lengthOfLongestSubstring("abcabcbb")
        println(res)
    }
}
