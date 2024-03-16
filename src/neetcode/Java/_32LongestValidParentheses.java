package neetcode.Java;
import java.util.Stack;

public class _32LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.add(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.add(i);
            else {
                st.pop();
                if (st.isEmpty())
                    st.add(i);
                else
                    max = Math.max(max, i - st.peek());
            }
        }
        return max;
    }

    public int longestValidParentheses1(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.push(i);
            else {
                st.pop();
                if (!st.isEmpty())
                    max = Math.max(max, i - st.peek());
                else
                    st.push(i);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        _32LongestValidParentheses obj = new _32LongestValidParentheses();
        String s = ")()(())";
        System.out.println(obj.longestValidParentheses(s));
        System.out.println(obj.longestValidParentheses1(s));
    }
}
