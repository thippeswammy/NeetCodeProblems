package neetcode.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _46Permutations {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList li = new ArrayList<>();
        for (int i : nums) li.add(i);
        Helper(li, new ArrayList<>());
        return list;
    }

    public void Helper(ArrayList<Integer> nums, ArrayList<Integer> l) {
        if (nums.size() == 0) {
            list.add(new ArrayList<>(l));
            return;
        }
        for (int n = 0; n < nums.size(); n++) {
            int val = nums.get(n);
            l.add(val);
            nums.remove(n);
            Helper(nums, l);
            nums.add(n, val);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        _46Permutations obj = new _46Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(obj.permute(nums));
    }
}
