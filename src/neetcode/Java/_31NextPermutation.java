package neetcode.Java;

public class _31NextPermutation {
    public int[] nextPermutation(int[] nums) {
        int len = nums.length,i;
        for (i = len - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) break;
        }
        int min = -1, j = len - 1, ind = len - 1;
        while (j >= i&&i!=0) {
            if ((min == -1 || min > nums[j]) && nums[i - 1] < nums[j]) {
                min = nums[j];
                ind = j;
            }
            j--;
        }
        j = ind;
        if(i!=0) {
            int temp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = temp;
        }

        for (int k = i, kk = len - 1; k < kk; k++, kk--) {
            int temp = nums[k];
            nums[k] = nums[kk];
            nums[kk] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        _31NextPermutation obj = new _31NextPermutation();
        {
            int[] num = obj.nextPermutation(new int[]{1,2,3});
            System.out.println();
            for (int i : num)
                System.out.print(i + " ");
        }
        {
            int[] num = obj.nextPermutation(new int[]{1,3,2});
            System.out.println();
            for (int i : num)
                System.out.print(i + " ");
        }
        {
            int[] num = obj.nextPermutation(new int[]{2,1,3});
            System.out.println();
            for (int i : num)
                System.out.print(i + " ");
        }
        {
            int[] num = obj.nextPermutation(new int[]{2,3,1});
            System.out.println();
            for (int i : num)
                System.out.print(i + " ");
        }
        {
            int[] num = obj.nextPermutation(new int[]{3, 1, 2});
            System.out.println();
            for (int i : num)
                System.out.print(i + " ");
        }
        {
            int[] num = obj.nextPermutation(new int[]{3, 2, 1});
            System.out.println();
            for (int i : num)
                System.out.print(i + " ");
        }
    }
}
