package com.qiaohx.leetcode.code10;

/**
 * Copyright (c) 2019, jiayong. All rights reserved.
 *
 * @author jiayong
 * @date 2019-02-14
 * @version 0.0.1
 */
public class Code005 {

    public static void main(String[] args) {
        String s = "abcdedcbaabcdedcba";
        long startTime = System.currentTimeMillis();

        String res = longestPalindrome(s);

        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
        System.out.println(res);
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。
     * @param s
     * @return
     */
	public static String longestPalindrome(String s) {
        String res = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            s = s.substring(i);
            System.out.println(s);
            boolean flag = checkStr(s.toCharArray());
            if (flag) {
                res = s;
                break;
            }
        }
        // boolean flag = checkStr(s.toCharArray());
        // if (flag) {
        //     res = s;
        // }
        return res;
    }

    public static boolean checkStr(char[] chars) {
        int zeng = chars.length % 2 == 0 ? 0 : 1;
        // for (int i = 0; i < chars.length / 2; i++) {
        //     for (int j = chars.length - 1; j > (chars.length / 2) + zeng; j--) {
        //         System.out.println(chars[i] + "," + chars[j] + "," + (chars[i] == chars[j]));
        //         if (chars[i] != chars[j]) {
        //             return false;
        //         }
        //     }
        // }
        int i= 0, j = chars.length - 1;
        while (i < chars.length / 2 && j >= (chars.length / 2) + zeng) {
            System.out.println(chars[i] + "," + chars[j] + "," + (chars[i] == chars[j]));
            if (chars[i] != chars[j]) {
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }

    
}