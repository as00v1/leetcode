package com.qiaohx.leetcode.code30;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code021 {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode l = mergeTwoLists(l11, l21);
        do {
            System.out.println(l.val);
            l = l.next;
        } while (l!=null);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode l = new ListNode(0);
        ListNode node = l;
        do {
            if (p1 != null && p2 != null) {
                int a = p1.val, b=p2.val;
                if (a < b) {
                    node.next = new ListNode(a);
                    p1 = p1.next;
                }else if (a>b) {
                    node.next = new ListNode(b);
                    p2 = p2.next;
                }else{
                    node.next = new ListNode(a);
                    node = node.next;
                    node.next = new ListNode(b);
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }else if (p1 != null) {
                node.next = new ListNode(p1.val);
                p1 = p1.next;
            }else if (p2 != null) {
                node.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            node = node.next;
        } while (p1 != null || p2 != null);
        return l.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}