package neetcode.kotlin

class _34FindFirstLastPositionElementSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var l = 0
        var r = nums.size - 1
        var mid: Int
        while (l <= r) {
            mid = (l + r) / 2
            if (nums[mid] == target) {
                l = mid
                r = mid
                while (l > 0 && nums[l - 1] == target) l--
                while (r < nums.size - 1 && nums[r + 1] == target) r++
                return intArrayOf(l, r)
            } else if (nums[mid] > target) r = mid - 1
            else l = mid + 1
        }
        return intArrayOf(-1, -1)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _34FindFirstLastPositionElementSortedArray()

            run {
                val nums = intArrayOf(5, 7, 7, 8, 8, 10)
                val num = obj.searchRange(nums, 8)
                for (i in num) println("$i ")
            }

            run {
                val nums = intArrayOf(2, 2)
                val num = obj.searchRange(nums, 2)
                for (i in num) println("$i ")
            }
        }
    }
}
