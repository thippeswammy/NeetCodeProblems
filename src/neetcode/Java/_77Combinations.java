package neetcode.Java;

import java.util.ArrayList;
import java.util.List;

public class _77Combinations {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        Helper(1,n,k,new ArrayList<>());
        return list;
    }

    public void Helper(int ii,int n, int k,List<Integer> l){
        if(k==0) {
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=ii;i<=n-k+1;i++){
            l.add(i);
            Helper(i+1,n,k-1,l);
            l.remove(l.size()-1);
        }
    }

    public static void main(String[] args) {
        _77Combinations obj = new _77Combinations();
        System.out.println(obj.combine(4, 2));
//        System.out.println(obj.combine(1, 1));
    }
}
