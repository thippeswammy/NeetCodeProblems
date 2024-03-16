package neetcode.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class _20ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (!st.isEmpty() && map.get(s.charAt(i)) == st.peek()) st.pop();
                else
                    return false;
            } else st.push(s.charAt(i));
        }
        return st.isEmpty();
    }


    public static void main(String[] args) {
        _20ValidParentheses obj = new _20ValidParentheses();
        System.out.println(obj.isValid("(){}}{"));
    }
}
