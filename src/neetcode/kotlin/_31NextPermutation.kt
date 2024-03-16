package neetcode.kotlin

class _31NextPermutation {
    fun nextPermutation(nums: IntArray): IntArray {
        val len = nums.size
        var i = len - 1
        while (i > 0) {
            if (nums[i - 1] < nums[i]) break
            i--
        }
        var min = -1
        var j = len - 1
        var ind = len - 1
        while (j >= i && i != 0) {
            if ((min == -1 || min > nums[j]) && nums[i - 1] < nums[j]) {
                min = nums[j]
                ind = j
            }
            j--
        }
        j = ind
        if (i != 0) {
            val temp = nums[i - 1]
            nums[i - 1] = nums[j]
            nums[j] = temp
        }

        var k = i
        var kk = len - 1
        while (k < kk) {
            val temp = nums[k]
            nums[k] = nums[kk]
            nums[kk] = temp
            k++
            kk--
        }
        return nums
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _31NextPermutation()
            run {
                val num = obj.nextPermutation(intArrayOf(1, 2, 3))
                println()
                for (i in num) print("$i ")
            }
            run {
                val num = obj.nextPermutation(intArrayOf(1, 3, 2))
                println()
                for (i in num) print("$i ")
            }
            run {
                val num = obj.nextPermutation(intArrayOf(2, 1, 3))
                println()
                for (i in num) print("$i ")
            }
            run {
                val num = obj.nextPermutation(intArrayOf(2, 3, 1))
                println()
                for (i in num) print("$i ")
            }
            run {
                val num = obj.nextPermutation(intArrayOf(3, 1, 2))
                println()
                for (i in num) print("$i ")
            }
            run {
                val num = obj.nextPermutation(intArrayOf(3, 2, 1))
                println()
                for (i in num) print("$i ")
            }
        }
    }
}
