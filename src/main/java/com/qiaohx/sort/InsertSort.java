package com.qiaohx.sort;

/**
 * InsertSort 直接插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {5,10,1,2,6,8,4};
        sort(nums);
        for (int num : nums) {
            System.out.print(num);
            System.out.print("-");
        }
    }

    private static void sort(int[] nums) {
        // 从第2个数开始，每次取一个数
        // 以i为界，左边认为是已排序的数组，右边未排序
        for (int i = 1; i < nums.length; i++) {
            // 定义游标index为当前数字的索引，游标j为左边有序数组的最大下标
            int index = i, j = i-1;
            while (j>=0) {
                if (nums[index]<nums[j]) {
                    // 如果当前数字比j小，交换位置
                    int temp = nums[index];
                    nums[index] = nums[j];
                    nums[j] = temp;
                    index = j;
                }
                j--;
            }
            // 经过不断地交换，i位置的值已经在有序数组中找到了自己的位置
        }
    }
}