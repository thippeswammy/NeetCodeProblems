package neetcode.kotlin

class _13RomantoInteger {
    fun romanToInt2(s: String): Int {
        val h1 = HashMap<Char, Int>()
        h1['I'] = 1
        h1['V'] = 5
        h1['X'] = 10
        h1['L'] = 50
        h1['C'] = 100
        h1['D'] = 500
        h1['M'] = 1000
        val alpha = s.toCharArray()
        var num = 0
        var pt = 0
        while (pt + 1 <= alpha.size) {
            if (pt == alpha.size - 1 || h1[alpha[pt]]!! >= h1[alpha[pt + 1]]!!) {
                num = num + h1[alpha[pt]]!!
                pt = pt + 1
            } else {
                num = num + h1[alpha[pt + 1]]!! - h1[alpha[pt]]!!
                pt = pt + 2
            }
        }
        return num
    }

    companion object {
        fun romanToInt1(s: String): Int {
            val `val` = arrayOf(
                "I", "IV", "V", "IX", "X",
                "XL", "L", "XC", "C", "CD", "D", "CM", "M",
            )
            val key = intArrayOf(
                1, 4, 5, 9, 10, 40,
                50, 90, 100, 400, 500, 900, 1000
            )
            var pos = 0
            val len = s.length
            var num = 0
            var i = key.size - 1
            while (i >= 0 && pos < len) {
                if (pos + 1 < len && (s[pos].toString() + "" + s[pos + 1] + "") == `val`[i]) {
                    pos += 2
                    num = num + key[i]
                    continue
                }
                if ((s[pos].toString() + "") == `val`[i]) {
                    pos++
                    num = num + key[i]
                    continue
                }
                i--
            }
            return num
        }

        fun romanToInt(s: String): Int {
            val `val` = arrayOf(
                "I", "IV", "V", "IX", "X",
                "XL", "L", "XC", "C", "CD", "D", "CM", "M",
            )
            val key = intArrayOf(
                1, 4, 5, 9, 10, 40,
                50, 90, 100, 400, 500, 900, 1000
            )
            val h1: HashMap<Any?, Any?> = HashMap<Any?, Any?>()
            h1["I"] = 1
            h1["IV"] = 4
            h1["V"] = 5
            h1["IX"] = 9
            h1["X"] = 10
            h1["XL"] = 40
            h1["L"] = 50
            h1["XC"] = 90
            h1["C"] = 100
            h1["CD"] = 400
            h1["D"] = 500
            h1["CM"] = 900
            h1["M"] = 1000
            val ss = s.toCharArray()
            var pos = 0
            val len = s.length
            var num = 0
            var i = key.size - 1
            while (i >= 0 && pos < len) {
                if (pos + 1 < len && (ss[pos].toString() + "" + ss[pos + 1]) == `val`[i]) {
                    pos += 2
                    num = num + key[i]
                    continue
                }
                if ((ss[pos].toString() + "") == `val`[i]) {
                    pos++
                    num = num + key[i]
                    continue
                }
                i--
            }
            return num
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val res = romanToInt("MCMXCIV")
            println(res)
        }
    }
}
