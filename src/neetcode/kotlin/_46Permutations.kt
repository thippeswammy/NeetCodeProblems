package neetcode.kotlin

class _46Permutations {
    var list: MutableList<List<Int>> = ArrayList()

    fun permute(nums: IntArray): List<List<Int>> {
        val li: ArrayList<*> = ArrayList<Any>()
        for (i in nums) li.add(i as Nothing)
        Helper(li, ArrayList())
        return list
    }

    fun Helper(nums: ArrayList<*>, l: ArrayList<Int>) {
        if (nums.size == 0) {
            list.add(ArrayList(l))
            return
        }
        for (n in nums.indices) {
            val `val` = nums[n]
            l.add(`val` as Int)
            nums.removeAt(n)
            Helper(nums, l)
            nums.add(n, `val` as Nothing)
            l.removeAt(l.size - 1)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _46Permutations()
            val nums = intArrayOf(1, 2, 3)
            println(obj.permute(nums))
        }
    }
}
