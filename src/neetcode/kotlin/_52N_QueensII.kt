package neetcode.kotlin

class _52N_QueensII {
    fun totalNQueens(n: Int): Int {
        val col = BooleanArray(n)
        val posSlope = BooleanArray(n * 2 - 1)
        val negSlope = BooleanArray(n * 2 - 1)
        return Helper(n, col, posSlope, negSlope, 0, 0, 0)
    }

    fun Helper(
        len: Int,
        col: BooleanArray,
        posSlope: BooleanArray,
        negSlope: BooleanArray,
        i: Int,
        l: Int,
        possible: Int
    ): Int {
        var possible = possible
        if (l == len) {
            return 1 + possible
        }
        for (n in 0 until len) {
            if (!col[n] && !posSlope[i + n] && !negSlope[i - n + len - 1]) {
                negSlope[i - n + len - 1] = true
                posSlope[i + n] = negSlope[i - n + len - 1]
                col[n] = posSlope[i + n]
                possible = Helper(len, col, posSlope, negSlope, i + 1, l + 1, possible)
                negSlope[i - n + len - 1] = false
                posSlope[i + n] = negSlope[i - n + len - 1]
                col[n] = posSlope[i + n]
            }
            if (n + 1 == len) return possible
        }
        return possible
    }

    ///////////////////////////////////////////////////////////
    private var res = 0

    fun totalNQueens1(n: Int): Int {
        Helper(n, 0, BooleanArray(n), BooleanArray(2 * n - 1), BooleanArray(2 * n - 1))
        return res
    }

    private fun Helper(n: Int, i: Int, cols: BooleanArray, diag1: BooleanArray, diag2: BooleanArray) {
        if (i == n) {
            ++res
            return
        }
        for (j in 0 until n) {
            if (cols[j] || diag1[i + j] || diag2[j - i + n - 1]) continue
            diag2[j - i + n - 1] = true
            diag1[i + j] = diag2[j - i + n - 1]
            cols[j] = diag1[i + j]
            Helper(n, i + 1, cols, diag1, diag2)
            diag2[j - i + n - 1] = false
            diag1[i + j] = diag2[j - i + n - 1]
            cols[j] = diag1[i + j]
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _52N_QueensII()
            println(obj.totalNQueens(8))
            println(obj.totalNQueens1(8))
        }
    }
}
