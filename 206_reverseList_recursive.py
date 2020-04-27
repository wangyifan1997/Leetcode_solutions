# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head == None or head.next == None:
            return head
        temp = head.next
        head.next = None
        return self.helper(head, temp)
        
    def helper(self, first: ListNode, rest: ListNode) -> ListNode:
        if rest.next == None:
            rest.next = first
            return rest
        temp = rest.next
        rest.next = first
        return self.helper(rest, temp)
        