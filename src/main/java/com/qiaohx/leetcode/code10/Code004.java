package com.qiaohx.leetcode.code10;

import java.util.Arrays;

/**
 * Copyright (c) 2019, HurricaneJor. All rights reserved.
 *
 * @author HurricaneJor
 * @date 2019-02-13
 * @version 0.0.1
 */
public class Code004 {
    
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 4};
        int[] nums2 = new int[]{2, 5};

        long startTime = System.currentTimeMillis();

        double res =  findMedianSortedArrays2(nums1, nums2);

        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
        System.out.println(res);

       
    }
    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0d;
        int length1 = nums1 == null ? 0 : nums1.length;
        int length2 = nums2 == null ? 0 : nums2.length;
        int length = length1 + length2;// 合并长度

        int[] sum = new int[length];
        if (length1 == 0) {
            System.arraycopy(nums2, 0, sum, 0, length2);
        }else if(length2 == 0){
            System.arraycopy(nums1, 0, sum, 0, length1);
        }else{
            System.arraycopy(nums1, 0, sum, 0, length1);
            System.arraycopy(nums2, 0, sum, length1, length2);
        }

        Arrays.sort(sum);
        int index = length / 2;
        if ((length % 2) == 0) {
            // 偶数
            result = (sum[index] + sum[index-1]) / 2d;
        }else{
            // 奇数
            result = sum[index];
        }
        return result;
    }

    /**
     * 优化后
     * @param nums1
     * @param nums2
     * @return
     */
    private static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1 == null ? 0 : nums1.length;
        int length2 = nums2 == null ? 0 : nums2.length;
        int length = length1 + length2;// 合并长度
        int middle = length/2;
        int[] num = new int[length];// 总数组
        int i = 0, j = 0, k = 0;// 两个游标
        while (k < length){
            if (i < length1 && j < length2){
                // 游标都不超长
                num[k] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
            }else if (i>=length1){
                // i游标超长
                // 将j全挪走
                num[k] = nums2[j++];;
            }else {// j>=length2
                num[k] = nums1[i++];;
            }
            if(k == middle){
                if (length%2==0){
                    return (num[k] + num[k-1])/2d;
                }else {
                    return num[k];
                }
            }
            k++;
        }
        return  0d;
    }
}