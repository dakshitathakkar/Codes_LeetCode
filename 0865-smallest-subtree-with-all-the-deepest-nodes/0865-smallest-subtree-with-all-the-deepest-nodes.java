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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parentMap.put(root, null);
        Set<TreeNode> set = new HashSet<>();
        while (!queue.isEmpty()) {
            set.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                set.add(curr);
                if (curr.left != null) {
                    queue.add(curr.left);
                    parentMap.put(curr.left, curr);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    parentMap.put(curr.right, curr);
                }
            }

        }

        while (set.size() > 1) {
            Set<TreeNode> next = new HashSet<>();
            for (TreeNode node : set) {
                next.add(parentMap.get(node));
            }
            set = next;
        }
        return set.iterator().next();
    }
}