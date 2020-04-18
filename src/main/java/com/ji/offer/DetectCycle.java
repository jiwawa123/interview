package com.ji.offer;/*
    user ji
    data 2020/2/18
    time 10:22 AM
*/

import com.ji.util.ListNode;

public class DetectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println(new DetectCycle().detectCycle(head).val);


    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode p = head;
        ListNode q = head;
        while (p != null && q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) {//表示遇见了环
                while (p != head) {
                    p = p.next;
                    head = head.next;
                }
                return p;
            }
        }
        return null;

    }
}
