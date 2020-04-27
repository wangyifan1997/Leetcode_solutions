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
    public boolean isValidBST(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        visit(root, visited);
        return validate(visited);
    }
    
    private void visit(TreeNode root, List<Integer> visited) {
        if (root == null) return;
        visit(root.left, visited);
        visited.add(root.val);
        visit(root.right, visited);
    }
    
    private boolean validate(List<Integer> visited) {
        if (visited.size() == 0 || visited.size() == 1) return true;
        for (int i = 0; i < visited.size() - 1; i++) {
            if (visited.get(i) >= visited.get(i + 1)) return false;
        }
        return true;
    }
}