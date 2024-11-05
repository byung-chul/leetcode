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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel = 1;

        while (!treeNodeQueue.isEmpty()) {
            int levelSum = 0;
            int levelSize = treeNodeQueue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = treeNodeQueue.poll();
                levelSum += currentNode.val;

                if (currentNode.left != null) {
                    treeNodeQueue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    treeNodeQueue.add(currentNode.right);
                }
            }

            if (maxSum < levelSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }
            currentLevel++;
        }
        return maxLevel;
    }
}