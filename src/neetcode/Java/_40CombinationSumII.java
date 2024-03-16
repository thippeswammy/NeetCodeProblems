package neetcode.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40CombinationSumII {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Helper(0, candidates, target, new ArrayList<>());
        return list;
    }

    public void Helper(int n, int[] num, int tar, ArrayList<Integer> l) {
        if (tar == 0) {
            list.add(new ArrayList<>(l));
            return;
        }
        for (int i = n; i < num.length; i++) {
            if (i != n) {
                for (; i < num.length && (num[i - 1] == num[i]); i++) ;
                if(i>=num.length) return;
            }
            if (tar - num[i] >= 0) {
                l.add(num[i]);
                Helper(i + 1, num, tar - num[i], l);
                l.remove(l.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _40CombinationSumII obj = new _40CombinationSumII();
        {
            int[] num = {10, 1, 2, 7, 6, 1, 5};
            int target = 8;
            System.out.println(obj.combinationSum2(num, target));
        }
        {
            int[] num = {1,1};
            int target = 1;
            System.out.println(obj.combinationSum2(num, target));
        }
    }
}
