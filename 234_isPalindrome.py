# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# regular approach: use a stack
class Solution_v1:
    def isPalindrome(self, head: ListNode) -> bool:
        length = 0
        temp = head
        letters = []
        count = 0
        while head != None:
            length += 1
            head = head.next
        if length % 2 == 0:
            cutoff = length / 2 # 1-based
            while temp != None:
                count += 1
                if count <= cutoff:
                    letters.append(temp.val)
                else:
                    if temp.val != letters.pop():
                        return False
                temp = temp.next
            return True
        else:
            cutoff = int(length / 2 + 1)
            while temp != None:
                count += 1
                if count < cutoff:
                    letters.append(temp.val)
                elif count > cutoff:
                    if temp.val != letters.pop():
                        return False
                temp = temp.next
            return True


# two pointer ver
class Solution_v2:
    def isPalindrome(self, head: ListNode) -> bool: