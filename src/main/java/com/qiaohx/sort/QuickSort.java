package com.qiaohx.sort;

/**
 * QuickSort 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {5,10,1,2,6,8,4};
        sort(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.print(num);
            System.out.print("-");
        }
    }

    /**
     * 快速排序
     * @param nums 
     * @param left
     * @param right
     */
    private static void sort(int[] nums, int left, int right) {
        // 递归的跳出条件：左右指针碰撞
        if (left >= right) {
            return;
        }
        // 定义i和j两个游标在数组两头，挖出最左的数作为比较基数
        int i = left, j = right, base = nums[i];
        // i和j碰撞则结束
        while (i<j) {
            // 从j开始向前比较，找出比基数小的下标才停止
            while (i<j && nums[j]>=base) {
                j--;
            }
            if (i<j) {
                // 将最小数下标j的值挖出来，填到i的坑里去
                nums[i] = nums[j];
                // i指针右移
                i++;
            }
            // 从i位置开始向右查找，找到比基数大的下标
            while (i<j && nums[i]<=base) {
                i++;
            }
            if (i<j) {
                // 把比基数大的数字i挖出来，填到j的坑里
                nums[j] = nums[i];
                // j指针左移
                j--;
            }
        }
        // i和j碰撞后，将基数填到i的坑里，这样i的左边都比它小，右边都比它大
        nums[i] = base;
        // 把i左右两边的小数组分别递归
        sort(nums, left, i-1);
        sort(nums, i+1, right);
    }
}