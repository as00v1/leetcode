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
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(7);
        l21.next = l22;
        l22.next = l23;

        ListNode sum = addTwoNumbers3(l11, l21);
        if (sum != null) {
            while(sum != null){
                System.out.println(sum.val);
                sum = sum.next;
            }
        } else {
            System.out.println("0000000");
        }
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode n1 = l1, n2 = l2, total = new ListNode(0);
        ListNode temp = total;// 代表下一位
        int single = 0;
        while (n1 != null || n2 != null) {
            int a = 0;
            int b = 0;
            if (n1 != null){
                a = n1.val;
                n1 = n1.next;
            }
            if (n2 != null){
                b= n2.val;
                n2 = n2.next;
            }
            int sum = a + b + single;

            single = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        if (single > 0){
            temp.next = new ListNode(single);
        }
        return total.next;
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode n1 = l1, n2 = l2, total = new ListNode(0);
        ListNode temp;// 代表下一位
        int single = 0;
        for (temp = total;n1 != null || n2 != null;temp = temp.next) {
            int a = 0;
            int b = 0;
            if (n1 != null){
                a = n1.val;
                n1 = n1.next;
            }
            if (n2 != null){
                b= n2.val;
                n2 = n2.next;
            }
            int sum = a + b + single;

            single = sum / 10;
            temp.next = new ListNode(sum % 10);
        }
        if (single > 0){
            temp.next = new ListNode(single);
        }
        return total.next;
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