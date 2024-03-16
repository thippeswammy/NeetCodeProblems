package neetcode.Java;

public class _45JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int i = 0, no_step = 1;
        for (; ; no_step++) {
            if (nums[i] == 0) nums[i] = 1;
            int pos = i + nums[i], max = i + nums[i];
            if (pos >= nums.length - 1) return no_step;
            //Finding the best position for next jump
            for (int n = i + 1; n <= i + nums[i] && n < nums.length; n++) {
                if (nums[n] + n > max) {
                    max = nums[n] + n;
                    pos = n;
                }
            }
            i = pos;
        }
    }


    public int jump1(int[] nums) {
        if (nums.length == 1) return 0;
        int i = 0, no_step = 1;
        for (; ; no_step++) {
            if (nums[i] == 0) nums[i] = 1;
            int pos = i + nums[i], max = i + nums[i];
            if (pos >= nums.length - 1) break;
            //Finding the best position for next jump
            for (int n = i + 1; n <= i + nums[i] && n < nums.length; n++) {
                if (nums[n] + n > max) {
                    max = nums[n] + n;
                    pos = n;
                }
            }
            i = pos;
        }
        return no_step;
    }

    public int jump2(int[] nums) {
        return Help2(nums, 0, 0);
    }

    public int Help2(int[] nums, int i, int min) {
        if (i >= nums.length - 1) return min;
        if (i + nums[i] >= nums.length - 1) return min + 1;
        int max_len = nums.length, max_dis = 0, next_pos = i + 1;
        for (int n = i + 1; n <= nums[i] + i; n++) {
            if (n < nums.length && max_dis <= nums[n] + n) {
                next_pos = n;
                max_dis = nums[n] + n;
            }
        }
        max_len = Math.min(Help2(nums, next_pos, min + 1), max_len);
        return max_len;
    }


    public static void main(String[] args) {
        _45JumpGameII obj = new _45JumpGameII();
        {
            int[] num = {3, 4, 3, 2, 5, 4, 3};
            System.out.println(obj.jump1(num));
        }
        {
            int[] num = {3, 4, 3, 2, 5, 4, 3};
            System.out.println(obj.jump(num));
        }
        {
            int[] num = {1, 1, 1, 1};
            System.out.println(obj.jump(num));
        }
        {
            int[] num = {2, 0};
            System.out.println(obj.jump(num));
        }
        {
            int[] num = {1, 1};
            System.out.println(obj.jump(num));
        }
        {
            int[] num = {1, 2};
            System.out.println(obj.jump(num));
        }
        {
            int[] num = {2, 3, 1, 1, 4};
            System.out.println(obj.jump(num));
        }
        {
            int[] num = {2, 3, 0, 1, 4};
            System.out.println(obj.jump(num));
        }
    }
}
