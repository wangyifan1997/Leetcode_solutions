/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.lang.*;

class Solution {
    int res;
    
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        getDepth(root);
        return res;
    }
    
    private int getDepth(TreeNode root) {
        if (root == null) return -1;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        res = Math.max(res, 2 + left + right);
        return 1 + Math.max(left, right);
    }
}