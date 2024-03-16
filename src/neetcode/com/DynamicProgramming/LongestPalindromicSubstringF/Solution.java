package com.DynamicProgramming.LongestPalindromicSubstringF;

public class Solution {
  public static String 
  LongestPalindrome(String s){
    if (s.length()==1) return s;
    String ss="";
    StringBuffer rrs = new StringBuffer(s);
    String rs=rrs.reverse().toString();
    for(int i=0;i<s.length();i++){
      for(int n=s.length()-1;n>=i;n--){
        String sss=s.substring(i,n+1);
        String rss=rs.substring(s.length()-n-1,s.length()-i);
        if(sss.equals(rss)&&
        sss.length()>ss.length()){
          ss=sss;
        }
      }
    }
    return ss;
  }
}
