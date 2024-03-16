package neetcode.Java;

import java.util.Arrays;

public class _80RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int pointer = 1;
        int times=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                times++;
            }else {
                times=0;
            }
            if(times<2){
                nums[pointer++]=nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return pointer;
    }

    public static void main(String[] args) {
        _80RemoveDuplicatesFromSortedArrayII obj = new _80RemoveDuplicatesFromSortedArrayII();
        {
            int[] nums = {1, 1, 1, 2, 2, 3};
            System.out.println(obj.removeDuplicates(nums));
        }
        {
            int[] nums = {0,0,1,1,1,1,2,3,3};
            System.out.println(obj.removeDuplicates(nums));
        }
    }
}