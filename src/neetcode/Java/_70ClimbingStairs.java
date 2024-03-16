package neetcode.Java;

public class _70ClimbingStairs {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int res=0;
        int l=2,ll=1;
        for(int i=3;i<=n;i++){
            res=ll+l;
            ll=l;
            l=res;
        }
        return res;
    }

    public static void main(String[] args) {
        _70ClimbingStairs obj =new _70ClimbingStairs();
        System.out.println(obj.climbStairs(4));
        System.out.println(obj.climbStairs(2));
    }
}
