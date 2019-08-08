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
        // 从下标0开始遍历所有值
        for (int i = 0; i < nums.length; i++) {
            // 从i+1开始，遍历所有值
            for (int j = i+1; j < nums.length; j++) {
                // 将i与之后每个值比较，碰见小的就交换(小的一直向上冒泡)
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            // 每趟比较i之后，i位置都是i之后最小的值
        }
    }
}