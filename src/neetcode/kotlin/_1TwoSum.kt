package neetcode.kotlin

object _1TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 1 until nums.size) {
            var j = 0
            while (j + i < nums.size) {
                if (nums[j + i] + nums[j] == target) {
                    return intArrayOf(j, j + i)
                }
                j++
            }
        }
        return intArrayOf()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val num = intArrayOf(2, 7, 11, 15)
        val a = twoSum(num, 9)
        println(a[0].toString() + " " + a[1])
    }
}
