package neetcode.kotlin

import java.util.*

object _15ThreeSum {
    fun threeSum1(nums: IntArray): List<List<Int>> {
        val list: MutableList<List<Int>> = ArrayList()
        Arrays.sort(nums)
        val len = nums.size
        for (i in 0 until len) {
            val v1 = nums[i]
            if (i - 1 >= 0 && v1 <= nums[i - 1]) continue
            var s = i + 1
            var e = len - 1
            while (s < e) {
                val v2 = nums[s]
                val v3 = nums[e]
                val vv2 = nums[s - 1]
                val vv3 = nums[e - 1]
                if (s - 1 != i && v2 <= vv2) {
                    s++
                    continue
                }
                if (e + 1 < len && v3 >= nums[e + 1]) {
                    e--
                    continue
                }
                val sum = v1 + v2 + v3
                if (sum == 0) {
                    val l: MutableList<Int> = ArrayList()
                    l.add(v1)
                    l.add(v2)
                    l.add(v3)
                    list.add(l)
                    s++
                } else if (sum > 0) {
                    e--
                } else {
                    s++
                }
            }
        }
        return list
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val list: MutableList<List<Int>> = ArrayList()
        Arrays.sort(nums)
        for (i in 0 until nums.size - 2) {
            if ((i >= 1) && (nums[i - 1] == nums[i])) {
                continue
            }
            var s = i + 1
            var e = nums.size - 1
            while (s < e) {
                val sum = nums[i] + nums[s] + nums[e]
                if (sum == 0) {
                    val l: MutableList<Int> = ArrayList()
                    l.add(nums[i])
                    l.add(nums[s])
                    l.add(nums[e])
                    list.add(l)
                    s++
                    while (nums[s] == nums[s - 1] && s < e) {
                        s++
                    }
                } else if (sum > 0) {
                    e--
                } else {
                    s++
                }
            }
        }
        return list
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val num = intArrayOf(-1, 0, 1, 2, -1, -4)
        val list = threeSum(num)
        println(list)
    }
}