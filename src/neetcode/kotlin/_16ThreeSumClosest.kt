package neetcode.kotlin

import java.util.*

object _16ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        Arrays.sort(nums)
        var Sum = nums[0] + nums[1] + nums[2]
        var closeSum = Sum
        var diffrence: Int
        for (i in 0 until nums.size - 2) {
            if ((i >= 1) && (nums[i - 1] == nums[i])) continue
            var s = i + 1
            var e = nums.size - 1
            while (s < e) {
                Sum = nums[i] + nums[s] + nums[e]
                if (Sum == target) return Sum
                diffrence = Sum - target
                var closeDiffrence = closeSum - target
                closeDiffrence = if (closeDiffrence > 0) closeDiffrence else -closeDiffrence
                diffrence = if (diffrence > 0) diffrence else -diffrence
                if (closeDiffrence > diffrence) closeSum = Sum
                else if (Sum > target) e--
                else s++
            }
        }
        return closeSum
    }


    @JvmStatic
    fun main(args: Array<String>) {
        val num = intArrayOf(-100, -98, -2, -1)
        val res = threeSumClosest(num, -101)
        println(res)
    }
}
