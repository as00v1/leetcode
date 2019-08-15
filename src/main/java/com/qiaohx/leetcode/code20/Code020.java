package com.qiaohx.leetcode.code20;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code020 {

    public static void main(String[] args) {
        boolean flag = isValid("((");
        System.out.println(flag);
    }
    public static boolean isValid(String s) {
        if ((s.length() % 2) != 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        List<Character> list = new LinkedList<>();
        for (int i = 0;i < s.length();i++) {
            char c = chars[i];
            if (c == '(' || c == '[' || c == '{') {
                // 碰见左括号入栈
                list.add(c);
            }else{
                // 非左括号，出栈
                if (list.size() == 0){
                    return false;
                }
                char right = list.get(list.size() - 1);
                if ((c == ')'&& right == '(') 
                    || (c == ']' && right == '[') 
                    || (c == '}' && right == '{')) {
                    // 匹配上，出栈
                    list.remove(list.size() - 1);
                }else{
                    // 匹配不上，就GG
                    return false;
                }
            }
        }
        if (list.size() == 0) {
            return true;
        }
        return false;
    }
}