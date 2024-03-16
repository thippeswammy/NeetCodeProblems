package neetcode.kotlin

class _27RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (i in nums) {
            if (i == `val`) {
                nums[k++] = i
            }
        }
        return k
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _27RemoveElement()
            val num = intArrayOf(3, 2, 2, 3)
            val `val` = 3
            println(obj.removeElement(num, `val`))
        }
    }
}
