package com.qiaohx.leetcode.code10;

import java.util.*;

public class Code009 {

    public static void main(String[] args) {
        boolean flag = isPalindrome(12312);
        System.out.println(flag);
    }

    /**
     * 解法1
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }else if (x < 10){
            return true;
        }
        int number = x;
        int length = 0;
        List<Integer> list = new ArrayList<>();
        while (number != 0){
            int yu = number % 10;
            list.add(yu);
            number = number/10;
            length++;
        }

        int i = length/2 - 1;
        int j = (length % 2 == 0 ? length/2 + 1 : length/2 + 2) - 1;
        while (i >= 0){
            System.out.println(list.get(i--) + "-" + list.get(j++));
            if (!list.get(i--).equals(list.get(j++)))
                return false;
        }
        return true;
    }

}
