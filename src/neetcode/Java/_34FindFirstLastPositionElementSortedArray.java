package neetcode.Java;

public class _34FindFirstLastPositionElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                l = mid;
                r = mid;
                while (l > 0 && nums[l - 1] == target) l--;
                while (r < nums.length - 1 && nums[r + 1] == target) r++;
                return new int[]{l, r};
            } else if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        _34FindFirstLastPositionElementSortedArray obj = new _34FindFirstLastPositionElementSortedArray();

        {
            int[] nums = {5, 7, 7, 8, 8, 10};
            int[] num = obj.searchRange(nums, 8);
            for (int i : num)
                System.out.println(i + " ");
        }

        {
            int[] nums = {2, 2};
            int[] num = obj.searchRange(nums, 2);
            for (int i : num)
                System.out.println(i + " ");
        }
    }
}
