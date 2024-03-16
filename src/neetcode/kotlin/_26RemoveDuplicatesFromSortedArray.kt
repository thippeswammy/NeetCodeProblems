package neetcode.kotlin

class _26RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var k = 1
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                nums[k] = nums[i]
            } else {
                k++
            }
        }
        return k
    }

    fun removeDuplicates1(nums: IntArray): Int {
        var k = 1
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) {
            } else {
                nums[k++] = nums[i]
            }
        }
        return k
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _26RemoveDuplicatesFromSortedArray()
            val num = intArrayOf(1, 1, 3)
            println(obj.removeDuplicates(num))
        }
    }
}
