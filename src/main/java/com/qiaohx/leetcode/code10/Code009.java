package com.qiaohx.leetcode.code10;

import java.util.*;
/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code009 {

    public static void main(String[] args) {
        boolean flag = isPalindrome(12321);
        System.out.println(flag);
    }

    public static boolean isPalindrome(int x) {
        if (x<0) {
            // 负数肯定不是回文数
            return false;
        }
        if (x>=0&&x<=9) {
            // 0-9肯定是
            return true;
        }
        // 只剩大于10的正数
        // 根据规律得出：只要翻转后数字相等，那么就是个回文数
        Long resver = 0l;
        int number = x;
        while (number>0) {
            // 取个位数
            int temp = number%10;
            resver = resver * 10 + temp;
            number /=10;
        }
        if (resver < Integer.MIN_VALUE || resver > Integer.MAX_VALUE) {
            // 溢出了 必定不是
            return false;
        }

        return x == resver.intValue();
    }
}
