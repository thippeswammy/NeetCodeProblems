package neetcode.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18FourSum {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        run(nums, target, 0, new ArrayList<>(), 4);
        return list;
    }

    public void run(int[] nums, int target, int i, List<Integer> l, int num) {
        if (target == 0 && num == 0) {
            list.add(new ArrayList<>(l));
            return;
        }
        if (num == 0) {
            return;
        }
        for (int n = i; n < nums.length; n++) {
            if (i != n && nums[n] <= nums[n - 1]) continue;
            l.add(nums[n]);
            run(nums, target - nums[n], n + 1, l, num - 1);
            l.remove(l.size() - 1);
        }
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if ((i > 0) && (nums[i - 1] == nums[i])) continue;
            for (int n = i + 1; n < nums.length - 2; n++) {
                if ((n > i + 1) && (nums[n - 1] == nums[n])) continue;
                int s = n + 1, e = nums.length - 1;
                while (s < e) {
                    double sum = nums[i] * 1.0 + nums[n] + nums[s] + nums[e];
                    if (sum == target) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[n]);
                        l.add(nums[s]);
                        l.add(nums[e]);
                        list.add(l);
                        s++;
                        e--;
                        while (s < e && nums[s] == nums[s - 1]) s++;
                        while (s < e && nums[e] == nums[e + 1]) e--;
                    } else if (sum > target) {
                        e--;
                    } else {
                        s++;
                    }
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        _18FourSum _18FourSum = new _18FourSum();
        int[] num = {1, 0, -1, 0, -2, 2};
        System.out.println(_18FourSum.fourSum(num, 0));
        System.out.println(_18FourSum.fourSum1(num, 0));
    }
}
