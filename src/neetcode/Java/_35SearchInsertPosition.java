package neetcode.Java;

public class _35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) return 0;
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (mid > 0 && nums[mid] >= target && nums[mid - 1] < target) {
                return mid;
            }
            if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return target > nums[nums.length - 1] ? nums.length : 0;
    }

    public int searchInsert1(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        int result = nums.length;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        _35SearchInsertPosition obj = new _35SearchInsertPosition();
        {
            int nums[] = {1, 2, 3, 4, 5, 10}, target = 2;
            System.out.println(obj.searchInsert(nums, target));
        }
        {
            int nums[] = {1, 2, 3, 4, 5, 10}, target = 2;
            System.out.println(obj.searchInsert1(nums, target));
        }
    }
}
