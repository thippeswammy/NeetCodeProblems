package neetcode.kotlin

class _28FindIndexFirstOccurrenceString {
    fun strStr(haystack: String, needle: String): Int {
        val arr = haystack.toCharArray()
        val tar = needle.toCharArray()
        Task@ for (i in 0 until arr.size - tar.size) {
            for (n in tar.indices) {
                if (tar[n] != arr[i + n]) continue@Task
            }
            return i
        }
        return -1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _28FindIndexFirstOccurrenceString()
            println(obj.strStr("sadbutsad", "sad"))
        }
    }
}
