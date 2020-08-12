""" 21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4 """

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoListsIterative(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 == None:
            return l2
        if l2 == None:
            return l1
        
        heap = list()
        heappush(heap, (l1.val, id(l1), l1))
        heappush(heap, (l2.val, id(l2), l2))
        head = None
        curr = None
        
        while len(heap) > 0:
            node = heappop(heap)[2]
            if node.next != None:
                heappush(heap, (node.next.val, id(node.next), node.next))
            if head == None:
                head = node
                curr = node
                continue
            curr.next = node
            curr = node
        return head

    def mergeTwoListsRecursive(self, l1: ListNode, l2: ListNode) -> ListNode:
        if (l1 == None):
            return l2
        if (l2 == None):
            return l1
        if (l1.val < l2.val):
            l1.next = self.mergeTwoListsRecursive(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoListsRecursive(l1, l2.next)
            return l2