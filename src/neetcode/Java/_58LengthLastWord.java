package neetcode.Java;

public class _58LengthLastWord {
    public int lengthOfLastWord(String s) {
        s=" "+s;
        char[] ch = s.toCharArray();
        int i = ch.length - 1, max_len = 0;
        for (; i >= 0; i--) {
            if (ch[i] == ' ') {if (max_len != 0) return max_len;}
            else max_len++;
        }
        return ch.length;
    }

    public static void main(String[] args) {
        _58LengthLastWord obj = new _58LengthLastWord();
        {
            String s = "World";
            System.out.println(obj.lengthOfLastWord(s));
        }
        {
            String s = "Hello World";
            System.out.println(obj.lengthOfLastWord(s));
        }
        {
            String s = "   fly me   to   the moon  ";
            System.out.println(obj.lengthOfLastWord(s));
        }
        {
            String s = "luffy is still joyboy";
            System.out.println(obj.lengthOfLastWord(s));
        }

    }
}
