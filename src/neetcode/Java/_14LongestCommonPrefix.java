package neetcode.Java;

public class _14LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int lenStrs = strs.length;
        int i = 0;
        int len = strs[0].length();
        Task:
        while (i < len) {
            for (int j = 1; j < lenStrs; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) break Task;
            }
            i++;
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        String[] s = {"dog","racecar","car"};
        String res = longestCommonPrefix(s);
        System.out.println(res);
    }
}
