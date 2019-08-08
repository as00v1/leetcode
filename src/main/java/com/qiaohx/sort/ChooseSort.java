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
        // 从0开始遍历
        for (int i = 0; i < nums.length; i++) {
            // 假设当前最小值的下标就是i
            int minIndex = i;
            // 遍历i之后的下标
            for (int j = i+1; j < nums.length; j++) {
                // 如果此下标的的值小，将最小值下标记录下来
                if (nums[j]<nums[minIndex]) {
                    minIndex = j;
                }
            }
            // 如果最小值下标发生变化，将目前最小值与i的值交换
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
}