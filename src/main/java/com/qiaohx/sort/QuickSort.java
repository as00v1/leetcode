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

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left, j = right, base = nums[i];

        while (i<j) {
            while (i<j && nums[j]>=base) {
                j--;
            }
            if (i<j) {
                nums[i] = nums[j];
                i++;
            }

            while (i<j && nums[i]<=base) {
                i++;
            }
            if (i<j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = base;
        sort(nums, left, i-1);
        sort(nums, i+1, right);
    }
}