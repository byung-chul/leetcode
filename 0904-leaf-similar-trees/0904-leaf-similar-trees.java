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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaves = new ArrayList<>();
        List<Integer> root2Leaves = new ArrayList<>();

        collectLeaves(root1, root1Leaves);
        collectLeaves(root2, root2Leaves);

        return root1Leaves.equals(root2Leaves);
    }

    private void collectLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        } else {
            collectLeaves(root.left, leaves);
            collectLeaves(root.right, leaves);
        }
    }
}