package com.ji.mynode;/*
    user ji
    data 2020/2/12
    time 5:31 PM
*/

import com.ji.util.ListNode;

public class ReversePrint {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        ListNode tmp = new ReversePrint().reverseNode(node);

    }

    int n = 0;

    public int[] reversePrint(ListNode head) {
        head = reverseNode(head);
        int res[] = new int[n];

        while(head!=null){
            res[n-1] = head.val;
            head = head.next;
            n--;
        }
        return res;
    }

    public ListNode reverseNode(ListNode head) {
        if (head == null)
            return head;
        ListNode cur = null;
        while (head != null) {
            n++;
            ListNode tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }
        return cur;
    }
}
