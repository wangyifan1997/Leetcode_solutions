// 19. Remove Nth Node From End of List

// Given a linked list, remove the n-th node from the end of list and return its head.

// Example:

// Given linked list: 1->2->3->4->5, and n = 2.

// After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:

// Given n will always be valid.

// Follow up:

// Could you do this in one pass?


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEndHashMap(ListNode head, int n) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int pos = 1;
        ListNode temp = head;
        while (temp != null) {
            map.put(pos, temp);
            temp = temp.next;
            pos++;
        }
        pos--;
        if (n == pos) {
            head = head.next;
        } else {
            ListNode front = map.get(pos - n);
            ListNode toRemove = front.next;
            front.next = front.next.next;
            toRemove.next = null;
        }
        return head;
    }

    public ListNode removeNthFromEndTwoPointers(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int skip = 0; skip < n; skip++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == null) {
            head = head.next;
        } else {
            slow.next = slow.next.next;
        }
        return head;
    }
}