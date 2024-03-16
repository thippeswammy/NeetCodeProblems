package neetcode.Java;

public class _53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = maxSum;
        for (int i = 1; i < nums.length; i++) {
            if(currSum<0) currSum=0;
            currSum += nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        _53MaximumSubarray obj = new _53MaximumSubarray();
        {
            int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            System.out.println(obj.maxSubArray(nums));
        }
        {
            int[] nums = {5, 4, -1, 7, 8};
            System.out.println(obj.maxSubArray(nums));
        }
        {
            int[] nums = {-2, -1};
            System.out.println(obj.maxSubArray(nums));
        }
        {
            int[] nums = {-1, -2};
            System.out.println(obj.maxSubArray(nums));
        }
    }
}
