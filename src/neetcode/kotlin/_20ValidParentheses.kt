package neetcode.kotlin

import java.util.*

class _20ValidParentheses {
    fun isValid(s: String): Boolean {
        if (s.length % 2 == 1) return false
        if (s[0] == ')' || s[0] == '}' || s[0] == ']') return false
        val map = HashMap<Char, Char>()
        map[']'] = '['
        map['}'] = '{'
        map[')'] = '('
        val st = Stack<Char>()
        for (i in 0 until s.length) {
            if (map.containsKey(s[i])) {
                if (!st.isEmpty() && map[s[i]] === st.peek()) st.pop()
                else return false
            } else st.push(s[i])
        }
        return st.isEmpty()
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _20ValidParentheses()
            println(obj.isValid("(){}}{"))
        }
    }
}
