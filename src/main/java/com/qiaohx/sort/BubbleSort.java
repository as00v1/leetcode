package com.qiaohx.sort;

/**
 * BubbleSort 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {5,10,1,2,6,8,3};
        sort(nums);
        for (int num : nums) {
            System.out.print(num);
            System.out.print("-");
        }
    }

    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}