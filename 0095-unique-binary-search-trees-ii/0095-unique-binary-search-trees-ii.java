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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> returnTree = new ArrayList<>();
        if (n == 0) {
            return returnTree;
        }
        returnTree = generateTrees(1, n);
        return returnTree;
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> all = new ArrayList<>();
        if (start > end) {
            all.add(null);
            return all;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i-1);
            List<TreeNode> right = generateTrees(i+1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode current = new TreeNode(i, l, r);
                    all.add(current);
                }
            }
        }

        return all;
    }
}