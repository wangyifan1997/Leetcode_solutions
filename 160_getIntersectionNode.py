# 160. Intersection of Two Linked Lists   

# Write a program to find the node at which the intersection of two singly linked lists begins.

# Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
# Output: Reference of the node with value = 8
# Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

# Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
# Output: Reference of the node with value = 2
# Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.

# Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
# Output: null
# Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
# Explanation: The two lists do not intersect, so return null.

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None or headB is None:
            return None
        
        hA, hB = headA, headB
        visited = False
        
        while True:
            if hA == hB:
                return hA
            
            hA, hB = hA.next, hB.next
            if hA is None:
                hA = headB
                if visited:
                    return None
                else:
                    visited = True
            if hB is None:
                hB = headA

    def getIntersectionNodeSoln(self, headA: ListNode, headB: ListNode) -> ListNode:
        # This is actually not needed as the logic is already included in the while loop
        # but include it just to fail fast
        if headA is None or headB is None:
            return None
        
        hA, hB = headA, headB
        
        while hA != hB:
            hA = headB if hA is None else hA.next
            hB = headA if hB is None else hB.next
        
        return hA