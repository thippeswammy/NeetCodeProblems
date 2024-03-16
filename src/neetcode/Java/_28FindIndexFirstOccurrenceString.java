package neetcode.Java;

public class _28FindIndexFirstOccurrenceString {
    public int strStr(String haystack, String needle) {
        char[] arr = haystack.toCharArray();
        char[] tar = needle.toCharArray();
        Task:
        for (int i = 0; i < arr.length - tar.length; i++) {
            for (int n = 0; n < tar.length; n++) {
                if (tar[n] != arr[i + n]) continue Task;
            }
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        _28FindIndexFirstOccurrenceString obj = new _28FindIndexFirstOccurrenceString();
        System.out.println(obj.strStr("sadbutsad", "sad"));
    }
}
