package com.qiaohx.leetcode.code10;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2019, jiayong. All rights reserved.
 *
 * @author jiayong
 * @date 2019-02-08
 * @version 0.0.1
 */
public class Code001 {

	public static void main(String[] args) {
        int[] nums = {3, 5, 11, 21};
        int target = 26;
        long start = System.currentTimeMillis();
        int[] res = sum3(nums, target);
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "ms");
        if (res != null) {
            for (int var : res) {
                System.out.print(var + ",");
            }
        }else{
            System.out.println("null");
        }
        
    }
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * https://leetcode-cn.com/problems/two-sum/
     * @param nums 整数数组
     * @param target 目标值
     */
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


    /**
     * 第二种解法 利用hashMap
     * @param nums
     * @param target
     * @return
     */
    public static int[] sum2(int nums[], int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);// 将数组构建哈希表
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];// 计算出要找到的数字
            if (map.containsKey(num) && map.get(num) != i)// 看下在不在map里面
                return new int[]{i, map.get(num)};
        }
        return null;
    }

    /**
     * 基于第二种优化
     * @param nums
     * @param target
     * @return
     */
    public static int[] sum3(int nums[], int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 构建的时候就可以检查了
            int num = target - nums[i];// 计算出要找到的数字
            if (map.containsKey(num) && map.get(num) != i)// 看下在不在map里面
                return new int[]{map.get(num), i};
            map.put(nums[i], i);// 将数组构建哈希表
        }
        return null;
    }
}