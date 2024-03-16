package neetcode.kotlin

class _29DivideTwoIntegers {
    fun divide(dividend: Int, divisor: Int): Int {
        var a = dividend.toLong()
        var b = divisor.toLong()
        if (b == -1L && a <= -Int.MAX_VALUE) return Int.MAX_VALUE
        if (b == -1L) return -dividend
        if (b == 1L) return dividend
        var isNeg = false
        if (a < 0) {
            isNeg = !isNeg
            a = -a
        }
        if (b < 0) {
            isNeg = !isNeg
            b = -b
        }
        var k: Long = 0
        while (a >= b) {
            a -= b
            k++
        }
        if (k >= Int.MAX_VALUE.toLong()) return if (isNeg) -Int.MAX_VALUE
        else Int.MAX_VALUE
        return if (isNeg) -k.toInt() else k.toInt()
    }

    fun divide1(dividend: Int, divisor: Int): Int {
        if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE
        if (dividend == Int.MIN_VALUE && divisor == 1) return Int.MIN_VALUE
        val sub = dividend % divisor
        return (dividend - sub) / divisor
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _29DivideTwoIntegers()
            println(obj.divide(-2147483648, -1))
            println(obj.divide1(-2147483648, 1))
        }
    }
}
