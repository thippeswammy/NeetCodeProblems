package neetcode.kotlin

class _43MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        val result = StringBuilder()
        val len1 = num1.length
        val len2 = num2.length
        val dp = IntArray(len1 + len2)
        for (i in len2 - 1 downTo 0) {
            val ch2 = (num2[i].toString() + "").toInt()
            for (n in len1 - 1 downTo 0) {
                val sum = (num1[n].code - '0'.code) * ch2 + dp[i + n + 1]
                dp[i + n] += sum / 10
                dp[i + n + 1] = sum % 10
            }
        }
        for (i in dp) if (i > 0 || !result.isEmpty()) {
            result.append(i)
        }
        return if (result.isEmpty()) "0" else result.toString()
    }

    fun multiply1(num1: String, num2: String): String {
        val sb = StringBuilder()
        val len1 = num1.length
        val len2 = num2.length
        val pos = IntArray(len1 + len2)
        for (i in len1 - 1 downTo 0) for (j in len2 - 1 downTo 0) {
            val multiply = (num1[i].code - '0'.code) * (num2[j].code - '0'.code)
            val sum = multiply + pos[i + j + 1]
            pos[i + j] += sum / 10
            pos[i + j + 1] = sum % 10
        }

        for (p in pos) if (p > 0 || !sb.isEmpty()) sb.append(p)

        return if (sb.isEmpty()) "0" else sb.toString()
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _43MultiplyStrings()
            println(obj.multiply("9999", "99"))
            println(obj.multiply1("9999", "99"))
        }
    }
}
