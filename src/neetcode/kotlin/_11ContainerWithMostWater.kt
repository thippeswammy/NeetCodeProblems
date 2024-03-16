package neetcode.kotlin

import kotlin.math.min

object _11ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var s = 0
        var e = height.size - 1
        var maxLevel = 0
        var lev = 0
        while (s < e) {
            lev = ((e - s) * min(height[s].toDouble(), height[e].toDouble())).toInt()
            if (lev > maxLevel) maxLevel = lev
            if (height[e] > height[s]) s++ else e--
        }
        return maxLevel
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(1, 1)
        val res = maxArea(arr)
        println(res)
    }
}
