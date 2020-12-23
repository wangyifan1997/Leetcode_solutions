# 148. Sort List
# Given the head of a linked list, return the list after sorting it in ascending order.

# Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

# Example 1:
# Input: head = [4,2,1,3]
# Output: [1,2,3,4]

# Example 2:
# Input: head = [-1,5,3,4,0]
# Output: [-1,0,3,4,5]

# Example 3:
# Input: head = []
# Output: []

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        
        mid = self.getMid(head)
        
        head = self.sortList(head)
        mid = self.sortList(mid)
        
        return self.merge(head, mid)
    
    def getMid(self, head: ListNode) -> ListNode:
        tmp = head
        length = 0
        while tmp:
            tmp = tmp.next
            length += 1
        
        node = head
        for i in range(length // 2 - 1):
            node = node.next
        
        tmp = node
        node = node.next
        tmp.next = None
        
        return node
    
    def merge(self, l1: ListNode, l2: ListNode) -> ListNode:
        curr = None
        
        if l1.val < l2.val:
            curr = l1
            l1 = l1.next
        else:
            curr = l2
            l2 = l2.next
            
        head = curr
            
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                curr.next = l1
                l1 = l1.next
            else:
                curr.next = l2
                l2 = l2.next
            curr = curr.next
        
        curr.next = l1 if l1 is not None else l2
            
        return head