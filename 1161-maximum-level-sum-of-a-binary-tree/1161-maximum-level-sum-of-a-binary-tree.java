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
        if(root.left == null && root.right == null){
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int max = root.val;
        int level = 0;
        int res = 1;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            level++;
            for(int i=0;i<size;i++){
                TreeNode curr = queue.remove();
                sum +=curr.val;
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            if(sum>max){
                max = Math.max(max,sum);
                res = level;
            }
            

        }
        return res;
    }
}