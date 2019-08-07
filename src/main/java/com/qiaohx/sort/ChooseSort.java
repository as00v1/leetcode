package com.qiaohx.sort;

/**
 * ChooseSort 选择排序
 */
public class ChooseSort {

    public static void main(String[] args) {
        int[] nums = {5,10,1,2,6,8,4};
        sort(nums);
        for (int num : nums) {
            System.out.print(num);
            System.out.print("-");
        }
    }

    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j]<nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
}