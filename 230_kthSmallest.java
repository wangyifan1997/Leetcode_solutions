class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ints = new LinkedList<>();
        inOrder(ints, root);
        return ints.get(k - 1);
    }
    
    private void inOrder(List<Integer> ints, TreeNode node) {
        if (node == null) return;
        inOrder(ints, node.left);
        ints.add(node.val);
        inOrder(ints, node.right);
    }
}


class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
    
}