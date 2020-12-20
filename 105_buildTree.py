# 105. Construct Binary Tree from Preorder and Inorder Traversal

# Given preorder and inorder traversal of a tree, construct the binary tree.

# Note:
# You may assume that duplicates do not exist in the tree.

# For example, given

# preorder = [3,9,20,15,7]
# inorder = [9,3,15,20,7]
# Return the following binary tree:

#     3
#    / \
#   9  20
#     /  \
#    15   7

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        return self.buildTreeHelper(preorder, 0, len(preorder), inorder, 0, len(inorder))
    
    def buildTreeHelper(self, preorder: List[int], preLeft: int, preRight: int, inorder: List[int], inLeft: int, inRight: int) -> TreeNode:
        if preLeft >= preRight:
            return None
        
        topNum = preorder[preLeft]
        ret = TreeNode(topNum)
        
        for i in range(inLeft, inRight):
            if inorder[i] == topNum:
                ret.left = self.buildTreeHelper(preorder, preLeft + 1, preLeft + 1 + i - inLeft, inorder, inLeft, i)
                ret.right = self.buildTreeHelper(preorder, preLeft + 1 + i - inLeft, preRight, inorder, i + 1, inRight)
                
        return ret