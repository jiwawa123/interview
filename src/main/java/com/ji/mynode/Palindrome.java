package com.ji.mynode;/*
    user ji
    data 2020/2/18
    time 11:05 AM
*/

import com.ji.util.ListNode;

public class Palindrome {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(0);
        new Palindrome().isPalindrome(node);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode p = head;
        ListNode q = head;

        while (p != null) {
            if (q.next == null || q.next.next == null) {
                break;
            }
            p = p.next;
            q = q.next.next;
        }

        ListNode last = reverse(p.next);
        while (last != null) {
            if (last.val != head.val)
                return false;
            last = last.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode cur = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = cur;
            cur = p;
            p = tmp;
        }
        return cur;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode p = headA;
        ListNode q = headB;
        while (headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
            lenA++;
            lenB++;
        }
        while (headA != null) {
            headA = headA.next;
            lenA++;
        }

        while (headB != null) {
            headB = headB.next;
            lenB++;
        }

        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff > 0) {
                p = p.next;
                diff--;
            }
        } else {
            int diff = lenB - lenA;
            while (diff > 0) {
                q = q.next;
                diff--;
            }
        }
        while (p != null) {
            if (p == q)
                return p;
            p = p.next;
            q = q.next;
        }

        return null;
    }
}
