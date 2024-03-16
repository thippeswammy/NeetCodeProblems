package neetcode.Java;

public class _38CountAndSay {
    public String countAndSay(int n) {
        return Helper(n);
    }

    public String Helper(int n) {
        if (n == 1) return "1";
        String s = Helper(n - 1) + " ";
        StringBuilder ss = new StringBuilder();
        int c = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (ch == s.charAt(i + 1)) {
                c++;
            } else {
                ss.append(c).append(ch);
                c = 1;
            }
        }
        return ss.toString();
    }

    public static void main(String[] args) {
        _38CountAndSay obj = new _38CountAndSay();
        System.out.println(obj.countAndSay(4));
    }
}
