package neetcode.Java;

import java.util.ArrayList;
import java.util.List;

public class _78Subsets {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Helper(nums, 0, nums.length, new ArrayList<>());
        return list;
    }

    public void Helper(int[] nums, int ii, int n, List<Integer> l) {
        list.add(new ArrayList<>(l));
        for (int i = ii; i < n; i++) {
            l.add(nums[i]);
            Helper(nums, i + 1, n, l);
            l.remove(l.size() - 1);
        }
    }


    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        System.out.println(1<<nums.length);
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    public static void main(String[] args) {
        _78Subsets obj = new _78Subsets();
        {
            int[] nums = {1, 2, 3};
            System.out.println(obj.subsets1(nums));
        }
        {
            int[] nums = {1, 2, 3};
            System.out.println(obj.subsets(nums));
        }
        {
            int[] nums = {0};
            System.out.println(obj.subsets(nums));
        }
    }
}
