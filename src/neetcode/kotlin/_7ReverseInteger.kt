package neetcode.kotlin

object _7ReverseInteger {
    fun reverse(x: Int): Int {
        println(x)
        val ans = solving(x)
        println(ans)
        if (ans > Int.MAX_VALUE || ans < Int.MIN_VALUE) return 0
        return ans.toInt()
    }

    private fun solving(num: Int): Long {
        var num = num
        var ans: Long = 0
        while (num != 0) {
            val rem = num % 10
            ans = (ans * 10) + rem
            num /= 10
        }
        return ans
    }

    fun reverse1(x: Int): Int {
        val isNeg = if (x >= 0) false else true
        var xn = x.toDouble()
        xn = if (isNeg) 0.0 - xn else xn
        val s = xn.toString() + ""
        var ss = ""
        for (i in 0 until s.length) {
            ss = s[i].toString() + ss
        }
        try {
            xn = ss.toDouble()
        } catch (e: Exception) {
            return 0
        }
        xn = if (isNeg) -xn else xn
        if (xn >= Int.MIN_VALUE && xn < Int.MAX_VALUE) {
            return xn.toInt()
        }
        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val res = reverse(-2147483648)
        println(res)
    }
}
