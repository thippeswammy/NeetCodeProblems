package neetcode.Java;

public class _26RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                nums[k] = nums[i];
            } else {
                k++;
            }
        }
        return k;
    }

    public int removeDuplicates1(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {

            } else {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        _26RemoveDuplicatesFromSortedArray obj = new _26RemoveDuplicatesFromSortedArray();
        int[] num = {1, 1, 3};
        System.out.println(obj.removeDuplicates(num));
    }
}
