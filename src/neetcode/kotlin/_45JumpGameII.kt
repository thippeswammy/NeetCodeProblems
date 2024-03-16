package neetcode.kotlin

import kotlin.math.min

class _45JumpGameII {
    fun jump(nums: IntArray): Int {
        if (nums.size == 1) return 0
        var i = 0
        var no_step = 1
        while (true) {
            if (nums[i] == 0) nums[i] = 1
            var pos = i + nums[i]
            var max = i + nums[i]
            if (pos >= nums.size - 1) return no_step
            //Finding the best position for next jump
            var n = i + 1
            while (n <= i + nums[i] && n < nums.size) {
                if (nums[n] + n > max) {
                    max = nums[n] + n
                    pos = n
                }
                n++
            }
            i = pos
            no_step++
        }
    }


    fun jump1(nums: IntArray): Int {
        if (nums.size == 1) return 0
        var i = 0
        var no_step = 1
        while (true) {
            if (nums[i] == 0) nums[i] = 1
            var pos = i + nums[i]
            var max = i + nums[i]
            if (pos >= nums.size - 1) break
            //Finding the best position for next jump
            var n = i + 1
            while (n <= i + nums[i] && n < nums.size) {
                if (nums[n] + n > max) {
                    max = nums[n] + n
                    pos = n
                }
                n++
            }
            i = pos
            no_step++
        }
        return no_step
    }

    fun jump2(nums: IntArray): Int {
        return Help2(nums, 0, 0)
    }

    fun Help2(nums: IntArray, i: Int, min: Int): Int {
        if (i >= nums.size - 1) return min
        if (i + nums[i] >= nums.size - 1) return min + 1
        var max_len = nums.size
        var max_dis = 0
        var next_pos = i + 1
        for (n in i + 1..nums[i] + i) {
            if (n < nums.size && max_dis <= nums[n] + n) {
                next_pos = n
                max_dis = nums[n] + n
            }
        }
        max_len = min(Help2(nums, next_pos, min + 1).toDouble(), max_len.toDouble()).toInt()
        return max_len
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _45JumpGameII()
            run {
                val num = intArrayOf(3, 4, 3, 2, 5, 4, 3)
                println(obj.jump1(num))
            }
            run {
                val num = intArrayOf(3, 4, 3, 2, 5, 4, 3)
                println(obj.jump(num))
            }
            run {
                val num = intArrayOf(1, 1, 1, 1)
                println(obj.jump(num))
            }
            run {
                val num = intArrayOf(2, 0)
                println(obj.jump(num))
            }
            run {
                val num = intArrayOf(1, 1)
                println(obj.jump(num))
            }
            run {
                val num = intArrayOf(1, 2)
                println(obj.jump(num))
            }
            run {
                val num = intArrayOf(2, 3, 1, 1, 4)
                println(obj.jump(num))
            }
            run {
                val num = intArrayOf(2, 3, 0, 1, 4)
                println(obj.jump(num))
            }
        }
    }
}
