package com.qiaohx.leetcode.code10;

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
        int res = reverse(-120);
        System.out.println(res);
    }

    private static int reverse(int x) {
        // 正负数标识
        boolean flag = false;
        if (x < 0) {
            // 如果是负数，先转化为正数
            x = -1*x;
            flag = true;
        }
        // 用long型防止溢出
        Long sum = 0L;
        while (x > 0) {
            // 每次对x取最后一位
            int temp = x % 10;
            x = x / 10;
            // 计算总数，需要把和X10再加上个位数
            sum = sum*10 + temp;
           
        }
        if (flag) {
            // 负数转换
            sum = -1*sum;
        }
        // 判断是否溢出
        if (sum<Integer.MIN_VALUE || sum>Integer.MAX_VALUE) {
            return 0;
        }
        return sum.intValue();
    }
}
