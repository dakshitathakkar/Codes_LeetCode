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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)    return result;
        TreeNode lastInserted = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        result.add(lastInserted.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    lastInserted = node.left;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    lastInserted = node.right;
                }
            }
            result.add(lastInserted.val);
        }
        result.remove(result.size()-1);
        return result;
    }
}