package neetcode.kotlin

object _12IntegertoRoman {
    fun intToRoman(num: Int): String {
        var num = num
        val `val` = arrayOf(
            "I", "IV", "V", "IX", "X",
            "XL", "L", "XC", "C", "CD", "D", "CM", "M",
        )
        val key = intArrayOf(
            1, 4, 5, 9, 10, 40,
            50, 90, 100, 400, 500, 900, 1000
        )
        val s = StringBuilder()
        var i = key.size - 1
        while (i >= 0 && num != 0) {
            if (num / key[i] >= 1) {
                s.append(`val`[i])
                num = num - key[i]
                continue
            }
            i--
        }
        return s.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val res = intToRoman(1994)
        println(res)
    }
}
