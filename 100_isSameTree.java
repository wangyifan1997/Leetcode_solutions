// 100. Same Tree

// Given two binary trees, write a function to check if they are the same or not.

// Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

// Example 1:

// Input:     1         1
//           / \       / \
//          2   3     2   3

//         [1,2,3],   [1,2,3]

// Output: true
// Example 2:

// Input:     1         1
//           /           \
//          2             2

//         [1,2],     [1,null,2]

// Output: false
// Example 3:

// Input:     1         1
//           / \       / \
//          2   1     1   2

//         [1,2,1],   [1,1,2]

// Output: false

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();

        stackP.push(p);
        stackQ.push(q);

        while (!stackP.empty()) {
            if (stackQ.empty()) {
                return false;
            }

            TreeNode nodeP = stackP.pop();
            TreeNode nodeQ = stackQ.pop();

            if (nodeP != null && nodeQ != null) {
                if (nodeP.val != nodeQ.val) {
                    return false;
                }
                stackP.push(nodeP.left);
                stackP.push(nodeP.right);
                stackQ.push(nodeQ.left);
                stackQ.push(nodeQ.right);
            } else if (nodeP != null || nodeQ != null) {
                return false;
            }
        }

        if (!stackQ.empty()) {
            return false;
        }

        return true;
    }
}