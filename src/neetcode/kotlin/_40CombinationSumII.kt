package neetcode.kotlin

import java.util.*

class _40CombinationSumII {
    var list: MutableList<List<Int>> = ArrayList()

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(candidates)
        Helper(0, candidates, target, ArrayList())
        return list
    }

    fun Helper(n: Int, num: IntArray, tar: Int, l: ArrayList<Int>) {
        if (tar == 0) {
            list.add(ArrayList(l))
            return
        }
        var i = n
        while (i < num.size) {
            if (i != n) {
                while (i < num.size && (num[i - 1] == num[i])) {
                    i++
                }
                if (i >= num.size) return
            }
            if (tar - num[i] >= 0) {
                l.add(num[i])
                Helper(i + 1, num, tar - num[i], l)
                l.removeAt(l.size - 1)
            }
            i++
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _40CombinationSumII()
            run {
                val num = intArrayOf(10, 1, 2, 7, 6, 1, 5)
                val target = 8
                println(obj.combinationSum2(num, target))
            }
            run {
                val num = intArrayOf(1, 1)
                val target = 1
                println(obj.combinationSum2(num, target))
            }
        }
    }
}
