package neetcode.Java;

import java.util.*;

public class _30SubstringWithConcatenationAllWords {
    public List<Integer> findSubstring1(String s, String[] words) {
        HashMap<String, Integer> word_fer = new HashMap<>();
        for (String word : words) {
            word_fer.put(word, 1 + word_fer.getOrDefault(word, 0));
        }
        int word_len = words[0].length(), window_len = words.length * word_len;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length() - window_len + 1; i++) {
            HashMap<String, Integer> subStrFre = new HashMap<>();
            int j;
            for (j = i; j < i + window_len; j = j + word_len) {
                String currentStr = s.substring(j, j + word_len);
                if (!word_fer.containsKey(currentStr)) break;
                subStrFre.put(currentStr, subStrFre.getOrDefault(currentStr, 0) + 1);
                if (subStrFre.get(currentStr) > word_fer.get(currentStr)) break;
            }
            if (j == i + window_len) res.add(i);
        }
        return res;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int worlen = words.length;
        int wind = words[0].length() * worlen;
        for (int i = 0; i < worlen; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        for (int i = 0; i <= s.length() - wind; i++) {
            HashMap<String, Integer> submap = new HashMap<>();
            for (int j = i; j < i + wind; j = j + words[0].length()) {
                String ss = s.substring(j, j + words[0].length());
                if (map.containsKey(ss)) {
                    if (submap.containsKey(ss)) {
                        submap.put(ss, submap.get(ss) + 1);
                    } else {
                        submap.put(ss, 1);
                    }
                } else {
                    break;
                }
            }
            if (map.equals(submap)) list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        _30SubstringWithConcatenationAllWords obj = new _30SubstringWithConcatenationAllWords();
        String[] words = {"foo", "bar"};
        System.out.println(obj.findSubstring("barfoothefoobarman", words));
    }
}

