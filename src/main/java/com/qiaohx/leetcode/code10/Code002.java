package com.qiaohx.leetcode.code10;

/**
 * Copyright (c) 2019, jiayong. All rights reserved.
 *
 * @author jiayong
 * @date 2019-02-08
 * @version 0.0.1
 */
public class Code002 {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * https://leetcode-cn.com/problems/add-two-numbers/
     * @param args
     */
	public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(2);

        ListNode sum = addTwoNumbers(l1, l2);
        if (sum != null) {
            while(sum != null){
                System.out.println(sum.val);
                sum = sum.next;
            }
        } else {
            System.out.println("0000000");
        }
    }

    /**
     * 参照教程
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode sum = new ListNode(0);
        ListNode n1 = l1, n2 = l2, temp = sum;
        int up = 0;
        while (n1 != null || n2 != null) {// 只要n1和n2不为null就一直加
            int a = n1 == null ? 0 : n1.val;
            int b = n2 == null ? 0 : n2.val;
            int ab = up + a + b;// 当前节点+ab两个节点
            // temp.val = ab % 10;// 取余数放到val
            up = ab / 10;// 获取进位是多少
            temp.next = new ListNode(ab % 10);// 进位设置为up
            temp = temp.next;
            if(n1 != null) n1 = n1.next;
            if(n2 != null) n2 = n2.next;
        }
        if (up > 0) {
            temp.next = new ListNode(up);
        }
        return sum.next;
    }

    /**
     * ListNode
     */
    public static class ListNode {
    
        int val;

        ListNode next;

        ListNode(int x) { 
            this.val = x;
        }
    }
}