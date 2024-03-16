package neetcode.Java;

public class _11ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int s=0,e=height.length-1;
        int maxLevel=0,lev=0;
        while (s<e){
            lev=(e-s)*Math.min(height[s],height[e]);
            if(lev>maxLevel) maxLevel=lev;
            if(height[e]>height[s]) s++;else e--;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        int[] arr={1,1};
        int res = maxArea(arr);
        System.out.println(res);
    }
}
