package com.ji.algo;/*
    user ji
    data 2019/10/21
    time 3:45 PM
*/

import com.ji.util.ListNode;

public class ListNodeAbout {
    public static void main(String[] args) {
        ListNode tmp = new ListNode(1);
        tmp.next = new ListNode(2);
        tmp.next.next = new ListNode(3);
        ListNode t = reverListNodeII(tmp);
        System.out.println(t.val);

    }

    public static ListNode reverListNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = reverListNode(head.next);
        head.next.next = head;
        head.next = null;

        return next;
    }
    public static ListNode reverListNodeII(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode cur = null;
        ListNode next =null;
        while(head!=null){
            next = head.next;

            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }
}
