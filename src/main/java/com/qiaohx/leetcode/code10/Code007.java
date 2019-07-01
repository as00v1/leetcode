package com.qiaohx.leetcode.code10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code007 {

    public static void main(String[] args) {
        int res = reverse2(-123);
        System.out.println(res);
    }

    private static int reverse(int x) {
        int number = x >= 0 ? x : x*-1;// 取正数
        List<Integer> list = new LinkedList<>();
        if (number == 0){
            list.add(0);
        }else {
            while (number != 0){
                int yu = number % 10;
                number = number/10;
                list.add(yu);
            }
        }
        int res = 0;
        int length = list.size();
        for (Integer i : list) {
            res = res + i * power(10, --length, 1);
        }
        res = x >= 0 ? res : res * -1;
        return res;
    }

    private static int power(int i, int power, int res) {
        if(power == 0){
            return res;
        }
        return power(i, --power, res*i);
    }


    private static int reverse2(int x) {
//        int number = x >= 0 ? x : x * -1;// 取正数

        String numStr = String.valueOf(x);
        boolean flag = numStr.startsWith("-");
        if (flag){
            numStr = numStr.substring(1);
        }
        char[] chars = numStr.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());
        int res = 0;
        try {
            res = Integer.parseInt(flag ? "-" + sb.toString() : sb.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
