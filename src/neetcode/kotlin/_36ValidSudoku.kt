package neetcode.kotlin

class _36ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val s: Set<Int> = HashSet()
        for (i in board) {
            val set: MutableSet<Char> = HashSet()
            for (n in i) {
                if (n != '.') if (set.contains(n)) return false
                else set.add(n)
            }
        }
        for (i in board.indices) {
            val set: MutableSet<Char> = HashSet()
            for (n in board.indices) {
                if (board[n][i] != '.') if (set.contains(board[n][i])) return false
                else set.add(board[n][i])
            }
        }
        for (ii in 0..2) {
            for (nn in 0..2) {
                val set: MutableSet<Char> = HashSet()
                for (i in ii * 3 until 3 + ii * 3) {
                    for (n in nn * 3 until 3 + nn * 3) {
                        if (board[i][n] != '.') if (set.contains(board[i][n])) return false
                        else set.add(board[i][n])
                    }
                }
            }
        }
        return true
    }

    fun isValidSudoku1(board: Array<CharArray>): Boolean {
        val m1 = Array(9) { BooleanArray(9) }
        val m2 = Array(9) { BooleanArray(9) }
        val m3 = Array(9) { BooleanArray(9) }

        for (i in 0..8) for (j in 0..8) if (board[i][j] != '.') {
            val num = board[i][j].code - '0'.code - 1
            val k = i / 3 * 3 + j / 3

            if (m1[i][num] || m2[j][num] || m3[k][num]) return false

            m3[k][num] = true
            m2[j][num] = m3[k][num]
            m1[i][num] = m2[j][num]
        }

        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _36ValidSudoku()
            run {
                val board = arrayOf(
                    charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
                )
                println(obj.isValidSudoku(board))
            }
            run {
                val board = arrayOf(
                    charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
                )
                println(obj.isValidSudoku1(board))
            }
        }
    }
}
