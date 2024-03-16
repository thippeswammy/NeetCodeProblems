package neetcode.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _47PermutationsII {
    List<List<Integer>> list = new ArrayList<>();
    int len;

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        len = nums.length;
        Helper(map, new ArrayList<>());
        return list;
    }

    public void Helper(HashMap<Integer, Integer> map, ArrayList<Integer> sub) {
        if (sub.size() == len) {
            list.add(new ArrayList<>(sub));
            return;
        }
        for (int i : map.keySet()) {
            if (map.get(i) > 0) {
                sub.add(i);
                map.put(i, map.get(i) - 1);
                Helper(map, sub);
                sub.remove(sub.size() - 1);
                map.put(i, map.get(i) + 1);
            }
        }
    }

    public static void main(String[] args) {
        _47PermutationsII obj = new _47PermutationsII();
        int[] nums = {1, 1, 2};
        System.out.println(obj.permuteUnique(nums));
    }
}
