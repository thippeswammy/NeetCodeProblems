package com.DynamicProgramming;

public class LargestNumberAtLeastTwiceofOthers {

  public static void main(String[] args) {
  
  int nums[]={0,0,0,1};
  int ind=-1;
  int ll=Math.min(nums[0],nums[1]);
  int l=Math.max(nums[0],nums[1]);
  if(l==nums[0]){
    ind=0;
  }else{
    ind=1;
  }
  for(int i=1;i<=nums.length-1;i++){
    if(nums[i]>l){
      l=nums[i];
      ind=i;
    }
  }
  for(int i=0;i<=nums.length-1;i++){
    if(nums[i]<l && nums[i]>=ll){
      ll=nums[i];
      
    }
  }
  if(l<ll*2){
    ind=-1;
  }
  System.out.print(ind);
  }
}
