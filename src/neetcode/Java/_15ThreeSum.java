package neetcode.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15ThreeSum {
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int v1 = nums[i];
            if (i - 1 >= 0 && !(v1 > nums[i - 1])) continue;
            int s = i + 1, e = len - 1;
            while (s < e) {
                int v2 = nums[s], v3 = nums[e];
                int vv2 = nums[s - 1], vv3 = nums[e - 1];
                if (s - 1 != i && !(v2 > vv2)) {
                    s++;
                    continue;
                }
                if (e + 1 < len && !(v3 < nums[e + 1])) {
                    e--;
                    continue;
                }
                int sum = v1 + v2 + v3;
                if (sum == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(v1);
                    l.add(v2);
                    l.add(v3);
                    list.add(l);
                    s++;
                } else if (sum > 0) {
                    e--;
                } else {
                    s++;
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if ((i >= 1) && (nums[i - 1] == nums[i])) {
                continue;
            }
            int s = i + 1, e = nums.length - 1;
            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if (sum == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[s]);
                    l.add(nums[e]);
                    list.add(l);
                    s++;
                    while (nums[s] == nums[s - 1] && s < e) {
                        s++;
                    }
                } else if (sum > 0) {
                    e--;
                } else {
                    s++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(num);
        System.out.println(list);
    }
}