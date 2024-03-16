package neetcode.kotlin

object _14LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val lenStrs = strs.size
        var i = 0
        val len = strs[0].length
        Task@ while (i < len) {
            for (j in 1 until lenStrs) {
                if (i >= strs[j].length || strs[0][i] != strs[j][i]) break@Task
            }
            i++
        }
        return strs[0].substring(0, i)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val s = arrayOf("dog", "racecar", "car")
        val res = longestCommonPrefix(s)
        println(res)
    }
}
