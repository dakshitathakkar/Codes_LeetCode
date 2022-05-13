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
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        validate(root);
        return result;
    }
    
    private int validate(TreeNode root){
        if(root == null)
            return 0;
        int lh = validate(root.left);
        int rh = validate(root.right);
        if(Math.abs(lh-rh)>1){
            result = false;
        }
        return 1+Math.max(lh,rh);
    }
}