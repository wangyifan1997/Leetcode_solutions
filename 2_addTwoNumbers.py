# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
         
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
    	carry = 0
        temp = ListNode(None)
        answer = temp
        while l1 and l2:
            temp.next = ListNode(0)
            temp = temp.next
            digitSum = l1.val + l2.val + carry
            if digitSum < 10:
                carry = 0
                temp.val = digitSum
            else:
                carry = 1
                temp.val = digitSum - 10
            l1 = l1.next
            l2 = l2.next
        while l1:
            temp.next = ListNode(0)
            temp = temp.next
            digitSum = l1.val + carry
            if digitSum < 10:
                carry = 0
                temp.val = digitSum
            else:
                carry = 1
                temp.val = digitSum - 10
            l1 = l1.next
        while l2:
            temp.next = ListNode(0)
            temp = temp.next
            digitSum = l2.val + carry
            if digitSum < 10:
                carry = 0
                temp.val = digitSum
            else:
                carry = 1
                temp.val = digitSum - 10
            l2 = l2.next
        if carry:
            temp.next = ListNode(1)
        return answer.next