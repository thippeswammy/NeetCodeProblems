package neetcode.Java;

import java.util.ArrayList;
import java.util.List;

public class _39CombinationSum {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> l = new ArrayList<>();
        Helper(0, candidates, target, l);
        return list;
    }

    public void Helper(int n, int[] num, int tar, ArrayList<Integer> l) {
        if (tar == 0) {
            list.add(new ArrayList<>(l));
            return;
        }
        for (int i = n; i < num.length; i++) {
            if (tar - num[i] >= 0) {
                l.add(num[i]);
                Helper(i, num, tar - num[i], l);
                l.remove(l.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _39CombinationSum obj = new _39CombinationSum();
        int[] num = {2, 3, 6, 7};
        int target = 7;
        System.out.println(obj.combinationSum(num, target));
    }
}
