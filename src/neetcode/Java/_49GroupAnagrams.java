package neetcode.Java;

import java.util.*;

public class _49GroupAnagrams {

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Boolean[] isUsed = new Boolean[strs.length];
        for (int i = 0; i < strs.length; i++) isUsed[i] = false;
        for (int i = 0; i < strs.length; i++) {
            if (isUsed[i] == true) continue;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            isUsed[i] = true;
            Task:
            for (int n = i + 1; n < strs.length; n++) {
                if (isUsed[n]) continue;
                List<Character> sub = new ArrayList<>();
                for (int nn = 0; nn < strs[i].length(); nn++) {
                    sub.add(strs[i].charAt(nn));
                }
                for (int j = 0; j < strs[n].length(); j++)
                    if (sub.contains(strs[n].charAt(j))) sub.remove(sub.indexOf(strs[n].charAt(j)));
                    else continue Task;
                if (sub.isEmpty()) {
                    list.add(strs[n]);
                    isUsed[n] = true;
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        int len = strs.length;
        boolean[] isUsed = new boolean[strs.length];
        for (int i = 0; i < len; i++) {
            if (isUsed[i]) continue;
            else isUsed[i] = true;
            List<String> sub = new ArrayList<>();
            sub.add(strs[i]);
            Task:
            for (int n = i + 1; n < len; n++) {
                if (isUsed[n]) continue Task;
                if (strs[i].length() != strs[n].length()) continue;
                List<Character> l = new ArrayList<>();
                for (int ii = 0; ii < strs[i].length(); ii++) {
                    l.add(strs[i].charAt(ii));
                }
                for (int nn = 0; nn < strs[n].length(); nn++) {
                    if (l.contains(strs[n].charAt(nn))) l.remove(l.indexOf(strs[n].charAt(nn)));
                    else continue Task;
                }
                isUsed[n] = true;
                sub.add(strs[n]);
            }
            lists.add(sub);
        }
        return lists;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = String.valueOf(ch);
            if (!map.containsKey(s)) map.put(s, new ArrayList());
            map.get(s).add(str);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        _49GroupAnagrams obj = new _49GroupAnagrams();
        {
            String[] srt = {"eat", "tea", "tan", "ate", "nat", "bat"};
            System.out.println(obj.groupAnagrams1(srt));
        }
        {
            String[] srt = {"ddddddddddg", "dgggggggggg"};
            System.out.println(obj.groupAnagrams1(srt));
        }
        {
            String[] srt = {"eat", "tea", "tan", "ate", "nat", "bat"};
            System.out.println(obj.groupAnagrams1(srt));
        }

        {
            String[] srt = {"eat", "tea", "tan", "ate", "nat", "bat"};
            System.out.println(obj.groupAnagrams(srt));
        }
        {
            String[] srt = {"ddddddddddg", "dgggggggggg"};
            System.out.println(obj.groupAnagrams(srt));
        }
        {
            String[] srt = {"eat", "tea", "tan", "ate", "nat", "bat"};
            System.out.println(obj.groupAnagrams(srt));
        }
    }
}
