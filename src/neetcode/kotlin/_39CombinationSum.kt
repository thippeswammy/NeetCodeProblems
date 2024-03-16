package neetcode.kotlin

class _39CombinationSum {
    var list: MutableList<List<Int>> = ArrayList()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val l = ArrayList<Int>()
        Helper(0, candidates, target, l)
        return list
    }

    fun Helper(n: Int, num: IntArray, tar: Int, l: ArrayList<Int>) {
        if (tar == 0) {
            list.add(ArrayList(l))
            return
        }
        for (i in n until num.size) {
            if (tar - num[i] >= 0) {
                l.add(num[i])
                Helper(i, num, tar - num[i], l)
                l.removeAt(l.size - 1)
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _39CombinationSum()
            val num = intArrayOf(2, 3, 6, 7)
            val target = 7
            println(obj.combinationSum(num, target))
        }
    }
}
