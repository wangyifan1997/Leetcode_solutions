// 257. Binary Tree Paths

// Given a binary tree, return all root-to-leaf paths.

// Note: A leaf is a node with no children.

// Example:

// Input:

//    1
//  /   \
// 2     3
//  \
//   5

// Output: ["1->2->5", "1->3"]

// Explanation: All root-to-leaf paths are: 1->2->5, 1->3

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<String> result;
    
    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, "");
        return result;
    }
    
    private void dfs(TreeNode root, String rsf) {
        if (root == null) return;
        rsf += root.val;
        if (root.left == null && root.right == null) {
            result.add(rsf);
        } else {
            rsf += "->";
            dfs(root.left, rsf);
            dfs(root.right, rsf);
        }
    }
}