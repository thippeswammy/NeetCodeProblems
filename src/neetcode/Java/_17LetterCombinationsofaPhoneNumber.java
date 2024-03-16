package neetcode.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17LetterCombinationsofaPhoneNumber {
    List<String> list = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<Character, String>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return list;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        run(digits, 0, "");
        return list;
    }

    public void run(String digits, int i, String s) {
        if (i == digits.length()) {
            list.add(s);
            return;
        }
        for (int n = 0; n < map.get(digits.charAt(i)).length(); n++) {
            run(digits, i + 1, s + map.get(digits.charAt(i)).charAt(n));
        }

    }


    public List<String> letterCombinations2(String digits) {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        map.put(" ", " ");
        if (digits.length() == 0) return list;
        if (digits.length() == 1) digits += "   ";
        if (digits.length() == 2) digits += "  ";
        if (digits.length() == 3) digits += " ";
        for (int i = 0; i < map.get(digits.charAt(0) + "").length(); i++) {
            //System.out.println(i+"RRRR111");
            for (int j = 0; j < map.get(digits.charAt(1) + "").length(); j++) {
                //System.out.println(i+"RRRR222");
                for (int n = 0; n < map.get(digits.charAt(2) + "").length(); n++) {
                    //System.out.println(i+"RRRR333");
                    for (int m = 0; m < map.get(digits.charAt(3) + "").length(); m++) {
                        // System.out.println(i+"RRRR444");
                        String ss = "";
                        ss = map.get(digits.charAt(0) + "").charAt(i) + "";
                        if (!map.get(digits.charAt(1) + "").equals(" ")) {
                            ss += map.get(digits.charAt(1) + "").charAt(j) + "";
                        }
                        if (!map.get(digits.charAt(2) + "").equals(" ")) {
                            ss += map.get(digits.charAt(2) + "").charAt(n) + "";
                        }
                        if (!map.get(digits.charAt(3) + "").equals(" ")) {
                            ss += map.get(digits.charAt(3) + "").charAt(m) + "";
                        }
                        list.add(ss);
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        _17LetterCombinationsofaPhoneNumber obj = new _17LetterCombinationsofaPhoneNumber();
        System.out.println(obj.letterCombinations("23"));
    }
}
