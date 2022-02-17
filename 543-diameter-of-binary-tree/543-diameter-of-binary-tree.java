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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        int leftHt = maxDepth(root.left);
        int rightHt = maxDepth(root.right);
        int rootDia = leftHt + rightHt;
        
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        return Math.max(rootDia,(Math.max(leftDia,rightDia)));
    }
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        int total = Math.max(leftDepth,rightDepth) +1;
        return total;
    }
}