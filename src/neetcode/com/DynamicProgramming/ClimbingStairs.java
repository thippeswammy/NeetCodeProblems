package com.DynamicProgramming;

public class ClimbingStairs {

  public static void main(String[] args) {
  int cost[]={1,100,1,1,1,100,1,1,100,1};
  int mcost[]=new int[cost.length+1];
  mcost[mcost.length-1]=0;
  mcost[mcost.length-2]=
  cost[cost.length-1];
  for(int i=mcost.length-3;i>=0;i--){
    mcost[i]=cost[i]+Math.min(
    mcost[i+1],mcost[i+2]);
  }
  System.out.print(
  Math.min(mcost[0],mcost[1]));
  }
}
