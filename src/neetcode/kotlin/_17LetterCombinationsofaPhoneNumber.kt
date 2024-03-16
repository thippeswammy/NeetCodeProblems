package neetcode.kotlin

class _17LetterCombinationsofaPhoneNumber {
    var list: MutableList<String> = ArrayList()
    var map: HashMap<Char, String> = HashMap()

    fun letterCombinations(digits: String): List<String> {
        if (digits.length == 0) return list
        map['2'] = "abc"
        map['3'] = "def"
        map['4'] = "ghi"
        map['5'] = "jkl"
        map['6'] = "mno"
        map['7'] = "pqrs"
        map['8'] = "tuv"
        map['9'] = "wxyz"
        run(digits, 0, "")
        return list
    }

    fun run(digits: String, i: Int, s: String) {
        if (i == digits.length) {
            list.add(s)
            return
        }
        for (n in 0 until map[digits[i]]!!.length) {
            run(digits, i + 1, s + map[digits[i]]!![n])
        }
    }


    fun letterCombinations2(digits: String): List<String> {
        var digits = digits
        val list: MutableList<String> = ArrayList()
        val map: MutableMap<String, String> = HashMap()
        map["2"] = "abc"
        map["3"] = "def"
        map["4"] = "ghi"
        map["5"] = "jkl"
        map["6"] = "mno"
        map["7"] = "pqrs"
        map["8"] = "tuv"
        map["9"] = "wxyz"
        map[" "] = " "
        if (digits.length == 0) return list
        if (digits.length == 1) digits += "   "
        if (digits.length == 2) digits += "  "
        if (digits.length == 3) digits += " "
        for (i in 0 until map[digits[0].toString() + ""]!!.length) {
            //System.out.println(i+"RRRR111");
            for (j in 0 until map[digits[1].toString() + ""]!!.length) {
                //System.out.println(i+"RRRR222");
                for (n in 0 until map[digits[2].toString() + ""]!!.length) {
                    //System.out.println(i+"RRRR333");
                    for (m in 0 until map[digits[3].toString() + ""]!!.length) {
                        // System.out.println(i+"RRRR444");
                        var ss = ""
                        ss = map[digits[0].toString() + ""]!![i].toString() + ""
                        if (map[digits[1].toString() + ""] != " ") {
                            ss += map[digits[1].toString() + ""]!![j].toString() + ""
                        }
                        if (map[digits[2].toString() + ""] != " ") {
                            ss += map[digits[2].toString() + ""]!![n].toString() + ""
                        }
                        if (map[digits[3].toString() + ""] != " ") {
                            ss += map[digits[3].toString() + ""]!![m].toString() + ""
                        }
                        list.add(ss)
                    }
                }
            }
        }

        return list
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _17LetterCombinationsofaPhoneNumber()
            println(obj.letterCombinations("23"))
        }
    }
}
