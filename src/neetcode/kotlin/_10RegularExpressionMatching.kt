package neetcode.kotlin

class _10RegularExpressionMatching {
    var ss: String = ""
    var pp: String = ""
    var s_len: Int = 0
    var p_len: Int = 0

    fun isMatch(s: String, p: String): Boolean {
        ss = s
        pp = p
        s_len = s.length
        p_len = p.length
        return Find(0, 0)
    }

    fun Find(i: Int, j: Int): Boolean {
        if (ss.length == i && pp.length == j) return true
        if (ss.length != i && pp.length == j) return false
        if (j + 1 < p_len && pp[j + 1] == '*') {
            return if (i < s_len && (pp[j] == '.' || ss[i] == pp[j])) {
                Find(i, j + 2) || Find(i + 1, j)
            } else {
                Find(i, j + 2)
            }
        }
        if (i < s_len && (pp[j] == '.' || ss[i] == pp[j])) return Find(i + 1, j + 1)
        return false
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val _10RegularExpressionMatching: _10RegularExpressionMatching =
                neetcode.kotlin._10RegularExpressionMatching()
            val res = _10RegularExpressionMatching.isMatch("aa", "a")
            println(res)
        }
    }
}
