// 206. Reverse Linked List

// Reverse a singly linked list.

// Example:

// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL
// Follow up:

// A linked list can be reversed either iteratively or recursively. Could you implement both?


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode last = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = last;
            last = head;
            head = temp;
        }
        return last;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode ret = reverseListRecursive(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return ret;
    }
}