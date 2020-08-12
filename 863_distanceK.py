""" 863. All Nodes Distance K in Binary Tree

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.

Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.
 

Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000. """

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, K: int) -> List[int]:
        if K == 0:
            return [target.val]
        
        map = dict()
        self.dfs(root, None, map)
        
        visited = set()
        level = 0
        queue = deque()
        queue.append(target)
        
        result = list()
        while (len(queue) != 0):
            if level == K:
                for node in queue:
                    if node != None and node not in visited:
                        result.append(node.val)
            size = len(queue)
            for i in range(size):
                node = queue.popleft()
                if node != None and node not in visited:
                    visited.add(node)
                    queue.append(node.left)
                    queue.append(node.right)
                    queue.append(map[node])
            level += 1
            
        return result
                    
    def dfs(self, root: TreeNode, parent: TreeNode, map: dict):
        if (root == None):  
            return
        map[root] = parent
        self.dfs(root.left, root, map)
        self.dfs(root.right, root, map)