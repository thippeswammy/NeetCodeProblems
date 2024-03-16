package neetcode.kotlin

import kotlin.math.max

class _6ZigzagConversion {
    fun convert2(s: String, numRows: Int): String {
        if (numRows == 1 || s.length == 1) return s

        var rs = ""
        for (i in 0 until numRows) {
            var pos = i
            var pro = if (i == 0 || i == numRows - 1) {
                0
            } else {
                i
            }
            while (pos < s.length) {
                if (pro == 0) {
                    rs = rs + s[pos]
                    pos = pos + (numRows - 1) * 2
                } else {
                    rs = rs + s[pos]
                    pos = pos + (numRows - 1) * 2 - pro * 2
                    if (pos < s.length) {
                        rs = rs + s[pos]
                        pos = pos + pro * 2
                    }
                }
            }
        }
        return rs
    }

    companion object {
        fun convert(s: String, numRows: Int): String {
            val n = s.length
            val arr = arrayOfNulls<StringBuffer>(numRows)
            for (i in 0 until numRows) arr[i] = StringBuffer()
            var i = 0
            while (i < n) {
                run {
                    var ind = 0
                    while (ind < numRows && i < n) {
                        arr[ind]!!.append(s[i++])
                        ind++
                    }
                }
                var ind = numRows - 2
                while (ind > 0 && i < n) {
                    arr[ind]!!.append(s[i++])
                    ind--
                }
            }
            val ans = StringBuffer()
            for (e in arr) {
                ans.append(e)
            }
            return ans.toString()
        }

        fun convert1(s: String, numRows: Int): String {
            println((1 % 3).toString() + " " + 5 % 3)
            if (s.length <= 2) return s
            if (numRows <= 1) return s
            val len = s.length
            var ss = ""
            val jump = max((numRows + numRows - 2).toDouble(), 1.0).toInt()
            run {
                var i = 0
                while (i < len) {
                    ss += s[i]
                    i = i + jump
                }
            }
            var j = 1
            while (j < (numRows - 1)) {
                var i = j
                while (true) {
                    if (i < len) ss = ss + s[i]
                    else break
                    i += jump - j * 2 //long jump
                    if (i < len) ss = ss + s[i] //short jump
                    else break
                    i += j * 2
                }
                j++
            }
            var i = numRows - 1
            while (i < len) {
                ss += s[i]
                i = i + jump
            }
            return ss
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val s = convert("ABCDEFGHIJKLMNOPQRSTWXYZ", 5)
            println(s)
        }
    }
}
