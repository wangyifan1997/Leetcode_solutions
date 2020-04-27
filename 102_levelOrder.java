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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currNum = 0;
        int last = 1;
        List<List<Integer>> result = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> levelElements = new ArrayList<>();
            for (int i = 0; i < last; i++) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    levelElements.add(curr.val);
                    q.offer(curr.left);
                    q.offer(curr.right);
                    currNum += 2;
                }
            }
            last = currNum;
            currNum = 0;
            if (levelElements.size() != 0) result.add(levelElements);
        }
        return result;
    }
}