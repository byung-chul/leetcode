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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        q.add(root);

        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList currentLevel = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();

                if (leftToRight) {
                    currentLevel.addLast(current.val);
                } else {
                    currentLevel.addFirst(current.val);
                }
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            ret.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return ret;
    }
}