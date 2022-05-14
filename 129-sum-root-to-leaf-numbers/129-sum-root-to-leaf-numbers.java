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
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
        
    }
    
    private int sum(TreeNode root,int v){
        if(root == null)
            return 0;
        v = (v*10)+root.val;
        if(root.left == null && root.right == null)
            return v;
        return (sum(root.left,v) + sum(root.right,v));
    }
}