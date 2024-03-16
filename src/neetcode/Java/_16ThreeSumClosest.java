package neetcode.Java;
import java.util.Arrays;

public class _16ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int Sum = nums[0] + nums[1] + nums[2];
        int closeSum = Sum;
        int diffrence;
        for (int i = 0; i < nums.length - 2; i++) {
            if ((i >= 1) && (nums[i - 1] == nums[i])) continue;
            int s = i + 1, e = nums.length - 1;
            while (s < e) {
                Sum = nums[i] + nums[s] + nums[e];
                if (Sum == target) return Sum;
                diffrence = Sum - target;
                int closeDiffrence = closeSum - target;
                closeDiffrence = closeDiffrence > 0 ? closeDiffrence : -closeDiffrence;
                diffrence = diffrence > 0 ? diffrence : -diffrence;
                if (closeDiffrence > diffrence) closeSum = Sum;
                else if (Sum > target)
                    e--;
                else
                    s++;
            }
        }
        return closeSum;
    }


    public static void main(String[] args) {
        int[] num = {-100, -98, -2, -1};
        int res = threeSumClosest(num, -101);
        System.out.println(res);
    }
}
