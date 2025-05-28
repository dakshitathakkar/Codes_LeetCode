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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTRange(TreeNode root, long minRange, long maxRange){
        if(root == null){
            return true;
        }
        return ((root.val>minRange && root.val <maxRange) &&
        isValidBSTRange(root.left, minRange,root.val) &&
        isValidBSTRange(root.right,root.val,maxRange));
    }
}