package neetcode.kotlin

class _47PermutationsII {
    var list: MutableList<List<Int>> = ArrayList()
    var len: Int = 0

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
        }
        len = nums.size
        Helper(map, ArrayList())
        return list
    }

    fun Helper(map: HashMap<Int, Int>, sub: ArrayList<Int>) {
        if (sub.size == len) {
            list.add(ArrayList(sub))
            return
        }
        for (i in map.keys) {
            if (map[i]!! > 0) {
                sub.add(i)
                map[i] = map[i]!! - 1
                Helper(map, sub)
                sub.removeAt(sub.size - 1)
                map[i] = map[i]!! + 1
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _47PermutationsII()
            val nums = intArrayOf(1, 1, 2)
            println(obj.permuteUnique(nums))
        }
    }
}
