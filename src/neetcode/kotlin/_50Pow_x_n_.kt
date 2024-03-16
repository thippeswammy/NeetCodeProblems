package neetcode.kotlin

import kotlin.math.pow

class _50Pow_x_n_ {
    fun myPow1(x: Double, n: Int): Double {
        return x.pow(n.toDouble())
    }

    fun myPow(x: Double, n: Int): Double {
        if (n == 0) return 1.0
        if (n == 1) return x
        return if (n > 0) {
            if (n % 2 == 0) myPow(x * x, n / 2) else x * myPow(x * x, n / 2)
        } else if (n == Int.MIN_VALUE) {
            myPow(x * x, n / 2)
        } else {
            myPow(1.0 / x, -1 * n)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _50Pow_x_n_()
            println(obj.myPow(2.0, -2147483648))
        }
    }
}
