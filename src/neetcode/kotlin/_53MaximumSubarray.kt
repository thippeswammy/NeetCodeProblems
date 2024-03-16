package neetcode.kotlin

class _53MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var currSum = maxSum
        for (i in 1 until nums.size) {
            if (currSum < 0) currSum = 0
            currSum += nums[i]
            if (currSum > maxSum) {
                maxSum = currSum
            }
        }
        return maxSum
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _53MaximumSubarray()
            run {
                val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
                println(obj.maxSubArray(nums))
            }
            run {
                val nums = intArrayOf(5, 4, -1, 7, 8)
                println(obj.maxSubArray(nums))
            }
            run {
                val nums = intArrayOf(-2, -1)
                println(obj.maxSubArray(nums))
            }
            run {
                val nums = intArrayOf(-1, -2)
                println(obj.maxSubArray(nums))
            }
        }
    }
}
