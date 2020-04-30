// Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree. 

// We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.

// Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
// Output: true
// Explanation: 
// The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
// Other valid sequences are: 
// 0 -> 1 -> 1 -> 0 
// 0 -> 0 -> 0

// Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
// Output: false 
// Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.

// Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
// Output: false
// Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.

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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return check(root, arr, 0);
    }
    
    private boolean check(TreeNode root, int[] arr, int pos) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return (pos == arr.length - 1) && arr[pos] == root.val;
        } else if (root.left == null) {
            return (pos < arr.length) && arr[pos] == root.val && check(root.right, arr, pos + 1);
        } else if (root.right == null) {
            return (pos < arr.length) && arr[pos] == root.val && check(root.left, arr, pos + 1);
        } else {
            return (pos < arr.length) && arr[pos] == root.val && (check(root.right, arr, pos + 1) || check(root.left, arr, pos + 1));
        }
    }
}