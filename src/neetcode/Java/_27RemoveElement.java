package neetcode.Java;

public class _27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i : nums) {
            if (i == val) {
                nums[k++] = i;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        _27RemoveElement obj = new _27RemoveElement();
        int[] num = {3, 2, 2, 3};
        int val = 3;
        System.out.println(obj.removeElement(num, val));
    }
}
