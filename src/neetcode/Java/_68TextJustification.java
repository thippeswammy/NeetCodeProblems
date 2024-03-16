package neetcode.Java;

import java.util.ArrayList;
import java.util.List;

public class _68TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // If last line or number of words in the line is 1, left-justify
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i]).append(' ');
                }
                builder.deleteCharAt(builder.length() - 1);
                while (builder.length() < maxWidth) {
                    builder.append(' ');
                }
            } else {
                // Middle justified
                int spaces = (maxWidth - count) / diff;
                int extra = (maxWidth - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < extra ? 1 : 0)); j++) {
                            builder.append(' ');
                        }
                    }
                }
            }
            result.add(builder.toString());
            index = last;
        }
        return result;
    }

    public static void main(String[] args) {
        _68TextJustification obj = new _68TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words1 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        System.out.println(obj.fullJustify(words1, 16));
    }
}