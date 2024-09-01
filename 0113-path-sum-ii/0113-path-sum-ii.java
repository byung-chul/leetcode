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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(root, result, current, targetSum);
        return result;
    }
    private void dfs(TreeNode root, List<List<Integer>> result, List<Integer> current, int targetSum) {
        if (root == null) {
            return;
        }

        current.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(current));
        } else {
            dfs(root.left, result, current, targetSum - root.val);
            dfs(root.right, result, current, targetSum - root.val);
        }

        current.remove(current.size() - 1);
    }
}