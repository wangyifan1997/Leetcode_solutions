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
    public TreeNode sortedArrayToBST(int[] nums) {
        return put(0, nums.length - 1, nums);
    }
    
    private TreeNode put(int left, int right, int[] nums) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = put(left, mid - 1, nums);
        root.right = put(mid + 1, right, nums);
        return root;
    }
}