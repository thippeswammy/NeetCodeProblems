package neetcode.kotlin

class _38CountAndSay {
    fun countAndSay(n: Int): String {
        return Helper(n)
    }

    fun Helper(n: Int): String {
        if (n == 1) return "1"
        val s = Helper(n - 1) + " "
        val ss = StringBuilder()
        var c = 1
        for (i in 0 until s.length - 1) {
            val ch = s[i]
            if (ch == s[i + 1]) {
                c++
            } else {
                ss.append(c).append(ch)
                c = 1
            }
        }
        return ss.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _38CountAndSay()
            println(obj.countAndSay(4))
        }
    }
}
