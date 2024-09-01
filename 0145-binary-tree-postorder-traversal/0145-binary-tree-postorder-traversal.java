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
    private LinkedList<Integer> result = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        result.addFirst(root.val);
        dfs(root.right);
        dfs(root.left);
    }
}