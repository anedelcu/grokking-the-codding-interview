package com.learn.inplacereversalofalinkedlist;
/*
Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */

public class ReverseEveryKElements {

    public static ListNode reverse(ListNode head, int k) {

        if(k <= 1 || head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        while(true) {
            ListNode start = prev;
            ListNode end = curr;
            ListNode temp = null;

            for(int i = 0; curr != null && i < k; i++) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            if(start != null) {
                start.next = prev;
            }
            else {
                head = prev;
            }
            end.next = curr;
            if(curr == null) {
                break;
            }
            prev = end;

        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
