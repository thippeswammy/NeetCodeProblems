package neetcode.kotlin

class _22GenerateParentheses {
    var list: MutableList<String> = ArrayList()

    fun generateParenthesis(n: Int): List<String> {
        Helper("", n, n)
        return list
    }

    fun Helper(s: String, open: Int, close: Int) {
        if (open == 0 && close == 0) {
            list.add(s)
        }
        if (open > 0) Helper("$s(", open - 1, close)
        if (close > open) Helper("$s)", open, close - 1)
    }

    fun generateParenthesis1(n: Int): List<String> {
        val list: MutableList<String> = ArrayList()
        Helper("", n, list, 0, 0)
        return list
    }

    fun Helper(s: String, n: Int, list: MutableList<String>, np: Int, nc: Int) {
        if (np < n) {
            Helper("$s(", n, list, np + 1, nc)
        }
        if (nc < np) {
            Helper("$s)", n, list, np, nc + 1)
        }
        if (np == nc && np == n) {
            list.add(s)
        }
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _22GenerateParentheses()
            println(obj.generateParenthesis(3))
            println(obj.generateParenthesis1(3))
        }
    }
}
