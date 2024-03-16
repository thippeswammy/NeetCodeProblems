package neetcode.kotlin

import kotlin.math.max
import kotlin.math.min


object _4MedianofTwoSortedArrays {
    fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
        val l = 0
        val r = nums1.size - 1
        val total = nums1.size + nums2.size
        val half = total / 2
        var mid1 = (l + r) / 2
        var mid2 = (max((half - (mid1 + 1)).toDouble(), 1.0) - 1).toInt()
        while (true) {
            if (mid2 + 1 >= 0 && mid2 + 1 < nums2.size && nums1[mid1] > nums2[mid2 + 1]) {
                mid1--
                mid2++
            } else if (mid1 + 1 < nums1.size && nums2[mid2 + 1] > nums1[mid1]) {
                mid2--
                mid1++
            } else {
                return if (total % 2 == 1) min(nums1[mid1 + 1].toDouble(), nums2[mid2 + 1].toDouble())
                else (max(nums1[mid1].toDouble(), nums2[mid2].toDouble())
                        + min(nums1[mid1 + 1].toDouble(), nums2[mid2 + 1].toDouble())) / 2.0
            }
        }
    }


    fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
        var index1 = 0
        var index2 = 0
        var med1 = 0
        var med2 = 0
        val total = (nums1.size + nums2.size)
        for (i in 0..total / 2) {
            med1 = med2
            //System.out.println("+++>>  " + index1 + "  " + index2);
            if (index1 == nums1.size) {
                //System.out.println("--->>  " + index1 + "  " + index2);
                index2 = (total + 1) / 2 - index2 - index1
                if (nums1.size == 0) {
                    index2--
                }
                med2 = nums2[index2]
                if (index2 + 1 < nums2.size && (index2 + 1) == total / 2) med1 = nums2[index2 + 1]
                //System.out.println("==>>  " + med1 + "  " + med2 + "  " + index1 + "  " + index2 + "  ---  " + (med1 + med2) / 2.0);
                //index2++;
                break
            } else if (index2 == nums2.size) {
                index1 = (total) / 2 - index1 - index2 + 1
                if (nums2.size == 0) {
                    index1--
                }
                med1 = nums1[index1]
                med2 = nums1[index1]
                if (index1 + 1 < nums1.size && (index1 + 1) == total / 2) med2 = nums1[index1 + 1]
                break
                //med2 = nums1[index1];
                //index1++;
            } else if (nums1[index1] < nums2[index2]) {
                med1 = nums1[index1]
                index1++
            } else {
                med2 = nums2[index2]
                index2++
            }
        }
        // the median is the average of two numbers
        if (total % 2 == 0) {
            println()
            return ((med1 + med2).toFloat() / 2).toDouble()
        }
        return med2.toDouble()
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var index1 = 0
        var index2 = 0
        var med1 = 0
        var med2 = 0
        for (i in 0..(nums1.size + nums2.size) / 2) {
            med1 = med2
            if (index1 == nums1.size) {
                med2 = nums2[index2]
                index2++
            } else if (index2 == nums2.size) {
                med2 = nums1[index1]
                index1++
            } else if (nums1[index1] < nums2[index2]) {
                med2 = nums1[index1]
                index1++
            } else {
                med2 = nums2[index2]
                index2++
            }
        }

        // the median is the average of two numbers
        if ((nums1.size + nums2.size) % 2 == 0) {
            return ((med1 + med2).toFloat() / 2).toDouble()
        }

        return med2.toDouble()
    }


    @JvmStatic
    fun main(args: Array<String>) {
        val `val` = findMedianSortedArrays(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        println(`val`)
    }
}


