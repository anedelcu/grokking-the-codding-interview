package com.learn.inplacereversalofalinkedlist;
/*
Given the head of a LinkedList and two positions ‘p’ and ‘q’,
reverse the LinkedList from position ‘p’ to ‘q’.
 */
public class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        if(p == q) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        for(int i = 0; curr  != null && i < p - 1; ++i) {
            prev = curr;
            curr = curr.next;
        }

        ListNode firstPart = prev;
        ListNode lastPart = curr;
        ListNode temp = null;
        for(int i = 0; curr != null && i < q - p + 1; i++) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        if(firstPart != null) {
            firstPart.next = prev;
        }
        else {
            head = prev;
        }
        lastPart.next = curr;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
