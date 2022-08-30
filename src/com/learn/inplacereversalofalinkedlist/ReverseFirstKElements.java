package com.learn.inplacereversalofalinkedlist;
/*
 Reverse the first ‘k’ elements of a given LinkedList.
 */
public class ReverseFirstKElements {
    public static ListNode reverse(ListNode head, int k) {

        if(k <= 1 || head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;

        ListNode start = prev;
        ListNode end = curr;

        for(int i = 0; curr != null && i <  k; i++) {
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

        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseFirstKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
