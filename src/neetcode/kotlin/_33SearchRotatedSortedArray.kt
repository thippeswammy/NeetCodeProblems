package neetcode.kotlin

class _33SearchRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        var mid: Int
        while (l <= r) {
            mid = (l + r) / 2
            val MidVal = nums[mid]
            if (MidVal == target) return mid
            if (MidVal > nums[r]) {
                //I am in left part side
                if (target > MidVal) l = mid + 1
                else if (target < nums[l]) l = mid + 1
                else r = mid - 1
            } else {
                //I, am in right part side
                if (MidVal > target) r = mid - 1
                else if (target > nums[r]) r = mid - 1
                else l = mid + 1
            }
        }
        return -1
    }

    fun search1(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        var mid: Int
        while (l <= r) {
            mid = (l + r) / 2
            val MidVal = nums[mid]
            if (MidVal == target) return mid
            if (MidVal > nums[r]) {
                //I am in left part side
                if (target > MidVal || target < nums[l]) l = mid + 1
                else r = mid - 1
            } else {
                //I am in right part side
                if (MidVal > target || target > nums[r]) r = mid - 1
                else l = mid + 1
            }
        }
        return -1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _33SearchRotatedSortedArray()
            val num = intArrayOf(4, 5, 6, 7, 8, 1, 2, 3)
            for (i in num.indices) {
                println(num[i].toString() + "    " + obj.search(num, num[i]) + " ->>  " + i)
                println(num[i].toString() + "    " + obj.search1(num, num[i]) + " ->>  " + i)
            }
        }
    }
}
