""" 23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6 """

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        heap = list()
        
        for node in lists:
            if node != None:
                heappush(heap, (node.val, id(node), node))
        
        if len(heap) == 0:
            return None
        
        head = None
        curr = None
        
        while len(heap) > 0:
            node = heappop(heap)[2]
            next = node.next
            if next != None:
                heappush(heap, (next.val, id(next), next))
            if head == None:
                head = node
                curr = node
                continue
            curr.next = node
            curr = node
            
        return head