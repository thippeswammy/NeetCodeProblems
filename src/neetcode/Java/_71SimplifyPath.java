package neetcode.Java;

import java.util.Arrays;
import java.util.Stack;

public class _71SimplifyPath {
    public String simplifyPath(String path) {
        Stack st = new Stack();
        path = path + "/";
        for (int i = 1, j = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (j != i) {
                    String s = path.substring(j, i);
                    if (s.equals("..")) {
                        if (!st.isEmpty()) st.pop();
                    } else if (!s.equals(".")) {
                        st.add("/" + s);
                    }
                }
                j = i+1;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.remove(0));
        return (sb.isEmpty()) ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        _71SimplifyPath obj = new _71SimplifyPath();
        System.out.println(obj.simplifyPath("/home/"));
    }
}
