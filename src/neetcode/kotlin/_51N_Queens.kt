package neetcode.kotlin

class _51N_Queens {
    var lists: MutableList<List<String>> = ArrayList()
    var l: MutableList<String> = ArrayList()
    var ss: StringBuilder = StringBuilder()

    fun solveNQueens1(n: Int): List<List<String>> {
        val col = BooleanArray(n)
        val posSlope = BooleanArray(n * 2 - 1)
        val negSlope = BooleanArray(n * 2 - 1)
        ss.append(".".repeat(n))
        Helper(n, col, posSlope, negSlope, 0)
        return lists
    }

    fun Helper(len: Int, col: BooleanArray, posSlope: BooleanArray, negSlope: BooleanArray, i: Int) {
        if (l.size == len) {
            lists.add(ArrayList(l))
            return
        }
        for (n in 0 until len) {
            if (!col[n] && !posSlope[i + n] && !negSlope[i - n + len - 1]) {
                negSlope[i - n + len - 1] = true
                posSlope[i + n] = negSlope[i - n + len - 1]
                col[n] = posSlope[i + n]
                val sss = StringBuilder(ss)
                l.add(sss.replace(n, n + 1, "Q").toString())
                Helper(len, col, posSlope, negSlope, i + 1)
                negSlope[i - n + len - 1] = false
                posSlope[i + n] = negSlope[i - n + len - 1]
                col[n] = posSlope[i + n]
                l.removeAt(l.size - 1)
            }
            if (n + 1 == len) return
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    fun solveNQueens(n: Int): List<List<String>> {
        val board = Array(n) { CharArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                board[i][j] = '.'
            }
        }
        val res: MutableList<List<String>> = ArrayList()
        val col = BooleanArray(n)
        val pos = BooleanArray(n * 2 - 1)
        val neg = BooleanArray(n * 2 - 1)
        Help(0, n, board, col, pos, neg, res)
        return res
    }

    protected fun Help(
        i: Int,
        n: Int,
        board: Array<CharArray>,
        col: BooleanArray,
        pos: BooleanArray,
        neg: BooleanArray,
        res: MutableList<List<String>>
    ) {
        if (i == n) {
            res.add(join(board))
            return
        }
        for (j in 0 until n) {
            if (!col[j] && !pos[i + j] && !neg[i - j + n - 1]) {
                board[i][j] = 'Q'
                neg[i - j + n - 1] = true
                pos[i + j] = neg[i - j + n - 1]
                col[j] = pos[i + j]
                Help(i + 1, n, board, col, pos, neg, res)
                neg[i - j + n - 1] = false
                pos[i + j] = neg[i - j + n - 1]
                col[j] = pos[i + j]
                board[i][j] = '.'
            }
            if (j + 1 == n) return
        }
    }

    protected fun join(b: Array<CharArray>): List<String> {
        val l: MutableList<String> = ArrayList()
        for (chars in b) {
            val str = String(chars)
            l.add(str)
        }
        return l
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _51N_Queens()
            println(obj.solveNQueens(4))
        }
    }
}
