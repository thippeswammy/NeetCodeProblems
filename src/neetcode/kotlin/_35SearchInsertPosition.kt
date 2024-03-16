package neetcode.kotlin

class _35SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (target <= nums[0]) return 0
        var l = 0
        var r = nums.size - 1
        var mid: Int
        while (l <= r) {
            mid = (l + r) / 2
            if (mid > 0 && nums[mid] >= target && nums[mid - 1] < target) {
                return mid
            }
            if (nums[mid] > target) r = mid - 1
            else l = mid + 1
        }
        return if (target > nums[nums.size - 1]) nums.size else 0
    }

    fun searchInsert1(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        var mid: Int
        var result = nums.size
        while (low <= high) {
            mid = (low + high) / 2
            if (nums[mid] >= target) {
                result = mid
                high = mid - 1
            } else low = mid + 1
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _35SearchInsertPosition()
            run {
                val nums = intArrayOf(1, 2, 3, 4, 5, 10)
                val target = 2
                println(obj.searchInsert(nums, target))
            }
            run {
                val nums = intArrayOf(1, 2, 3, 4, 5, 10)
                val target = 2
                println(obj.searchInsert1(nums, target))
            }
        }
    }
}
