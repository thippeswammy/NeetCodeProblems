package neetcode.kotlin

import java.util.*
import kotlin.math.max

class _32LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        val st = Stack<Int>()
        st.add(-1)
        var max = 0
        for (i in 0 until s.length) {
            if (s[i] == '(') st.add(i)
            else {
                st.pop()
                if (st.isEmpty()) st.add(i)
                else max = max(max.toDouble(), (i - st.peek()).toDouble()).toInt()
            }
        }
        return max
    }

    fun longestValidParentheses1(s: String): Int {
        val st = Stack<Int>()
        st.push(-1)
        var max = 0
        for (i in 0 until s.length) {
            if (s[i] == '(') st.push(i)
            else {
                st.pop()
                if (!st.isEmpty()) max = max(max.toDouble(), (i - st.peek()).toDouble()).toInt()
                else st.push(i)
            }
        }
        return max
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _32LongestValidParentheses()
            val s = ")()(())"
            println(obj.longestValidParentheses(s))
            println(obj.longestValidParentheses1(s))
        }
    }
}
