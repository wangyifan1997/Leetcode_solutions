// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// Note: A leaf is a node with no children.

// Example:

// Given the below binary tree and sum = 22,

//       5
//      / \
//     4   8
//    /   / \
//   11  13  4
//  /  \    / \
// 7    2  5   1
// Return:

// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]
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
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        helper(root, sum, path, 0);
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> path, int ssf) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null & root.right == null) {
            if (ssf + root.val == sum) {
                result.add(new LinkedList<>(path));
            }
        } else {
            helper(root.left, sum, path, ssf + root.val);
            helper(root.right, sum, path, ssf + root.val);
        }
        path.remove(path.size() - 1);
    }
}