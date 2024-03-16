package neetcode.kotlin

object _8StringtoInteger {
    fun myAtoi(s: String): Int {
        var s = s
        s = s.trim { it <= ' ' }
        if (s.isEmpty()) {
            return 0
        }
        var ans: Long = 0
        var neg = false


        for (i in 0 until s.length) {
            val ch = s[i]
            if (i == 0) {
                if (ch == '-') {
                    neg = true
                    continue
                } else if (ch == '+') {
                    continue
                }
            }
            if (ch >= '0' && ch <= '9') {
                val dig = ch.code - '0'.code
                ans = ans * 10 + dig
                if (neg) {
                    val check = -ans
                    if (check < Int.MIN_VALUE) {
                        return Int.MIN_VALUE
                    }
                } else if (ans > Int.MAX_VALUE) {
                    return Int.MAX_VALUE
                }
            } else {
                break
            }
        }
        if (neg) {
            ans = -ans
        }
        return ans.toInt()
    }

    fun myAtoi1(s: String): Int {
        var ss = ""
        var isPos = true
        for (i in 0 until s.length) {
            val ch = s[i]
            if (ch == ' ' && ss.length == 0) continue
            if (ch == '-') {
                if (ss.length >= 1) break
                isPos = false
                ss = "-"
                continue
            }
            if (ch == '+') {
                if (ss.length >= 1) break
                isPos = true
                ss = "+"
                continue
            }
            if (Character.isDigit(ch)) ss += ch
            else break
        }

        if (ss.length == 0) return 0
        if (ss.length == 1 && (ss[0] == '-' || ss[0] == '+')) return 0
        val ans: Long
        try {
            ans = if (isPos) ss.toLong()
            else ss.toLong()
        } catch (e: Exception) {
            return if (isPos) Int.MAX_VALUE
            else Int.MIN_VALUE
        }
        return if (ans > Int.MAX_VALUE) Int.MAX_VALUE
        else if (ans < Int.MIN_VALUE) Int.MIN_VALUE
        else ans.toInt()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val res = myAtoi("20000000000000000000")
        println(res)
    }
}
