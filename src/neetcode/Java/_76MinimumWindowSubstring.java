package neetcode.Java;

import java.util.*;
public class _76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        int have = 0, left = 0, min_result = Integer.MAX_VALUE;
        int[] res = new int[]{-1, -1};
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int need = countT.size();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            countS.put(c, countS.getOrDefault(c, 0) + 1);
            if (countT.containsKey(c) && countT.get(c).equals(countS.get(c))) have++;
            while (need == have) {
                if (right - left + 1 < min_result) {
                    res[0] = left;
                    res[1] = right;
                    min_result = right - left + 1;
                }
                char key = s.charAt(left);
                countS.put(key, countS.get(key) - 1);
                if (countT.containsKey(key) && countS.get(key) < countT.get(key)) have--;
                left++;
            }
        }
        return min_result == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

    public static void main(String[] args) {
        _76MinimumWindowSubstring obj = new _76MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(obj.minWindow("a", "a"));
        System.out.println(obj.minWindow("aa", "aa"));
    }
}
