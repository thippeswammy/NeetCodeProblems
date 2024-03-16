package neetcode.Java;

public class _33SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            int MidVal = nums[mid];
            if (MidVal == target)
                return mid;
            if (MidVal > nums[r]) {
                //I am in left part side
                if (target > MidVal) l = mid + 1;
                else if (target < nums[l]) l = mid + 1;
                else r = mid - 1;
            } else {
                //I, am in right part side
                if (MidVal > target) r = mid - 1;
                else if (target > nums[r]) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            int MidVal = nums[mid];
            if (MidVal == target)
                return mid;
            if (MidVal > nums[r]) {
                //I am in left part side
                if (target > MidVal || target < nums[l]) l = mid + 1;
                else r = mid - 1;
            } else {
                //I am in right part side
                if (MidVal > target || target > nums[r]) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _33SearchRotatedSortedArray obj = new _33SearchRotatedSortedArray();
        int[] num = {4, 5, 6, 7, 8, 1, 2, 3};
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i] + "    " + obj.search(num, num[i]) + " ->>  " + i);
            System.out.println(num[i] + "    " + obj.search1(num, num[i]) + " ->>  " + i);

        }
    }
}
