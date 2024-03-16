package neetcode.kotlin

import java.util.*

class _18FourSum {
    var list: MutableList<List<Int>> = ArrayList()

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(nums)
        run(nums, target, 0, ArrayList(), 4)
        return list
    }

    fun run(nums: IntArray, target: Int, i: Int, l: MutableList<Int>, num: Int) {
        if (target == 0 && num == 0) {
            list.add(ArrayList(l))
            return
        }
        if (num == 0) {
            return
        }
        for (n in i until nums.size) {
            if (i != n && nums[n] <= nums[n - 1]) continue
            l.add(nums[n])
            run(nums, target - nums[n], n + 1, l, num - 1)
            l.removeAt(l.size - 1)
        }
    }

    fun fourSum1(nums: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(nums)
        val list: MutableList<List<Int>> = ArrayList()
        for (i in 0 until nums.size - 3) {
            if ((i > 0) && (nums[i - 1] == nums[i])) continue
            for (n in i + 1 until nums.size - 2) {
                if ((n > i + 1) && (nums[n - 1] == nums[n])) continue
                var s = n + 1
                var e = nums.size - 1
                while (s < e) {
                    val sum = nums[i] * 1.0 + nums[n] + nums[s] + nums[e]
                    if (sum == target.toDouble()) {
                        val l: MutableList<Int> = ArrayList()
                        l.add(nums[i])
                        l.add(nums[n])
                        l.add(nums[s])
                        l.add(nums[e])
                        list.add(l)
                        s++
                        e--
                        while (s < e && nums[s] == nums[s - 1]) s++
                        while (s < e && nums[e] == nums[e + 1]) e--
                    } else if (sum > target) {
                        e--
                    } else {
                        s++
                    }
                }
            }
        }
        return list
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val _18FourSum = _18FourSum()
            val num = intArrayOf(1, 0, -1, 0, -2, 2)
            println(_18FourSum.fourSum(num, 0))
            println(_18FourSum.fourSum1(num, 0))
        }
    }
}
