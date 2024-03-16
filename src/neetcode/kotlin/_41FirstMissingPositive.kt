package neetcode.kotlin

import java.util.*
import kotlin.math.abs

class _41FirstMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        var c = 1
        val len = nums.size
        Arrays.sort(nums)
        for (i in 0 until len) {
            if (nums[i] < 1) continue
            if (i > 0 && nums[i - 1] >= nums[i]) continue
            if (c == nums[i]) c++
            else return c
        }
        return c
    }

    fun firstMissingPositive1(nums: IntArray): Int {
        for (i in nums.indices) if (nums[i] < 0) nums[i] = 0
        for (i in nums.indices) {
            var ind = abs(nums[i].toDouble()).toInt()
            if (ind > 0 && ind <= nums.size) {
                ind--
                if (nums[ind] > 0) nums[ind] *= -1
                else if (nums[ind] == 0) nums[ind] = ((nums.size) + 1) * -1
            }
        }
        for (i in nums.indices) if (nums[i] >= 0) return i + 1
        return nums.size + 1
    }

    fun firstMissingPositive2(nums: IntArray): Int {
        val dp = IntArray(nums.size + 1)

        for (i in nums) {
            if (i > 0 && i <= nums.size) {
                dp[i]++
            }
        }
        for (i in 1 until nums.size + 1) {
            if (dp[i] == 0) {
                return i
            }
        }
        return nums.size + 1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _41FirstMissingPositive()

            run {
                val num = intArrayOf(1, 2, 0)
                println(obj.firstMissingPositive(num))
            }
            run {
                val num = intArrayOf(3, 4, -1, 2)
                println(obj.firstMissingPositive(num))
            }
            run {
                val num = intArrayOf(7, 8, 9, 11, 12)
                println(obj.firstMissingPositive(num))
            }
            run {
                val num = intArrayOf(0, 2, 2, 1, 1)
                println(obj.firstMissingPositive(num))
            }

            println("\n\n\n")

            run {
                val num = intArrayOf(1, 2, 0)
                println(obj.firstMissingPositive1(num))
            }
            run {
                val num = intArrayOf(3, 4, -1, 2)
                println(obj.firstMissingPositive1(num))
            }
            run {
                val num = intArrayOf(7, 8, 9, 11, 12)
                println(obj.firstMissingPositive1(num))
            }
            run {
                val num = intArrayOf(0, 2, 2, 1, 1)
                println(obj.firstMissingPositive1(num))
            }

            println("\n\n\n")

            run {
                val num = intArrayOf(1, 2, 0)
                println(obj.firstMissingPositive2(num))
            }
            run {
                val num = intArrayOf(3, 4, -1, 2)
                println(obj.firstMissingPositive2(num))
            }
            run {
                val num = intArrayOf(7, 8, 9, 11, 12)
                println(obj.firstMissingPositive2(num))
            }
            run {
                val num = intArrayOf(0, 2, 2, 1, 1)
                println(obj.firstMissingPositive2(num))
            }
        }
    }
}
