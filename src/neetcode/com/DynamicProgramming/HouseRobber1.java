package com.DynamicProgramming;

public class HouseRobber1 {

  public static void main(String[] args) {
    int[] nums={5,3,2,3};
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    for(int i=0;i<dp.length;i++){
      System.out.println(dp[i]+"-"+nums[i]);
    }
    System.out.print(dp[nums.length - 1]);
  }
}