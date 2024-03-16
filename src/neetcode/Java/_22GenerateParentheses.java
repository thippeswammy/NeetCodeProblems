package neetcode.Java;

import java.util.ArrayList;
import java.util.List;

public class _22GenerateParentheses {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        Helper("", n, n);
        return list;
    }

    public void Helper(String s, int open, int close) {
        if (open == 0 && close == 0) {
            list.add(s);
        }
        if (open > 0)
            Helper(s + "(", open - 1, close);
        if (close > open)
            Helper(s + ")", open, close - 1);
    }

    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        Helper("", n, list, 0, 0);
        return list;
    }

    public void Helper(String s, int n, List<String> list, int np, int nc) {
        if (np < n) {
            Helper(s + "(", n, list, np + 1, nc);
        }
        if (nc < np) {
            Helper(s + ")", n, list, np, nc + 1);
        }
        if (np == nc && np == n) {
            list.add(s);
        }
    }


    public static void main(String[] args) {
        _22GenerateParentheses obj = new _22GenerateParentheses();
        System.out.println(obj.generateParenthesis(3));
        System.out.println(obj.generateParenthesis1(3));
    }

}
