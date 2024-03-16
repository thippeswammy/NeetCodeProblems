package neetcode.Java;

public class _1TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j + i < nums.length; j++) {
                if (nums[j+i] + nums[j] == target) {
                    return new int[]{j, j+i};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] num={2,7,11,15};
        int a[] = twoSum(num,9);
        System.out.println(a[0]+" "+a[1]);
    }
}
