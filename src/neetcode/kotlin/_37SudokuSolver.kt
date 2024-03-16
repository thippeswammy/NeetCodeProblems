package neetcode.kotlin

class _37SudokuSolver {
    fun solveSudoku(board: Array<CharArray>) {
        sodoku(board)
    }

    fun sodoku(board: Array<CharArray>): Boolean {
        for (i in 0..8) {
            for (j in 0..8) {
                if (board[i][j] == '.') {
                    var c = '1'
                    while (c <= '9') {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c
                            if (sodoku(board)) return true
                            else board[i][j] = '.'
                        }
                        c++
                    }
                    return false
                }
            }
        }
        return true
    }

    fun isValid(board: Array<CharArray>, row: Int, col: Int, c: Char): Boolean {
        for (i in 0..8) {
            if (board[i][col] == c) return false
            if (board[row][i] == c) return false
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _37SudokuSolver()
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
                obj.solveSudoku(board)
                for (i in board) {
                    for (n in i) {
                        print("$n   ")
                    }
                    println()
                }
            }
        }
    }
}
