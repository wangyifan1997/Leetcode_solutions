// 103. Binary Tree Zigzag Level Order Traversal

// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
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
    public List<List<Integer>> zigzagLevelOrderSlow(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> list;
        stack1.push(root);
        while (!stack1.empty() || !stack2.empty()) {
            list = new LinkedList<>();
            while (!stack1.empty()) {
                TreeNode node = stack1.pop();
                if (node != null) {
                    list.add(node.val);
                    stack2.push(node.left);
                    stack2.push(node.right);
                }
            }
            if (list.size() != 0) result.add(list);
            list = new LinkedList<>();
            while (!stack2.empty()) {
                TreeNode node = stack2.pop();
                if (node != null) {
                    list.add(node.val);
                    stack1.push(node.right);
                    stack1.push(node.left);
                }
            }
            if (list.size() != 0) result.add(list);
        }
        return result;
    }
}