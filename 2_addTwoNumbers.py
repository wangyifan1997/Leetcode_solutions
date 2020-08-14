""" 2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807. """

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:         
        carry = 0
        head = None
        prev = None
        while l1 != None or l2 != None or carry != 0:
            sum = (0 if not l1 else l1.val) + (0 if not l2 else l2.val) + carry
            carry = 1 if sum >= 10 else 0
            curr = ListNode(sum % 10)
            l1 = l1.next if l1 else l1
            l2 = l2.next if l2 else l2
            if head == None:
                head = curr
                prev = curr
                continue
            prev.next = curr
            prev = curr
            
        return head

    def addTwoNumbersRecursive(self, l1: ListNode, l2: ListNode) -> ListNode:
        return self.helper(l1, l2, 0)

    def helper(self, l1: ListNode, l2: ListNode, carry: int) -> ListNode:
        if l1 == None and l2 == None and carry == 0:
            return None
        sum = (0 if not l1 else l1.val) + (0 if not l2 else l2.val) + carry
        carry = 1 if sum >= 10 else 0
        head = ListNode(sum % 10)
        head.next = self.helper(l1.next if l1 else l1, l2.next if l2 else l2, carry)
        return head
