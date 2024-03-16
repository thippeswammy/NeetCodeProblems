package neetcode.Java;

import java.util.ArrayList;
import java.util.List;

public class _60PermutationSequence {
    public String getPermutation(int n, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        StringBuilder s = new StringBuilder();

        for (int no_ = 0; no_ < n && k > 1; no_++) {
            int pro = fact(n - no_ - 1);
            int ind = (k - 1) / pro;
            s.append(list.get(ind));
            list.remove(ind);
            k = (k - 1) % (pro) + 1;
        }

        for (int i : list) {
            s.append(i);
        }
        return s.toString();
    }

    public int fact(int n) {
        if (n <= 1) return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        _60PermutationSequence obj = new _60PermutationSequence();
        for (int i = 1; i <= 24; i++) System.out.println(obj.getPermutation(4, i));

    }
}
