package neetcode.Java;

public class _10RegularExpressionMatching {
    String ss = "", pp = "";
    int s_len, p_len;

    public boolean isMatch(String s, String p) {
        ss = s;
        pp = p;
        s_len = s.length();
        p_len = p.length();
        return Find(0, 0);
    }

    public boolean Find(int i, int j) {
        if (ss.length() == i && pp.length() == j) return true;
        if (ss.length() != i && pp.length() == j) return false;
        if (j + 1 < p_len && pp.charAt(j + 1) == '*') {
            if (i < s_len && (pp.charAt(j) == '.' || ss.charAt(i) == pp.charAt(j))) {
                return (Find(i, j + 2) || Find(i + 1, j));
            } else {
                return Find(i, j + 2);
            }
        }
        if (i < s_len && (pp.charAt(j) == '.' || ss.charAt(i) == pp.charAt(j)))
            return Find(i + 1, j + 1);
        return false;
    }


    public static void main(String[] args) {
        _10RegularExpressionMatching _10RegularExpressionMatching = new _10RegularExpressionMatching();
        boolean res = _10RegularExpressionMatching.isMatch("aa", ".*");
        System.out.println(res);
    }
}
