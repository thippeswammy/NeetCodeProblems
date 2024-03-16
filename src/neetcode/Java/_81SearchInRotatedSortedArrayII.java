package neetcode.Java;

public class _81SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) return true;
            if (nums[l] < nums[mid]) {
                // in left part
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[l] > nums[mid]) {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _81SearchInRotatedSortedArrayII obj = new _81SearchInRotatedSortedArrayII();
        {
            int[] nums = {2, 2, 2, 2, 3, 1};
            for (int i : nums)
                System.out.println(obj.search(nums, i) + "  " + i);
            System.out.println("\n");
        }
        {
            int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
            for (int i : nums)
                System.out.println(obj.search(nums, i) + "  " + i);
            System.out.println("\n");
        }
        {
            int[] nums = {3, 4, 1, 2};
            for (int i : nums)
                System.out.println(obj.search(nums, i) + "  " + i);
            System.out.println("\n");
        }
        {
            int[] nums = {3, 4, 1, 2, 2};
            for (int i : nums)
                System.out.println(obj.search(nums, i) + "  " + i);
            System.out.println("\n");
        }
    }
}
