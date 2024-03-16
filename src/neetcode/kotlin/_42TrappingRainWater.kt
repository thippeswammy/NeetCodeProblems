package neetcode.kotlin

import kotlin.math.max
import kotlin.math.roundToInt

class _42TrappingRainWater {
    fun trap(height: IntArray): Int {
        var area = 0
        var l = 0
        var r = height.size - 1
        var LM = height[l]
        var RM = height[r]
        while (l <= r) {
            if (LM > RM) {
                area = (area +max(0.0, (RM - height[r])*1.0)).roundToInt()
            } else {
                area = (area+max(0.0, (LM - height[l])*1.0)).roundToInt()
            }
            if (height[r] > RM) RM = height[r]
            if (height[l] > LM) LM = height[l]
            if (LM > RM) r-- else l++
        }
        return area
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _42TrappingRainWater()
            run {
                val num = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
                println(obj.trap(num))
            }
            run {
                val num = intArrayOf(4, 2, 0, 3, 2, 5)
                println(obj.trap(num))
            }
            run {
                val num = intArrayOf(
                    6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3,
                    2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3
                )
                println(obj.trap(num))
            }
        }
    }
}
