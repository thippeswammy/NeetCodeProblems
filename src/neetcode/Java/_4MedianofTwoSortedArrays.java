package neetcode.Java;


import static java.lang.Math.max;
import static java.lang.Math.min;

public class _4MedianofTwoSortedArrays {
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int l = 0, r = nums1.length - 1;
        int total = nums1.length + nums2.length, half = total / 2;
        int mid1 = (l + r) / 2;
        int mid2 = max(half - (mid1 + 1), 1) - 1;
        while (true) {
            if (mid2 + 1 >= 0 && mid2 + 1 < nums2.length &&
                    nums1[mid1] > nums2[mid2 + 1]) {
                mid1--;
                mid2++;
            } else if (mid1 + 1 < nums1.length && nums2[mid2 + 1] > nums1[mid1]) {
                mid2--;
                mid1++;
            } else {
                if (total % 2 == 1)
                    return min(nums1[mid1 + 1], nums2[mid2 + 1]);
                else
                    return (max(nums1[mid1], nums2[mid2])
                            + min(nums1[mid1 + 1], nums2[mid2 + 1])) / 2.0;
            }
        }
    }


    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int med1 = 0;
        int med2 = 0;
        int total = (nums1.length + nums2.length);
        for (int i = 0; i <= total / 2; i++) {
            med1 = med2;
            //System.out.println("+++>>  " + index1 + "  " + index2);
            if (index1 == nums1.length) {
                //System.out.println("--->>  " + index1 + "  " + index2);
                index2 = (total + 1) / 2 - index2 - index1;
                if (nums1.length == 0) {
                    index2--;
                }
                med2 = nums2[index2];
                if (index2 + 1 < nums2.length && (index2 + 1) == total / 2)
                    med1 = nums2[index2 + 1];
                //System.out.println("==>>  " + med1 + "  " + med2 + "  " + index1 + "  " + index2 + "  ---  " + (med1 + med2) / 2.0);
                //index2++;
                break;
            } else if (index2 == nums2.length) {
                index1 = (total) / 2 - index1 - index2 + 1;
                if (nums2.length == 0) {
                    index1--;
                }
                med1 = nums1[index1];
                med2 = nums1[index1];
                if (index1 + 1 < nums1.length && (index1 + 1) == total / 2)
                    med2 = nums1[index1 + 1];
                break;
                //med2 = nums1[index1];
                //index1++;
            } else if (nums1[index1] < nums2[index2]) {
                med1 = nums1[index1];
                index1++;
            } else {
                med2 = nums2[index2];
                index2++;
            }
        }
        // the median is the average of two numbers
        if (total % 2 == 0) {
            System.out.println();
            return (float) (med1 + med2) / 2;
        }
        return med2;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int med1 = 0;
        int med2 = 0;
        for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            med1 = med2;
            if (index1 == nums1.length) {
                med2 = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                med2 = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2]) {
                med2 = nums1[index1];
                index1++;
            } else {
                med2 = nums2[index2];
                index2++;
            }
        }

        // the median is the average of two numbers
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (float) (med1 + med2) / 2;
        }

        return med2;
    }


    public static void main(String[] args) {
        double val = findMedianSortedArrays(new int[]{1, 2},
                new int[]{3, 4});
        System.out.println(val);
    }
}


