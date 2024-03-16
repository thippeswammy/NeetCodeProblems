package neetcode.kotlin

object _9PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        var x = x
        if (x < 0) {
            return false
        }
        val ref = x
        var rev = 0
        while (x != 0) {
            rev = 10 * rev + x % 10
            x = x / 10
        }
        return ref == rev
    }

    fun isPalindrome1(x: Int): Boolean {
        if (x == 0) return true
        if (x % 10 == 0 || x < 0) return false
        var i = 0
        val s = x.toString() + ""
        val len = s.length - 1
        while (i <= len / 2) {
            if (s[i] != s[len - i]) return false
            i++
        }
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val `val` = isPalindrome(-212)
        println(`val`)
    }
}
