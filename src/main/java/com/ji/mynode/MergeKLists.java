package com.ji.mynode;

import com.ji.util.ListNode;

/**
 * user ji
 * data 2020/4/26
 * time 8:42 上午
 */
public class MergeKLists {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode tmp = null;
        for (int i = 0; i < lists.length; i++) {
            tmp = merge(tmp,lists[i]);
        }

        return tmp;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode tmp = new ListNode(0);
        ListNode next = tmp;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                next.next = new ListNode(l2.val);
                next = next.next;
                l2 = l2.next;
            } else {
                next.next = new ListNode(l1.val);
                next = next.next;
                l1 = l1.next;
            }
        }
        if (l1 != null) {
            next.next = l1;
        }
        if (l2 != null) {
            next.next = l2;
        }
        return tmp.next;
    }
}
