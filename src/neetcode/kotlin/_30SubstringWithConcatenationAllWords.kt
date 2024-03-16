package neetcode.kotlin

class _30SubstringWithConcatenationAllWords {
    fun findSubstring1(s: String, words: Array<String>): List<Int> {
        val word_fer = HashMap<String, Int>()
        for (word in words) {
            word_fer[word] = 1 + word_fer.getOrDefault(word, 0)
        }
        val word_len = words[0].length
        val window_len = words.size * word_len
        val res: MutableList<Int> = ArrayList()
        for (i in 0 until s.length - window_len + 1) {
            val subStrFre = HashMap<String, Int>()
            var j: Int
            j = i
            while (j < i + window_len) {
                val currentStr = s.substring(j, j + word_len)
                if (!word_fer.containsKey(currentStr)) break
                subStrFre[currentStr] = subStrFre.getOrDefault(currentStr, 0) + 1
                if (subStrFre[currentStr]!! > word_fer[currentStr]!!) break
                j = j + word_len
            }
            if (j == i + window_len) res.add(i)
        }
        return res
    }

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val list: MutableList<Int> = ArrayList()
        val map = HashMap<String, Int>()
        val worlen = words.size
        val wind = words[0].length * worlen
        for (i in 0 until worlen) {
            if (map.containsKey(words[i])) {
                map[words[i]] = map[words[i]]!! + 1
            } else {
                map[words[i]] = 1
            }
        }
        for (i in 0..s.length - wind) {
            val submap = HashMap<String, Int>()
            var j = i
            while (j < i + wind) {
                val ss = s.substring(j, j + words[0].length)
                if (map.containsKey(ss)) {
                    if (submap.containsKey(ss)) {
                        submap[ss] = submap[ss]!! + 1
                    } else {
                        submap[ss] = 1
                    }
                } else {
                    break
                }
                j = j + words[0].length
            }
            if (map == submap) list.add(i)
        }
        return list
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _30SubstringWithConcatenationAllWords()
            val words = arrayOf("foo", "bar")
            println(obj.findSubstring("barfoothefoobarman", words))
        }
    }
}

