package com.qiaohx.leetcode.code20;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class Code014 {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        // String[] strs = {"dog","racecar","car"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 找出数组中最短字符串的下标
        int minIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < strs[minIndex].length()) {
                minIndex = i;
            }
        }
        // 拿到最短的字符串
        String str = strs[minIndex];
        while (str.length() > 0) {
            int i = 0;
            // 遍历数组，看是否匹配前缀
            while (i < strs.length) {
                String s = strs[i];
                if (s.startsWith(str)) {
                    if (i==strs.length-1) {
                        // 如果匹配且是数组最后一个了，那就返回了
                        return str;
                    }else{
                        i++;
                    }
                }else{
                    // 不匹配的话，将字符串最后一位切掉，再次遍历数组
                    str = str.substring(0, str.length()-1);
                    break;
                }
            }
        }
        return "";
    }
}