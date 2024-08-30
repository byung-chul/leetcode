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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.add(root.left);
        right.add(root.right);

        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode lTree = left.poll();
            TreeNode rTree = right.poll();

            if (lTree == null && rTree == null) {
                continue;
            }
            if (lTree == null || rTree == null) {
                return false;
            }
            if (lTree.val != rTree.val) {
                return false;
            }

            left.add(lTree.left);
            left.add(lTree.right);
            right.add(rTree.right);
            right.add(rTree.left);
        }
        return left.isEmpty() && right.isEmpty();
    }
}