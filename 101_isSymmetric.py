# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 28 ms
class Solution_v1:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        l = self.helper(root.left, "left")
        r = self.helper(root.right, "right")
        if not len(l) == len(r):
            return False
        else:
            for i in range(len(l)):
                if not l[i] == r[i]:
                    return False
            return True
        
        
    def helper(self, node: TreeNode, pos: str) -> list:
        if node == None:
            return [-1]
        else:
            if pos == "left":
                return [node.val] + self.helper(node.left, "left") + self.helper(node.right, "left")
            else:
                return [node.val] + self.helper(node.right, "right") + self.helper(node.left, "right")


# 32 ms
# 标准答案
class Solution_v2:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None: return True
        return self.isMirror(root.left, root.right)

    def isMirror(self, l: TreeNode, r: TreeNode) -> bool:
        if l == None and r == None:
            return True
        if l == None or r == None:
            return False
        return l.val == r.val and self.isMirror(l.left, r.right) and self.isMirror(l.right, r.left)


# 
from collections import deque

class Solution_v3:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None: return True
        toDo = deque()
        toDo.append(root.left)
        toDo.append(root.right)
        while toDo:
            curL = toDo.popleft()
            curR = toDo.popleft()
            if curL == None and curR == None:
                continue
            if curL == None or curR == None:
                return False
            if curL.val != curR.val:
                return False
            toDo.append(curL.left)
            toDo.append(curR.right)
            toDo.append(curR.left)
            toDo.append(curL.right)
        return True




