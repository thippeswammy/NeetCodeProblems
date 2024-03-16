package neetcode.kotlin

class _48RotateImage {
    fun rotate1(matrix: Array<IntArray>): Array<IntArray> {
        var l = 0
        var r = matrix.size - 1
        var t = l
        var b = r
        while (t <= b) {
            l = t
            r = b
            while (r > t) {
                val tem = matrix[t][l]
                matrix[t][l] = matrix[r][t]
                matrix[r][t] = matrix[b][r]
                matrix[b][r] = matrix[l][b]
                matrix[l][b] = tem
                l++
                r--
            }
            t++
            b--
        }
        return matrix
    }

    fun rotate(matrix: Array<IntArray>): Array<IntArray> {
        var l = 0
        var r = matrix.size - 1
        while (l < r) {
            for (i in 0 until r - l) {
                val topLeft = matrix[l][l + i]
                matrix[l][l + i] = matrix[r - i][l]
                matrix[r - i][l] = matrix[r][r - i]
                matrix[r][r - i] = matrix[l + i][r]
                matrix[l + i][r] = topLeft
            }
            l++
            r--
        }
        return matrix
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _48RotateImage()
            val matrix = arrayOf(
                intArrayOf(5, 1, 9, 11),
                intArrayOf(2, 4, 8, 10),
                intArrayOf(13, 3, 6, 7),
                intArrayOf(15, 14, 12, 16)
            )

            run {
                val rs = obj.rotate(matrix)
                for (i in matrix) {
                    for (n in i) print("$n    ")
                    println("")
                }
            }
            println()
            println()

            run {
                run {
                    val rs = obj.rotate1(matrix)
                    for (i in matrix) {
                        for (n in i) print("$n    ")
                        println("")
                    }
                }
            }
        }
    }
}
