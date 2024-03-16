package com.DynamicProgramming;

public class HouseRobber22 {

  public static void main(String[] args) {
    int[] nums={5,3,2,3};
    //if (nums == null || nums.length == 0) return 0;
    //if (nums.length == 1) return nums[0];
    //if (nums.length == 2) return Math.max(nums[0], nums[1]);
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    
    System.out.print(dp[nums.length - 1]);

  }

}
