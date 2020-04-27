class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (stack.isEmpty()) break;
            root = stack.removeLast();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}