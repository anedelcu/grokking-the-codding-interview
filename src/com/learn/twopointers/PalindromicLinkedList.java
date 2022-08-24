package com.learn.twopointers;

public class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {
        ListNode node = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        fast = node;
        while (slow != null) {
            if (slow.value != fast.value) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        //head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        //head.next.next.next.next.next = new ListNode(2);
        //System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}

