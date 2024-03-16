package neetcode.Java;

public class _55JumpGame {

    public boolean canJump(int[] nums) {
        int pos = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + i > pos) pos = nums[i] + i;
            else if (pos <= i && nums[i] == 0) {
                break;
            }
        }
        return pos >= nums.length - 1;
    }


    public boolean canJump1(int[] nums) {
        int goal = nums.length - 1;
        int pla = goal - 1;
        while (pla >= 0) {
            if ((nums[pla] + pla) >= (goal)) {
                goal = pla;
            }
            pla--;
        }
        return goal==0;
    }


    public static void main(String[] args) {
        _55JumpGame obj = new _55JumpGame();
        int nums[] = {3, 2, 1, 0, 4};
        System.out.println(obj.canJump(nums));
        System.out.println(obj.canJump1(nums));
    }
}
