package com.qiaohx.leetcode.code10;

/**
 * Copyright (c) 2019, jiayong. All rights reserved.
 *
 * @author jiayong
 * @date 2019-02-08
 * @version 0.0.1
 */
public class Code001 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * https://leetcode-cn.com/problems/two-sum/
     * @param args
     */
	public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 26;

        int[] res = sum(nums, target);
        if (res != null) {
            for (int var : res) {
                System.out.print(var + ",");
            }
        }else{
            System.out.println("null");
        }
        
    }

    public static int[] sum(int nums[], int target){
        int i, j;
        for (i = 0; i < nums.length - 1; i++) {
            int num1 = nums[i];// 每次取数组中一个数
            for (j = i + 1; j < nums.length; j++) {// 遍历i之后的数组
                int num2 = nums[j];// 依次取出i之后数组的数字
                if ((num1 + num2) == target) {
                    return new int[]{i ,j};
                }
            }
        }
        return null;
    }
}